--1. Employee Names and Manager Names "Self Join
SELECT 
    e.employee_id,
    e.first_name || ' ' || e.last_name AS employee_name,
    m.employee_id                    AS manager_id,
    m.first_name || ' ' || m.last_name AS manager_name
FROM employees e
LEFT JOIN employees m 
       ON e.manager_id = m.employee_id;

--2. Customer Names and Salesperson Names
SELECT 
    c.name AS customer_name,
    e.name AS salesperson_name
FROM customers c
JOIN employees e 
  ON c.sales_rep_id = e.employee_id;

--3. Order IDs and Product IDs
SELECT 
    o.order_id,
    od.product_id
FROM orders o
JOIN order_details od 
  ON o.order_id = od.order_id;

--4. Student Names and Instructor Names
SELECT 
    s.name AS student_name,
    i.name AS instructor_name
FROM students s
JOIN classes c     ON s.class_id = c.class_id
JOIN instructors i ON c.instructor_id = i.instructor_id;

--5. Employee Salaries and Department Budgets
SELECT 
    e.first_name || ' ' || e.last_name AS employee_name,
    e.salary                           AS employee_salary,
    d.department_name,
    d.budget                           AS department_budget
FROM employees e
JOIN departments d 
  ON e.department_id = d.department_id;

--6. Project Names and Task Names
SELECT 
    p.name AS project_name,
    t.name AS task_name
FROM projects p
JOIN tasks t 
  ON p.project_id = t.project_id;

--7. Course Dates and Exam Dates
SELECT 
    c.course_name,
    c.start_date AS course_start_date,
    e.exam_date  AS exam_scheduled_date
FROM courses c
JOIN exams e 
  ON c.course_id = e.course_id;

--8. Product Name and Category Name
SELECT 
    p.name AS product_name,
    c.name AS category_name
FROM products p
JOIN categories c 
  ON p.category_id = c.category_id;

--9. Book Title and Publisher Name
SELECT 
    b.title AS book_title,
    p.name  AS publisher_name
FROM books b
JOIN publishers p 
  ON b.publisher_id = p.publisher_id;

--10. Employee Names and Department Location
SELECT 
    e.first_name || ' ' || e.last_name AS employee_name,
    e.location                         AS employee_location,
    d.location                         AS department_location
FROM employees e
JOIN departments d 
  ON e.department_id = d.department_id;

--