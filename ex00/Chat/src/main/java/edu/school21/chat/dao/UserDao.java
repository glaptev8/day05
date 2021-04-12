package edu.school21.chat.dao;

import edu.school21.chat.Program;
import edu.school21.chat.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.school21.chat.settings.ColumnName.CHAT_ID;
import static edu.school21.chat.settings.ColumnName.CHAT_TABLE_NAME;
import static edu.school21.chat.settings.ColumnName.CHAT_USER_CHAT_ID;
import static edu.school21.chat.settings.ColumnName.CHAT_USER_TABLE;
import static edu.school21.chat.settings.ColumnName.CHAT_USER_USER_ID;
import static edu.school21.chat.settings.ColumnName.USER_ID;
import static edu.school21.chat.settings.ColumnName.USER_LOGIN;
import static edu.school21.chat.settings.ColumnName.USER_PASSWORD;
import static edu.school21.chat.settings.ColumnName.USER_TABLE_NAME;

public class UserDao {
  public User getUserById(int id) {
    String getUserById = "SELECT * FROM \"" + USER_TABLE_NAME.getColumnName() + "\" where " + USER_ID.getColumnName() + " = ?";
    PreparedStatement ps = Program.preparedStatement(getUserById);
    try {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      User user = null;
      if (resultSet.next()) {
        int userId = resultSet.getInt(USER_ID.getColumnName());
        String login = resultSet.getString(USER_LOGIN.getColumnName());
        String password = resultSet.getString(USER_PASSWORD.getColumnName());
        user = new User(userId, login, password, getChatIdByUserId(id));
      }
      ps.close();
      return user;
    } catch (SQLException e) {
      throw new RuntimeException("Error get result", e);
    }
  }

  public List<Integer> getChatIdByUserId(int id) {
    String getChatIdByUserId = "SELECT cr." + CHAT_ID.getColumnName() + " FROM "
      + CHAT_TABLE_NAME.getColumnName() + " cr "
      + "LEFT JOIN " + CHAT_USER_TABLE.getColumnName() + " uc on cr." + CHAT_ID.getColumnName()
      + " = uc." + CHAT_USER_CHAT_ID.getColumnName()
      + " LEFT JOIN \"" + USER_TABLE_NAME.getColumnName() + "\" u on uc."
      + CHAT_USER_USER_ID.getColumnName() + " = u." + USER_ID.getColumnName()
      + " WHERE u." + USER_ID.getColumnName() + " = ?";
    List<Integer> chats = new ArrayList<Integer>();
    PreparedStatement ps = Program.preparedStatement(getChatIdByUserId);
    try {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        int chatId = resultSet.getInt(CHAT_ID.getColumnName());
        chats.add(chatId);
      }
      ps.close();
      return chats;
    } catch (SQLException e) {
      throw new RuntimeException("Error get result", e);
    }


  }
}
