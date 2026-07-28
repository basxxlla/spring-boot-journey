/* ============================================================================
   1. EMPLOYEES EARNING MORE THAN AVERAGE SALARY
   Uses a scalar subquery to calculate the overall average salary.
   ============================================================================ */
SELECT 
    first_name, 
    last_name, 
    salary
FROM employees
WHERE salary > (
    SELECT AVG(salary) 
    FROM employees
);


/* ============================================================================
   2. CUSTOMERS WITH THE HIGHEST NUMBER OF ORDERS
   Uses subqueries to aggregate order counts per customer and find the maximum count.
   ============================================================================ */
SELECT 
    c.customer_id, 
    c.customer_name, 
    COUNT(o.order_id) AS total_orders
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, c.customer_name
HAVING COUNT(o.order_id) = (
    SELECT MAX(order_count)
    FROM (
        SELECT COUNT(order_id) AS order_count
        FROM orders
        GROUP BY customer_id
    )
);


/* ============================================================================
   3. PRODUCTS PRICED HIGHER THAN ANY PRODUCT IN 'ACCESSORIES'
   > ANY means greater than the minimum price in the Accessories category.
   ============================================================================ */
SELECT 
    product_id, 
    product_name, 
    price
FROM products
WHERE price > ANY (
    SELECT p.price
    FROM products p
    JOIN categories c ON p.category_id = c.category_id
    WHERE c.category_name = 'Accessories'
);


/* ============================================================================
   4. EMPLOYEES IN THE SAME DEPARTMENT AS 'JOHN SMITH'
   Uses a subquery to look up John Smith's department_id (excluding John Smith himself).
   ============================================================================ */
SELECT 
    first_name, 
    last_name, 
    department_id
FROM employees
WHERE department_id = (
    SELECT department_id 
    FROM employees 
    WHERE first_name = 'John' AND last_name = 'Smith'
)
AND NOT (first_name = 'John' AND last_name = 'Smith');


/* ============================================================================
   5. ORDERS PLACED BY CUSTOMERS FROM 'NEW YORK'
   Uses IN with a subquery filtering customers by city.
   ============================================================================ */
SELECT 
    order_id, 
    order_date, 
    customer_id, 
    total_amount
FROM orders
WHERE customer_id IN (
    SELECT customer_id 
    FROM customers 
    WHERE city = 'New York'
);


/* ============================================================================
   6. DEPARTMENTS WITH NO EMPLOYEES
   Uses a correlated NOT EXISTS subquery to check for unassigned departments.
   ============================================================================ */
SELECT 
    d.department_id, 
    d.department_name
FROM departments d
WHERE NOT EXISTS (
    SELECT 1 
    FROM employees e 
    WHERE e.department_id = d.department_id
);


/* ============================================================================
   7. STUDENTS NOT ENROLLED IN ANY COURSE
   Uses NOT EXISTS to safely handle potential NULL values in enrollment records.
   ============================================================================ */
SELECT 
    s.student_id, 
    s.first_name || ' ' || s.last_name AS student_name
FROM students s
WHERE NOT EXISTS (
    SELECT 1 
    FROM enrollments e 
    WHERE e.student_id = s.student_id
);


/* ============================================================================
   8. SECOND HIGHEST SALARY
   Uses MAX with a subquery filtering out the top salary.
   ============================================================================ */
SELECT MAX(salary) AS second_highest_salary
FROM employees
WHERE salary < (
    SELECT MAX(salary) 
    FROM employees
);


/* ============================================================================
   9. PRODUCTS PRICED HIGHER THAN AVERAGE PRODUCT PRICE
   Uses a scalar subquery to evaluate against the dataset's mean price.
   ============================================================================ */
SELECT 
    product_id, 
    product_name, 
    price
FROM products
WHERE price > (
    SELECT AVG(price) 
    FROM products
);


/* ============================================================================
   10. CUSTOMERS WHO HAVE ORDERED ALL PRODUCTS IN CATEGORY 'A'
   Uses relational division (double NOT EXISTS): "Find customers for whom 
   there exists NO product in Category A that they have NOT ordered."
   ============================================================================ */
SELECT 
    c.customer_id, 
    c.customer_name
FROM customers c
WHERE NOT EXISTS (
    SELECT p.product_id
    FROM products p
    JOIN categories cat ON p.category_id = cat.category_id
    WHERE cat.category_name = 'A'
    AND NOT EXISTS (
        SELECT 1
        FROM orders o
        JOIN order_details od ON o.order_id = od.order_id
        WHERE o.customer_id = c.customer_id
        AND od.product_id = p.product_id
    )
);