create database Question28;
use Question28;

-- Create the 'employees' table
CREATE TABLE IF NOT EXISTS employees1 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(100) NOT NULL
);

-- Insert some initial data
INSERT INTO employees1 (name, position) VALUES ('Alice Johnson', 'Manager');
INSERT INTO employees1 (name, position) VALUES ('Bob Smith', 'Developer');
INSERT INTO employees1 (name, position) VALUES ('Carol Brown', 'Designer');

select *from employees1;