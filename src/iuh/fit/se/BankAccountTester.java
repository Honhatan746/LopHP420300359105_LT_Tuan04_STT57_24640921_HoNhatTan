package iuh.fit.se;

import java.util.Scanner;

public class BankAccountTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank list = new Bank("IUH Bank", 10);
		int choice = 0;
		do {
			System.out.println("Welome to IUH Bank");
			System.out.println("1.Open new account");
			System.out.println("2.Deposit");
			System.out.println("3.WithDraw");
			System.out.println("4.Transfer");
			System.out.println("5.The total balacne of all the bank accounts in the bank");
			System.out.println("6.Print all bank account");
			System.out.println("7.Exit");
			System.out.println("Enter your choice: ");
			int choices = sc.nextInt();
			choice = choices;
			switch(choice) {
			case 1: {
				sc.nextLine();
				System.out.println("Enter your account number: ");
				String accountNumber = sc.nextLine();
				if(list.find(accountNumber) != null) {
					System.out.println("Account bank is alredy exit");
					break;
				}
				System.out.println("Enter your account name: ");
				String accountName = sc.nextLine();
				System.out.println("Enter your balances into the bank account: ");
				double balance = sc.nextDouble();
				list.addNew(accountNumber, accountName, balance);
				System.out.println("The account is added in the Bank completely!");
				break;
			}
			case 2:{
				sc.nextLine();
				System.out.println("Enter your account number: ");
				String accountNumber = sc.nextLine();
				if(list.find(accountNumber) != null) {
					System.out.println("Enter the amount: ");
					double amount = sc.nextDouble();
					list.find(accountNumber).deposit(amount);
				}else {
					System.out.println("Account number is not exists");
				}
				break;
			}
			case 3:{
				sc.nextLine();
				System.out.println("Enter your account number: ");
				String accountNumber = sc.nextLine();
				if(list.find(accountNumber) != null) {
					System.out.println("Enter the amount: ");
					double amount = sc.nextDouble();
					list.find(accountNumber).withdraw(amount);
				}else {
					System.out.println("Account number is not exists");
				}
				break;
			}
			case 4:{
				sc.nextLine();
				System.out.println("Enter your account number: ");
				String accountNumber = sc.nextLine();
				System.out.println("Enter account number of the recipient: ");
				String accountNumberRecipient = sc.nextLine();
				if(list.find(accountNumber) != null && list.find(accountNumberRecipient) != null) {
					System.out.println("Enter the amount: ");
					double amount = sc.nextDouble();
					list.find(accountNumber).transfer(list.find(accountNumberRecipient), amount);
				}else {
					System.out.println("Account number is not exits");
				}
				break;
			}
			case 5:{
				System.out.println("The total of all the bank accounts in the Bank is:  ");
				System.out.println(list.getTotalBalance());
				break;
			}
			case 6:{
				String headLine = String.format("%s | %s | %s ", "Account Number", "Account Name", "Balance");
				System.out.println(headLine);
				System.out.println("-".repeat(80));
				for (BankAccount bankAccount : list.getAccounts()) {
					System.out.println(bankAccount);
				}
				break;
			}
			case 7:{
				System.out.println("Exit");
				break;
			}
			default :{
				System.out.println("The choice is not valid, Enter again please!");
				break;
			}
			}
		} while (choice != 7);
		
		sc.close();
	}
}
