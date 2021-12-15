DROP table users, restaurants, items, orders;

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

create table restaurants(
	restaurant_id int not null,
	restaurant_name varchar(20) not null,
	-- store_password varchar(40),
	restaurant_address varchar(100) not null,
	restaurant_genre varchar(20),
	restaurant_average float,
	restaurant_tel varchar(12) not null,
	restaurant_lat float not null,
	restaurant_long float not null,
    restaurant_isFav varchar(5) not null,
	primary key(restaurant_id)
);

create table items(
	restaurant_id int not null,
	restaurant_name varchar(20) not null,
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
	foreign key(restaurant_id) references restaurants(restaurant_id)
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
	restaurant_id int not null,
	upload_time date,
	item_id int not null,
	item_amount int,
	item_taste int CHECK (item_taste in(1,2,3,4,5)),
	item_environment int CHECK (item_environment in(1,2,3,4,5)),
	item_service int CHECK (item_service in(1,2,3,4,5)),
	foreign key (restaurant_id) references restaurants(restaurant_id)
	    on delete cascade on update cascade,
	foreign key (user_id) references users(user_id)
	    on delete cascade on update cascade,
	foreign key (item_id) references items(item_id)
	    on delete cascade on update cascade
);

