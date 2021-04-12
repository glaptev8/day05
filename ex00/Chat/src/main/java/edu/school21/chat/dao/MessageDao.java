package edu.school21.chat.dao;

import edu.school21.chat.Program;
import edu.school21.chat.models.Message;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static edu.school21.chat.ColumnName.MESSAGE_AUTHOR;
import static edu.school21.chat.ColumnName.MESSAGE_DATE;
import static edu.school21.chat.ColumnName.MESSAGE_ID;
import static edu.school21.chat.ColumnName.MESSAGE_ROOM;
import static edu.school21.chat.ColumnName.MESSAGE_TABLE_NAME;
import static edu.school21.chat.ColumnName.MESSAGE_TEXT;

public class MessageDao {
  public Message getMessageByID(int id) {
    String getMessageById = "SELECT * FROM " + MESSAGE_TABLE_NAME.getColumnName() +" m"
      + " WHERE m." + MESSAGE_ID.getColumnName() + " = ?";
    PreparedStatement ps = Program.preparedStatement(getMessageById);
    try {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      Message message = null;
      if (resultSet.next()) {
        int messageId = resultSet.getInt(MESSAGE_ID.getColumnName());
        int messageAuthor = resultSet.getInt(MESSAGE_AUTHOR.getColumnName());
        int messageRoom = resultSet.getInt(MESSAGE_ROOM.getColumnName());
        String messageText = resultSet.getString(MESSAGE_TEXT.getColumnName());
        Date date = new Date(resultSet.getDate(MESSAGE_DATE.getColumnName()).getTime());
        message = new Message(messageId, messageAuthor, messageRoom, messageText, date);
      }
      return message;
    } catch (SQLException e) {
      throw new RuntimeException("Error get result", e);
    }
  }
}
