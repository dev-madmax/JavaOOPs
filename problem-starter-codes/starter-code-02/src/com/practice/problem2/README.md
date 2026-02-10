# Problem 2: Parking Lot Manager

## Problem Summary

Implement an object-oriented parking lot management system that allows vehicles to be parked, unparked, and removed, with proper slot management and exception handling.

## Learning Goals

- Encapsulation
- Interfaces
- Composition
- Inheritance (where appropriate)
- Polymorphism
- Defensive programming

## Folder Explanation

- `Main.java` – Entry point; runs the evaluator.
- `evaluator/` – Contains `Evaluator.java` (LOCKED, DO NOT EDIT): runs 22 assertions and prints `ALL TESTS PASSED` or throws.
- `interfaces/` – Java interfaces (e.g. `Parkable`).
- `models/` – Core data models (`ParkingLot`, `Slot`, `Vehicle`).
- `services/` – Business logic, user-facing API (`ParkingLotService`).
- `exceptions/` – Custom exceptions for error conditions.

## Classes to Implement

- Implement skeletons as provided.
- All methods must throw `new UnsupportedOperationException("TODO");`
- Do not implement logic until instructions are lifted.

## How to Run

```sh
javac com/practice/problem2/**/*.java
java com.practice.problem2.Main
```