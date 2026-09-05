-- ============================================================
-- Hospital relationship schema
--   Doctor       <-> DoctorDetails : ONE-TO-ONE
--   Hospital     ->  Doctor        : ONE-TO-MANY
--   Doctor       ->  Patient       : ONE-TO-MANY
--   Hospital     <-> Patient       : MANY-TO-MANY (needs join table)
-- ============================================================

CREATE TABLE hospital (
    id                INT PRIMARY KEY AUTO_INCREMENT,
    name              VARCHAR(100) NOT NULL,
    number_of_doctors INT,
    number_of_patient INT
);

CREATE TABLE doctor_details (
    id           INT PRIMARY KEY AUTO_INCREMENT,
    full_address VARCHAR(255),
    first_name   VARCHAR(50),
    last_name    VARCHAR(50),
    age          INT
);

CREATE TABLE doctor (
    id                INT PRIMARY KEY AUTO_INCREMENT,
    user_name         VARCHAR(50) NOT NULL,
    salary            DOUBLE,
    hospital_id       INT,
    doctor_details_id INT UNIQUE,                       -- UNIQUE enforces the 1-to-1 side
    FOREIGN KEY (hospital_id)       REFERENCES hospital(id),
    FOREIGN KEY (doctor_details_id) REFERENCES doctor_details(id)
);

CREATE TABLE patient (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    name            VARCHAR(100) NOT NULL,
    type_of_disease VARCHAR(100),
    doctor_id       INT,                                -- FK on the "many" side (patient -> doctor)
    FOREIGN KEY (doctor_id) REFERENCES doctor(id)
);

-- Join table for the Hospital <-> Patient many-to-many relationship
CREATE TABLE hospital_patient (
    hospital_id INT,
    patient_id  INT,
    PRIMARY KEY (hospital_id, patient_id),
    FOREIGN KEY (hospital_id) REFERENCES hospital(id),
    FOREIGN KEY (patient_id)  REFERENCES patient(id)
);
