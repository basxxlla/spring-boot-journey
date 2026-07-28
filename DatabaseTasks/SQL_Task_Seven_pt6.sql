/* ============================================================================
   1. CUSTOMERS AND ORDERS
   Returns all customers (even without orders) AND all orders (even without matching customers).
   ============================================================================ */
SELECT 
    c.customer_id,
    c.customer_name,
    o.order_id,
    o.order_date,
    o.total_amount
FROM customers c
FULL OUTER JOIN orders o 
             ON c.customer_id = o.customer_id;


/* ============================================================================
   2. EMPLOYEES AND PROJECTS
   Returns unassigned employees AND projects with no assigned employees.
   ============================================================================ */
SELECT 
    e.employee_id,
    e.first_name || ' ' || e.last_name AS employee_name,
    p.project_id,
    p.project_name
FROM employees e
FULL OUTER JOIN project_assignments pa ON e.employee_id = pa.employee_id
FULL OUTER JOIN projects p           ON pa.project_id = p.project_id;


/* ============================================================================
   3. PRODUCTS AND SUPPLIERS
   Returns products without suppliers AND suppliers offering no products.
   ============================================================================ */
SELECT 
    p.product_id,
    p.product_name,
    s.supplier_id,
    s.supplier_name
FROM products p
FULL OUTER JOIN suppliers s 
             ON p.supplier_id = s.supplier_id;


/* ============================================================================
   4. STUDENTS AND COURSES
   Returns students not enrolled in courses AND courses with zero students enrolled.
   ============================================================================ */
SELECT 
    s.student_id,
    s.first_name || ' ' || s.last_name AS student_name,
    c.course_id,
    c.course_name
FROM students s
FULL OUTER JOIN enrollments e ON s.student_id = e.student_id
FULL OUTER JOIN courses c     ON e.course_id = c.course_id;


/* ============================================================================
   5. AUTHORS AND BOOKS
   Returns authors without books AND books without assigned authors.
   ============================================================================ */
SELECT 
    a.author_id,
    a.author_name,
    b.book_id,
    b.title AS book_title
FROM authors a
FULL OUTER JOIN books b 
             ON a.author_id = b.author_id;


/* ============================================================================
   6. EMPLOYEES AND DEPARTMENTS
   Returns unassigned employees AND departments with zero staff.
   ============================================================================ */
SELECT 
    e.employee_id,
    e.first_name || ' ' || e.last_name AS employee_name,
    d.department_id,
    d.department_name
FROM employees e
FULL OUTER JOIN departments d 
             ON e.department_id = d.department_id;


/* ============================================================================
   7. TRANSACTIONS AND PAYMENT METHODS
   Returns transactions without valid payment methods AND unused payment methods.
   ============================================================================ */
SELECT 
    t.transaction_id,
    t.amount,
    t.transaction_date,
    pm.payment_method_id,
    pm.method_name
FROM transactions t
FULL OUTER JOIN payment_methods pm 
             ON t.payment_method_id = pm.payment_method_id;


/* ============================================================================
   8. COMBINE REGIONAL CUSTOMER LISTS
   Compares East Region vs. West Region customer lists by customer_id/email, 
   showing matches, East-only, and West-only records.
   ============================================================================ */
SELECT 
    e.customer_id AS east_cust_id,
    e.customer_name AS east_cust_name,
    w.customer_id AS west_cust_id,
    w.customer_name AS west_cust_name,
    COALESCE(e.email, w.email) AS primary_email
FROM customers_east e
FULL OUTER JOIN customers_west w 
             ON e.email = w.email;