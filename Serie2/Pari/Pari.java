import java.util.Scanner;

public class Pari{
	public static void main(String[] args){
		int highestNum = getInput();
		printEvens(highestNum);
	}
	
	public static void printEvens(int highest){
		for(int i = 1; i < highest; i++){
			if (( i % 2 ) == 0){
				System.out.println(i);
			}
		}
	}
	
	public static int getInput(){
		Scanner input = new Scanner(System.in);
		System.out.print("Please insert highest number: ");
		
		int userInput = 0;
		
		if (input.hasNextInt() ) {
			userInput = input.nextInt(); 
		} else {
			System.out.println((char) 27 + "[31m Sorry, please enter a number!" + (char) 27 + "[0m");
		}
		
		
		return userInput;
	}
}