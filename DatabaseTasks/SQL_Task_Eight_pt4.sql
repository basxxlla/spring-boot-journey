/* ============================================================
   STEP 1: Create User 'ALEX' and Grant System Privileges
   (Executed as SYS / DBA)
   ============================================================ */

-- Create the user 'ALEX'
CREATE USER alex IDENTIFIED BY Password123#;

-- 1. Grant 'create session' so Alex can log in
GRANT CREATE SESSION TO alex;

-- 2. Grant 'create table' and tablespace quota so Alex can create tables
GRANT CREATE TABLE TO alex;
ALTER USER alex QUOTA UNLIMITED ON users;


/* ============================================================
   STEP 2 & 3: Create Table and Grant Object Privileges
   (Executed as ALEX)
   ============================================================ */

-- Connect as ALEX:
-- CONNECT alex/Password123#;

-- Create the Student table
CREATE TABLE alex.Student (
    id   NUMBER PRIMARY KEY,
    name VARCHAR2(50)
);

-- 3. Grant INSERT, SELECT, UPDATE, DELETE on Student table to HR
GRANT SELECT, INSERT, UPDATE, DELETE ON alex.Student TO hr;


/* ============================================================
   GO TO HR SCHEMA AND PERFORM OPERATIONS
   (Executed as HR)
   ============================================================ */

-- Connect as HR:
-- CONNECT hr/hr_password;

-- 3a. INSERT on Student table
INSERT INTO alex.Student (id, name) VALUES (101, 'John Doe');
INSERT INTO alex.Student (id, name) VALUES (102, 'Jane Smith');
COMMIT;

-- 3b. SELECT from Student table
SELECT * FROM alex.Student;

-- 3c. UPDATE Student table
UPDATE alex.Student 
SET name = 'Johnathan Doe' 
WHERE id = 101;
COMMIT;

-- 3d. DELETE from Student table
DELETE FROM alex.Student 
WHERE id = 102;
COMMIT;


/* ============================================================
   STEP 4: REVOKE All Privileges
   ============================================================ */

-- Revoke object privileges on Student table from HR (Executed as ALEX)
REVOKE SELECT, INSERT, UPDATE, DELETE ON alex.Student FROM hr;

-- Revoke system privileges from ALEX (Executed as SYS / DBA)
REVOKE CREATE SESSION, CREATE TABLE FROM alex;