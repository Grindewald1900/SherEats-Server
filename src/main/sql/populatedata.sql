/* Add Users*/
delete from users;
insert into users values('002269013','Yi Ren','renyi002269013','1994-09-24','M','2233445567','renyi@gmail.com');
insert into users values('002276355','Wentao Lu','luwentao002276355','1990-03-08','M','1122334458','luwentao@gmail.com');
insert into users values('002000000','aaa','aaa','1990-03-10','F','1224535440','aaabbb@gmail.com');
insert into users values('000000100','yee','aaa','1990-03-10','F','1224535440','123456@gmail.com');


/* Add restaurants: 因为缺少实验数据，人均消费栏由商家自行填写 */
delete from restaurants;
insert into restaurants values(0001,'McDonalds','110 Rue Queen, Sherbrooke, QC J1M 1J6','Fast Food',13,
						 '+18195635828',45.36750783294007, -71.85578947857024, 'T');
insert into restaurants values(0002,'Tim Hortons','89 Rue Queen, Sherbrooke, QC J1M 1J5','Fast Food',9,
						 '+18198237007',45.3654632370656, -71.85717677305372, 'F');
insert into restaurants values(0003,'Sushi King','1234 Rue King Ouest, Sherbrooke, QC J1H 1S2','Japanese Style',15,
						 '+18197912438', 45.39877034787492, -71.90770061538169, 'F');
insert into restaurants values(0004,'Chez Stanley','1180 Rue King E, Sherbrooke, QC J1G 1E4','Sports Bar',30,
						 '+18195623350',45.40812828776601, -71.8627545730523,'T');
insert into restaurants values(0005,'Antidote FoodLab','35 Rue Belvédère N suite 10, Sherbrooke, Quebec J1H 4A7',
						 'Canadian Style',50, '+18197919117', 45.399877868749506, -71.89720360845091, 'T');
insert into restaurants values(0006,'Chez Freddy Pizzeria','835 Rue du Conseil, Sherbrooke, QC J1G 3L2',
						 'Pizza',17,'+18198212248',45.404532386620524, -71.8707963005016, 'F');
insert into restaurants values(0007,'Sballo','34 Rue Wellington N, Sherbrooke, QC J1H 5B7','Italian Style',55,
						  '+18197913559', 45.40284504094125, -71.89058027369387,'T');
insert into restaurants values(0008,'Restaurant An Phu','1105 Rue King E, Sherbrooke, QC J1G 1E5',
						 'Vietnamese Style',20,'+18195691445',45.409081942402146, -71.86470232260079,'T');
insert into restaurants values(0009,'Bâton Rouge Steakhouse & Bar','2844 Rue King O, Sherbrooke, QC J1L 1C5',
						 'Canadian Style',20,'+18193469888',45.397360883078335, -71.94195772279187,'T');
insert into restaurants values(0010,'Starbucks','2201 Rue King O, Sherbrooke, QC J1J 2G2',
						 'Coffee',22,'+18195691445',45.39912831981553, -71.92763326114012,'T');
insert into restaurants values(0011,'Café Dépôt Sherbrooke','Carrefour de l''Estrie, 3050 Boul de Portland, Sherbrooke, QC J1L 1K1',
						 'Coffee',20,'+18195691445',45.401579876276195, -71.95279212677053,'T');
insert into restaurants values(0012,'Brasserie Seigneurie, Steakhouse & Bar','14 Rue Léger, Sherbrooke, QC J1L 1W1',
						 'Canadian Style',20,'+18195691445',45.3866019281863, -71.96373425360962,'T');
insert into restaurants values(0013,'Caffuccino','4257 Boul Bourque, Sherbrooke, QC J1N 1S4',
						 'Canadian Style',20,'+18195691445',45.384044325982615, -71.96734517035223,'T');
insert into restaurants values(0014,'Créme Glacée En Folie','2684 Rue Galt O, Sherbrooke, QC J1K 2X2',
						 'Canadian Style',20,'+18195691445',45.38698382135774, -71.93945737742932,'T');
insert into restaurants values(0015,'Au Coin du Vietnam','1530 Rue Galt O, Sherbrooke, QC J1H 2B4',
						 'Vietnamese Style',20,'+18195691445',45.38706947871017, -71.912783479273,'F');
insert into restaurants values(0016,'Subway','1515 Rue Dunant, Sherbrooke, QC J1H 5N6',
						 'Fast Food',20,'+18195691445',45.38364418448974, -71.89949276417899,'T');
insert into restaurants values(0017,'Domino''s Pizza','1105 Rue  S, Sherbrooke, Quebec J1H 4C8',
						 'Pizza',25,'+18195691445',45.38982554181572, -71.89630534546536,'T');










/* Add Items: 商品分类也由商家自行添加（用于菜单搜索，分类细则会写在platform表格里）*/
delete from items;
insert into items (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0001,'McDonalds',00001,'Big Mac Bacon','burger',10, 4.1);
insert into items (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0001,'McDonalds',00002,'Double Western BBQ Quarter Pounder','burger',12.02, 3.9);
insert into items (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0002,'Tim Hortons',00003,'Brewed Coffee','coffee',1.76, 4.2);
insert into items (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0002,'Tim Hortons',00004,'Crispy Chicken Sandwich','sandwish',3.98, 5.0);
insert into items (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0002,'Tim Hortons',00005,'Beef Burger','burger',4.99, 4.6);
insert into items (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0003,'Sushi King',00006,'Salmon Sushi 6 pcs','sushi',5.95, 3.4);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0003,'Sushi King',00007,'Mix Salade','salade',7.75, 3.2);
insert into items (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0004,'Chez Stanley',00008,'Salade grecque','salade',15, 3.8);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0004,'Chez Stanley',00009,'Pepsi','beverage',2.50, 2.8);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0004,'Chez Stanley',00010,'Stanly Pizza','pizza',17.49, 3.9);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0005,'Antidote FoodLab',00011,'Salmon','fish dishes',28, 2.4);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0005,'Antidote FoodLab',00012,'Duck Breast','duck dishes',35, 3.6);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0005,'Antidote FoodLab',00013,'Toscana Pietranera 2018, Piaggia','wine',130, 4.5);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0006,'Chez Freddy Pizzeria',00014,'Italian Pizza','pizza',15.99, 4.7);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0006,'Chez Freddy Pizzeria',00015,'Club Sandwish','sandwish',13.99, 4.2);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0007,'Sballo',00016,'Carnaroli Risotto Seafood','seafood dishes',38, 3.8);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0007,'Sballo',00017,'Filettino di bue del Conte','beef dishes',42, 2.0);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0008,'Restaurant An Phu',00018,'Chicken Fried','chicken dishes',18, 2.3);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0008,'Restaurant An Phu',00019,'Fried Noodle','noodle/pasta',18, 1.8);
insert into items  (restaurant_id, restaurant_name, item_id, item_name, item_genre, item_price, item_taste)
values(0008,'Restaurant An Phu',00020,'Sauteed Chicken in Peanut Sauce','chicken dishes',17, 4.9);


/* orders*/
-- delete from orders;
/* orders-generate orders*/
-- insert into orders values(default,00002,'002276355',0008,'2020-09-24',00018,1);
-- insert into orders values(default,00003,'002269013',0002,'2020-09-24',00003,2);
-- insert into orders values(default,00003,'002269013',0002,'2020-09-24',00004,1);
-- insert into orders values(default,00005,'002276355',0001,'2020-09-24',00001,1);
-- insert into orders values(default,00006,'002276355',0003,'2020-09-24',00006,3);
-- insert into orders values(default,00007,'002276355',0003,'2020-09-24',00007,1);
-- insert into orders values(default,00008,'002276355',0005,'2020-09-24',00013,1);
-- insert into orders values(default,00009,'002276355',0005,'2020-09-24',00012,1);
-- insert into orders values(default,00010,'002276355',0005,'2020-09-24',00011,2);
-- insert into orders values(default,00013,'002269013',0006,'2020-09-24',00014,2);
-- insert into orders values(default,00015,'002269013',0006,'2020-09-24',00015,4);
-- insert into orders values(default,00017,'002276355',0007,'2020-09-24',00017,1);
--
-- insert into orders values(1,00018,'000000100',0007,'2020-09-24',00017,1);
-- insert into orders values(2,00018,'000000100',0008,'2020-09-24',00018,2);
-- insert into orders values(3,00018,'000000100',0002,'2020-09-24',00003,1);
-- insert into orders values(1,00019,'000000100',0004,'2020-09-24',00009,1);
-- insert into orders values(2,00019,'000000100',0007,'2020-09-24',00017,3);
-- insert into orders values(1,00020,'000000100',0007,'2020-09-24',00017,1);
-- insert into orders values(1,00021,'000000100',0007,'2020-09-24',00017,4);
-- insert into orders values(1,00022,'000000100',0007,'2020-09-24',00017,1);
-- insert into orders values(2,00022,'000000100',0007,'2020-09-24',00017,1);

/**
 badges
 */
insert into badges values('000000100', 00001, 01, 1, '[Lv1] First top up', '2021-01-01', 1);
insert into badges values('000000100', 00002, 02, 2, '[Lv1] Peace and love', '2021-02-01', 1);
insert into badges values('000000100', 00003, 03, 3, '[Lv2] All correct', '2021-03-01', 2);
insert into badges values('000000100', 00004, 04, 4, '[Lv1] Ecological volunteer', '2021-04-01', 1);
insert into badges values('000000100', 00005, 05, 5, '[Lv1] 100% Guarantee', '2021-05-01', 1);
insert into badges values('000000100', 00006, 06, 6, '[Lv3] Amazing', '2021-06-01', 3);
insert into badges values('000000100', 00007, 07, 7, '[Lv1] Sunshine and beach', '2021-07-01', 1);
insert into badges values('000000100', 00008, 08, 8, '[Lv1] Rock star', '2021-08-01', 1);
insert into badges values('000000100', 00009, 09, 9, '[Lv4] Lifetime learning', '2021-09-01', 4);
insert into badges values('000000100', 00010, 01, 10, '[Lv1] First top up', '2021-09-03', 1);
insert into badges values('000000100', 00011, 03, 11, '[Lv2] All correct', '2021-09-06', 2);
insert into badges values('000000100', 00012, 06, 12, '[Lv3] Amazing', '2021-10-01', 3);
insert into badges values('000000100', 00013, 09, 13, '[Lv4] Lifetime learning', '2021-11-11', 4);




-- update orders set item_taste=5, item_environment=3, item_service=4
-- where order_id = 00001 and item_id = 00017;
-- update orders set item_taste=5, item_environment=5, item_service=4
-- where order_id = 00003 and item_id = 00003;
-- update orders set item_taste=4, item_environment=5, item_service=5
-- where order_id = 00003 and item_id = 00004;
-- update orders set item_taste=3, item_environment=4, item_service=5
-- where order_id = 00004 and item_id = 00009;
-- update orders set item_taste=4, item_environment=5, item_service=5
-- where order_id = 00005 and item_id = 00001;
-- update orders set item_taste=4, item_environment=5, item_service=3
-- where order_id = 00007 and item_id = 00007;
-- update orders set item_taste=5, item_service=2
-- where order_id = 00008 and item_id = 00013;
-- update orders set item_taste=4, item_environment=5, item_service=5
-- where order_id = 00010 and item_id = 00011;
-- update orders set item_environment=5, item_service=5
-- where order_id = 00012 and item_id = 00018;
-- update orders set item_taste=3,item_environment=4, item_service=5
-- where order_id = 00011 and item_id = 00019;
-- update orders set item_taste=5,item_environment=4, item_service=4
-- where order_id = 00014 and item_id = 00002;
-- update orders set item_taste=5,item_environment=5, item_service=5
-- where order_id = 00015 and item_id = 00015;
-- update orders set item_taste=5
-- where order_id = 00009 and item_id = 00012;
-- update orders set item_service=5
-- where order_id = 00002 and item_id = 00018;
-- update orders set item_taste=5, item_environment=5, item_service=5
-- where order_id = 00017 and item_id = 00017;123456

-- delete from useraccountrecord;
-- insert into useraccountrecord values(002276355,'change password','2021-03-21','08:00:00','change password into 12345');
-- insert into useraccountrecord values(002269013,'change tel','2021-03-21','09:00:00','change tel into 4455332211');

/* update discount */
update items set item_discount = 0.8
where item_id = 2;
update items set item_discount = 0.9
where item_id = 4;
update items set item_discount = 0.7
where item_id = 13;
update items set item_discount = 0.95
where item_id = 15;
update items set item_discount = 0.8
where item_id = 17;

/* update rate */
-- update items set item_taste = 4.1 where store_id = 1;
-- update items set item_taste = 4.5 where store_id = 2;
-- update items set item_taste = 3.2 where store_id = 3;
-- update items set item_taste = 3.5 where store_id = 4;
-- update items set item_taste = 3.6 where store_id = 5;
-- update items set item_taste = 4.6 where store_id = 6;
-- update items set item_taste = 2.8 where store_id = 7;
-- update items set item_taste = 2 where store_id = 8;
