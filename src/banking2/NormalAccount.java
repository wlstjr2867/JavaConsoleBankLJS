package banking2;

public class NormalAccount extends Account  {
	private int interestRate;
	
	
	public NormalAccount(String name, String accountNumber, int balance, int interestRate) {
		super(name, accountNumber, balance);
		this.interestRate = interestRate;
	}
	
	@Override
	void deposit(int money) {
		int interest = (int)(getBalance() * interestRate);//(잔고 * 이자율)int형변환 -> 소수점버림
		setBalance(getBalance() + interest + money);//잔고 + 이자율 + 입금액 
		System.out.println("입금이 완료되었습니다.");
	}



	public void showAccInfo() {
		System.out.println("-----------");
		System.out.println("계좌번호:"+ getAccountNumber());
		System.out.println("이름:"+ getName());
		System.out.println("잔고:"+ getBalance());
		System.out.println("기본이자:"+ (int)(interestRate * 100)+ "%");
		System.out.println("----------");
	}
	


}
