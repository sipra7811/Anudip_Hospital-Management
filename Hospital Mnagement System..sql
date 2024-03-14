create database HOSPITAL ;
USE HOSPITAL;

CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    password VARCHAR(255),
    role VARCHAR(20) CHECK (role IN ('patient', 'admin'))
);

CREATE TABLE patient (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(50),
    dateofbirth DATE,
    gender VARCHAR(10),
    address VARCHAR(255),
    phone_no VARCHAR(15),
    insurance_info VARCHAR(255),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE doctor (
    doctor_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    specialization VARCHAR(50),
    email_id VARCHAR(255),
    contact_no VARCHAR(15),
    department_name VARCHAR(255)
);
CREATE TABLE appointment (
    appointment_id INT PRIMARY KEY,
    appointment_date DATE,
    status VARCHAR(20),
    prescription TEXT, 
    patient_id INT,
    doctor_id INT,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE Billing (
    billing_id INT PRIMARY KEY,
    patient_id INT,
    amount INT,
    billing_date DATE,
    payment_status VARCHAR(20),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);

-- DROP TABLE IF EXISTS Users;
