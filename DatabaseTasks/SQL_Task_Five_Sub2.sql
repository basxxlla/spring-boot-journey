-- 1. Create the Doctor Table
CREATE TABLE Doctor (
    doctor_id NUMBER,
    name VARCHAR2(100) NOT NULL,
    salary NUMBER(10, 2),
    CONSTRAINT pk_doctor PRIMARY KEY (doctor_id)
);

-- 2. Create the Patient Table
CREATE TABLE Patient (
    patient_id NUMBER,
    name VARCHAR2(100) NOT NULL,
    age NUMBER,
    CONSTRAINT pk_patient PRIMARY KEY (patient_id)
);

-- 3. Create the Junction Table (Doctor_Patient) to handle the Many-to-Many relationship
CREATE TABLE Doctor_Patient (
    doctor_id NUMBER,
    patient_id NUMBER,
    -- Composite Primary Key (prevents duplicating the exact same appointment)
    CONSTRAINT pk_doctor_patient PRIMARY KEY (doctor_id, patient_id),
    -- Foreign Keys linking back to parent tables
    CONSTRAINT fk_dp_doctor FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id) ON DELETE CASCADE,
    CONSTRAINT fk_dp_patient FOREIGN KEY (patient_id) REFERENCES Patient(patient_id) ON DELETE CASCADE
);