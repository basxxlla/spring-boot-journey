-- 1. Create the Phone table first
CREATE TABLE Phone (
    phone_id NUMBER,
    phone_number VARCHAR2(20) NOT NULL,
    CONSTRAINT pk_phone PRIMARY KEY (phone_id)
);

-- 2. Create the Employee table second
CREATE TABLE Employee (
    employee_id NUMBER,
    name VARCHAR2(100) NOT NULL,
    age NUMBER,
    phone_id NUMBER, -- The foreign key column
    
    CONSTRAINT pk_employee PRIMARY KEY (employee_id),
    
    -- Links Employee to Phone
    CONSTRAINT fk_employee_phone FOREIGN KEY (phone_id) 
        REFERENCES Phone(phone_id),
        
    -- The UNIQUE constraint ensures it is a strict 1:1 relationship.
    -- No two employees can be assigned the same phone_id.
    CONSTRAINT unq_employee_phone UNIQUE (phone_id)
);