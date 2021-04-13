package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class ChatRoom {
  private Long id;
  private String chatName;
  private User chatOwner;
  private List<Integer> messages;

  public ChatRoom(Long id, String chatName, User chatOwner, List<Integer> messages) {
    this.id = id;
    this.chatName = chatName;
    this.chatOwner = chatOwner;
    this.messages = messages;
  }

  public ChatRoom(Long id, String chatName, User chatOwner) {
    this.id = id;
    this.chatName = chatName;
    this.chatOwner = chatOwner;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getChatName() {
    return chatName;
  }

  public void setChatName(String chatName) {
    this.chatName = chatName;
  }

  public List<Integer> getMessages() {
    return messages;
  }

  public void setMessages(List<Integer> messages) {
    this.messages = messages;
  }

  public User getChatOwner() {
    return chatOwner;
  }

  public void setChatOwner(User chatOwner) {
    this.chatOwner = chatOwner;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ChatRoom)) return false;
    ChatRoom chatRoom = (ChatRoom) o;
    return id == chatRoom.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "ChatRoom{" +
      "id=" + id +
      ", chatName='" + chatName + '\'' +
      ", chatOwner=" + chatOwner +
      ", messages=" + messages +
      '}';
  }
}
