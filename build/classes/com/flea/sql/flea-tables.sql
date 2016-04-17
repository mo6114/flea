create table fUser (
	email varchar2(40) check(email like '%@%.com') primary key ,
	userName varchar2(20) unique not null ,
	password varchar2(32) not null ,
	registerTime date not null ,
	status number(1) default(0) check(status in(0,1)) not null ,
	account number(10 , 2) default(0.00) not null ,
	school varchar2(30) not null ,
	mobile char(11) not null
);

create table fGoods (
	id varchar2(40) primary key ,
	email varchar2(40) check(email like '%@%.com') references fUser(email) ,
	name varchar2(40) not null ,
	one_level varchar2(20) not null ,
	two_level varchar2(20) not null ,
	picture varchar2(40) not null ,
	introduction varchar2(200) ,
	timeOnShelves date not null ,
	status number(1) default(1) check(status in(0,1)) not null ,
	amount number(3) default(1) not null ,
	price number(8,2) default(0.01) not null ,
	times number(4) default(0) not null
);

create table fOrder (
	id varchar2(40) primary key ,
	bEmail varchar2(40) check(bEmail like '%@%.com') references fUser(email) ,
	sEmail varchar2(40) check(sEmail like '%@%.com') references fUser(email) ,
	goodsId varchar2(40) references fGoods(id) ,
	amount number(3) default(1) not null ,
	status number(1) default(1) check(status in(0,1,2)) not null ,
	orderTime date not null ,
	finishTime date ,
	space char(100) not null ,
	saleTime date not null
);

create table fAuction (
	id varchar2(40) primary key ,
	goodsId varchar2(40) references fGoods(id) ,
	email varchar2(40) check(email like '%@%.com') references fUser(email) ,
	startingPrice number(8,2) not null ,
	theLowestPrice number(8,2) not null ,
	hammerPrice number(8,2) ,
	fixedPrice number(8,2) ,
	numberOfBids number(3) ,
	startTime date not null ,
	status number(1) default(1) check(status in(0,1,2)) not null 
);

drop table fOrder;