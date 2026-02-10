# Problem 2: Bank Account Management

## Problem Summary
Implement a simple bank account system that supports deposits, withdrawals, and maintains a balance. The system should handle various validation rules and exceptions.

## Learning Goals
- Practice financial calculations with floating-point numbers
- Implement validation logic for business rules
- Handle different types of custom exceptions
- Apply defensive programming principles
- Work with equality and hash code based on business identity

## Folder Structure
```
src/
├── com/practice/problem2/
│   ├── Main.java                 # Entry point (calls evaluator)
│   ├── evaluator/
│   │   └── Evaluator.java       # Automated tests (DO NOT MODIFY)
│   ├── interfaces/              # Interface definitions
│   ├── models/                  # Business models (BankAccount)
│   ├── services/                # Service classes
│   └── exceptions/              # Custom exception classes
```

## Classes to Implement
- `BankAccount.java` - Model representing a bank account with deposit/withdrawal operations
- `InsufficientFundsException.java` - Exception for withdrawal attempts exceeding balance
- `InvalidAmountException.java` - Exception for invalid transaction amounts (negative/zero)

## How To Run
Compile and run the evaluator to test your implementation:
```bash
javac com/practice/problem2/**/*.java
java com.practice.problem2.Main
```

The evaluator will run comprehensive tests and print "PASS" if all requirements are met.