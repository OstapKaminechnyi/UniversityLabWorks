USE [master]
GO

CREATE DATABASE [lab9]
GO

USE [lab9]
GO

CREATE SCHEMA [lab9]
GO

CREATE TABLE [lab9].[employee] (
  [id] INT NOT NULL,
  [surname] VARCHAR(45) NULL DEFAULT NULL,
  [name] VARCHAR(45) NULL,
  [middleName] VARCHAR(45) NULL,
  [identity_number] VARCHAR(45) NULL,
  [passport] VARCHAR(45) NULL,
  [experience] VARCHAR(45) NULL,
  [birthday] DATETIME NULL,
  [post] VARCHAR(45) NULL,
  [pharmacy_id] INT NULL,
  PRIMARY KEY ([id]));

  CREATE TABLE [lab9].[medicine] (
  [id] INT NOT NULL,
  [name] VARCHAR(45) NULL,
  [ministry_code] VARCHAR(45) NULL,
  [recipe] VARCHAR (45) NULL,
   [narcotic] VARCHAR (45) NULL,
    [psychotropic] VARCHAR (45) NULL,
	[zone_id] int  null,
  PRIMARY KEY ([id]));

  CREATE TABLE [lab9].[medicine_zone] (
  [medicine_id] INT NOT NULL,
  [zone_id] INT NOT NULL,
  PRIMARY KEY ([medicine_id],[zone_id]));
  drop table [lab9].[pharmacy]

  CREATE TABLE [lab9].[pharmacy] (
  [id] INT NOT NULL,
  [name] VARCHAR(45)  NULL,
  [building] Varchar(45)  NULL,
  [www] Varchar(45)  NULL,
  [work_time] TIME,
  [street_id] VARCHAR(45),
  PRIMARY KEY ([id] ));
  


  CREATE TABLE [lab9].[pharmacy_medicine] (
  [pharmacy_id] INT NOT NULL,
  [medicine_id] INT NOT NULL,
  PRIMARY KEY ([pharmacy_id],[medicine_id]));

  CREATE TABLE [lab9].[post] (
  [id] INT NOT NULL,
  [post] VARCHAR(45) NULL,
  [post_id] INT NULL,
  PRIMARY KEY ([id]));
  DROP TABLE  [lab9].[street];
  CREATE TABLE [lab9].[street] (
  [id] INT NOT NULL,
  [street_id] INT NOT NULL,
  [street] VARCHAR(45) NULL,
  PRIMARY KEY ([id]));
  drop table [lab9].[zone];
CREATE TABLE [lab9].[zone] (
[id] INT NOT NULL,
[medicine_id] INT NOT NULL,
[name] VARCHAR(45) NULL,
PRIMARY KEY ([id]));

INSERT INTO [lab9].[employee] ([id],[surname],[name],[middleName],[identity_number],[passport],[experience],[birthday],[post],[pharmacy_id]) VALUES (1,'Камінечний','Остап','Тарасович', '2122','4324', 'exp','1999-05-06','фармацевт',1);
INSERT INTO [lab9].[employee] ([id],[surname],[name],[middleName],[identity_number],[passport],[experience],[birthday],[post],[pharmacy_id]) VALUES (2,'Франко','Іван','Якович', '0123','32210', 'ц','1909-05-06','лікар',2);