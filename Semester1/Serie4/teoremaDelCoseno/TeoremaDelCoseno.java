import java.util.Scanner;

public class TeoremaDelCoseno{
	private static double sideA, sideB, angle;
	
	public static void main (String [] args){
		getInput();
		System.out.println(getMissingSide());
	}
	
	public static double getMissingSide(){
		double rad = Math.toRadians(angle);
		double sideC = Math.sqrt(Math.pow(sideA, 2)+Math.pow(sideB, 2)-(2*sideB*sideA*Math.cos(rad)));
		return sideC;
	}
	
	public static void getInput(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the lenght two sides and the value in degrees of the angle between 0 and 180 as requested: ");
		System.out.println("");
		
		System.out.print("Side a: ");
		if(input.hasNextDouble()){
			sideA = input.nextDouble();
		}else{
			System.out.println("");
			System.out.println((char) 27 + "[31m Please enter a number." + (char) 27 + "[0m");
			System.out.println("");
			getInput();
			return;
		}
		
		System.out.println("");
		System.out.print("Side b: ");
		if(input.hasNextDouble()){
			sideB = input.nextDouble();
		}else{
			System.out.println("");
			System.out.println((char) 27 + "[31m Please enter a number." + (char) 27 + "[0m");
			System.out.println("");
			getInput();
			return;
		}
		
		System.out.println("");
		System.out.print("Angle:  ");
		if(input.hasNextDouble()){
			angle = input.nextDouble();
		}else {   
			System.out.println("");
			System.out.println((char) 27 + "[31m Please enter a number." + (char) 27 + "[0m");
			System.out.println("");
			getInput();
			return;
		}
		
	}
}