--1. Employee Names and Department Names
SELECT first_name, last_name, department_name
FROM employees
JOIN departments USING (department_id);

--2. Orders and Customer Names
SELECT order_id, order_date, customer_name
FROM orders
JOIN customers USING (customer_id);

--3. Product Names and Supplier Names
SELECT product_name, supplier_name
FROM products
JOIN suppliers USING (supplier_id);

--4. Student Names and Course Titles
SELECT student_name, course_title
FROM students
JOIN enrollments USING (student_id)
JOIN courses USING (course_id);

--5. Invoice Numbers and Product Names
SELECT invoice_number, product_name
FROM invoices
JOIN products USING (product_id);

--6. Project Names and Employee Names
SELECT project_name, first_name, last_name
FROM projects
JOIN project_assignments USING (project_id)
JOIN employees USING (employee_id);

--7. Author Names and Book Titles
SELECT author_name, book_title
FROM books
JOIN authors USING (author_id);

--8. Sales Order Details with Employee Names
SELECT order_id, order_date, first_name, last_name
FROM sales_orders
JOIN employees USING (employee_id);

--9. Course Schedules and Instructor Names
SELECT course_title, schedule_time, instructor_name
FROM course_schedules
JOIN instructors USING (instructor_id);

--10. Transactions and Account Holder Names
SELECT transaction_id, transaction_date, amount, account_holder_name
FROM transactions
JOIN accounts USING (account_id);

--