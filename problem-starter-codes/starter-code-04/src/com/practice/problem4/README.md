# Problem 4: Classroom Attendance Tracker

## Problem Summary

Implement an object-oriented attendance tracking system to add/remove students, mark attendance, and manage attendance records with proper exception handling.

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
- `interfaces/` – Java interfaces (e.g. `Attendable`).
- `models/` – Core data models (`Student`, `ClassRoom`, `AttendanceRecord`).
- `services/` – Business logic, user-facing API (`AttendanceService`).
- `exceptions/` – Custom exceptions for error conditions.

## Classes to Implement

- Implement skeletons as provided.
- All methods must throw `new UnsupportedOperationException("TODO");`
- Do not implement logic until instructions are lifted.

## How to Run

```sh
javac com/practice/problem4/**/*.java
java com.practice.problem4.Main
```