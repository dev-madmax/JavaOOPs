## Problem 3: Bank Account System

**Description**  
Model bank accounts with different rules: `SavingsAccount` (min $100 balance) vs `CheckingAccount` ($2 withdrawal fee). *Teaches: Inheritance with behavioral differences, Polymorphism, Encapsulation of balance, Interface abstraction.*

**OOP Concepts Explicitly Required**  
- ✅ **Inheritance**: `BankAccount` (abstract) → `SavingsAccount`, `CheckingAccount`  
- ✅ **Polymorphism**: Different `withdraw()` behavior per subclass  
- ✅ **Abstraction**: `Account` interface defines core operations  
- ✅ **Encapsulation**: Balance never directly accessible; modified only via methods

**Interfaces**  
```java
public interface Account {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
    double getBalance();
}
```

**Classes**  
- `BankAccount` (abstract) implements `Account`  
  - Fields: `protected String accountNumber`, `protected double balance`  
  - Constructor: `BankAccount(String accountNumber, double initialBalance)`  
- `SavingsAccount extends BankAccount`  
  - Enforces min $100 balance in `withdraw()`  
- `CheckingAccount extends BankAccount`  
  - Deducts $2 fee after successful withdrawal  
- `Bank`  
  - Fields: `private Map<String, Account> accounts`

**Constructors**  
- `SavingsAccount(String accountNumber, double initialBalance)` – validates `initialBalance >= 100.0`  
- `CheckingAccount(String accountNumber, double initialBalance)` – no minimum  
- `Bank()` – initializes empty account map

**Methods to Implement**  
1. `Bank.createAccount(Account account)` – stores account by accountNumber  
2. `Bank.transfer(String fromAccount, String toAccount, double amount)` – validates both accounts exist + sufficient funds  
3. `SavingsAccount.withdraw(double amount)` – throws if `balance - amount < 100`  
4. `CheckingAccount.withdraw(double amount)` – deducts amount + $2 fee if successful  
5. `Bank.getAccountBalance(String accountNumber)` – returns balance or -1 if not found

**Exceptions**  
- `InsufficientFundsException extends Exception`

**Grading Focus**  
✓ Abstract parent class with protected fields  
✓ Method overriding with different business logic per subclass  
✓ Transfer validation without exposing internal map  
✓ Fee deduction AFTER withdrawal validation (not before)

---
