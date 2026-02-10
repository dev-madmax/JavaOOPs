# Problem 11: Task Management System

## Problem Summary

Implement an OOP task management system to add/remove users and tasks, assign tasks, and raise proper exceptions.

## Learning Goals

- Encapsulation
- Interfaces
- Composition
- Inheritance (where appropriate)
- Polymorphism
- Defensive programming

## Folder Explanation

- `Main.java` – Entry point; runs the evaluator.
- `evaluator/` – LOCKED, DO NOT EDIT; runs 22 assertions and prints `ALL TESTS PASSED` or throws.
- `interfaces/` – Java interfaces (e.g. `Assignable`).
- `models/` – Core data models (`Task`, `User`, `Assignment`).
- `services/` – Business logic, user-facing API (`TaskService`).
- `exceptions/` – Custom exceptions for error conditions.

## Classes to Implement

- Implement skeletons as provided.
- All methods must throw `new UnsupportedOperationException("TODO");`
- Do not implement logic until instructions are lifted.

## How to Run

```sh
javac com/practice/problem11/**/*.java
java com.practice.problem11.Main
```