package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager {
	
	Scanner scan = new Scanner(System.in);
	
	private Account[] myaccount;
	private int accCnt;
	
	public AccountManager(int num) {
		myaccount = new Account[num];
		accCnt = 0;
	}
			
	public void makeAccount() {
		System.out.println("***신규계좌개설***");
		System.out.println("---계좌선택---");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		System.out.print("선택:");
	try {
		int choice = scan.nextInt();
		scan.nextLine();
		
		System.out.print("계좌번호:");
		String accountNumber = scan.nextLine();
		
		System.out.print("고객이름:");
		String name = scan.nextLine();
		
		System.out.print("잔고:");
		int balance = scan.nextInt();
		
		System.out.print("기본이자&(정수형태로입력):");
		int interestRate = scan.nextInt();
		
		
		if(choice==1) {
			myaccount[accCnt++] = new NormalAccount(name, accountNumber, balance, interestRate);
			System.out.println("계좌계설이 완료되었습니다.");
		}
		else if(choice==2) {
			System.out.print("신용등급 (A,B,C등급):");
			String creditGrade = scan.next();
			
			myaccount[accCnt++] = new HighCreditAccount(name, accountNumber, balance, interestRate, creditGrade);
			System.out.println("계좌계설이 완료되었습니다.");
			
		}
		else {
			System.out.println("잘못된 선택입니다.");
			return;
		}
	}
	catch(InputMismatchException e) {
		System.out.println("숫자만 입력할 수 있습니다.");
	}
}	
	public void depositMoney() {
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
	try {
		System.out.print("계좌번호:");
		String accountNumber = scan.nextLine();
		scan.nextLine();
		System.out.print("입금액:");
		int money = scan.nextInt();
		
		for(int i=0; i<accCnt; i++) {
			if(myaccount[i].accountNumber.equals(accountNumber)) {
				myaccount[i].deposit(money);
				System.out.println("입금이 완료되었습니다.");
				return;
			}
		}
	}
	catch(InputMismatchException e) {
		System.out.println("숫자만 입력할 수 있습니다.");
	}
}
	
	public void withdrawMoney() {
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
	try {
		System.out.print("계좌번호:");
		String accountNumber = scan.nextLine();
		System.out.print("출금액:");
		int money = scan.nextInt();
		
		for(int i=0; i<accCnt; i++) {
			if(myaccount[i].getAccountNumber().equals(accountNumber)) {
				if(myaccount[i].getBalance() >=money) {
					myaccount[i].setBalance(myaccount[i].getBalance() - money);
					System.out.println("출금이 완료되었습니다.");
				}
				else {
					System.out.println("잔액이 부족합니다.");
				}
				return;
			}
		}
	}
	catch(InputMismatchException e) {
		System.out.println("숫자만 입력할 수 있습니다.");
	}
}
	
	public void showAccInfo() {
		for(int i=0; i<accCnt; i++) {
			myaccount[i].showAccInfo();
			System.out.println();
		}
		System.out.println("##전체정보가 출력되었습니다.##");
	}
}
