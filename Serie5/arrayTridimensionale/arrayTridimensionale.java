public class arrayTridimensionale{
	public static void main(String[] args){
		double[][][] arrayTri = new double[3][4][2];
		double somma = 0;
		
		//ciclo per dare valori
		for(int i = 0; i < arrayTri.length; i++){
			for(int x = 0; x < arrayTri[i].length; x++){
				for(int y = 0; y < arrayTri[i][x].length; y++){
					arrayTri[i][x][y] = (double)Math.round(((Math.random() * 10) + 0) * 100d)/100d;
				}
			}
		}
		
		//ciclo per calcolare somma
		for(int i = 0; i < arrayTri.length; i++){
			for(int x = 0; x < arrayTri[i].length; x++){
				for(int y = 0; y < arrayTri[i][x].length; y++){
					System.out.print(arrayTri[i][x][y]+" ");
					somma += arrayTri[i][x][y];
				}
			}
		}
		System.out.println("");
		System.out.println("Somma: " + ((double)Math.round(somma * 100d)/100d));
	}
}