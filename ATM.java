package ATMInterface;
	import java.util.Scanner;

	public class ATM {
	    private BankAccount bankAccount;
	    private Scanner scanner;

	    public ATM(BankAccount bankAccount) {
	        this.bankAccount = bankAccount;
	        this.scanner = new Scanner(System.in);
	    }

	    public void start() {
	        int choice;
	        do {
	            System.out.println("\nATM Menu:");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    checkBalance();
	                    break;
	                case 2:
	                    deposit();
	                    break;
	                case 3:
	                    withdraw();
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the ATM. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        } while (choice != 4);
	    }

	    private void checkBalance() {
	        System.out.printf("Your current balance is: $%.2f%n", bankAccount.getBalance());
	    }

	    private void deposit() {
	        System.out.print("Enter amount to deposit: ");
	        double amount = scanner.nextDouble();
	        if (amount > 0) {
	            bankAccount.deposit(amount);
	            System.out.printf("Deposited $%.2f. New balance: $%.2f%n", amount, bankAccount.getBalance());
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    private void withdraw() {
	        System.out.print("Enter amount to withdraw: ");
	        double amount = scanner.nextDouble();
	        if (amount > 0) {
	            if (bankAccount.withdraw(amount)) {
	                System.out.printf("Withdrew $%.2f. New balance: $%.2f%n", amount, bankAccount.getBalance());
	            } else {
	                System.out.println("Insufficient funds or invalid amount.");
	            }
	        } else {
	            System.out.println("Invalid withdrawal amount.");
	        }
	    }
	}


