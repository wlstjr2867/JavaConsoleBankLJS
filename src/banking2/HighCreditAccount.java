package banking2;

public class HighCreditAccount extends Account {
	private int interestRate; //기본 이자율
	private String creditGrade; // 신용 등급 (A, B, C)

	public HighCreditAccount(String name, String accountNumber, int balance, int interestRate, String creditGrade) {
		super(name, accountNumber, balance);
		this.interestRate = interestRate;
		this.creditGrade = creditGrade;
	}
	
	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("기본이자율: "+ interestRate + "%");
		System.out.println("신용등급: "+  creditGrade.toUpperCase());
	}

	@Override
	void deposit(int money) {
		int interest
		= (int)(getBalance() * interestRate / 100);
		
		int bonusInterest = 0;
		if(creditGrade.toUpperCase().equals("A")) {
			bonusInterest = (int)(getBalance() * 0.07);
		}
		else if(creditGrade.toUpperCase().equals("B")) {
			bonusInterest = (int)(getBalance() * 0.04);
		}
		else if(creditGrade.toUpperCase().equals("C")) {
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