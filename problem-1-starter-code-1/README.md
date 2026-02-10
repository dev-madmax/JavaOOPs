# Problem 1: Library Management System

## Problem Summary
Implement a simple library management system that allows adding, removing, and finding books. Books are uniquely identified by their ISBN.

## Learning Goals
- Practice encapsulation with private fields and public getters
- Implement proper equals() and hashCode() methods based on business key (ISBN)
- Handle collections safely with capacity limits
- Implement custom exceptions for business rules
- Work with basic OOP concepts like constructors and methods

## Folder Structure
```
src/
├── com/practice/problem1/
│   ├── Main.java                 # Entry point (calls evaluator)
│   ├── evaluator/
│   │   └── Evaluator.java       # Automated tests (DO NOT MODIFY)
│   ├── interfaces/              # Interface definitions
│   ├── models/                  # Business models (Book, Library)
│   ├── services/                # Service classes
│   └── exceptions/              # Custom exception classes
```

## Classes to Implement
- `Book.java` - Model representing a book with ISBN, title, author, and publication year
- `Library.java` - Model representing a library with book collection management
- `DuplicateEntityException.java` - Exception for duplicate entries
- `EntityNotFoundException.java` - Exception for missing entities

## How To Run
Compile and run the evaluator to test your implementation:
```bash
javac com/practice/problem1/**/*.java
java com.practice.problem1.Main
```

The evaluator will run comprehensive tests and print "PASS" if all requirements are met.