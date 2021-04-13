package edu.school21.chat.dao;

import edu.school21.chat.Program;
import edu.school21.chat.models.ChatRoom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.school21.chat.settings.ColumnName.CHAT_ID;
import static edu.school21.chat.settings.ColumnName.CHAT_NAME;
import static edu.school21.chat.settings.ColumnName.CHAT_OWNER;
import static edu.school21.chat.settings.ColumnName.CHAT_TABLE_NAME;
import static edu.school21.chat.settings.ColumnName.CHAT_USER_CHAT_ID;
import static edu.school21.chat.settings.ColumnName.CHAT_USER_TABLE;
import static edu.school21.chat.settings.ColumnName.CHAT_USER_USER_ID;
import static edu.school21.chat.settings.ColumnName.MESSAGE_ID;
import static edu.school21.chat.settings.ColumnName.MESSAGE_ROOM;
import static edu.school21.chat.settings.ColumnName.MESSAGE_TABLE_NAME;
import static edu.school21.chat.settings.ColumnName.USER_ID;
import static edu.school21.chat.settings.ColumnName.USER_TABLE_NAME;

public class ChatDao {

  public ChatRoom getChat(int id) {
    String getChatById = "SELECT * FROM " + CHAT_TABLE_NAME.getColumnName() + " where " + CHAT_ID.getColumnName() + " = ?";
    PreparedStatement ps = Program.preparedStatement(getChatById);
    try {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      ChatRoom chatRoom = null;
      if (resultSet.next()) {
        int chatId = resultSet.getInt(CHAT_ID.getColumnName());
        int owner = resultSet.getInt(CHAT_OWNER.getColumnName());
        String name = resultSet.getString(CHAT_NAME.getColumnName());
        chatRoom = new ChatRoom(chatId, name, owner, getUserIdByChatId(id), getMessageIdByChatId(id));
      }
      ps.close();
      return chatRoom;
    } catch (SQLException e) {
      throw new RuntimeException("Error get result", e);
    }
  }

  public List<Integer> getMessageIdByChatId(int id) {
    String getMessageIdByChatId = "SELECT m." + MESSAGE_ID.getColumnName() + " FROM "
      + MESSAGE_TABLE_NAME.getColumnName() + " m "
      + "WHERE m." + MESSAGE_ROOM.getColumnName() + " = ?";
    PreparedStatement ps = Program.preparedStatement(getMessageIdByChatId);
    List<Integer> messagesId = new ArrayList<Integer>();
    try {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        int messageId = resultSet.getInt(MESSAGE_ID.getColumnName());
        messagesId.add(messageId);
      }
      return messagesId;
    } catch (SQLException e) {
      throw new RuntimeException("Error get result", e);
    }
  }

  public List<Integer> getUserIdByChatId(int id) {
    String getChatIdByUserId = "SELECT u." + USER_ID.getColumnName() + " FROM "
      + CHAT_TABLE_NAME.getColumnName() + " cr "
      + "LEFT JOIN " + CHAT_USER_TABLE.getColumnName() + " uc on cr." + CHAT_ID.getColumnName()
      + " = uc." + CHAT_USER_CHAT_ID.getColumnName()
      + " LEFT JOIN \"" + USER_TABLE_NAME.getColumnName() + "\" u on uc."
      + CHAT_USER_USER_ID.getColumnName() + " = u." + USER_ID.getColumnName()
      + " WHERE cr." + CHAT_ID.getColumnName() + " = ?";
    List<Integer> usersId = new ArrayList<Integer>();
    PreparedStatement ps = Program.preparedStatement(getChatIdByUserId);
    try {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        int userId = resultSet.getInt(USER_ID.getColumnName());
        usersId.add(userId);
      }
      ps.close();
      return usersId;
    } catch (SQLException e) {
      throw new RuntimeException("Error get result", e);
    }
  }
}
