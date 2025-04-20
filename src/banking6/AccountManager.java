package banking6;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager {

//	Scanner scan = new Scanner(System.in);

	HashSet<Account> accountSet;
	private AutoSaver autoSaver;

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
			
			Account acc;
			if (choice == 1) {
				System.out.println("**특판계좌 선택**");
				System.out.print("1. Yes, 2. No");
				choice = BankingSystemMain.scan.nextInt();
				BankingSystemMain.scan.nextLine();
				
				if (choice == 1) {
					acc = new SpecialAccount(name, accountNumber, balance, interestRate);//special을 만드는 코드
					System.out.println("특판계좌가 개설되었습니다.");
				}
				else {
					acc = new NormalAccount(name, accountNumber, balance, interestRate);//노말어카운트를 만드는 코드
					System.out.println("기본계좌로 돌아갑니다.");
				}
				
			}
			else if (choice == 2) {
				System.out.print("신용등급 (A,B,C등급):");
				String creditGrade = BankingSystemMain.scan.next();
				acc = new HighCreditAccount(name, accountNumber, balance, interestRate, creditGrade);//크레딧어카운트를 만드는 코드
			} 
			else {
				System.out.println("잘못된 선택입니다.");
				return;
			}
			
			boolean isAdd = accountSet.add(acc);
			if (isAdd==false) {
				System.out.println("중복계좌발견됨.\n 덮어쓸까요?(y or n)");
				String input = BankingSystemMain.scan.nextLine();
				if (input.equals("y")) {
					accountSet.remove(acc);
					accountSet.add(acc);
					System.out.println("새로운 정보로 갱신되었습니다.");
				} 
				else if (input.equals("n")) {
					System.out.println("기본 정보가 유지됩니다.");
					return;
				}
			} 
			else {
				accountSet.add(acc);
				System.out.println("계좌계설이 완료되었습니다.");
			}
		} catch (InputMismatchException e) {
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

			for (Account acc : accountSet) {
				if (acc.accountNumber.equals(accountNumber)) {
					acc.deposit(money);
//				System.out.println("입금이 완료되었습니다.");
					return;
				}
			}
		} catch (InputMismatchException e) {
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

			for (Account acc : accountSet) {
				if (acc.getAccountNumber().equals(accountNumber)) {
					if (money <= 0) {
						System.out.println("0원 이하 금액은 출금할 수 없습니다.");
						return;
					}
					if (money % 1000 != 0) {
						System.out.println("1000원 단위로 출금가능함.");
						return;
					}
					if (acc.getBalance() < money) {
						// getBalance는 메서드이기때문에 () 붙이고 앞에 인스턴스 붙히기 (부모에 있는 메서드를 불러오는거기때문에 super)
						System.out.println("잔액 부족입니다. 금액전체를 출금할까요?(y or n)");
						String choice = BankingSystemMain.scan.nextLine();
						if (choice.equals("y")) {
							acc.setBalance(0);
							System.out.println("출금이 완료되었습니다.");
							return;
						} else if (choice.equals("n")) {
							System.out.println("출금 요청취소되었습니다.");
							return;
						}
					}
					acc.setBalance(acc.getBalance() - money);
					System.out.println("출금이 완료되었습니다.");
					return;
				}
			}
			System.out.println("계좌를 찾지 못했습니다.");
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력할 수 있습니다.");
		}
	}

	public void showAccInfo() {
		for (Account acc : accountSet) {
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
		// 나 : 333 저: 333
		for (Account acc : accountSet) {
			if (accountNumber.equals(acc.accountNumber)) {
				accountSet.remove(acc);
				isDelete = true;
				break;
			}
		}
		if (isDelete) {
			System.out.println("##계좌를 삭제하였습니다##");
		} else {
			System.out.println("##일치하는 계좌가 없습니다##");
		}
	}

	public void saveOption() {
		System.out.println("***자동저장을 시작합니다***");
		System.out.println("쓰레드=Thread[Thread-0,5,main");
		System.out.println("자동옵션을 선택하세요");
		System.out.print("1.자동저장on, 2.자동저장off");
		System.out.println("선택: ");
		int choice = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();

		switch (choice) {
		case 1:
			if (autoSaver != null && autoSaver.isAlive()) { // 오토서버가 정보가 있고 오토서버가 실행되고있을때
				System.out.println("이미 자동저장이 실행중입니다.");
			} else { // 정보가없고 실행되고있지 않을때
				autoSaver = new AutoSaver(accountSet);
				autoSaver.setDaemon(true);
				autoSaver.start(); // 쓰레드자체를실행
				System.out.println("자동저장이 시작되었습니다.");
			}
			break;
		case 2:
			if (autoSaver != null && autoSaver.isAlive()) {
				autoSaver.interrupt(); // interrupt는 실행을 정지시키는 메서드 (약속)
				System.out.println("자동저장이 종료되었습니다.");
				break;
			} else {
				System.out.println("자동저장이 실행 중이 아닙니다.");
			}
			break;
		}
	}
}