package banking;

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
		System.out.print("고객이름:"+ name);
		System.out.print("계좌번호:"+ accountNumber);
		System.out.print("잔고:"+ balance);
	}
	
	void deposit(int money) {
		balance += money;
		System.out.println("입금이 완료되었습니다.");
	}
	
	void withdraw(int money) {
		balance -=money;
		System.out.println("출금이 완료되었습니다");
	}
}

