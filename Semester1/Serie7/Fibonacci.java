import java.util.Scanner;

public class Fibonacci{
	
	public static long fibShow(long numOne, long numTwo, long howManyMore){
		if(howManyMore > 0){
			//System.out.println(numOne);
			return fibShow(numTwo, numOne+numTwo, howManyMore -1);
		}else{
			return numOne;
		}
	}
	
	
	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);
		long in = 0;
		System.out.print("How many numers do you want to see? ");
		
		if(input.hasNextInt()){
			in = input.nextInt();
		}else{
			System.out.println("Please insert a whole, positive numer next time.");
			System.exit(0);
		}
		if(in < 1){
			System.out.println("Number must be bigger than 1.");
			System.exit(0);
		}
		
		System.out.println(fibShow(0,1, in));
	}
}