/* ============================================================================
   1. EMPLOYEES EARNING MORE THAN AT LEAST ONE EMPLOYEE IN DEPT 10
   > ANY returns true if salary is greater than the MINIMUM salary in dept 10.
   ============================================================================ */
SELECT 
    employee_id, 
    first_name || ' ' || last_name AS employee_name, 
    salary, 
    department_id
FROM employees
WHERE salary > ANY (
    SELECT salary 
    FROM employees 
    WHERE department_id = 10
);


/* ============================================================================
   2. EMPLOYEES EARNING LESS THAN ALL EMPLOYEES IN DEPT 20
   < ALL returns true if salary is less than the MINIMUM salary in dept 20.
   ============================================================================ */
SELECT 
    employee_id, 
    first_name || ' ' || last_name AS employee_name, 
    salary, 
    department_id
FROM employees
WHERE salary < ALL (
    SELECT salary 
    FROM employees 
    WHERE department_id = 20
);


/* ============================================================================
   3. PRODUCTS WITH PRICE EQUAL TO ANY PRODUCT IN 'ELECTRONICS'
   Uses IN to match against the list of prices returned from the category.
   ============================================================================ */
SELECT 
    product_id, 
    product_name, 
    price
FROM products
WHERE price IN (
    SELECT p.price
    FROM products p
    JOIN categories c ON p.category_id = c.category_id
    WHERE c.category_name = 'Electronics'
);


/* ============================================================================
   4. CUSTOMERS WHO PLACED AN ORDER FOR A PRODUCT > $1000
   Uses IN with nested subqueries to filter customer IDs.
   ============================================================================ */
SELECT 
    customer_id, 
    customer_name
FROM customers
WHERE customer_id IN (
    SELECT o.customer_id
    FROM orders o
    JOIN order_details od ON o.order_id = od.order_id
    WHERE od.product_id IN (
        SELECT product_id 
        FROM products 
        WHERE price > 1000
    )
);


/* ============================================================================
   5. EMPLOYEES WORKING IN JOB TITLES SHARED BY AT LEAST ONE OTHER EMPLOYEE
   Subquery finds job_ids assigned to more than 1 employee.
   ============================================================================ */
SELECT 
    employee_id, 
    first_name || ' ' || last_name AS employee_name, 
    job_id
FROM employees
WHERE job_id IN (
    SELECT job_id
    FROM employees
    GROUP BY job_id
    HAVING COUNT(employee_id) > 1
);


/* ============================================================================
   6. DEPARTMENTS THAT HAVE MORE THAN ONE EMPLOYEE
   Uses IN with a grouped subquery returning department_ids.
   ============================================================================ */
SELECT 
    department_id, 
    department_name
FROM departments
WHERE department_id IN (
    SELECT department_id
    FROM employees
    GROUP BY department_id
    HAVING COUNT(employee_id) > 1
);


/* ============================================================================
   7. ORDERS PLACED BY CUSTOMERS FROM CITIES WITH MULTIPLE CUSTOMERS
   Subquery selects cities where customer count is greater than 1.
   ============================================================================ */
SELECT 
    o.order_id, 
    o.order_date, 
    o.customer_id
FROM orders o
WHERE o.customer_id IN (
    SELECT customer_id
    FROM customers
    WHERE city IN (
        SELECT city
        FROM customers
        GROUP BY city
        HAVING COUNT(customer_id) > 1
    )
);


/* ============================================================================
   8. BOOKS WRITTEN BY AUTHORS WITH MORE THAN ONE BOOK
   Subquery filters author_ids with book counts > 1.
   ============================================================================ */
SELECT 
    book_id, 
    title, 
    author_id
FROM books
WHERE author_id IN (
    SELECT author_id
    FROM books
    GROUP BY author_id
    HAVING COUNT(book_id) > 1
);


/* ============================================================================
   9. STUDENTS ENROLLED IN COURSES TAUGHT BY 'DR. SMITH'
   Subquery gets all course_ids linked to Dr. Smith.
   ============================================================================ */
SELECT 
    s.student_id, 
    s.first_name || ' ' || s.last_name AS student_name
FROM students s
WHERE s.student_id IN (
    SELECT e.student_id
    FROM enrollments e
    WHERE e.course_id IN (
        SELECT c.course_id
        FROM courses c
        JOIN instructors i ON c.instructor_id = i.instructor_id
        WHERE i.instructor_name = 'Dr. Smith'
    )
);


/* ============================================================================
   10. EMPLOYEES WHOSE SALARY MATCHES ANY SALARY IN DEPT 30
   Uses IN to match salaries against department 30.
   ============================================================================ */
SELECT 
    employee_id, 
    first_name || ' ' || last_name AS employee_name, 
    salary, 
    department_id
FROM employees
WHERE salary IN (
    SELECT salary 
    FROM employees 
    WHERE department_id = 30
);