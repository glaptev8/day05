package edu.school21.chat.models;

import java.util.Date;
import java.util.Objects;

public class Message {
  private Long id;
  private User authorId;
  private ChatRoom chatId;
  private String message;
  private Date date;

  public Message(Long id, User authorId, ChatRoom chatId, String message, Date date) {
    this.id = id;
    this.authorId = authorId;
    this.chatId = chatId;
    this.message = message;
    this.date = date;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public User getAuthorId() {
    return authorId;
  }

  public void setAuthorId(User authorId) {
    this.authorId = authorId;
  }

  public ChatRoom getChatId() {
    return chatId;
  }

  public void setChatId(ChatRoom chatId) {
    this.chatId = chatId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Message)) return false;
    Message message = (Message) o;
    return id == message.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Message{" +
      "id=" + id +
      ", authorId=" + authorId +
      ", chatId=" + chatId +
      ", message='" + message + '\'' +
      ", date=" + date +
      '}';
  }
}
