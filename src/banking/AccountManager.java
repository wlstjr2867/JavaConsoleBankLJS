package banking;

import java.util.Scanner;

public class AccountManager {
	
	private Account[] myaccount;
	private int numofAccount;
	
	
	public AccountManager(int num) {
		myaccount = new Account[num];
		numofAccount = 0;
	}

	public void makeAccount() {
		System.out.println("***신규계좌개설***");
		Scanner scan = new Scanner(System.in);
		String iname, iaccountNumber; int ibalance; double jinterestRest;
		System.out.print("계좌번호:");iaccountNumber = scan.nextLine();
		System.out.print("고객이름:");iname = scan.nextLine();
		System.out.print("잔고:");ibalance = scan.nextInt();
//		System.out.print("기본이자&(정수형태로입력):");jinterestRest = scan.nextDouble();
		
		System.out.println("계좌개설이 완료되었습니다");
	}
	
	public void depositMoney() {
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호:");String iaccountNumber = scan.nextLine();
		System.out.print("입금액:");int money = scan.nextInt();
		System.out.println("입금이 완료되었습니다.");

	}
	
	public void withdrawMoney() {
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호:");String iaccountNumber = scan.nextLine();
		System.out.print("출금액:");int money = scan.nextInt();
		System.out.println("출금이 완료되었습니다.");
	}
	
	public void showAccInfo() {
		for(int i=0; i<numofAccount; i++) {
			if(myaccount[i] instanceof NormalAccount) {
				((NormalAccount)myaccount[i]).showAccInfo();
			}
			else if (myaccount[i] instanceof HighCreditAccount) {
				((HighCreditAccount)myaccount[i]).showAccInfo();
			}
		}
		System.out.println("##전체정보가 출력되었습니다.##");
	}
	
}
