package banking2;

public class HighCreditAccount extends Account {
	private int interestRate; //기본 이자율
	private String creditGrade; // 신용 등급 (A, B, C)

	public HighCreditAccount(String name, String accountNumber, int balance, int interestrate) {
		super(name, accountNumber, balance);
		this.interestRate = interestRate;
		this.creditGrade = creditGrade;
	}
	
	
	
	@Override
	void deposit(int money) {
		int interest = (int)(getBalance() * interestRate);
		
		int bonusInterest = 0;
		if(creditGrade.equals("A,a")) {
			bonusInterest = (int)(getBalance() * 0.07);
		}
		else if(creditGrade.equals("B,b")) {
			bonusInterest = (int)(getBalance() * 0.04);
		}
		else if(creditGrade.equals("C,c")) {
			bonusInterest = (int)(getBalance() * 0.02);
		}
		
		setBalance(getBalance() + interest + bonusInterest + money);
		System.out.println("입금이 완료되었습니다.");
	}



	public void showAccInfo() {
		super.showAccount();
		System.out.println("신용등급: "+ creditGrade);
	}
}
