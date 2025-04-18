package banking5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("-------Menu4-------");
		System.out.println("1. 계좌계설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 전체계좌정보출력");
		System.out.println("5. 계좌정보삭제");
		System.out.println("6. 프로그램종료");
		System.out.print("메뉴선택 :");
	}
		
	 
	public static void main(String[] args) {
		AccountManager manager = new AccountManager();
		ObjectInOutputStream inOutputStream = new ObjectInOutputStream();
		
		if(inOutputStream.inPut() != null) {
			manager.accountSet = inOutputStream.inPut(); //out으로 생성된 파일에서 정보를 가져온다.
		}
		
		while(true) {
			showMenu();
		try {
			int choice = scan.nextInt();
			scan.nextLine();
			
			if(choice>6||choice<1) {
				throw new MenuChoiceException();
			}
				switch(choice) {
				case 1:
					manager.makeAccount();
					break;
				case 2:
					manager.depositMoney();
					break;
				case 3:
					manager.withdrawMoney();
					break;
				case 4:
					manager.showAccInfo();
					break;
				case 5:
					manager.deleteAccount();
					break;
				case 6:
					inOutputStream.outPut(manager.accountSet);  // 정보가 out되서 파일이 생성된다.
					System.out.println("AccountInfo.obj 파일로 저장되었습니다.");
					System.out.println("프로그램종료");
					return;
				}//switch문 끝
			}
			catch(InputMismatchException e) {
				System.out.println("숫자만 입력하세요.");
				scan.nextLine();
			}
			catch(MenuChoiceException e) {
				e.choiceEx();
			}
		}//while문 끝
	}//main 끝
}//class 끝
