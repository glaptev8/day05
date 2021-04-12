package edu.school21.chat.models;

import java.util.List;

public class ChatRoom {
  private int id;
  private String chatName;
  private int chatOwner;
  private List<Integer> members;
  private List<Integer> messages;

  public ChatRoom(int id, String chatName, int chatOwner, List<Integer> members, List<Integer> messages) {
    this.id = id;
    this.chatName = chatName;
    this.chatOwner = chatOwner;
    this.members = members;
    this.messages = messages;
  }

  public ChatRoom(int id, String chatName, int chatOwner, List<Integer> members) {
    this.id = id;
    this.chatName = chatName;
    this.chatOwner = chatOwner;
    this.members = members;
  }

  public ChatRoom(String chatName, int chatOwner) {
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

  public int getChatOwner() {
    return chatOwner;
  }

  public void setChatOwner(int chatOwner) {
    this.chatOwner = chatOwner;
  }

  public List<Integer> getMembers() {
    return members;
  }

  public void setMembers(List<Integer> members) {
    this.members = members;
  }

  public List<Integer> getMessages() {
    return messages;
  }

  public void setMessages(List<Integer> messages) {
    this.messages = messages;
  }
}
