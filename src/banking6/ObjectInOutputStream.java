package banking6;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

public class ObjectInOutputStream {

	public void outPut(HashSet<Account> acc) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/banking6/AccountInfo.obj"));
			for (Account count : acc) {
				out.writeObject(count);
			}
			
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("[예외]파일없음");
		} catch (IOException e) {
			System.out.println("[Exception]뭔가없음");
		}
	}

	public HashSet<Account> inPut() {

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/banking6/AccountInfo.obj"));
			HashSet<Account> allData = new HashSet<Account>();
			while (true) {
				try {
					Account acc = (Account) in.readObject();// readObject는 Object타입을 불러오기 때문에 어카운트타입으로 바꿔줘야한다.
					allData.add(acc);
				} catch (EOFException e) { // EOF~ : 파일안에 정보를 다 빼왔을때 더 나오지 않게 예외를걸어준다.
					in.close();
					return allData;
				}
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("[예외]클래스없음");
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("AccountInfo.obj 파일없음");
			return null;
		} catch (IOException e) {
			System.out.println("[Exception]뭔가없음");
			return null;
		}
	}
}
