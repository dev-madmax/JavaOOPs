# Problem 3: Student Grade Management

## Problem Summary
Implement a simple student grade management system that handles students, courses, and grades. The system should validate data formats and convert letter grades to numeric equivalents.

## Learning Goals
- Practice data validation (email format, grade format)
- Work with multiple related entity classes
- Convert between different representations (letter to numeric grades)
- Implement business logic with specific rules
- Apply proper equality and hash code implementations

## Folder Structure
```
src/
├── com/practice/problem3/
│   ├── Main.java                 # Entry point (calls evaluator)
│   ├── evaluator/
│   │   └── Evaluator.java       # Automated tests (DO NOT MODIFY)
│   ├── interfaces/              # Interface definitions
│   ├── models/                  # Business models (Student, Course, Grade)
│   ├── services/                # Service classes
│   └── exceptions/              # Custom exception classes
```

## Classes to Implement
- `Student.java` - Model representing a student with ID, name, and validated email
- `Course.java` - Model representing a course with ID, name, and credits
- `Grade.java` - Model representing a grade with student, course, and letter grade
- `DuplicateEntityException.java` - Exception for duplicate entries
- `EntityNotFoundException.java` - Exception for missing entities

## How To Run
Compile and run the evaluator to test your implementation:
```bash
javac com/practice/problem3/**/*.java
java com.practice.problem3.Main
```

The evaluator will run comprehensive tests and print "PASS" if all requirements are met.