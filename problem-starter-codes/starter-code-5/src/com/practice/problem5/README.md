# Problem 5: Hotel Room Booking System

## Problem Summary

Implement an OOP hotel booking system to add/remove guests and rooms, book/cancel rooms, and raise proper exceptions.

## Learning Goals

- Encapsulation
- Interfaces
- Composition
- Inheritance (where appropriate)
- Polymorphism
- Defensive programming

## Folder Explanation

- `Main.java` – Entry point; runs the evaluator.
- `evaluator/` – LOCKED, DO NOT EDIT; runs 24 assertions and prints `ALL TESTS PASSED` or throws.
- `interfaces/` – Java interfaces (e.g. `Bookable`).
- `models/` – Core data models (`Room`, `Guest`, `Hotel`, `Booking`).
- `services/` – Business logic, user-facing API (`BookingService`).
- `exceptions/` – Custom exceptions for error conditions.

## Classes to Implement

- Implement skeletons as provided.
- All methods must throw `new UnsupportedOperationException("TODO");`
- Do not implement logic until instructions are lifted.

## How to Run

```sh
javac com/practice/problem5/**/*.java
java com.practice.problem5.Main
```