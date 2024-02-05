import java.util.Scanner;

// BankAccount class represents the user's bank account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient funds
        }
    }
}

// ATM class represents the ATM machine
public class ATM {
    private BankAccount userAccount;

    // Constructor
    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    // Method to check account balance
    public void checkBalance() {
        System.out.println("Current Balance: $" + userAccount.getBalance());
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Current Balance: $" + userAccount.getBalance());
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        boolean withdrawalStatus = userAccount.withdraw(amount);
        if (withdrawalStatus) {
            System.out.println("Withdrawal successful. Current Balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            // Display menu
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            
            // Validate user input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            option = scanner.nextInt();

            // Process user's choice
            switch (option) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

        } while (option != 4);

        scanner.close();
    }
}
