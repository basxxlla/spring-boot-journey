-- 1. Create the Phone table first (so it can be referenced by Employee)
CREATE TABLE Phone (
    phone_id     NUMBER,
    phone_number VARCHAR2(20) NOT NULL,
    CONSTRAINT pk_phone PRIMARY KEY (phone_id)
);

-- 2. Create the Employee table second
CREATE TABLE Employee (
    employee_id NUMBER,
    name        VARCHAR2(100) NOT NULL,
    age         NUMBER,
    phone_id    NUMBER, -- The foreign key column
    
    CONSTRAINT pk_employee PRIMARY KEY (employee_id),
    
    -- Enforces that the phone_id must exist in the Phone table
    CONSTRAINT fk_employee_phone FOREIGN KEY (phone_id) 
        REFERENCES Phone(phone_id),
        
    -- CRITICAL STEP: The UNIQUE constraint turns this from a standard 1:Many into a strict 1:1.
    -- No two rows in the Employee table can share the same phone_id.
    CONSTRAINT unq_employee_phone UNIQUE (phone_id)
);

SELECT e.name AS employee_name, e.age, p.phone_number
FROM Employee e
JOIN Phone p ON e.phone_id = p.phone_id;