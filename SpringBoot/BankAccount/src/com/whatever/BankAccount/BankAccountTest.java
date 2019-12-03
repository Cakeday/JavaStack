package com.whatever.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount();
		
		account1.deposit(100, "checking");
		account1.deposit(100, "checking");
		account1.deposit(100, "checking");
		account1.deposit(100, "checking");
		account1.getTotalBalance();
		account1.withdraw(100, "checking");
		account1.withdraw(200, "checking");
		account1.withdraw(300, "checking");
		
	}

}
