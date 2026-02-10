# Problem 1: Bank Account Management System

## Problem Description
Design a basic bank account management system that supports creating accounts, depositing money, withdrawing money, and checking balance. Implement proper encapsulation by making account data private and providing public methods to interact with the account.

## Requirements
- Create a `BankAccount` class with private fields for account number, account holder name, and balance
- Implement constructor(s) to initialize the account
- Provide getter methods for account information
- Implement deposit() method that adds money to the account
- Implement withdraw() method that removes money from the account (with validation)
- Implement getBalance() method to check current balance
- Add validation to prevent negative balances during withdrawal

## Starter Code Location
- Main implementation: `src/main/java/BankAccount.java`
- Test cases: `src/test/java/BankAccountTest.java`