public class BankAccountTest {
    public static void main(String[] args) {
        // Test case 1: Creating a new account
        BankAccount account = new BankAccount("ACC001", "John Doe", 1000.0);
        assert account.getAccountNumber().equals("ACC001") : "Account number should be ACC001";
        assert account.getAccountHolderName().equals("John Doe") : "Account holder name should be John Doe";
        assert account.getBalance() == 1000.0 : "Initial balance should be 1000.0";
        System.out.println("Test 1 passed: Account creation");

        // Test case 2: Deposit money
        account.deposit(500.0);
        assert account.getBalance() == 1500.0 : "Balance should be 1500.0 after deposit";
        System.out.println("Test 2 passed: Deposit functionality");

        // Test case 3: Withdraw money
        boolean success = account.withdraw(300.0);
        assert success : "Withdrawal should be successful";
        assert account.getBalance() == 1200.0 : "Balance should be 1200.0 after withdrawal";
        System.out.println("Test 3 passed: Withdraw functionality");

        // Test case 4: Attempt to withdraw more than balance
        boolean failure = account.withdraw(2000.0);
        assert !failure : "Withdrawal should fail when amount exceeds balance";
        assert account.getBalance() == 1200.0 : "Balance should remain unchanged after failed withdrawal";
        System.out.println("Test 4 passed: Insufficient funds handling");

        // Test case 5: Edge case - attempt to withdraw exact balance
        BankAccount account2 = new BankAccount("ACC002", "Jane Doe", 500.0);
        boolean exactWithdrawal = account2.withdraw(500.0);
        assert exactWithdrawal : "Should be able to withdraw exact balance";
        assert account2.getBalance() == 0.0 : "Balance should be zero after exact withdrawal";
        System.out.println("Test 5 passed: Exact balance withdrawal");

        System.out.println("All tests passed!");
    }
}