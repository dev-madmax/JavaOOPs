# Problem 1: Library Book Management System

## Problem Summary

Implement an object-oriented library management system that allows adding and removing books and members, and borrowing and returning books, enforcing appropriate constraints and raising exceptions as needed.

## Learning Goals

- Encapsulation
- Interfaces
- Composition
- Inheritance (where appropriate)
- Polymorphism
- Defensive programming

## Folder Explanation

- `Main.java` – Entry point; runs the evaluator.
- `evaluator/` – Contains `Evaluator.java` (LOCKED, DO NOT EDIT): runs over 20 assertions and prints `ALL TESTS PASSED` or throws.
- `interfaces/` – Java interfaces (e.g. `Borrowable`).
- `models/` – Core data models (`Book`, `Library`, `Member`).
- `services/` – Business logic, user-facing API (`LibraryService`).
- `exceptions/` – Custom exceptions for error conditions.

## Classes to Implement

- Implement skeletons as provided.
- All methods must throw `new UnsupportedOperationException("TODO");`
- Do not implement logic until instructions are lifted.

## How to Run

```sh
javac com/practice/problem1/**/*.java
java com.practice.problem1.Main
```