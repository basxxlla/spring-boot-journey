/* ============================================================================
   1. EMPLOYEE(S) WITH THE HIGHEST SALARY
   Subquery returns a single scalar value representing the MAX(salary).
   ============================================================================ */
SELECT 
    employee_id, 
    first_name || ' ' || last_name AS employee_name, 
    salary
FROM employees
WHERE salary = (
    SELECT MAX(salary) 
    FROM employees
);


/* ============================================================================
   2. EMPLOYEES IN THE SAME DEPARTMENT AS 'ALICE'
   Subquery fetches Alice's department_id (excluding Alice herself).
   ============================================================================ */
SELECT 
    employee_id, 
    first_name || ' ' || last_name AS employee_name, 
    department_id
FROM employees
WHERE department_id = (
    SELECT department_id 
    FROM employees 
    WHERE first_name = 'Alice'
)
AND first_name != 'Alice';


/* ============================================================================
   3. PRODUCT DETAILS WITH THE LOWEST PRICE
   Subquery returns the single MIN(price) from the products table.
   ============================================================================ */
SELECT 
    product_id, 
    product_name, 
    price
FROM products
WHERE price = (
    SELECT MIN(price) 
    FROM products
);


/* ============================================================================
   4. DEPARTMENT NAME OF THE EMPLOYEE WITH THE HIGHEST SALARY
   Uses nested single-row subqueries to resolve max salary -> department_id.
   ============================================================================ */
SELECT department_name
FROM departments
WHERE department_id = (
    SELECT department_id 
    FROM employees 
    WHERE salary = (
        SELECT MAX(salary) 
        FROM employees
    )
);


/* ============================================================================
   5. MANAGER OF THE MOST RECENTLY HIRED EMPLOYEE
   Subquery finds the latest hire date to identify the employee's manager.
   ============================================================================ */
SELECT 
    m.employee_id AS manager_id, 
    m.first_name || ' ' || m.last_name AS manager_name
FROM employees m
WHERE m.employee_id = (
    SELECT manager_id 
    FROM employees 
    WHERE hire_date = (
        SELECT MAX(hire_date) 
        FROM employees
    )
);


/* ============================================================================
   6. EMPLOYEES WHOSE SALARY EQUALS THE COMPANY AVERAGE
   Subquery calculates AVG(salary).
   ============================================================================ */
SELECT 
    employee_id, 
    first_name || ' ' || last_name AS employee_name, 
    salary
FROM employees
WHERE salary = (
    SELECT AVG(salary) 
    FROM employees
);


/* ============================================================================
   7. ORDER(S) WITH THE EARLIEST ORDER DATE
   Subquery returns the single MIN(order_date).
   ============================================================================ */
SELECT 
    order_id, 
    customer_id, 
    order_date, 
    total_amount
FROM orders
WHERE order_date = (
    SELECT MIN(order_date) 
    FROM orders
);


/* ============================================================================
   8. EMPLOYEES EARNING MORE THAN EMPLOYEE ID 101
   Subquery retrieves salary for employee 101.
   ============================================================================ */
SELECT 
    first_name || ' ' || last_name AS employee_name, 
    salary
FROM employees
WHERE salary > (
    SELECT salary 
    FROM employees 
    WHERE employee_id = 101
);


/* ============================================================================
   9. STUDENTS WITH THE SAME GPA AS 'JOHN DOE'
   Subquery gets John Doe's GPA (excluding John Doe from results).
   ============================================================================ */
SELECT 
    student_id, 
    first_name || ' ' || last_name AS student_name, 
    gpa
FROM students
WHERE gpa = (
    SELECT gpa 
    FROM students 
    WHERE first_name = 'John' AND last_name = 'Doe'
)
AND NOT (first_name = 'John' AND last_name = 'Doe');


/* ============================================================================
   10. BOOKS WITH SAME PRICE AS THE MOST EXPENSIVE 'SCIENCE' BOOK
   Subquery retrieves the maximum price within the 'Science' category.
   ============================================================================ */
SELECT 
    b.book_id, 
    b.title, 
    b.price
FROM books b
WHERE b.price = (
    SELECT MAX(b2.price)
    FROM books b2
    JOIN categories c ON b2.category_id = c.category_id
    WHERE c.category_name = 'Science'
);