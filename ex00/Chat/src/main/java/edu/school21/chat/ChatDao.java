package edu.school21.chat;

import edu.school21.chat.models.ChatRoom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatDao {

  public ChatRoom getChat(int id) {
    String getChatById = "SELECT * FROM chatroom where chatroom_id = ?";
    PreparedStatement ps = Program.preparedStatement(getChatById);
    try {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      ChatRoom chatRoom = null;
      if (resultSet.next()) {
        int chatId = resultSet.getInt("chatroom_id");
        String owner = resultSet.getString("chatroom_owner");
        String name = resultSet.getString("chatroom_name");
        chatRoom = new ChatRoom(chatId, name, owner, null);
      }
      return chatRoom;
    } catch (SQLException e) {
      throw new RuntimeException("Error get result", e);
    }

  }
}
