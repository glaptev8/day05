package edu.school21.chat.models;

import java.util.Date;
import java.util.Objects;

public class Message {
  private int id;
  private int authorId;
  private int chatId;
  private String message;
  private Date date;

  public Message(int id, int authorId, int chatId, String message, Date date) {
    this.id = id;
    this.authorId = authorId;
    this.chatId = chatId;
    this.message = message;
    this.date = date;
  }

  public Message(int authorId, int chatId, String message, Date date) {
    this.authorId = authorId;
    this.chatId = chatId;
    this.message = message;
    this.date = date;
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }

  public int getChatId() {
    return chatId;
  }

  public void setChatId(int chatId) {
    this.chatId = chatId;
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

  public void setId(int id) {
    this.id = id;
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
}
