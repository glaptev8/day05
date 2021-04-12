INSERT INTO "User" (login, password) VALUES ('admin', 'admin');
INSERT INTO "User" (login, password) VALUES ('laptev', 'admin');
INSERT INTO "User" (login, password) VALUES ('school21', 'admin');

INSERT INTO "chatroom" (chatroom_name, chatroom_owner) VALUES ('chat1', 1);
INSERT INTO "chatroom" (chatroom_name, chatroom_owner) VALUES ('chat2', 2);

INSERT INTO "userschats" (user_id, chat_id) VALUES (1, 1);
INSERT INTO "userschats" (user_id, chat_id) VALUES (1, 2);
INSERT INTO "userschats" (user_id, chat_id) VALUES (2, 1);
INSERT INTO "userschats" (user_id, chat_id) VALUES (3, 1);
INSERT INTO "userschats" (user_id, chat_id) VALUES (3, 2);

INSERT INTO "message" (message_author, message_room, message_text, message_date) VALUES (1, 1, 'hi, my name is admin', current_date);
INSERT INTO "message" (message_author, message_room, message_text, message_date) VALUES (1, 1, 'and i"m" coder ', current_date);
INSERT INTO "message" (message_author, message_room, message_text, message_date) VALUES (1, 2, 'hi my friends', current_date);
INSERT INTO "message" (message_author, message_room, message_text, message_date) VALUES (1, 2, 'today we will chill', current_date);
INSERT INTO "message" (message_author, message_room, message_text, message_date) VALUES (2, 1, 'glad to see you admin"', current_date);
INSERT INTO "message" (message_author, message_room, message_text, message_date) VALUES (1, 2, 'it is good news', current_date);