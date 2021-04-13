package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Scanner;

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
    System.out.println("Enter message ID");
    Scanner sc = new Scanner( System.in );
    Long id = null;
    while (sc.hasNext()) {
      if (sc.hasNextLong()) {
        id = sc.nextLong();
        break;
      }
      System.out.println("print number please");
      sc.next();
    }
    MessagesRepositoryJdbcImpl messagesRepository = new MessagesRepositoryJdbcImpl(ds);
    Optional<Message> message = messagesRepository.findById(id);

    if (message.isPresent()) {
      System.out.println(message);
    } else {
      System.out.println("message by id = " + id + " not found");
    }
  }
}
