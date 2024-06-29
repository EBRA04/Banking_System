import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
}

class BankingSystem {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        Account newAccount = new Account(accountNumber, accountHolderName, balance);
        accounts.add(newAccount);
        System.out.println("Account created successfully.");
    }

    public void deposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Current Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }


    public void displayMenu() {
        while (true) {
            System.out.println("\n************** Welcome to IMB Bank **********************");
            System.out.println("Our services");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thanks for Trusting IMB Bank");
                    System.out.println("Good Bye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.displayMenu();
    }
}
