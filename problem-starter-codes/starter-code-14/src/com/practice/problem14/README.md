# Problem 14: Movie Theater Ticketing System

## Problem Summary

Implement an OOP movie theater ticketing system to add/remove customers and movies, book/cancel tickets, and raise proper exceptions.

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
- `interfaces/` – Java interfaces (e.g. `Ticketable`).
- `models/` – Core data models (`Movie`, `Customer`, `Ticket`, `Theater`).
- `services/` – Business logic, user-facing API (`TicketService`).
- `exceptions/` – Custom exceptions for error conditions.

## Classes to Implement

- Implement skeletons as provided.
- All methods must throw `new UnsupportedOperationException("TODO");`
- Do not implement logic until instructions are lifted.

## How to Run

```sh
javac com/practice/problem14/**/*.java
java com.practice.problem14.Main
```