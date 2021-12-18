drop database shoping;
create database shoping;
use shoping;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id bigint NOT NULL primary key,
  userName varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  birth date default NULL,
  gender varchar(10) default NULL,
  email varchar(255) default NULL,
  phone varchar(20) default NULL,
  address varchar(255) default NULL
);

DROP TABLE IF EXISTS category;
CREATE TABLE category (
  id bigint NOT NULL primary key,
  name varchar(255) default NULL,
  decription varchar(255) default NULL
);

DROP TABLE IF EXISTS cart;
create table cart (
	id bigint not null primary key,
    userId bigint not null,
    price double default 0,
    foreign key (userId) references user(id)
);

DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
  id bigint NOT NULL PRIMARY KEY,
  userId bigint default NULL,
  cartId bigint default NULL,
  productCode bigint default NULL,
  createAt timestamp NULL default NULL,
  amount int default NULL,
  totalPrice double default NULL,
  foreign key (userId) references user(id),
  foreign key (cartId) references cart(id)
);

DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id bigint NOT NULL primary key,
  productName varchar(255) default NULL,
  categoryId bigint,
  picture varchar(255) default NULL,
  price double default NULL,
  NSX varchar(255) default NULL,
  content text default NULL,
  foreign key (categoryId) references category (id)
);


DROP TABLE IF EXISTS cart_item;
create table cart_item (
	id bigint not null primary key,
    cartId bigint default null,
    productId bigint not null,
    amount smallint not null default 1,
    foreign key (cartId) references cart(id),
    foreign key (productId) references product(id)
);