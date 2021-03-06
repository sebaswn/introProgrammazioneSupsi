import java.util.Scanner;
import java.util.Arrays;

public class VettoriTridimensionali{
	public static double[] createVector(int size){
		double [] vector = new double[size];
		return vector;
	}
	
	public static double[] initArray(double[] vector, int max, int min){
		for(int i= 0; i<vector.length; i++){
			vector[i] = Math.round((min+(double)(Math.random()*max))* 100.0)/100.0;
		}
		return vector;                     
	}
	
	public static void printVector(double[] vector){
		for(int i= 0; i<vector.length; i++){
			System.out.print(vector[i]);
			if(i != vector.length-1){
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
	public static double[] sommaVettori(double[] vector1, double[] vector2){
		double[] vectorResult = new double[3];
		for(int i = 0; i<vector1.length; i++){
			vectorResult[i] = Math.round((vector1[i] + vector2[i])*100.0)/100.0;
		}
		return vectorResult;
	}
	
	public static double[] prodottoConstante(double[] vector, double constant){
		for(int i = 0; i<vector.length; i++){
			vector[i] = vector[i]*constant;
		}
		return vector;
	}
	
	public static double[] prodottoVettoriale(double[] vector1, double[] vector2){
		double[] vectorResult = new double[3];
		
		vectorResult[0] =  Math.round(((vector1[1]*vector2[2])-(vector1[2]*vector2[1]))*100.0)/100.0;
		vectorResult[1] =  Math.round(((vector1[2]*vector2[0])-(vector1[0]*vector2[2]))*100.0)/100.0;
		vectorResult[2] =  Math.round(((vector1[0]*vector2[1])-(vector1[1]*vector2[0]))*100.0)/100.0;
		
		return vectorResult;
	}
	 
	
	public static void main(String[] args){
		double[] vettore1 = createVector(3);
		vettore1 = initArray(vettore1, 10, 0);
		printVector(vettore1);
		
		double[] vettore2 = createVector(3);
		vettore2 = initArray(vettore2, 10, 0);
		printVector(vettore2);
		
		vettore2 = sommaVettori(vettore1, vettore2);
		printVector(vettore2);
		
		vettore2 = prodottoConstante(vettore2, 2);
		printVector(vettore2);
	
		vettore2 = prodottoVettoriale(vettore1, vettore2);
		printVector(vettore2);
		
		//System.out.println(Arrays.toString(initArray(vettore, 10, 0)));
	}
}
