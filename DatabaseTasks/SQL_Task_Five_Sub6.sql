-- 1. Create the Parent Table (Language) first
CREATE TABLE Language (
    language_id NUMBER,
    name        VARCHAR2(50) NOT NULL,
    CONSTRAINT pk_language PRIMARY KEY (language_id)
);

-- 2. Create the Child Table (Teacher) second
CREATE TABLE Teacher (
    teacher_id  NUMBER,
    name        VARCHAR2(100) NOT NULL,
    salary      NUMBER(10, 2),
    language_id NUMBER NOT NULL, -- The foreign key column linking to Language
    
    CONSTRAINT pk_teacher PRIMARY KEY (teacher_id),
    
    -- Enforces that every language_id assigned to a teacher must exist in the Language table
    CONSTRAINT fk_teacher_language FOREIGN KEY (language_id) 
        REFERENCES Language(language_id)
);

SELECT t.name AS teacher_name, t.salary, l.name AS language_name
FROM Teacher t
JOIN Language l ON t.language_id = l.language_id;