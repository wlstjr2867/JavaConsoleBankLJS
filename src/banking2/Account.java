package banking2;

public class Account {
	String name;
	String accountNumber;
	private int balance;
	
	
	public Account(String name, String accountNumber, int balance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void showAccount() {
		System.out.println("고객이름:"+ name);
		System.out.println("계좌번호:"+ accountNumber);
		System.out.println("잔고:"+ balance);
		System.out.println("-------------------------");
	}
	
	public void showAccountInfo() {
		System.out.println("이름: "+ name);
		System.out.println("계좌번호: "+ accountNumber);
		System.out.println("잔고: "+ balance + "원");
	}
	
	void deposit(int money) {
		balance += money;
		System.out.println("입금이 완료되었습니다.");
	}
	
	void withdraw(int money) {
		if(balance >= money) {
			balance -= money;
			System.out.println("출금되었습니다.");
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
		
	}
	
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