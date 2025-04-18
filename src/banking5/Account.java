package banking5;

import java.io.Serializable;
import java.util.Objects;

abstract public class Account implements Serializable  {
	String name;
	String accountNumber;
	private int balance;
	
	
	public Account(String name, String accountNumber, int balance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	

	abstract public void showAccInfo();

	abstract void deposit(int money);
	
	abstract void withdraw(int money);
	
	
	//get /set 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(accountNumber);
	}


	@Override
	public boolean equals(Object obj) {
		
		Account acc = (Account) obj;
		return this.accountNumber.equals(acc.accountNumber);
	}


	
	
	
	
	
	
}