package edu.school21.chat.models;

import java.util.Date;
import java.util.Objects;

public class Message {
  private Long id;
  private User author;
  private ChatRoom chat;
  private String message;
  private Date date;

  public Message(Long id, User author, ChatRoom chat, String message, Date date) {
    this.id = id;
    this.author = author;
    this.chat = chat;
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

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public ChatRoom getChat() {
    return chat;
  }

  public void setChat(ChatRoom chat) {
    this.chat = chat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Message)) return false;
    Message message = (Message) o;
    return id.equals(message.id) &&
      date.equals(message.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date);
  }

  @Override
  public String toString() {
    return "Message{" +
      "id=" + id +
      ", author=" + author +
      ", chat=" + chat +
      ", message='" + message + '\'' +
      ", date=" + date +
      '}';
  }
}
