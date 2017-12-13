import java.util.Scanner;

public class Sfera{
	
	public static double[] radius = new double[5];
	public static double[] volume = new double[5];
	public static double[] area = new double[5];
	
	public static double area(int r){		
		return 4 * Math.PI * Math.pow(radius[r],2);
	}
	
	public static double volume(int r){
		return (4.0/3) * Math.PI * Math.pow(radius[r],3);
	}
	
	public static void totale(){
		double sommaVolume = 0;
		double sommaArea = 0;
		for(int x = 0; x < radius.length; x++){
			sommaArea = sommaArea + area[x];
			sommaVolume = sommaVolume + volume[x];
		}
		System.out.println("Somma Area: " + sommaArea);
		System.out.println("Somma Volume: " + sommaVolume);
	}
	
	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);
		
		System.out.println("Please input 5 numers: ");
		
		for(int i = 0; i<radius.length; i++){
			System.out.print("Valore " + (i+1) + ": ");
			if(input.hasNextDouble()){
				radius[i] = input.nextDouble();
			}
		}
		
		for(int i = 0; i<5; i++){
			area[i] = area(i);
			volume[i] = volume(i);
		}
		totale();
	}
}