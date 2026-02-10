# Problem 3: Bank Account System

## Problem Summary

Implement an object-oriented bank account system to open/close accounts, manage customers, deposit/withdraw funds, manage transactions, and raise proper exceptions.

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
- `interfaces/` – Java interfaces (e.g. `Accountable`).
- `models/` – Core data models (`BankAccount`, `Customer`, `Transaction`).
- `services/` – Business logic, user-facing API (`BankService`).
- `exceptions/` – Custom exceptions for error conditions.

## Classes to Implement

- Implement skeletons as provided.
- All methods must throw `new UnsupportedOperationException("TODO");`
- Do not implement logic until instructions are lifted.

## How to Run

```sh
javac com/practice/problem3/**/*.java
java com.practice.problem3.Main
```