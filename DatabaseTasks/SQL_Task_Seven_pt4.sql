--1. Employees and Their Department Names
SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    d.department_name
FROM employees e
LEFT OUTER JOIN departments d 
             ON e.department_id = d.department_id;

--2. Products and Their Associated Categories
SELECT 
    p.product_id,
    p.product_name,
    c.category_name
FROM products p
LEFT JOIN categories c 
       ON p.category_id = c.category_id;

--3. Students and Enrolled Courses
SELECT 
    s.student_id,
    s.first_name || ' ' || s.last_name AS student_name,
    c.course_name
FROM students s
LEFT OUTER JOIN enrollments e ON s.student_id = e.student_id
LEFT OUTER JOIN courses c     ON e.course_id = c.course_id;

--4. Orders with Customer Names
SELECT 
    o.order_id,
    o.order_date,
    o.total_amount,
    c.customer_name
FROM orders o
LEFT JOIN customers c 
       ON o.customer_id = c.customer_id;

--5. Departments and Their Managers
SELECT 
    d.department_id,
    d.department_name,
    e.first_name || ' ' || e.last_name AS manager_name
FROM departments d
LEFT OUTER JOIN employees e 
             ON d.manager_id = e.employee_id;

--6. Books and Their Authors
SELECT 
    b.book_id,
    b.title,
    a.author_name
FROM books b
LEFT JOIN authors a 
       ON b.author_id = a.author_id;

--7. Invoices and Payment Status
SELECT 
    i.invoice_id,
    i.invoice_date,
    i.amount,
    p.payment_status,
    p.payment_date
FROM invoices i
LEFT JOIN payments p 
       ON i.invoice_id = p.invoice_id;

--8. Employees and Assigned Projects
SELECT 
    e.employee_id,
    e.first_name || ' ' || e.last_name AS employee_name,
    pa.project_id,
    pa.project_name
FROM employees e
LEFT JOIN projects_assigned pa 
       ON e.employee_id = pa.employee_id;
