package edu.school21.chat.models;

import java.util.List;

public class ChatRoom {
  private int id;
  private String chatName;
  private String chatOwner;
  private List<User> members;

  public ChatRoom(int id, String chatName, String chatOwner, List<User> members) {
    this.id = id;
    this.chatName = chatName;
    this.chatOwner = chatOwner;
    this.members = members;
  }

  public ChatRoom(String chatName, String chatOwner) {
    this.chatName = chatName;
    this.chatOwner = chatOwner;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getChatName() {
    return chatName;
  }

  public void setChatName(String chatName) {
    this.chatName = chatName;
  }

  public String getChatOwner() {
    return chatOwner;
  }

  public void setChatOwner(String chatOwner) {
    this.chatOwner = chatOwner;
  }

  public List<User> getMembers() {
    return members;
  }

  public void setMembers(List<User> members) {
    this.members = members;
  }
}
