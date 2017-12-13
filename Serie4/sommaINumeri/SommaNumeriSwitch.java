import java.util.Scanner;

public class SommaNumeriSwitch{
	static Scanner input  = new Scanner(System.in);
	
	public static void main(String[] args){
		
		System.out.println("Hello. Please choose a number under 10 to add to other numbers. Choose 10 to display the sum. Choose a number greater than 10 to show the numbers.");
		boolean continueLoop = true;
		int sum = 0, count = 0, average = 0, newNumber = 0;
		
		while(continueLoop){
			newNumber = getInput();
			
			switch(newNumber){
				case 0: continueLoop = false;
					break;
				case 1: case 2: case 3:
				case 4: case 5: case 6: 
				case 7: case 8:
					sum = sum + newNumber;
					count ++;
					break;
				case 9: 
					break;
				case 10: 
					System.out.println("Sum: " + sum);
					break;
				default: 
					System.out.println("Average: " + (double)(sum)/(count));
					break;
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
