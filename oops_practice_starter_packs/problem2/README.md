# Problem 2: Employee Management System

## Problem Description
Create an employee management system that models employees with their basic information. Implement inheritance by creating different types of employees (Full-time and Part-time) with specialized behaviors.

## Requirements
- Create an abstract `Employee` class with common properties (employeeId, name, email)
- Implement abstract method calculateSalary()
- Create FullTimeEmployee class that extends Employee with fixed salary
- Create PartTimeEmployee class that extends Employee with hourly rate and hours worked
- Implement proper constructors and getters/setters
- Override toString() method in all classes

## Starter Code Location
- Main implementation: `src/main/java/Employee.java`, `src/main/java/FullTimeEmployee.java`, `src/main/java/PartTimeEmployee.java`
- Test cases: `src/test/java/EmployeeTest.java`