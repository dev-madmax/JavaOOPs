package com.practice.problem3.evaluator;

import com.practice.problem3.services.*;
import com.practice.problem3.models.*;
import com.practice.problem3.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Bank Account System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 24;

        try {
            BankService service = new BankService();

            // 1. Add customer
            Customer c1 = new Customer(1001, "Alice");
            service.addCustomer(c1);
            passed++;

            // 2. Open account
            BankAccount acc1 = new BankAccount(2001, 1001, "Savings", 500.0);
            service.openAccount(acc1);
            passed++;

            // 3. Duplicate account throws
            try {
                service.openAccount(new BankAccount(2001, 1001, "Savings", 100.0));
                throw new RuntimeException("Duplicate account not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 4. Deposit funds
            service.deposit(2001, 250.0);
            passed++;

            // 5. Withdraw funds (happy)
            service.withdraw(2001, 150.0);
            passed++;

            // 6. Withdraw more than balance throws
            try {
                service.withdraw(2001, 9999.0);
                throw new RuntimeException("Insufficient funds not detected");
            } catch (InsufficientFundsException ex) {
                passed++;
            }

            // 7. Withdraw negative throws
            try {
                service.withdraw(2001, -50.0);
                throw new RuntimeException("Negative withdraw not detected");
            } catch (InvalidTransactionException ex) {
                passed++;
            }

            // 8. Deposit negative throws
            try {
                service.deposit(2001, -30.0);
                throw new RuntimeException("Negative deposit not detected");
            } catch (InvalidTransactionException ex) {
                passed++;
            }

            // 9. Open account for unknown customer throws
            try {
                service.openAccount(new BankAccount(2002, 99999, "Savings", 200.0));
                throw new RuntimeException("Unknown customer not detected");
            } catch (AccountNotFoundException ex) {
                passed++;
            }

            // 10. Get account balance
            double bal = service.getBalance(2001);
            if (bal < 0) throw new RuntimeException("Balance negative");
            passed++;

            // 11. Deposit to unknown account throws
            try {
                service.deposit(9999, 10.0);
                throw new RuntimeException("Unknown account not detected");
            } catch (AccountNotFoundException ex) {
                passed++;
            }

            // 12. Withdraw from unknown account throws
            try {
                service.withdraw(8888, 1.0);
                throw new RuntimeException("Unknown account (withdraw) not detected");
            } catch (AccountNotFoundException ex) {
                passed++;
            }

            // 13. Add customer null throws
            try {
                service.addCustomer(null);
                throw new RuntimeException("Null customer not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 14. Open account null throws
            try {
                service.openAccount(null);
                throw new RuntimeException("Null account not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 15. Deposit null throws
            try {
                service.deposit(2001, 0.0);
                passed++; // zero deposit allowed
            } catch (Exception ex) {
                throw new RuntimeException("Zero deposit must not throw exception");
            }

            // 16. Withdraw zero allowed
            service.withdraw(2001, 0.0);
            passed++;

            // 17. Transaction record
            Transaction txn1 = new Transaction("tx123", 2001, "withdraw", 10.0, "completed");
            if(!txn1.getStatus().equals("completed")) throw new RuntimeException("Txn status wrong");
            passed++;

            // 18. Accountable interface check
            Accountable acc = new BankAccount(3001, 1001, "Checking", 1000.0);
            if(!acc.getClass().getInterfaces()[0].getSimpleName().equals("Accountable")) throw new RuntimeException("Interface missing");
            passed++;

            // 19. Remove account
            service.closeAccount(2001);
            try {
                service.getBalance(2001);
                throw new RuntimeException("Account not closed");
            } catch(AccountNotFoundException ex) {
                passed++;
            }

            // 20. Defensive: close unknown account throws
            try {
                service.closeAccount(3000);
                throw new RuntimeException("Close unknown account not detected");
            } catch(AccountNotFoundException ex) {
                passed++;
            }

            // 21. Defensive: open many accounts
            for(int i=4000;i<4020;i++) {
                service.addCustomer(new Customer(i, "User"+i));
                service.openAccount(new BankAccount(i, i, "Savings", 100.0));
            }
            passed++;

            // 22. Defensive: large balance allowed
            service.deposit(4000, 1_000_000.0);
            passed++;

            // 23. Transaction status update
            Transaction txn2 = new Transaction("tx999", 4000, "deposit", 500.0, "pending");
            txn2.setStatus("completed");
            if(!txn2.getStatus().equals("completed")) throw new RuntimeException("Txn status update failed");
            passed++;

            // 24. Remove customer
            service.removeCustomer(4000);
            try {
                service.openAccount(new BankAccount(4021, 4000, "Savings", 100.0));
                throw new RuntimeException("Account for removed customer allowed");
            } catch(AccountNotFoundException ex) {
                passed++;
            }

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}