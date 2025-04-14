package banking;

public class HighCreditAccount extends Account {
//	private double interestRate;

	public HighCreditAccount(String name, String accountNumber, int balance, double interestRate) {
		super(name, accountNumber, balance);
//		this.interestRate = interestRate;
	}
	
	public void showAccInfo() {
		super.showAccount();
	}
	
	

//	public void makeAccount() {
//		System.out.println("==신용신뢰계좌==");
//		super.showAccount();
//		System.out.println("이율: "+ interestRate + "%");
//
//	}

}
