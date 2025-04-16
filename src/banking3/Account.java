package banking3;

abstract public class Account {
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
	
	
	
	
}