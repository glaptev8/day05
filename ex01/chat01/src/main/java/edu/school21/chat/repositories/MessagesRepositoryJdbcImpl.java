package edu.school21.chat.repositories;

import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static edu.school21.chat.app.ColumnName.CHAT_ID;
import static edu.school21.chat.app.ColumnName.CHAT_NAME;
import static edu.school21.chat.app.ColumnName.MESSAGE_DATE;
import static edu.school21.chat.app.ColumnName.MESSAGE_ID;
import static edu.school21.chat.app.ColumnName.MESSAGE_TEXT;
import static edu.school21.chat.app.ColumnName.USER_ID;
import static edu.school21.chat.app.ColumnName.USER_LOGIN;
import static edu.school21.chat.app.ColumnName.USER_PASSWORD;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

  private DataSource dataSource;

  public MessagesRepositoryJdbcImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public Optional<Message> findById(Long id) {
    String getMessageById = "SELECT m.message_id, m.message_text, m.message_date, u.user_id ,u.login, u.password, c.chatroom_id, chatroom_name FROM message m"
    + " LEFT JOIN \"User\" u on u.user_id = m.message_author"
    + " LEFT JOIN chatroom c on m.message_room = c.chatroom_id"
    + " WHERE m.message_id = ?";
    try {
      PreparedStatement ps = dataSource.getConnection().prepareStatement(getMessageById);
      ps.setLong(1, id);
      ResultSet resultSet = ps.executeQuery();
      Message message = null;
      User user;
      ChatRoom chatRoom;
      if (resultSet.next()) {
        Long messageId = resultSet.getLong(MESSAGE_ID.getColumnName());
        String messageText = resultSet.getString(MESSAGE_TEXT.getColumnName());
        Date date = new Date(resultSet.getDate(MESSAGE_DATE.getColumnName()).getTime());
        Long userId = resultSet.getLong(USER_ID.getColumnName());
        String userLogin = resultSet.getString(USER_LOGIN.getColumnName());
        String userPassword = resultSet.getString(USER_PASSWORD.getColumnName());
        Long chatId = resultSet.getLong(CHAT_ID.getColumnName());
        String chatName = resultSet.getString(CHAT_NAME.getColumnName());
        user = new User(userId, userLogin, userPassword);
        chatRoom = new ChatRoom(chatId, chatName);
        message = new Message(messageId, user, chatRoom, messageText, date);
      }
      return Optional.ofNullable(message);
    } catch (SQLException e) {
      throw new RuntimeException("Error connecting to the database", e);
    }
  }
}
