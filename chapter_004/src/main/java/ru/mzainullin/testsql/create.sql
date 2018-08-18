-- create database
create database items;

-- create tables
create table users (
	user_id serial primary key,
	user_name varchar(255)
);

create table role (
	role_id serial primary key,
	role_name varchar(255),
	user_id int references users(user_id)
);

create table items (
	item_id serial primary key,
	item_name varchar(255),
	user_id int references users(user_id)
);

create table rules (
	rule_id serial primary key,
	role_id int references role(role_id),
	user_id int references users(user_id)
);

create table comments (
	comment_id serial primary key,
	comment_desc text,
	item_id int references items(item_id)
);

create table attachs (
	attach_id serial primary key,
	file_name varchar(255),
	item_id int references items(item_id)
);

create table category (
	category_id serial primary key,
	category_name varchar(255),
	item_id int references items(item_id)
);

create table state (
	state_id serial primary key,
	state_name varchar(255),
	item_id int references items(item_id)
);

-- insert into tables

insert into users (user_name) values
('admin'), ('root');

insert into role (role_name, user_id) values
('admin', 1), ('guest', 2);

insert into rules(role_id, user_id) values
(1, 1), (2, 2);

insert into items(item_name, user_id) values
('product 1', 1), ('product 1', 2), ('product 3', 2), ('product 4', 2);

insert into comments(comment_desc, item_id) values
('Комментарий 1', 1), ('Комментарий 2', 2), ('Комментарий 3', 3);

insert into attachs(file_name, item_id) values
('Readme.txt', 1), ('img.png', 2);

insert into category(category_name, item_id) values
('gold', 1), ('silver', 2), ('silver', 3);

insert into state(state_name, item_id) values
('success', 1), ('success', 2), ('Нет в наличии', 3);