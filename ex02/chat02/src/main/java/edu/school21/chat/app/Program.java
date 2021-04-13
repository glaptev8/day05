package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class Program {

  private static HikariConfig config = new HikariConfig();
  private static HikariDataSource ds;

  static {
    config.setJdbcUrl(Property.JDBC_URL.getValue());
    config.setUsername(Property.JDBC_USER_NAME.getValue());
    config.setPassword(Property.JDBC_USER_PASSWORD.getValue());
    config.addDataSourceProperty( "cachePrepStmts" , "true" );
    config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
    config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
    ds = new HikariDataSource( config );
  }

  public static void main(String[] args) {
    User creator = new User(2L, "user", "user", new ArrayList<>(), new ArrayList<>());
    ChatRoom room = new ChatRoom(1L, "room", creator, new ArrayList<>());
    Message message = new Message(null, creator, room, "create with help jdbc!", LocalDateTime.now());
    MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(ds);
    messagesRepository.save(message);
    Optional<Message> byId = messagesRepository.findById(8L);
    byId.ifPresent(System.out::println);
  }
}
