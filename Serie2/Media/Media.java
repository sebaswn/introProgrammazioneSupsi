import java.util.Scanner;

public class Media{
	public static void main(String[] args){
		int highestNum = getInput();
		printMedia(highestNum);
	}
	
	public static void printMedia(int highest){
		int addTotale = 0;
		
		for(int i = 0; i <= highest; i++){
			addTotale = addTotale + i;
		}
		double valoreFinale = ((double)addTotale/highest);
		System.out.println("Valore medio: " + valoreFinale);
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