create table if not exists "User"
(
	user_id bigserial not null
		constraint "User_pkey"
			primary key,
	login text not null,
	password text not null
);

alter table "User" owner to postgres;

create unique index if not exists user_login_uindex
	on "User" (login);

create unique index if not exists user_user_id_uindex
	on "User" (user_id);

create table if not exists chatroom
(
	chatroom_id bigserial not null
		constraint chatroom_pkey
			primary key,
	chatroom_name text not null,
	chatroom_owner integer not null
		constraint chatroom_user_user_id_fk
			references "User"
);

alter table chatroom owner to postgres;

create unique index if not exists chatroom_chatroom_id_uindex
	on chatroom (chatroom_id);

create unique index if not exists chatroom_chatroom_owner_uindex
	on chatroom (chatroom_owner);

create table if not exists message
(
	message_id bigserial not null
		constraint message_pkey
			primary key,
	message_author integer
		constraint message_user_user_id_fk
			references "User",
	message_room integer
		constraint message_chatroom_chatroom_id_fk
			references chatroom,
	message_text text,
	message_date timestamp default CURRENT_TIMESTAMP
);

alter table message owner to postgres;

create unique index if not exists message_message_id_uindex
	on message (message_id);

create table if not exists userschats
(
	id bigserial not null
		constraint userschats_pkey
			primary key,
	user_id integer not null
		constraint userschats_user_user_id_fk
			references "User",
	chat_id integer not null
		constraint userschats_chatroom_chatroom_id_fk
			references chatroom
);

alter table userschats owner to postgres;

create unique index if not exists userschats_id_uindex
	on userschats (id);

