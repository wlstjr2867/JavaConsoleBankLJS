package banking;

import java.util.Scanner;

public class AccountManager {
	
	private Account[] myaccount;
	private int accCnt;
	
	
	public AccountManager(int num) {
		myaccount = new Account[num];
		accCnt = 0;
	}

	public void makeAccount() {
		System.out.println("***신규계좌개설***");
		Scanner scan = new Scanner(System.in);
		String iname, iaccountNumber; 
		int ibalance;
		System.out.print("계좌번호:");iaccountNumber = scan.nextLine();
		System.out.print("고객이름:");iname = scan.nextLine();
		System.out.print("잔고:");ibalance = scan.nextInt();
//		System.out.print("기본이자&(정수형태로입력):");jinterestRest = scan.nextDouble();
		myaccount[accCnt] = new NormalAccount(iname, iaccountNumber, ibalance);
				accCnt++;
		System.out.println("계좌개설이 완료되었습니다");
	}
	
	public void depositMoney() {
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호:");String iaccountNumber = scan.nextLine();
		System.out.print("입금액:");int money = scan.nextInt();
		for(int i=0; i<accCnt; i++) {
			if(myaccount[i].accountNumber.equals(iaccountNumber)) {
				myaccount[i].deposit(money);
				return;
			}
		}
		System.out.println("입금이 완료되었습니다.");

	}
	
	public void withdrawMoney() {
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호:");String iaccountNumber = scan.nextLine();
		System.out.print("출금액:");int money = scan.nextInt();
		for(int i=0; i<accCnt; i++) {
			if(myaccount[i].accountNumber.equals(iaccountNumber)) {
				myaccount[i].withdraw(money);
				return;
			}
		}
		System.out.println("출금이 완료되었습니다.");
	}
	
	public void showAccInfo() {
		for(int i=0; i<accCnt; i++) {
			myaccount[i].showAccount();
			System.out.println();
		}
		System.out.println("##전체정보가 출력되었습니다.##");
	}
	
}