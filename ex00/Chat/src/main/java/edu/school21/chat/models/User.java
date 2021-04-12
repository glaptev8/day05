package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
  private int i;
  private String login;
  private String password;
  private List<Integer> chatRooms;

  public User(int i, String login, String password) {
    this.i = i;
    this.login = login;
    this.password = password;
  }

  public User(int i, String login, String password, List<Integer> chatRooms) {
    this.i = i;
    this.login = login;
    this.password = password;
    this.chatRooms = chatRooms;
  }

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Integer> getChatRooms() {
    return chatRooms;
  }

  public void setChatRooms(List<Integer> chatRooms) {
    this.chatRooms = chatRooms;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return i == user.i;
  }

  @Override
  public int hashCode() {
    return Objects.hash(i);
  }
}
