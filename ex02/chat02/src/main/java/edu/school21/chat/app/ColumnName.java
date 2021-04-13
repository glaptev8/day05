package edu.school21.chat.app;

public enum ColumnName {
  USER_TABLE_NAME("User"),
  USER_ID("user_id"),
  USER_LOGIN("login"),
  USER_PASSWORD("password"),
  MESSAGE_TABLE_NAME("message"),
  MESSAGE_ID("message_id"),
  MESSAGE_AUTHOR("message_author"),
  MESSAGE_ROOM("message_room"),
  MESSAGE_TEXT("message_text"),
  MESSAGE_DATE("message_date"),
  CHAT_TABLE_NAME("chatroom"),
  CHAT_ID("chatroom_id"),
  CHAT_NAME("chatroom_name"),
  CHAT_OWNER("chatroom_owner"),
  CHAT_USER_TABLE("userschats"),
  CHAT_USER_USER_ID("user_id"),
  CHAT_USER_CHAT_ID("chat_id");

  String columnName;

  ColumnName(String columnName) {
    this.columnName = columnName;
  }

  public String getColumnName() {
    return columnName;
  }
}
