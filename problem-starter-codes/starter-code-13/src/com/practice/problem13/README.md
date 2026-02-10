# Problem 13: Pet Adoption Center

## Problem Summary

Implement an OOP pet adoption center system to add/remove pets and adopters, adopt/cancel adoptions, and raise proper exceptions.

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
- `interfaces/` – Java interfaces (e.g. `Adoptable`).
- `models/` – Core data models (`Pet`, `Adopter`, `Adoption`, `Center`).
- `services/` – Business logic, user-facing API (`AdoptionService`).
- `exceptions/` – Custom exceptions for error conditions.

## Classes to Implement

- Implement skeletons as provided.
- All methods must throw `new UnsupportedOperationException("TODO");`
- Do not implement logic until instructions are lifted.

## How to Run

```sh
javac com/practice/problem13/**/*.java
java com.practice.problem13.Main
```