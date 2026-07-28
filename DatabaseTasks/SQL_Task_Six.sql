-- Create Employees with Age Check
CREATE TABLE Employees (
    employee_id NUMBER PRIMARY KEY,
    first_name  VARCHAR2(50),
    last_name   VARCHAR2(50),
    age         NUMBER CONSTRAINT chk_employees_age CHECK (age >= 18)
);

--Create Staff with Salary Range Check
CREATE TABLE Staff (
    staff_id NUMBER PRIMARY KEY,
    name     VARCHAR2(100),
    salary   NUMBER CONSTRAINT chk_staff_salary CHECK (salary BETWEEN 3000 AND 10000)
);

--Add Price Check to Existing Products Table
ALTER TABLE Products 
ADD CONSTRAINT chk_products_price CHECK (price > 0);


--Create Students with Grade Value List
CREATE TABLE Students (
    student_id NUMBER PRIMARY KEY,
    name       VARCHAR2(100),
    grade      CHAR(1) CONSTRAINT chk_students_grade CHECK (grade IN ('A', 'B', 'C', 'D', 'E', 'F'))
);

--2. Adding Constraints via ALTER TABLE, Add NOT NULL to Customers.email
ALTER TABLE Customers 
MODIFY email CONSTRAINT nn_customers_email NOT NULL;

--Add UNIQUE to Users.username
ALTER TABLE Users 
ADD CONSTRAINT uk_users_username UNIQUE (username);

--Add FOREIGN KEY to Orders.customer_id
ALTER TABLE Orders 
ADD CONSTRAINT fk_orders_customer FOREIGN KEY (customer_id) REFERENCES Customers(id);

--Add CHECK to Accounts.balance
ALTER TABLE Accounts 
ADD CONSTRAINT chk_accounts_balance CHECK (balance >= 0);

--Add PRIMARY KEY to Departments.dept_id
ALTER TABLE Departments 
ADD CONSTRAINT pk_departments_dept_id PRIMARY KEY (dept_id);

--3. Dropping (Removing) Constraints, Drop chk_salary from Employees
ALTER TABLE Employees 
DROP CONSTRAINT chk_salary;

--Remove UNIQUE Constraint on Users.email
-- Replace uk_users_email with your actual constraint name
ALTER TABLE Users 
DROP CONSTRAINT uk_users_email;

--Drop PRIMARY KEY from Products
ALTER TABLE Products 
DROP PRIMARY KEY;

--Drop fk_order_customer from Orders
ALTER TABLE Orders 
DROP CONSTRAINT fk_order_customer;

--Remove NOT NULL from Contacts.phone
ALTER TABLE Contacts 
MODIFY phone NULL;

--4. Renaming Constraints, Rename chk_age to check_min_age
ALTER TABLE Students 
RENAME CONSTRAINT chk_age TO check_min_age;

--Rename fk_emp_dept to fk_employee_department
ALTER TABLE Employees 
RENAME CONSTRAINT fk_emp_dept TO fk_employee_department;

--Rename PRIMARY KEY Constraint
-- Assuming current constraint name is pk_users
ALTER TABLE Users 
RENAME CONSTRAINT pk_users TO pk_users_id;

--Rename UNIQUE Constraint on username
-- Assuming current constraint name is uk_username
ALTER TABLE Users 
RENAME CONSTRAINT uk_username TO uk_user_name;

