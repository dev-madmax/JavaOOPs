package com.practice.problem3.interfaces;

/**
 * Represents an object which has an account in the system.
 */
public interface Accountable {
    /**
     * Get the account number/id.
     * @return account id
     */
    int getAccountId();

    /**
     * Get current balance.
     * @return balance
     */
    double getBalance();
}