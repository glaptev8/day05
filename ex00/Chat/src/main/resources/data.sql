INSERT INTO "User" (login, password)
VALUES ('admin', 'admin');
INSERT INTO "User" (login, password)
VALUES ('laptev', 'admin');
INSERT INTO "User" (login, password)
VALUES ('school21', 'admin');
INSERT INTO "chatroom" (chatroom_name, chatroom_owner)
VALUES ('chat1', 1);
INSERT INTO "chatroom" (chatroom_name, chatroom_owner)
VALUES ('chat2', 2);
INSERT INTO "userschats" (user_id, chat_id)
VALUES (1, 1);
INSERT INTO "userschats" (user_id, chat_id)
VALUES (1, 2);
INSERT INTO "userschats" (user_id, chat_id)
VALUES (2, 1);
INSERT INTO "userschats" (user_id, chat_id)
VALUES (3, 1);
INSERT INTO "userschats" (user_id, chat_id)
VALUES (3, 2);

INSERT INTO "message" (message_author, message_room, message_text, message_date)
VALUES (1, 1, 'hi, my name is admin', current_timestamp);
INSERT INTO "message" (message_author, message_room, message_text, message_date)
VALUES (1, 1, 'and i"m" coder ', current_timestamp);
INSERT INTO "message" (message_author, message_room, message_text, message_date)
VALUES (1, 2, 'hi my friends', current_timestamp);
INSERT INTO "message" (message_author, message_room, message_text, message_date)
VALUES (1, 2, 'today we will chill', current_timestamp);
INSERT INTO "message" (message_author, message_room, message_text, message_date)
VALUES (2, 1, 'glad to see you admin"', current_timestamp);
INSERT INTO "message" (message_author, message_room, message_text, message_date)
VALUES (1, 2, 'it is good news', current_timestamp);

SELECT u.user_id, u.login, cr.chatroom_name
FROM "User" u
         LEFT JOIN userschats uc ON uc.user_id = u.user_id
         LEFT JOIN chatroom cr ON cr.chatroom_id = uc.chat_id
WHERE cr.chatroom_id = 1;

SELECT cr.chatroom_id
FROM chatroom cr
         LEFT JOIN userschats uc on cr.chatroom_id = uc.chat_id
         LEFT JOIN "User" u on uc.user_id = u.user_id
WHERE u.user_id = 3;

SELECT u.user_id
FROM chatroom cr
         LEFT JOIN userschats uc on cr.chatroom_id = uc.chat_id
         LEFT JOIN "User" u on uc.user_id = u.user_id
WHERE cr.chatroom_id = 1;

SELECT * FROM message m
WHERE m.message_id = 1;

SELECT m.message_id FROM message m
WHERE m.message_room = 1;
