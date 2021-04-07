DROP table users, stores, items, orders, user_events;

create table users(
	user_id int not null,
	user_name varchar(20) not null,
	user_password varchar(40) not null,
	user_birthday date not null,
	user_gender char(1) default 'M' CHECK (user_gender in('M','F')) not null,
	user_tel varchar(12) not null,
	user_mail varchar(40),
	user_icon bytea,
	primary key(user_id),
	unique(user_name)
);

create table stores(
	store_id int not null,
	store_name varchar(20) not null,
	store_password varchar(40),
	store_address varchar(100) not null,
	store_genre varchar(20),
	store_average float,
	store_tel varchar(12) not null,
	store_lat float not null,
	store_long float not null,
	store_pic bytea,
	store_taste float,
	store_environment float,
	store_service float,
	primary key(store_id)
);

create table items(
	store_id int not null,
	store_name varchar(20) not null,
	item_id int not null,
	item_name varchar(40) not null,
	item_genre varchar(20),
	item_price float not null,
	item_pic bytea,
	item_discount float default 1,
	item_taste float,
	item_environment float,
	item_service float,
	primary key(item_id),
	foreign key(store_id) references stores(store_id)
	    on delete cascade on update cascade
);

-- create table order_item(
-- 	id int not null
-- 	item_id int
-- 	item_price float not null
-- 	item_count int not null
-- 	primary key(id)
-- );

create table orders(
	id serial,
	order_id int not null,
	user_id int not null,
	store_id int not null,
	upload_time date,
	item_id int not null,
	item_amount int,
	item_taste int CHECK (item_taste in(1,2,3,4,5)),
	item_environment int CHECK (item_environment in(1,2,3,4,5)),
	item_service int CHECK (item_service in(1,2,3,4,5)),
	foreign key (store_id) references stores(store_id)
	    on delete cascade on update cascade,
	foreign key (user_id) references users(user_id)
	    on delete cascade on update cascade,
	foreign key (item_id) references items(item_id)
	    on delete cascade on update cascade
);

create table user_events(
	event_id int not null,
	user_id int not null,
	store_id int,
	event_type varchar(20) not null,
	primary key (event_id),
	foreign key (user_id) references users(user_id)
	    on delete cascade on update cascade,
	foreign key (store_id) references stores(store_id)
	    on delete cascade  on update cascade
);

