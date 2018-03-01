import java.util.Scanner;

public class Multipli{
	private static int[] multi(int numero, int[] list){
		list[numero-1] = (3*numero);
		if(numero > 1 ){
			numero --;
			return multi(numero,list);
		}
		return list;
	}

	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);

		for(int i = 0; i < 5; i++){
			System.out.print("Insert a number to calculate: ");
			if(input.hasNextInt()){
				int num = input.nextInt();
				num = (int)(num/3);
				int[] list = new int[num];
				int[] finList = multi(num, list);
				for(int j = 1; j<finList.length+1; j++){
					if(j%10 == 0){
						System.out.println(finList[j-1]);

					}else{
						System.out.print(finList[j-1]);
						if(finList[j-1]/10<1){
							System.out.print("          ");
						}else if(finList[j-1]/10 >= 1 && finList[j-1]/10 < 10){
							System.out.print("         ");
						}else if(finList[j-1]/10 >=10 && finList[j-1]/10 <= 100){
							System.out.print("        ");
						}
					}

				}
				System.out.println("");

			}else{
			 System.out.println("Please insert a whole number next time. ");
			 System.exit(1);
			}
		}

		input.close();
	}
}
