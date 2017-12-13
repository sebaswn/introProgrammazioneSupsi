import java.util.Scanner;

public class ContoAllaRovescia{
	public static void main(String[] args){
		int userInput = collectInput();
		divisibilityByTen(userInput);
		countDown(userInput);

	}
	
	public static void countDown(int biggestNum){
		for(int x = biggestNum; x>=0; x--){
			if(x > 0){
				System.out.print(x + ", ");
			}else{
				System.out.println(x + ".");
			}
		}
	}
	
	public static void divisibilityByTen(int numToDivide){
		// 
		
		int answer = (numToDivide/10)*10;
		int answer2 = answer + 10;
		if(answer == 100){
			System.out.println("This number is between " + 90 + " and "+100);
		}else{
			System.out.println("This number is between " + answer + " and "+answer2);
		}
	}
	
	public static int collectInput(){
		// Creates new input and collects the integer. 
		// Throws error if not integer or if int is 
		// not between 0 & 100. Returns integer.
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please insert whole number between 0 and 100  ");
		int chosenNumber = 0;
		
		if (input.hasNextInt() ) {
			chosenNumber = input.nextInt(); 
			if (chosenNumber > 100 || chosenNumber < 0){
				System.out.println((char) 27 + "[31m Sorry, please enter a number between 0 and 100!" + (char) 27 + "[0m");
			}
		} else {
			System.out.println((char) 27 + "[31m Sorry, please enter a number!" + (char) 27 + "[0m");
		}
		System.out.println("Your chosen number is: " + chosenNumber);
		return chosenNumber;
	}
}
