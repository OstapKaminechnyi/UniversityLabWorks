--
-- ER/Studio Data Architect SQL Code Generation
-- Project :      Model1.DM1
--
-- Date Created : Tuesday, November 27, 2018 15:10:38
-- Target DBMS : MySQL 5.x
--

-- 
-- TABLE: Chief 
--

CREATE TABLE Chief(
    id                         INT                     NOT NULL,
    business_characteristic    NATIONAL VARCHAR(10),
    full_name                  NATIONAL VARCHAR(10),
    PRIMARY KEY (id)
)ENGINE=MYISAM
;



-- 
-- TABLE: Employee 
--

CREATE TABLE Employee(
    id                    INT                     NOT NULL,
    chief_id              INT,
    business_telephone    NATIONAL VARCHAR(45)    
                          CHECK ([business_telephone] != [home_telephone]),
    education             NATIONAL VARCHAR(45),
    speciality            NATIONAL VARCHAR(45),
    experience            NATIONAL VARCHAR(45)    
                          CHECK (([experience] <= 0)),
    birth_day             DATE,
    address               NATIONAL VARCHAR(45),
    home_telephone        NATIONAL VARCHAR(45)    
                          CHECK ([home_telephone] != [business_telephone]),
    image                 BLOB,
    post                  NATIONAL VARCHAR(45),
    full_name             NATIONAL VARCHAR(45),
    PRIMARY KEY (id)
)ENGINE=MYISAM
;



-- 
-- TABLE: Promotion 
--

CREATE TABLE Promotion(
    id             INT                     NOT NULL,
    employee_id    INT,
    fill_posts     NATIONAL VARCHAR(45),
    date           DATE,
    list           NATIONAL VARCHAR(45),
    PRIMARY KEY (id)
)ENGINE=MYISAM
;



-- 
-- TABLE: Employee 
--

ALTER TABLE Employee ADD CONSTRAINT RefChief4 
    FOREIGN KEY (chief_id)
    REFERENCES Chief(id)
;


-- 
-- TABLE: Promotion 
--

ALTER TABLE Promotion ADD CONSTRAINT RefEmployee3 
    FOREIGN KEY (employee_id)
    REFERENCES Employee(id)
;


