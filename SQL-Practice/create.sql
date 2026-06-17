CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employee (
    eid INT PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    age INT
);

INSERT INTO employee VALUES (101, 'Sonia', 50000, 20);
INSERT INTO employee VALUES (102, 'Riya', 45000, 21);
INSERT INTO employee VALUES (103, 'Aman', 60000, 22);