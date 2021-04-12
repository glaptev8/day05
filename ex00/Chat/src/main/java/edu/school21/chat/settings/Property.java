package edu.school21.chat.settings;

import java.io.IOException;
import java.util.Properties;

public enum Property {
  JDBC_URL("jdbc.url"),
  JDBC_USER_NAME("jdbc.user.name"),
  JDBC_USER_PASSWORD("jdbc.user.password"),
  JDBC_DATABASE("jdbc.user.database");

  String name;
  String value;
  Properties properties = new Properties();
  {
    try {
      properties.load(Property.class.getResourceAsStream("/application.properties"));
    } catch (IOException e) {
      throw new RuntimeException("Error get property", e);
    }

  }
  Property(String name) {
    this.name = name;
    this.value = properties.getProperty(name);
  }

  public String getValue() {
    return value;
  }
}
