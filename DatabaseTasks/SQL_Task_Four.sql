-- 1. Find all employees where the emp_id is within a certain range 100 and 105.
-- The BETWEEN operator is inclusive, meaning it captures 100, 105, and everything in middle.
SELECT * FROM employees 
WHERE employee_id BETWEEN 100 AND 105;

-- 2. Find all employees that belong to a specific set of emp_id 151, 152, 153, 154, 155.
-- The IN operator matches values against an explicit list.
SELECT * FROM employees 
WHERE employee_id IN (151, 152, 153, 154, 155);

-- 3. Retrieve all employees where the employee first_name starts with the letter 'P' OR 'p'
-- The '%' wildcard means "any characters can follow". LOWER standardizes the column for case insensitivity.
SELECT * FROM employees 
WHERE LOWER(first_name) LIKE 'p%';

-- 4. Retrieve all employees where the employee first_name ends with the letter 'A' OR 'a'
-- The '%' wildcard at the start means "can start with anything, but must end with a".
SELECT * FROM employees 
WHERE LOWER(first_name) LIKE '%a';

-- 5. Retrieve all employees where the employee first_name contains the letter 'A' OR 'a'
-- Placing '%' on both sides checks if the letter exists anywhere inside the string.
SELECT * FROM employees 
WHERE LOWER(first_name) LIKE '%a%';

-- 6. Retrieve all employees where the employee first_name third char is the letter 'e' OR 'E'
-- The underscore '_' wildcard represents exactly ONE character. Two underscores look for 'e' in the 3rd slot.
SELECT * FROM employees 
WHERE LOWER(first_name) LIKE '__e%';

-- 7. Retrieve all employees who don't have a manager assigned (i.e., manager_id is NULL).
-- You must use IS NULL. Databases cannot use '= NULL' because NULL represents an unknown value.
SELECT * FROM employees 
WHERE manager_id IS NULL;

-- 8. Find all employees who have a manager assigned.
-- IS NOT NULL filters out any rows missing a manager ID.
SELECT * FROM employees 
WHERE manager_id IS NOT NULL;

-- 9. Insert a new employee without assigning a manager (NULL value for manager_id).
-- We explicitly pass the NULL keyword into the manager_id column.
INSERT INTO employees (employee_id, first_name, last_name, job_id, hire_date, salary, manager_id)
VALUES (999, 'John', 'Doe', 'IT_PROG', SYSDATE, 5000, NULL);

-- 10. Find all employees who work either in the 'AD_VP' JOB_ID or the 'IT_PROG' JOB_ID.
-- Using the IN operator handles multiple distinct text matches easily.
SELECT * FROM employees 
WHERE job_id IN ('AD_VP', 'IT_PROG');

-- 11. Retrieve all employees sorted by their last_name in ascending order.
-- ASC is the default for ORDER BY, but writing it explicitly keeps code readable.
SELECT * FROM employees 
ORDER BY last_name ASC;

-- 12. Retrieve all employees sorted by their hire_date in descending order.
-- DESC pulls the newest/most recent dates to the top.
SELECT * FROM employees 
ORDER BY hire_date DESC;

-- 13. Sort employees first by department in ascending order and then by salary in descending order within each department_id.
-- Oracle processes order criteria from left to right.
SELECT * FROM employees 
ORDER BY department_id ASC, salary DESC;

-- 14. Retrieve all employees with their last_name in lowercase
-- The LOWER() function transforms the output presentation without changing the actual data in the table.
SELECT employee_id, first_name, LOWER(last_name) AS lowercase_lastname 
FROM employees;

-- 15. Retrieve all employees with their first_name in uppercase.
-- The UPPER() function forces all characters to capitals.
SELECT employee_id, UPPER(first_name) AS uppercase_firstname, last_name 
FROM employees;

-- 16. Retrieve all employees with their first_name and last_name in title case (first letter capitalized).
SELECT INITCAP(first_name) AS formatted_firstname, INITCAP(last_name) AS formatted_lastname 
FROM employees;

-- 17. Find employees whose last_name is 'smith', regardless of the case.
-- Applying LOWER() to the column ensures that 'Smith', 'SMITH', or 'smITh' will all trigger a successful match.
SELECT * FROM employees 
WHERE LOWER(last_name) = 'smith';