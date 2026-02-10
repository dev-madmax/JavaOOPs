# Problem 10: Restaurant Table Reservation System

## Problem Summary

Implement an OOP restaurant reservation system to add/remove customers and tables, make/cancel reservations, and raise proper exceptions.

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
- `interfaces/` – Java interfaces (e.g. `Reservable`).
- `models/` – Core data models (`Table`, `Customer`, `Reservation`, `Restaurant`).
- `services/` – Business logic, user-facing API (`ReservationService`).
- `exceptions/` – Custom exceptions for error conditions.

## Classes to Implement

- Implement skeletons as provided.
- All methods must throw `new UnsupportedOperationException("TODO");`
- Do not implement logic until instructions are lifted.

## How to Run

```sh
javac com/practice/problem10/**/*.java
java com.practice.problem10.Main
```