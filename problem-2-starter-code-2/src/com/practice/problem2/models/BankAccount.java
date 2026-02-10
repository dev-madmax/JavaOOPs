package com.practice.problem2.models;

import com.practice.problem2.exceptions.InsufficientFundsException;
import com.practice.problem2.exceptions.InvalidAmountException;

/**
 * Represents a bank account with basic operations like deposit and withdrawal.
 */
public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    /**
     * Creates a new bank account with the specified details.
     *
     * @param accountNumber The unique account number
     * @param accountHolderName The name of the account holder
     * @param initialBalance The initial balance of the account
     */
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the account number.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the account holder's name.
     *
     * @return the account holder's name
     */
    public String getAccountHolderName() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the current balance of the account.
     *
     * @return the current balance
     */
    public double getBalance() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount The amount to deposit
     * @throws InvalidAmountException if the amount is negative or zero
     */
    public void deposit(double amount) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount The amount to withdraw
     * @throws InvalidAmountException if the amount is negative or zero
     * @throws InsufficientFundsException if the account has insufficient funds
     */
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Checks if this bank account is equal to another object.
     * Two bank accounts are considered equal if they have the same account number.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the hash code of the bank account.
     * The hash code is based on the account number.
     *
     * @return the hash code of the bank account
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("TODO");
    }
}