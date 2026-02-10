# Problem 4: Task Management System

## Problem Summary
Implement a simple task management system that allows creating tasks with different statuses (PENDING, IN_PROGRESS, COMPLETED) and tracking their completion state.

## Learning Goals
- Work with enums for state representation
- Practice data validation for required fields
- Implement state management with proper encapsulation
- Create a clean domain model with appropriate methods
- Apply equality and hash code based on business identity

## Folder Structure
```
src/
├── com/practice/problem4/
│   ├── Main.java                 # Entry point (calls evaluator)
│   ├── evaluator/
│   │   └── Evaluator.java       # Automated tests (DO NOT MODIFY)
│   ├── interfaces/              # Interface definitions
│   ├── models/                  # Business models (Task, TaskStatus)
│   ├── services/                # Service classes
│   └── exceptions/              # Custom exception classes
```

## Classes to Implement
- `Task.java` - Model representing a task with ID, title, description, and status
- `TaskStatus.java` - Enum representing possible task statuses
- `InvalidTaskException.java` - Exception for invalid task operations

## How To Run
Compile and run the evaluator to test your implementation:
```bash
javac com/practice/problem4/**/*.java
java com.practice.problem4.Main
```

The evaluator will run comprehensive tests and print "PASS" if all requirements are met.