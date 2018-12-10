USE master
GO

DROP DATABASE  IF EXISTS Dai;
GO

CREATE DATABASE Dai
ON PRIMARY
( NAME = University, FILENAME = 'D:\database\Dai.mdf',
SIZE = 30MB, MAXSIZE = UNLIMITED, FILEGROWTH = 5MB )
LOG ON
( NAME = University_log, FILENAME = 'D:\database\Dai_log.ldf',
SIZE = 8MB, MAXSIZE = UNLIMITED, FILEGROWTH = 10% )

GO

use Dai;

IF DB_ID ('Dai') is not null
CREATE TABLE [engine]
(
[id] int IDENTITY,
[volume] int NULL,
[prod_year] date NULL,
[fee] float	 NULL,

  CONSTRAINT PK_engine PRIMARY KEY  NONCLUSTERED ([id]),
  CHECK ([volume]<=3),
  CHECK ([fee]>0)
);
go

CREATE TABLE [transport]
(
[id] int IDENTITY ,
[category] nvarchar(50) NULL,
[mark] nvarchar(50) NULL,
[colour] nvarchar(50) NULL,
[gov_number] nvarchar(50) NULL,
[specifics] nvarchar(50) NULL,
[image] varbinary(5000) NULL,
[engine_id] int NULL,
);
go
ALTER TABLE [transport] 
  ADD 
  CONSTRAINT PK_transport PRIMARY KEY  NONCLUSTERED ([id]),
  CONSTRAINT FK_transport FOREIGN KEY (engine_id) REFERENCES engine (id)

go
CREATE TABLE [owners]
(
[id] int IDENTITY ,
[SNM] nvarchar(50) NULL,
[birth_day] date NULL,
[adress] nvarchar(50) NULL,
[number] nvarchar(50) NULL
);
go
ALTER TABLE [owners] 
  ADD 
  CONSTRAINT PK_owner PRIMARY KEY  NONCLUSTERED ([id])
go
CREATE TABLE [ownership]
(
[id] int IDENTITY ,
[owner_id] int NULL,
[transport_id] int NULL,
);
go
ALTER TABLE [ownership] 
  ADD 
  CONSTRAINT PK_ownership PRIMARY KEY  NONCLUSTERED ([id]),
  CONSTRAINT FK_owner_id FOREIGN KEY(owner_id) REFERENCES owners (id),
  CONSTRAINT FK_transport_id FOREIGN KEY(transport_id) REFERENCES transport (id)
go
CREATE TABLE [accounting]
(
[id] int IDENTITY ,
[ownership_id] int NULL,
[date_of_inspection] date NULL,
[next_inspection] date NULL,

);
go
ALTER TABLE [accounting] 
  ADD 
  CONSTRAINT PK_accounting PRIMARY KEY  NONCLUSTERED ([id]),
  CONSTRAINT FK_ownership_id FOREIGN KEY(ownership_id) REFERENCES ownership (id)
go

INSERT engine(volume, prod_year, fee) VALUES 
(2, '2018/10/5', 2)

INSERT transport(category, mark, colour, gov_number, specifics, image, engine_id) VALUES 
('B', 'BMW', 'black', 'BC 12345 BC','cool', 1204, 1)

INSERT owners(SNM, birth_day, adress,number) VALUES 
('Ivanov Ivan Ivanovych', '2018/10/5', 'Lvivska, 5', 225)

INSERT ownership(owner_id, transport_id) VALUES 
(1,1)

INSERT accounting(ownership_id, date_of_inspection, next_inspection) VALUES 
(1, '2018/10/5', '2018/10/5')
go