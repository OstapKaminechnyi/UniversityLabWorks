
DROP DATABASE  IF EXISTS MobileStore;


CREATE DATABASE MobileStore;

use MobileStore;

CREATE TABLE cpu
(
id int NOT NULL auto_increment,
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


INSERT cpu(volume, prod_year, fee) VALUES
(2, '2018/10/5', 2),
(3, '2017/9/4',1),
(4,'2016/9/5',3),
(5,'2015/8/6',3),
(6,'2016/1/1',2),
(7,'2018/9/1',1),
(3,'2011/2/1',2),
(2,'2011/2/2',2),
(1,'2010/2/3',1),
(2,'1991/2/8',2);

INSERT mobile(catery, mark, colour, v_number, specifics, image, cpu_id) VALUES
('Button', 'Nokia', 'black', 'SADASFS','1SIM', 1204, 1),
('Available','Xiaomi','black','Note5','Scanner',1205,2),
('Secured','Sony','black','XA1PlusDuo','8j',1206,3),
('GoodAccumulutor','Tp-Link','grey','NeffosC5a','Garanty',1207,4),
('Flagman','Samsung','OrchidGrey','Note8','FingerPrint',1208,5),
('Smartphone','Asus','MeteorSilver','Zenfone', 'IPS',1209,6),
('NFC','Huawei','Twilight','p20','NFC',1210,7),
('OTG','Apple','Silver','Xs','Autofocus',1211,8),
('WithoutBorders','Meizu','Black','M6s','Gyroscope',1212,9),
('Waterproof','Motorola','SterlingBlue','MotoX4','FrontalLight',1213,10);




INSERT customer(SNM, birth_day, adress,number) VALUES
('Ivanov Ivan Ivanovych', '2018/10/5', 'Lvivska, 5', 225),
('Felix Kjellberg','1989/10/2','Goteburg, Sweden', 226),
('Jeff Nem','2000/1/1','England',227),
('Petrov Petro Petrovych', '2001/1/9','Chornovola',228),
('Kaminechnyi Ostap Tarasovych', '1999/10/5','Bandery,222',229),
('Savchuk Lev Dmytrovych','1989/10/3','Naukova,29',230),
('Kravchuk Kyryl Olegovych','1990/10/2','Energetychna,9',231),
('Kharenko Anastasiya Romanivna','1999/3/9','Dovzhenka',232),
('Kravs Marta Romanivna','2000/10/11','Symonenka',233),
('Shyba Sofiya Yuriyivna','2000/2/2','Stryiska,9',234);
INSERT ownership(owner_id, mobile_id) VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);
