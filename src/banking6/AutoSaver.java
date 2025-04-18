package banking6;


public class AutoSaver extends Thread {
	
	public void run() {
	while(true) {
			try {
				Thread.sleep(5000);
				System.out.println("계좌정보가 자동저장되었습니다.");
			}
			catch(InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
