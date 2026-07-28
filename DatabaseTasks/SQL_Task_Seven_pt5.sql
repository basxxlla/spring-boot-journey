/* ============================================================================
   1. DEPARTMENTS AND EMPLOYEES
   Returns all departments from the right table, including those with zero employees.
   ============================================================================ */
SELECT 
    d.department_id,
    d.department_name,
    e.employee_id,
    e.first_name || ' ' || e.last_name AS employee_name
FROM employees e
RIGHT OUTER JOIN departments d 
              ON e.department_id = d.department_id;


/* ============================================================================
   2. ORDERS AND CUSTOMERS
   Returns all customers from the right table, including those who have placed no orders.
   ============================================================================ */
SELECT 
    c.customer_id,
    c.customer_name,
    o.order_id,
    o.order_date
FROM orders o
RIGHT JOIN customers c 
        ON o.customer_id = c.customer_id;


/* ============================================================================
   3. COURSES AND ENROLLED STUDENTS
   Returns all courses from the right table, including courses without enrolled students.
   ============================================================================ */
SELECT 
    c.course_id,
    c.course_name,
    s.student_id,
    s.first_name || ' ' || s.last_name AS student_name
FROM enrollments e
JOIN students s ON e.student_id = s.student_id
RIGHT JOIN courses c ON e.course_id = c.course_id;


/* ============================================================================
   4. PROJECTS AND ASSIGNED EMPLOYEES
   Returns all projects from the right table, including projects with no assigned employees.
   ============================================================================ */
SELECT 
    p.project_id,
    p.project_name,
    e.employee_id,
    e.first_name || ' ' || e.last_name AS employee_name
FROM project_assignments pa
JOIN employees e ON pa.employee_id = e.employee_id
RIGHT OUTER JOIN projects p ON pa.project_id = p.project_id;


/* ============================================================================
   5. PAYMENT METHODS AND TRANSACTIONS
   Returns all payment methods from the right table, including unused ones.
   ============================================================================ */
SELECT 
    pm.payment_method_id,
    pm.method_name,
    t.transaction_id,
    t.amount,
    t.transaction_date
FROM transactions t
RIGHT JOIN payment_methods pm 
        ON t.payment_method_id = pm.payment_method_id;


/* ============================================================================
   6. AUTHORS AND THEIR BOOKS
   Returns all authors from the right table, including authors with no published books.
   ============================================================================ */
SELECT 
    a.author_id,
    a.author_name,
    b.book_id,
    b.title AS book_title
FROM books b
RIGHT OUTER JOIN authors a 
              ON b.author_id = a.author_id;


/* ============================================================================
   7. CATEGORIES AND PRODUCTS
   Returns all categories from the right table, including categories with no products.
   ============================================================================ */
SELECT 
    c.category_id,
    c.category_name,
    p.product_id,
    p.product_name
FROM products p
RIGHT JOIN categories c 
        ON p.category_id = c.category_id;


/* ============================================================================
   8. STUDENTS AND ASSIGNED DORM ROOMS
   Returns all dorm rooms from the right table, including empty/unassigned rooms.
   ============================================================================ */
SELECT 
    r.room_id,
    r.room_number,
    r.building_name,
    s.student_id,
    s.first_name || ' ' || s.last_name AS student_name
FROM students s
RIGHT OUTER JOIN dorm_rooms r 
              ON s.room_id = r.room_id;