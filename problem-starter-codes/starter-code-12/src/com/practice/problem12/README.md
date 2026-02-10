# Problem 12: Flight Booking System

## Problem Summary

Implement an OOP flight booking system to add/remove passengers and flights, book/cancel flights, and raise proper exceptions.

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
- `models/` – Core data models (`Flight`, `Passenger`, `Reservation`, `Airline`).
- `services/` – Business logic, user-facing API (`BookingService`).
- `exceptions/` – Custom exceptions for error conditions.

## Classes to Implement

- Implement skeletons as provided.
- All methods must throw `new UnsupportedOperationException("TODO");`
- Do not implement logic until instructions are lifted.

## How to Run

```sh
javac com/practice/problem12/**/*.java
java com.practice.problem12.Main
```