package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
  private Long i;
  private String login;
  private String password;
  private List<ChatRoom> createChats;
  private List<ChatRoom> allChats;

  public User(Long i, String login, String password) {
    this.i = i;
    this.login = login;
    this.password = password;
  }

  public User(Long i, String login, String password, List<ChatRoom> createChats) {
    this.i = i;
    this.login = login;
    this.password = password;
    this.createChats = createChats;
  }

  public User(Long i, String login, String password, List<ChatRoom> createChats, List<ChatRoom> allChats) {
    this.i = i;
    this.login = login;
    this.password = password;
    this.createChats = createChats;
    this.allChats = allChats;
  }

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public Long getI() {
    return i;
  }

  public void setI(Long i) {
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

  public List<ChatRoom> getCreateChats() {
    return createChats;
  }

  public void setCreateChats(List<ChatRoom> createChats) {
    this.createChats = createChats;
  }

  public List<ChatRoom> getAllChats() {
    return allChats;
  }

  public void setAllChats(List<ChatRoom> allChats) {
    this.allChats = allChats;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return i.equals(user.i) &&
      login.equals(user.login);
  }

  @Override
  public int hashCode() {
    return Objects.hash(i, login);
  }

  @Override
  public String toString() {
    return "User{" +
      "i=" + i +
      ", login='" + login + '\'' +
      ", password='" + password + '\'' +
      ", createChats=" + createChats +
      ", allChats=" + allChats +
      '}';
  }
}
