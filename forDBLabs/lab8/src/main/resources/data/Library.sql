
DROP DATABASE  IF EXISTS MobileStore;


CREATE DATABASE MobileStore;

use MobileStore;

CREATE TABLE cpu
(
id int NOT NULL auto_increment ,
volume int NULL,
prod_year date NULL,
fee float	 NULL,
primary key (id)
);

ALTER TABLE cpu
  add CHECK (volume<=3),
  add CHECK (fee>0);

CREATE TABLE mobile
(
id int NOT NULL auto_increment,
catery nvarchar(50) NULL,
mark nvarchar(50) NULL,
colour nvarchar(50) NULL,
v_number nvarchar(50) NULL,
specifics nvarchar(50) NULL,
image varbinary(5000) NULL,
cpu_id int NULL,
primary key (id)
);

ALTER TABLE mobile

  add constraint FK_mobile FOREIGN KEY (cpu_id) REFERENCES cpu (id);


CREATE TABLE customer
(
id int   NOT NULL auto_increment  ,
SNM nvarchar(50) NULL,
birth_day date NULL,
adress nvarchar(50) NULL,
number nvarchar(50) NULL,
primary key (id)
);


CREATE TABLE ownership
(
id int  NOT NULL auto_increment ,
owner_id int NULL,
mobile_id int NULL,
primary key (id)
);

ALTER TABLE ownership

  add constraint FK_owner_id FOREIGN KEY(owner_id) REFERENCES customer (id),
  add constraint FK_mobile_id FOREIGN KEY(mobile_id) REFERENCES mobile (id);


