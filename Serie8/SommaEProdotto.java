import java.util.Scanner;

public class SommaEProdotto{
	private static long somma(long numero){
		if(numero >0){
			return (numero + somma(numero-1));
		}else{
			return (numero);
		}
	}

	private static long prodotto(long numero){
		if(numero >1){
			return (numero * prodotto(numero-1));
		}else{
			return (numero);
		}
	}

	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);

		for(int i = 0; i < 5; i++){
			System.out.print("Insert a number to calculate: ");
			if(input.hasNextInt()){
				int num = input.nextInt();
				System.out.println("Sum of numbers between 1 and " + num + " is: " + somma(num));
				System.out.println("Products of numbers between 1 and " + num + " is: " + prodotto(num));
			}else{
			 System.out.println("Please insert a whole number next time. ");
			 System.exit(1);
			}
		}
		input.close();
	}
}
