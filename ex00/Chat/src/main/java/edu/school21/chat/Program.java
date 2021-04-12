package edu.school21.chat;

import edu.school21.chat.models.ChatRoom;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
  public static void main(String[] args) {
    ChatDao chatDao = new ChatDao();
    ChatRoom chat = chatDao.getChat(1);
    System.out.println("1");
  }

  static public Connection getConnection() {
    try {
      DriverManager.registerDriver(new Driver());
      return DriverManager.getConnection(Property.JDBC_URL.getValue(), Property.JDBC_USER_NAME.getValue(), Property.JDBC_USER_PASSWORD.getValue());
    } catch (SQLException e) {
      throw new RuntimeException("Error connecting to the database", e);
    }
  }

  static public PreparedStatement preparedStatement(String sql) {
    PreparedStatement ps;
    try {
      ps = getConnection().prepareStatement(sql);
    } catch (SQLException e) {
      throw new RuntimeException("Error request to database", e);
    }
    return ps;
  }
}