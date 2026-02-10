package com.practice.problem2.evaluator;

import com.practice.problem2.models.BankAccount;
import com.practice.problem2.exceptions.InsufficientFundsException;
import com.practice.problem2.exceptions.InvalidAmountException;

public class Evaluator {
    public static void run() {
        // Test basic functionality
        BankAccount account = new BankAccount("12345", "John Doe", 100.0);
        
        // Test constructor and getters
        if (!account.getAccountNumber().equals("12345")) {
            throw new RuntimeException("Account number getter failed");
        }
        if (!account.getAccountHolderName().equals("John Doe")) {
            throw new RuntimeException("Account holder name getter failed");
        }
        if (account.getBalance() != 100.0) {
            throw new RuntimeException("Initial balance getter failed");
        }
        
        // Test deposit
        account.deposit(50.0);
        if (account.getBalance() != 150.0) {
            throw new RuntimeException("Deposit operation failed");
        }
        
        // Test withdrawal
        account.withdraw(30.0);
        if (account.getBalance() != 120.0) {
            throw new RuntimeException("Withdrawal operation failed");
        }
        
        // Test invalid amount for deposit
        boolean invalidDepositThrown = false;
        try {
            account.deposit(-10.0);
        } catch (InvalidAmountException e) {
            invalidDepositThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for invalid deposit: " + e.getMessage());
        }
        if (!invalidDepositThrown) {
            throw new RuntimeException("Should throw InvalidAmountException for negative deposit");
        }
        
        // Test invalid amount for withdrawal
        boolean invalidWithdrawalThrown = false;
        try {
            account.withdraw(-5.0);
        } catch (InvalidAmountException e) {
            invalidWithdrawalThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for invalid withdrawal: " + e.getMessage());
        }
        if (!invalidWithdrawalThrown) {
            throw new RuntimeException("Should throw InvalidAmountException for negative withdrawal");
        }
        
        // Test insufficient funds
        boolean insufficientFundsThrown = false;
        try {
            account.withdraw(200.0);  // More than balance
        } catch (InsufficientFundsException e) {
            insufficientFundsThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for insufficient funds: " + e.getMessage());
        }
        if (!insufficientFundsThrown) {
            throw new RuntimeException("Should throw InsufficientFundsException for withdrawal exceeding balance");
        }
        
        // Verify balance unchanged after failed withdrawal
        if (account.getBalance() != 120.0) {
            throw new RuntimeException("Balance should remain unchanged after failed withdrawal");
        }
        
        // Test zero amount operations
        boolean zeroDepositThrown = false;
        try {
            account.deposit(0.0);
        } catch (InvalidAmountException e) {
            zeroDepositThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for zero deposit: " + e.getMessage());
        }
        if (!zeroDepositThrown) {
            throw new RuntimeException("Should throw InvalidAmountException for zero deposit");
        }
        
        boolean zeroWithdrawalThrown = false;
        try {
            account.withdraw(0.0);
        } catch (InvalidAmountException e) {
            zeroWithdrawalThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for zero withdrawal: " + e.getMessage());
        }
        if (!zeroWithdrawalThrown) {
            throw new RuntimeException("Should throw InvalidAmountException for zero withdrawal");
        }
        
        // Test exact balance withdrawal
        BankAccount exactBalanceAccount = new BankAccount("67890", "Jane Smith", 100.0);
        try {
            exactBalanceAccount.withdraw(100.0);
            if (exactBalanceAccount.getBalance() != 0.0) {
                throw new RuntimeException("Exact balance withdrawal should result in zero balance");
            }
        } catch (Exception e) {
            throw new RuntimeException("Unexpected exception during exact balance withdrawal: " + e.getMessage());
        }
        
        // Test multiple deposits and withdrawals
        BankAccount multiOpAccount = new BankAccount("55555", "Bob Johnson", 50.0);
        multiOpAccount.deposit(25.0);
        multiOpAccount.withdraw(10.0);
        multiOpAccount.deposit(5.0);
        if (multiOpAccount.getBalance() != 70.0) {
            throw new RuntimeException("Multiple operations failed to calculate correctly");
        }
        
        // Test very large amounts (within reasonable bounds)
        BankAccount largeAmountAccount = new BankAccount("99999", "Large Account", 1000000.0);
        largeAmountAccount.deposit(500000.0);
        if (largeAmountAccount.getBalance() != 1500000.0) {
            throw new RuntimeException("Large amount operations failed");
        }
        
        // Test account equality based on account number
        BankAccount account1 = new BankAccount("ABC123", "Person A", 100.0);
        BankAccount account2 = new BankAccount("ABC123", "Person B", 200.0);  // Same number, different person/balance
        BankAccount account3 = new BankAccount("XYZ789", "Person C", 100.0);  // Different number
        
        if (!account1.equals(account2)) {
            throw new RuntimeException("Accounts with same number should be equal");
        }
        if (account1.equals(account3)) {
            throw new RuntimeException("Accounts with different numbers should not be equal");
        }
        if (account1.hashCode() != account2.hashCode()) {
            throw new RuntimeException("Equal accounts should have same hash code");
        }
        
        System.out.println("PASS");
    }
}