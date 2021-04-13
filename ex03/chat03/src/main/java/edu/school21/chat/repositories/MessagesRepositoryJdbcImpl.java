package edu.school21.chat.repositories;

import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        LocalDateTime date;
        if (resultSet.getTimestamp(MESSAGE_DATE.getColumnName()) == null) {
          date = null;
        } else {
          date = resultSet.getTimestamp(MESSAGE_DATE.getColumnName()).toLocalDateTime();
        }
        Long userId = resultSet.getLong(USER_ID.getColumnName());
        String userLogin = resultSet.getString(USER_LOGIN.getColumnName());
        String userPassword = resultSet.getString(USER_PASSWORD.getColumnName());
        Long chatId = resultSet.getLong(CHAT_ID.getColumnName());
        String chatName = resultSet.getString(CHAT_NAME.getColumnName());
        user = new User(userId, userLogin, userPassword);
        chatRoom = new ChatRoom(chatId, chatName);
        message = new Message(messageId, user, chatRoom, messageText, date);
      }
      ps.close();
      return Optional.ofNullable(message);
    } catch (SQLException e) {
      throw new RuntimeException("Error get result", e);
    }
  }

  @Override
  public void save(Message message) {
    String saveMessage = "INSERT INTO \"message\" (message_author, message_room, message_text, message_date)"
      + " VALUES (?, ?, ?, ?)";
    try {
      PreparedStatement ps = dataSource.getConnection().prepareStatement(saveMessage);
      ps.setLong(1, message.getAuthor().getId());
      ps.setLong(2, message.getChat().getId());
      ps.setString(3, message.getMessage());
      ps.setTimestamp(4, Timestamp.valueOf(message.getDate()));
      ps.executeQuery();
      ps.close();
    } catch (SQLException e) {
      throw new RuntimeException("Error get result", e);
    }
  }

  @Override
  public void update(Message message) {
    String updateMessage = "UPDATE message SET message_author = ?, message_room = ?,"
      + " message_text = ?, message_date = ?"
      + " WHERE message_id = " + message.getId();
    try {
      PreparedStatement ps = dataSource.getConnection().prepareStatement(updateMessage);
      ps.setLong(1, message.getAuthor().getId());
      ps.setLong(2, message.getChat().getId());
      ps.setString(3, message.getMessage());
      if (message.getDate() == null) {
        ps.setTimestamp(4,null);
      }
      else {
        ps.setTimestamp(4, Timestamp.valueOf(message.getDate()));
      }
      ps.execute();
    } catch (SQLException e) {
      throw new RuntimeException("Error get result", e);
    }
  }
}
