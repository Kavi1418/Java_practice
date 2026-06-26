import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Kavidharshini", "KAVI1418");
        account.showMenu();
    }
}

class BankAccount {
    int balance;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            System.out.println("Amount Deposited Successfully: Rs." + amount);
        }
    }

    void withdraw(int amount) {
        if (amount != 0 && balance >= amount) {
            balance = balance - amount;
            System.out.println("Amount Withdrawn Successfully: Rs." + amount);
        } else if (balance < amount) {
            System.out.println("Error: Insufficient Balance!");
        }
    }

    void showMenu() {
        int option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is: " + customerId);
        System.out.println("\n");

        do {
            System.out.println("=====================================");
            System.out.println("Enter an option below:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");
            System.out.println("=====================================");
            System.out.print("Option: ");
            option = scanner.nextInt();
            System.out.println("\n");

            switch (option) {
                case 1:
                    System.out.println("---------------------------------");
                    System.out.println("Balance: Rs." + balance);
                    System.out.println("---------------------------------");
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.println("---------------------------------");
                    System.out.print("Enter an amount to deposit: Rs.");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("---------------------------------");
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("---------------------------------");
                    System.out.print("Enter an amount to withdraw: Rs.");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("---------------------------------");
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid Option! Please enter again.");
                    break;
            }
        } while (option != 4);

        System.out.println("Thank you for using our Banking Services!");
        scanner.close();
    }
}
