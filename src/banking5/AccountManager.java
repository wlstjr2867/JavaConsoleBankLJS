package banking5;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AccountManager {
	
//	Scanner scan = new Scanner(System.in);
	
	HashSet<Account> accountSet;
	
	public AccountManager() {
		accountSet = new HashSet<Account>();
	}
			
	public void makeAccount() {
		System.out.println("***신규계좌개설***");
		System.out.println("---계좌선택---");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		System.out.print("선택:");
	try {
		int choice = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		System.out.print("계좌번호:");
		String accountNumber = BankingSystemMain.scan.nextLine();
		
		System.out.print("고객이름:");
		String name = BankingSystemMain.scan.nextLine();
		
		System.out.print("잔고:");
		int balance = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		System.out.print("기본이자&(정수형태로입력):");
		int interestRate = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		if(choice==1) {
			Account acc = new NormalAccount(name, accountNumber, balance, interestRate);
			
			if(accountSet.contains(acc)) {
				System.out.println("중복계좌발견됨.\n 덮어쓸까요?(y or n)");
				String input = BankingSystemMain.scan.nextLine();
				if(input.equals("y")) {
					accountSet.remove(acc); 
					accountSet.add(acc);
					System.out.println("새로운 정보로 갱신되었습니다.");
				}
				else if(input.equals("n")) {
					System.out.println("기본 정보를 유지합니다.");
					return;
				}
			}
			else {
				accountSet.add(acc);
				System.out.println("계좌계설이 완료되었습니다.");
			}
		}
		else if(choice==2) {
			System.out.print("신용등급 (A,B,C등급):");
			String creditGrade = BankingSystemMain.scan.next();
			
			Account acc = new HighCreditAccount(name, accountNumber, balance, interestRate, creditGrade);
			if(accountSet.contains(acc)) {
			
				System.out.println("중복계좌발견됨.\n 덮어쓸까요?(y or n)");
				String input = BankingSystemMain.scan.nextLine();
				if(input.equals("y")) {
					accountSet.remove(acc); 
					accountSet.add(acc);
					System.out.println("새로운 정보로 갱신되었습니다.");
				}
				else if(input.equals("n")) {
					System.out.println("기본 정보가 유지됩니다.");
					return;
				}
			}
			else {
				accountSet.add(acc);
				System.out.println("계좌계설이 완료되었습니다.");
			}
		}
		else {
			System.out.println("잘못된 선택입니다.");
			return;
		}
	}
	catch(InputMismatchException e) {
		System.out.println("숫자만 입력할 수 있습니다.");
		BankingSystemMain.scan.nextLine();
	}
}	
	public void depositMoney() {
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
	try {
		System.out.print("계좌번호:");
		String accountNumber = BankingSystemMain.scan.nextLine();
		System.out.print("입금액:");
		int money = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		for(Account acc : accountSet) {
			if(acc.accountNumber.equals(accountNumber)) {
				acc.deposit(money);
//				System.out.println("입금이 완료되었습니다.");
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
		String accountNumber = BankingSystemMain.scan.nextLine();
		System.out.print("출금액:");
		int money = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		for(Account acc : accountSet) {
			if(acc.getAccountNumber().equals(accountNumber)) {
				acc.withdraw(money);
				return;
			}
		}
	}
	catch(InputMismatchException e) {
		System.out.println("숫자만 입력할 수 있습니다.");
	}
}
	
	public void showAccInfo() {
		for(Account acc : accountSet) {
			acc.showAccInfo();
			System.out.println();
		}
		System.out.println("##전체정보가 출력되었습니다.##");
	}
	
	public void deleteAccount() {
		System.out.println("***계좌정보삭제***");
		System.out.println("삭제할 계좌번호를 입력하세요");
		System.out.print("계좌번호:");
		String accountNumber = BankingSystemMain.scan.nextLine();
		boolean isDelete = false;
		//나 : 333 저: 333
		for(Account acc : accountSet) {
			if(accountNumber.equals(acc.accountNumber)) {
				accountSet.remove(acc);
				isDelete = true;
				break;
			}
		}
		if(isDelete) { 
			System.out.println("##계좌를 삭제하였습니다##");
		}
		else {
			System.out.println("##일치하는 계좌가 없습니다##");
		}
	}
}