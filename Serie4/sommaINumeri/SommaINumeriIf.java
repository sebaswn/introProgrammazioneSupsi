import java.util.Scanner;

public class SommaINumeriIf{
	static Scanner input  = new Scanner(System.in);
	
	public static void main(String[] args){
		
		System.out.println("Hello. Please choose a number under 10 to add to other numbers. Choose 10 to display the sum. Choose a number greater than 10 to show the numbers.");
		boolean continueLoop = true;
		int sum = 0, count = 0, average = 0, newNumber = 0;
		
		while(continueLoop){
			newNumber = getInput();
			if(newNumber == 0){
				continueLoop = false;
			}else if(newNumber < 9){
				sum = sum + newNumber;
				count ++;
			}else if(newNumber == 10){
				System.out.println("Sum: " + sum);
			}else if(newNumber > 10){
				System.out.println("Average: " + (double)(sum)/(count));
			}
		}
		
		input.close();
	}
	
	
	
	public static int getInput(){
		
		int error=0;
		int number = 0;
		
		do{
			System.out.print("Insert number: ");
			if(input.hasNextInt()){
				number = input.nextInt();
			}else {
				number = 0;
				System.out.println((char) 27 + "[31m Please enter a positive whole number next time." + (char) 27 + "[0m");
			}
			if(number < 0 ){
				System.out.println((char) 27 + "[31m Please enter a positive whole number." + (char) 27 + "[0m");
			}
			
		}while (number < 0);
		
		return number;
	}
}
