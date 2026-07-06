-- 1. Create the Parent Table Language
CREATE TABLE Language (
    language_id NUMBER,
    name VARCHAR2(50) NOT NULL,
    CONSTRAINT pk_language PRIMARY KEY (language_id)
);

-- 2. Create the Child Table Teacher
CREATE TABLE Teacher (
    teacher_id NUMBER,
    name VARCHAR2(100) NOT NULL,
    salary NUMBER(10, 2),
    language_id NUMBER NOT NULL, -- The foreign key mapping back to Language
    
    CONSTRAINT pk_teacher PRIMARY KEY (teacher_id),
    -- This enforces that language_id must exist in the Language table
    CONSTRAINT fk_teacher_language FOREIGN KEY (language_id) 
        REFERENCES Language(language_id)
);