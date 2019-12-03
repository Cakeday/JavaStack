package com.whatever.BankAccount;

public class BankAccount {
	
	
//	Attributes
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int numberOfAccounts = 0;
	private static double totalAmount = 0;
	
	
	
//	Constructor
	public BankAccount() {
		String number = randomNumber();
		setAccountNumber(number);
		numberOfAccounts++;
	}
	
	
	
	
//	Getters and Setters
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public static void setNumberOfAccounts(int numberOfAccounts) {
		BankAccount.numberOfAccounts = numberOfAccounts;
	}

	public static double getTotalAmount() {
		return totalAmount;
	}

	public static void setTotalAmount(double totalAmount) {
		BankAccount.totalAmount = totalAmount;
	}

	
	
	
//	Methods
	public String randomNumber() {
		String numericString ="0123456789"; 
		StringBuilder str = new StringBuilder(10);
		for(int i = 0; i<10; i++){
            int index = (int)(numericString.length()*Math.random());
            str.append(numericString.charAt(index));
        }
        return str.toString();
	}
	
	public void deposit(double amount, String whichAccount) {
		if (whichAccount == "checking") {
			double currentBalance = getCheckingBalance();
			setCheckingBalance(currentBalance + amount);
			setTotalAmount(getTotalAmount() + amount);
			System.out.println("Balance for account " + getAccountNumber() + " is now " + getCheckingBalance());
		}
		else if (whichAccount == "savings") {
			double currentBalance = getSavingsBalance();
			setSavingsBalance(currentBalance + amount);
			setTotalAmount(getTotalAmount() + amount);
			System.out.println("Balance for account " + getAccountNumber() + " is now " + getSavingsBalance());
		}
		
	}
	
	public void withdraw(double amount, String whichAccount) {
		if (whichAccount == "checking") {
			double currentBalance = getCheckingBalance();
			if(currentBalance >= amount) {
				setCheckingBalance(currentBalance - amount);
				setTotalAmount(getTotalAmount() - amount);
				System.out.println("Balance for account " + getAccountNumber() + " is now " + getCheckingBalance());
			}
			else {
				System.out.println("Insufficient funds");
			}
		}
		else if (whichAccount == "savings") {
			double currentBalance = getCheckingBalance();
			if(currentBalance >= amount) {
				setSavingsBalance(currentBalance - amount);
				setTotalAmount(getTotalAmount() - amount);
				System.out.println("Balance for account " + getAccountNumber() + " is now " + getSavingsBalance());
			}
			else {
				System.out.println("Insufficient funds");
			}
		}
		
	}
	
	
	public void getTotalBalance() {
		double checking = getCheckingBalance();
		double savings = getSavingsBalance();
		double total = checking + savings;
		System.out.println("The total balance is " + total);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
