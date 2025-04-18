package banking5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HighCreditAccount extends Account {
	private int interestRate; //기본 이자율
	private String creditGrade; // 신용 등급 (A, B, C)

	public HighCreditAccount(String name, String accountNumber, int balance, int interestRate, String creditGrade) {
		super(name, accountNumber, balance);
		this.interestRate = interestRate;
		this.creditGrade = creditGrade;
	}
	
	@Override
	void deposit(int money) {
		if(money<=0) {
			System.out.println("음수는 입금불가");
			return;
		}
		if(money % 500 != 0) {
			System.out.println("500원 단위로 입금가능함");
			return;
		}
		int interest = (int)(getBalance() * interestRate / 100);
		
		int bonusInterest = 0;
		switch(creditGrade.toUpperCase()) {
		case "A":
			bonusInterest = (int)(getBalance() * 0.07);
			break;
		case "B":
			bonusInterest = (int)(getBalance() * 0.04);
			break;
		case "C":
			bonusInterest = (int)(getBalance() * 0.02);
			break;
		}
		setBalance(getBalance() + interest + bonusInterest + money);
		System.out.println("입금이 완료되었습니다.");
		System.out.println("입금액: " + money + "원, 기본이자: " + interest + "원, 추가이자: " + bonusInterest + "원");
		System.out.println("현재잔액: " + getBalance() + "원");
	}

	@Override
	void withdraw(int money) {
		if(money<=0) {
			System.out.println("0원 이하 금액은 출금할 수 없습니다.");
			return;
		}
		if(money % 1000 != 0) {
			System.out.println("1000원 단위로 출금가능함.");
			return;
		}
		if(super.getBalance()<money) { 
// getBalance는 메서드이기때문에 () 붙이고 앞에 인스턴스 붙히기 (부모에 있는 메서드를 불러오는거기때문에 super)
			System.out.println("잔액 부족입니다. 금액전체를 출금할까요?(y or n");
			String choice = BankingSystemMain.scan.nextLine();
			if(choice.equals("y")) {
				setBalance(0);
				System.out.println("출금이 완료되었습니다.");
				return;
			}
			else if(choice.equals("n")) {
				System.out.println("출금 요청취소되었습니다.");
				return;
			}
		}
		setBalance(super.getBalance() - money);
		System.out.println("출금이 완료되었습니다.");
		System.out.println("출금액:" + money + "원");
		System.out.println("현재잔액: "+ getBalance() + "원");
	}

	@Override
	public void showAccInfo() {
		System.out.println("-----------");
		System.out.println("계좌번호:"+ getAccountNumber());
		System.out.println("이름:"+ getName());
		System.out.println("잔고:"+ getBalance());
		System.out.println("기본이자:"+ (int)interestRate+ "%");
		System.out.println("신용등급:"+ creditGrade);
		System.out.println("----------");
	}

}