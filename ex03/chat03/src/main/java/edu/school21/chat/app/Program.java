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
    MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(ds);
    Optional<Message> optionalMessage = messagesRepository.findById(7L);
    Message message;
    if (optionalMessage.isPresent()) {
      message = optionalMessage.get();
      message.setMessage("444");
      message.setDate(null);
      messagesRepository.update(message);
    }
    optionalMessage = messagesRepository.findById(7L);
    optionalMessage.ifPresent(System.out::println);
  }
}
