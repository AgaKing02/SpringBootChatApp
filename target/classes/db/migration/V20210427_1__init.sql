drop table if exists users;
create table users
(
    id   serial,
    name varchar(255)
);

drop table if exists chat;
create table chat
(
    id serial,
    name varchar(255)
);

drop table if exists message;
create table message
(
    id serial,
    user_id bigint,
    chat_id bigint,
    text varchar(255)

);

drop table if exists participant;
create table participant
(
    id serial,
    user_id bigint,
    chat_id bigint
);

