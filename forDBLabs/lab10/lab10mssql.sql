/*
 * ER/Studio Data Architect SQL Code Generation
 * Project :      Model1.DM1
 *
 * Date Created : Tuesday, November 27, 2018 15:25:09
 * Target DBMS : Microsoft SQL Server 2017
 */

/* 
 * TABLE: Chief 
 */
 create database lab10msql;

 use lab10msql;

CREATE TABLE Chief(
    id                         int             NOT NULL,
    business_characteristic    nvarchar(10)    NULL,
    full_name                  nvarchar(10)    NULL,
    CONSTRAINT PK3 PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('Chief') IS NOT NULL
    PRINT '<<< CREATED TABLE Chief >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Chief >>>'
go

/* 
 * TABLE: Employee 
 */

CREATE TABLE Employee(
    id                    int             NOT NULL,
    chief_id              int             NULL,
    business_telephone    nvarchar(45)    NULL,
                          
    education             nvarchar(45)    NULL,
    speciality            nvarchar(45)    NULL,
    experience            nvarchar(45)    NULL
                          CHECK ((experience <= 0)),
    birth_day             date            NULL,
    address               nvarchar(45)    NULL,
    home_telephone        nvarchar(45)    NULL
                          ,
    image                 image           NULL,
    post                  nvarchar(45)    NULL,
    full_name             nvarchar(45)    NULL,
    CONSTRAINT PK1 PRIMARY KEY NONCLUSTERED (id)
)
go

ALTER TABLE Employee ADD CONSTRAINT Check1 
	Check ([home_telephone] != [business_telephone])
	go

IF OBJECT_ID('Employee') IS NOT NULL
    PRINT '<<< CREATED TABLE Employee >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Employee >>>'
go

/* 
 * TABLE: Promotion 
 */

CREATE TABLE Promotion(
    id             int             NOT NULL,
    employee_id    int             NULL,
    fill_posts     nvarchar(45)    NULL,
    date           date            NULL,
    list           nvarchar(45)    NULL,
    CONSTRAINT PK2 PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('Promotion') IS NOT NULL
    PRINT '<<< CREATED TABLE Promotion >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Promotion >>>'
go

/* 
 * TABLE: Employee 
 */

ALTER TABLE Employee ADD CONSTRAINT RefChief4 
    FOREIGN KEY (chief_id)
    REFERENCES Chief(id)
go


/* 
 * TABLE: Promotion 
 */

ALTER TABLE Promotion ADD CONSTRAINT RefEmployee3 
    FOREIGN KEY (employee_id)
    REFERENCES Employee(id)
go


