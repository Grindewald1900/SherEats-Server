/* Calculate order consumption: 第一种是查单个订单，第二种是根据用户id查总订单*/
select sum(items.item_price * userorders.item_amount * items.item_discount) as consumption from items,userorders
where userorders.order_id = 00003 and items.item_id = userorders.item_id;

select userorders.order_id,sum(items.item_price * userorders.item_amount * items.item_discount) as consumption from items,userorders
where items.item_id = userorders.item_id and userorders.user_id =002268087 
group by userorders.order_id
order by userorders.order_id ASC;

/* Personal information */
select * from users;


/* contact stores */
select store_id, store_name, store_tel from stores
where store_name like ('%Sballo%');

/* find dishes */
select store_id,item_name,item_price,item_discount from items
where store_id = 3;

/* Calculate store rating */
select store_name, store_address, store_genre,store_average, store_tel,store_lat,store_long,store_pic,(avg(userorders.item_taste)+avg(userorders.item_environment)+avg(userorders.item_service))/3 
as rating from stores,userorders
where userorders.store_id = stores.store_id
group by store_name, store_address, store_genre,store_average, store_tel,store_lat,store_long,store_pic
order by rating DESC;

/* Calculate item rating */
select store_name,item_name,item_genre,item_price,item_discount,avg(userorders.item_taste)as taste,avg(userorders.item_environment)as environment,
avg(userorders.item_service)as service from items,userorders
group by store_name,item_name,item_genre,item_price,item_discount;

/* search items: burger*/
select store_name,item_name,item_genre,item_price,item_discount,(avg(userorders.item_taste)+avg(userorders.item_environment)+
avg(userorders.item_service))/3 as rating from items,userorders
where items.item_id = userorders.item_id and item_genre like lower('%burger%')
group by store_name,item_name,item_genre,item_price,item_discount
order by item_discount ASC;


