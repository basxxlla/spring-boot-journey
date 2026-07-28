--1. Employees and Department Names
SELECT first_name, last_name, department_name
FROM employees
NATURAL JOIN departments;

--2. Orders and Customer Names
SELECT order_id, order_date, customer_name
FROM orders
NATURAL JOIN customers;

--3. Student Names and Enrolled Courses
SELECT student_name, course_name
FROM students
NATURAL JOIN enrollments
NATURAL JOIN courses;

--4. Project Names and Assigned Employees
SELECT project_name, first_name, last_name
FROM projects
NATURAL JOIN project_assignments
NATURAL JOIN employees;

--5. Invoice Details and Product Names
SELECT invoice_id, invoice_date, product_name, quantity, unit_price
FROM invoice_items
NATURAL JOIN products;

--6. Books and Author Names
SELECT book_title, author_name
FROM books
NATURAL JOIN authors;

--7. Class Schedules and Instructor Names
SELECT class_name, schedule_time, room_number, instructor_name
FROM class_schedules
NATURAL JOIN instructors;

--8. Supplier Names and Products Supplied
SELECT supplier_name, product_name
FROM suppliers
NATURAL JOIN products;

--9. Customer Orders and Shipping Details
SELECT order_id, order_date, shipping_address, tracking_number, shipping_status
FROM orders
NATURAL JOIN shipments;

--10. Employees and Job Titles
SELECT first_name, last_name, job_title
FROM employees
NATURAL JOIN jobs;

--