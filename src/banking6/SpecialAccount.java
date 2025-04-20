package banking6;


public class SpecialAccount extends NormalAccount {
	
	private int numDeposit;

	
	public SpecialAccount(String name, String accountNumber, int balance, int interestRate) {
		super(name, accountNumber, balance, interestRate);
		this.numDeposit = 0; // 입금으로 간주하지 않는부분. 입금을 간주한다치면(입금(처음들어간잔고)이 1회 들어가있으니까) 1값이 들어가야한다.
	}
	
	public void deposit(int money) {
		numDeposit++; //입금횟수 
		
		if(numDeposit %2 !=0) {//나눠서 홀수 !=0
			int interest = (int)(getBalance() * getInterestRate() / 100);//(잔고 * 이자율)int형변환 -> 소수점버림
			setBalance(getBalance() + interest + money);//잔고 + 이자율 + 입금액
		}
		else if(numDeposit %2 ==0) {//나눠서 짝수 ==0
			int interest = ((int)(getBalance() * getInterestRate() / 100) + 500);
			setBalance(getBalance() + interest + money); 
		}
		
	}
	
	@Override
	public void showAccInfo() {
		System.out.println("-----------");
		System.out.println("계좌번호:"+ getAccountNumber());
		System.out.println("이름:"+ getName());
		System.out.println("잔고:"+ getBalance());
		System.out.println("기본이자:"+ (int)getInterestRate()+ "%");
		System.out.println("입금횟수:"+ numDeposit);
		System.out.println("----------");
	}
}
