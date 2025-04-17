package banking4;

public class MenuChoiceException extends Exception{
		
	public MenuChoiceException() {
		super("1~5까지의 정수를 입력하세요.");
	}
	
	public void choiceEx() {
		System.out.println("입력 예외발생됨."+ super.getMessage());
	}

}
