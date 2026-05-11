--Doctor Table--
CREATE TABLE Doctor (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    salary NUMBER(10, 2),
    address VARCHAR2(255)
);

INSERT INTO Doctor (id, name, salary, address) VALUES (1, 'Dr. Aris Thorne', 95000.00, '123 Maple St, Boston, MA');
INSERT INTO Doctor (id, name, salary, address) VALUES (2, 'Dr. Elena Rodriguez', 110000.50, '456 Oak Ave, Austin, TX');
INSERT INTO Doctor (id, name, salary, address) VALUES (3, 'Dr. Julian Kwong', 88000.00, '789 Pine Rd, Seattle, WA');
INSERT INTO Doctor (id, name, salary, address) VALUES (4, 'Dr. Sarah Jenkins', 125000.00, '101 Cedar Blvd, Chicago, IL');
INSERT INTO Doctor (id, name, salary, address) VALUES (5, 'Dr. Victor Morales', 92000.75, '202 Birch Ln, Miami, FL');
INSERT INTO Doctor (id, name, salary, address) VALUES (6, 'Dr. Amara Okafor', 105000.00, '303 Elm St, Atlanta, GA');
INSERT INTO Doctor (id, name, salary, address) VALUES (7, 'Dr. Leo Sterling', 118000.00, '404 Walnut Dr, Denver, CO');
INSERT INTO Doctor (id, name, salary, address) VALUES (8, 'Dr. Maya Patel', 97500.25, '505 Cherry Ct, Phoenix, AZ');
INSERT INTO Doctor (id, name, salary, address) VALUES (9, 'Dr. Simon Vance', 130000.00, '606 Spruce Way, San Francisco, CA');
INSERT INTO Doctor (id, name, salary, address) VALUES (10, 'Dr. Nadia Volkov', 112000.00, '707 Ash Dr, Portland, OR');


UPDATE Doctor 
SET salary = 20000 
WHERE id = 3;

DELETE FROM Doctor 
WHERE id = 9;


SELECT name || ' earns ' || salary AS Doctor_Earnings 
FROM Doctor;

SELECT id, name, address, (salary * 2) AS doubled_salary 
FROM Doctor;

SELECT * 
FROM Doctor 
WHERE salary IN (1000, 2000, 3000);

RENAME Doctor TO PRD_DOCTOR;


--Employees Table--

CREATE TABLE Employeees (
    EmployeeID NUMBER PRIMARY KEY,
    FirstName VARCHAR2(50),
    LastName VARCHAR2(50),
    Department VARCHAR2(50),
    Salary NUMBER(10, 2)
);

INSERT ALL 
  INTO Employeees (EmployeeID, FirstName, LastName, Department, Salary) VALUES (101, 'John1', 'Doe1', 'HR', 20000)
  INTO Employeees (EmployeeID, FirstName, LastName, Department, Salary) VALUES (102, 'John2', 'Doe2', 'IT', 50000)
  INTO Employeees (EmployeeID, FirstName, LastName, Department, Salary) VALUES (103, 'John3', 'Doe3', 'CS', 40000)
  INTO Employeees (EmployeeID, FirstName, LastName, Department, Salary) VALUES (104, 'John4', 'Doe4', 'IT', 10000)
  INTO Employeees (EmployeeID, FirstName, LastName, Department, Salary) VALUES (105, 'John5', 'Doe5', 'ZX', 30000)
SELECT * FROM dual;


UPDATE Employeees 
SET Salary = 600000 
WHERE EmployeeID = 101;

DELETE FROM Employeees 
WHERE Department = '101';

SELECT * 
FROM Employeees 
WHERE Department = 'IT';

SELECT (FirstName || ' ' || LastName) AS Full_Name, EmployeeID, Department, Salary
FROM Employeees;

DROP TABLE PRD_DOCTOR;
DROP TABLE Employeees;

