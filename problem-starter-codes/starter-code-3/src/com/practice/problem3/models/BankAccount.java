package com.practice.problem3.models;

import com.practice.problem3.interfaces.Accountable;

/**
 * Represents a bank account.
 */
public class BankAccount implements Accountable {
    /**
     * Construct a bank account with accountId, customerId, type, and balance.
     * @param accountId unique account identifier
     * @param customerId customer identifier
     * @param type type of account
     * @param balance initial balance
     */
    public BankAccount(int accountId, int customerId, String type, double balance) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get account id.
     */
    @Override
    public int getAccountId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get customer id.
     * @return customer id
     */
    public int getCustomerId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get type.
     * @return account type
     */
    public String getType() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get current balance.
     */
    @Override
    public double getBalance() {
        throw new UnsupportedOperationException("TODO");
    }
}