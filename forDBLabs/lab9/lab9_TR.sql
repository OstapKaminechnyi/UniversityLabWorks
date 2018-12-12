USE lab9
GO
/* Забезпечити параметризовану вставку нових значень у
таблицю Перелік лікарств. */

DROP PROCEDURE IF EXISTS InsertParameter
GO

CREATE or alter PROCEDURE InsertParameter
(
@id int = 0,
@name VARCHAR (MAX)='?',
@ministry_code VARCHAR (MAX)='?',
@recipe VARCHAR(MAX) = '?',
@narcotic VARCHAR(MAX)= '?',
@psychotropic VARCHAR(MAX)= '?',
@zone_id INT = 0
) 
AS
BEGIN
	INSERT INTO [lab9].medicine VALUES (@id, @name, @ministry_code, @recipe, @narcotic, @psychotropic,@zone_id)
END
GO
EXEC InsertParameter @id = 6, @name = 'Aspiryn',@ministry_code = '2222',@recipe = 'sss',@narcotic = 'aaa2',@psychotropic= 'gmail', @zone_id = 1;
go
SELECT * FROM [lab9].medicine;
go
/*Створити пакет, який вставляє 10 стрічок в таблицю Посада у
форматі < Noname+No> , наприклад: Noname5, Noname6,
Noname7 і т.д.  */
CREATE PROCEDURE RandNames AS
  BEGIN
    DECLARE @cnt INT = 0;
    DECLARE @post NVARCHAR(50)

    WHILE @cnt < 10
    BEGIN
      SET @post = 'Noname' + CAST(@cnt as VARCHAR(45))

      INSERT INTO lab9.post VALUES (@cnt + 5, @post, 1)
      SET @cnt = @cnt + 1;
        
    END;
  END
GO
exec RandNames;

SELECT * FROM lab9.post;
go
/* Використовуючи курсор, забезпечити динамічне створення БД
з іменами Співробітників, з випадковою кількістю таблиць для
кожної БД (від 1 до 9). Структура таблиць довільна. Імена
таблиць відповідають імені Співробітника з порядковим
номером від 1 до 9. */

CREATE PROCEDURE DBX
AS
BEGIN
DECLARE @i int;

	DECLARE @k int;

	SELECT @k=FLOOR(RAND()*(9-1+1)+1);
	
	DECLARE cur CURSOR FOR SELECT name FROM [lab9].employee;
	OPEN cur;

	DECLARE @c int;
	DECLARE @l int;

	DECLARE @temp_query nvarchar(100);
	DECLARE @nameEmployee nvarchar(45);
	DECLARE @temp_table_query nvarchar(200);
	
	SET @c = 0;
	SET @l = 0;

	WHILE @c<@k

	BEGIN
	    FETCH cur INTO @nameEmployee;
		SET @temp_query = N'CREATE DATABASE ' + @nameEmployee;

		exec sp_executesql
		@statement = @temp_query

		SET @i = FLOOR(RAND()*(9-1+1)+1);

		WHILE @l<@i

		BEGIN
			SET @temp_table_query = N'CREATE TABLE ' + @nameEmployee + '.[dbo].Employee' + CAST(@l as nchar(1)) + N'(ID INT)';
			
			exec sp_executesql
			@statement = @temp_table_query

			SET @l = @l + 1;
		END
		SET @c = @c + 1;
	END
	CLOSE cur;
	DEALLOCATE cur;
END
GO
exec DBX;
go
/* Для таблиці Співробітники написати функцію як буде

формувати значення з перших літер стовпців Прізвище, Ім’я, По-
батькові. Потім зробити вибірку даних (SELECT) з цієї таблиці,

використовуючи дану функцію.*/

CREATE or alter FUNCTION getLetter(@empl varchar, @empl1 varchar)
RETURNS varchar(2) 
as
BEGIN

  set @empl = (select TOP 1 LEFT(name,1) from lab9.employee);
  set @empl1 = (select TOP 1 LEFT(surname,1) from lab9.employee);
  return @empl;
  return @empl1;
END;
go

select dbo.getLetter('O', 'К') 
select concat('О','Т','K')
go

/* 2. Написати функцію, яка витягує за ключем між таблицями
Вулиця та Аптечна установа значення поля Назва вулиці. Потім
зробити вибірку усіх даних (SELECT) з таблиці Аптечна
установа, використовуючи дану функцію.*/
CREATE or alter FUNCTION StreetInfo(@ind int) RETURNS VARCHAR(MAX)
AS
BEGIN
	DECLARE @qwe VARCHAR(MAX);
	SELECT @qwe = [street] FROM [lab9].street WHERE id=@ind;
	RETURN @qwe;
END;
GO
SELECT id, name, building, www,work_time, [dbo].StreetInfo(street_id) cityInfo FROM [lab9].pharmacy
go
/*Забезпечити цілісність значень для структури БД. */

CREATE TRIGGER NewStreet ON [lab9].street AFTER INSERT AS
DECLARE @ID INT
SELECT @ID=street_id FROM inserted
IF (@ID NOT IN (SELECT id FROM [lab9].pharmacy))
BEGIN
	PRINT'Error insert'
	ROLLBACK TRANSACTION
END
GO

CREATE TRIGGER UpdateStreet ON [lab9].pharmacy AFTER UPDATE AS
DECLARE @OldID INT,
		@NewID INT;
IF UPDATE(id)
BEGIN
	SELECT @OldID=id FROM deleted
	SELECT @NewID=id FROM inserted
	UPDATE street SET street_id =@NewID WHERE street_id=@OldID
END
DECLARE @IDr INT
IF UPDATE(street_id)
BEGIN
	SELECT @IDr=street_id FROM inserted
	IF (@IDr NOT IN (SELECT id FROM street))
	BEGIN
		PRINT'Error update'
		ROLLBACK TRANSACTION
	END
END
GO

CREATE TRIGGER DeleteStreet ON [lab9].street AFTER DELETE AS
DECLARE @ID INT
SELECT @ID=id FROM deleted
IF (@ID IN (SELECT street_id FROM pharmacy))
BEGIN
	PRINT'Error delete'
	ROLLBACK TRANSACTION
	END
GO

CREATE TRIGGER UpStreet ON [lab9].Street AFTER UPDATE AS
DECLARE @OldID INT,
		@NewID INT;
IF UPDATE(id)
BEGIN
	SELECT @OldID=id FROM deleted
	SELECT @NewID=id FROM inserted
	UPDATE street SET street_id=@NewID WHERE street_id=@OldID
END
GO

CREATE TRIGGER DelStreet ON [lab9].street AFTER DELETE AS
DECLARE @ID INT
SELECT @ID=id FROM deleted
IF (@ID IN (SELECT street_id FROM pharmacy))
BEGIN
	PRINT'Error delete'
	ROLLBACK TRANSACTION
end 
If (Select Count(*) from lab9.street) < 2 and (Select Count(*) from lab9.street) > 6
Begin 
PRINT'Error cardinality'
	ROLLBACK TRANSACTION
END
GO
SELECT * from lab9.street 
go

CREATE TRIGGER UpPharmacy ON [lab9].pharmacy AFTER UPDATE AS
DECLARE @OldID INT,
		@NewID INT;
IF UPDATE(id)
BEGIN
	SELECT @OldID=id FROM deleted
	SELECT @NewID=id FROM inserted
	UPDATE employee SET pharmacy_id=@NewID WHERE pharmacy_id=@OldID
END
GO

CREATE TRIGGER DelPharmacy ON [lab9].Zone AFTER DELETE AS
DECLARE @ID INT
SELECT @ID=id FROM deleted
IF (@ID IN (SELECT pharmacy_id FROM employee))
BEGIN
	PRINT'Error delete'
	ROLLBACK TRANSACTION
END
GO

CREATE TRIGGER NewMedicine ON [lab9].Medicine AFTER INSERT AS
DECLARE @ID INT
SELECT @ID=id FROM inserted
IF (@ID NOT IN (SELECT id FROM zone))
BEGIN
	PRINT'Error insert'
	ROLLBACK TRANSACTION
END
GO

CREATE or alter TRIGGER NewEmployee ON [lab9].Employee AFTER INSERT AS

DECLARE @id_number VARCHAR(MAX)
SELECT @id_number=identity_number FROM inserted
IF @id_number NOT LIKE '[0-9]{10}'
BEGIN
	PRINT'Error insert'
	ROLLBACK TRANSACTION
END
GO
Insert into lab9.[employee] ([id],[surname],[name],[middleName],[identity_number],[passport],[experience],[birthday],[post],[pharmacy_id]) VALUES (8,'Савчук','Лев','Сергійович', '5000','4324', 'exp','1999-05-06','фармацевт',1);
go
/*Перша буква Перелік лікарств→ Код міністерства повинна
співпадати з першою буквою Перелік лікарств→Назва.*/
CREATE or alter TRIGGER meds ON [lab9].medicine
AFTER INSERT
AS
Declare @letter2 varchar(1) 
declare @code varchar(45)
Select @code = ministry_code from inserted;
SET @letter2 = (select top 1 Left(name,1) from lab9.medicine);
if @code not like concat(@letter2,'[0-9]{3}') 
BEGIN
	PRINT 'Incorrect values'
	ROLLBACK TRANSACTION
END
go
INSERT INTO lab9.Medicine (id,name,ministry_code,recipe,narcotic,psychotropic) VALUES
(9,'Valium','K123','lrer','ACrwrr','rew');
go