import java.util.Scanner;

public class OperazioniAritmeticheDouble{
	private static double a,b,c,d,r;
	
	public static void main(String[] args){
		
		getInput();
		
		if(checkDivision(r,a,b,d)== true){
			System.out.println("");
			System.out.println("Solution is possible with your numbers!");
			doTheMath(a,b,c,d,r);
		}else if (checkDivision(r,a,b,d)== false){
			System.out.println("");
			System.out.println((char) 27 + "[31mSolution is NOT possible with your numbers. You cannot divide by 0." + (char) 27 + "[0m");
			main(args);
		}
	}
	
	public static void getInput(){
	    Scanner input = new Scanner(System.in);
		System.out.println("");
		System.out.println("Please values for variables as requested: ");
		
		System.out.println("");
		System.out.print("a: ");
		if (input.hasNextInt()){
			OperazioniAritmeticheDouble.a = input.nextInt(); 
		}else{
			System.out.println((char) 27 + "[31m Please enter a number" + (char) 27 + "[0m");
			getInput();
			return;
		}
		
		
		System.out.println("");
		System.out.print("b: ");
		if (input.hasNextInt()){
			OperazioniAritmeticheDouble.b = input.nextInt();  
		}else{
			System.out.println((char) 27 + "[31m Please enter a number" + (char) 27 + "[0m");
			getInput();
			return;
		}
		
		
		System.out.println("");
		System.out.print("c: ");
		if (input.hasNextInt()){
			OperazioniAritmeticheDouble.c = input.nextInt();  
		}else{
			System.out.println((char) 27 + "[31m Please enter a number" + (char) 27 + "[0m");
			getInput();
			return;
		} 
		
		System.out.println("");
		System.out.print("d: ");
		if (input.hasNextInt()){
			OperazioniAritmeticheDouble.d = input.nextInt();  
		}else{
			System.out.println((char) 27 + "[31m Please enter a number" + (char) 27 + "[0m");
			getInput();
			return;
		}
		
		System.out.println("");
		System.out.print("r: ");
		if (input.hasNextInt()){
			OperazioniAritmeticheDouble.r = input.nextInt();  
		}else{
			System.out.println((char) 27 + "[31m Please enter a number" + (char) 27 + "[0m");
			getInput();
			return;
		}	
	}
	
	public static boolean checkDivision(double r, double a, double b, double d) {
		if((3*(r + 34))==0){
			return false;
		}else if ((a+b*d)==0){
			return false;
		}else{
			return true;
		}
    }
    
	public static void doTheMath(double a, double b, double c, double d, double r){
		double solution =  ((4/(3*(r + 34)))-(9*a+b*c)+((3+d*(2+a))/(a+b*d)));
		System.out.println("");
		System.out.println("Your solution: " + solution);
	    System.out.println("");
	    
	}
}