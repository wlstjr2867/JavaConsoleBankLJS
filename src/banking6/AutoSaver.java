package banking6;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class AutoSaver extends Thread {
	
	private HashSet<Account> acc;
	
	public AutoSaver(HashSet<Account> acc) {
		this.acc = acc;
	}

	public void autoSave() {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("src/AutoSaveAccount.txt"));
			for(Account count : acc) {
				out.println(count.toString());
			}
			out.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {

			try {
				Thread.sleep(5000);
				System.out.println("계좌정보가 자동저장되었습니다.");
				
			this.autoSave();

			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}