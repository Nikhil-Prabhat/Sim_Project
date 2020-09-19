create database ecom;
use ecom;
SET SQL_SAFE_UPDATES = 0;

create table menu(
id int not null auto_increment primary key,
pic varchar(200),
name varchar(20),
price float,
active boolean,
category varchar(20),
freedelivery boolean
);

insert into menu(pic,name,price,active,category,freedelivery) values('shoes.pic','Nike',2300,true,'Shoes',true);
insert into menu(pic,name,price,active,category,freedelivery) values('mobile.pic','Iphone',12300,true,'Mobiles',true);
insert into menu(pic,name,price,active,category,freedelivery) values('tv.pic','Sony',21300,true,'TV',false);
insert into menu(pic,name,price,active,category,freedelivery) values('watch.pic','Rolex',6300,true,'Watch',false);
insert into menu(pic,name,price,active,category,freedelivery) values('perfume.pic','Van Se Trio',3300,false,'Perfumes',true);

select * from menu;
delete from menu;
drop table menu;

create table cart
(pkey int not null auto_increment primary key,
userid varchar(20),
id int);

drop table cart;

select * from cart;

insert into cart(userid,id) values('user',1);
insert into cart(userid,id) values('user',2);