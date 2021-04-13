package edu.school21.chat;

import edu.school21.chat.dao.ChatDao;
import edu.school21.chat.dao.MessageDao;
import edu.school21.chat.dao.UserDao;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.settings.Property;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
  public static void main(String[] args) {
    ChatDao chatDao = new ChatDao();
    ChatRoom chat = chatDao.getChat(1);
    UserDao userDao = new UserDao();
    User user = userDao.getUserById(1);
    MessageDao messageDao = new MessageDao();
    Message messageByID = messageDao.getMessageByID(1);
    System.out.println("1");
  }

  static public DataSource getDataSource() {
    PGSimpleDataSource dataSource = new PGSimpleDataSource();
    dataSource.setServerNames(new String[]{"localhost"});
    dataSource.setDatabaseName(Property.JDBC_DATABASE.getValue());
    dataSource.setUser(Property.JDBC_USER_NAME.getValue());
    dataSource.setPassword(Property.JDBC_USER_PASSWORD.getValue());
    return dataSource;
  }

  static public Connection getConnection() {
    try {
      return getDataSource().getConnection();
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
