import java.util.Scanner;

public class Dispari{
	public static void main(String[] args){
		int highestNum = getInput();
		printOdds(highestNum);
	}
	
	public static void printOdds(int highest){
		for(int i = 1; i < highest; i++){
			if (( i % 2 ) == 1){
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