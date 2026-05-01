CREATE TABLE Manger
	(id NUMBER(8),
	 name VARCHAR2(14),
	 birth_date DATE,
	 address VARCHAR2(14));

INSERT INTO Manger(id, name) VALUES(1, 'Basmalla')

SELECT * FROM Manger;

ALTER TABLE Manger DROP (address);

ALTER TABLE Manger ADD (city_address VARCHAR2(20), street VARCHAR2(20));

ALTER TABLE Manger
RENAME COLUMN name TO full_name;

ALTER TABLE Manger READ ONLY;

SELECT * FROM Manger;

CREATE TABLE Owner
	(column_id NUMBER(8),
	 birth_date DATE);

RENAME Manger TO Master;

DROP TABLE Master;
DROP TABLE Manager;
DROP TABLE Owner;