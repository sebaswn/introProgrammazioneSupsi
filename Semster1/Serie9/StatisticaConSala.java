import java.util.Scanner;

class Insieme{
	double somma = 0.0;
  double sommaQuadrata = 0.0;
  int numeroElementi = 0;
  double max = Double.NaN;
  double min = Double.NaN;

  void aggiungiElemento(double elemento){
    somma = somma + elemento;
    sommaQuadrata = sommaQuadrata + Math.pow(elemento,2);
    numeroElementi ++;

    if(Double.isNaN(max)){
      max = elemento;
    }else if(max < elemento){
      max = elemento;
    }

    if(Double.isNaN(min)){
      min = elemento;
    }else if(min > elemento){
      min = elemento;
    }
  }

  int numeroElementi(){
    return numeroElementi;
  }

  double somma(){
    return somma;
  }

  double media(){
    if(numeroElementi == 0){
      return 0.0;
    }else{
      return ((1.0/numeroElementi)*somma);
    }
  }

  double deviazioneStandard(){
    if(numeroElementi == 0){
      return 0.0;
    }else{
      return (Math.sqrt(((1.0/numeroElementi)*sommaQuadrata)-Math.pow((double)(media()),2)));
    }
  }

  double massimo(){
    return max;
  }

  double minimo(){
    return min;
  }
}

public class StatisticaConSala{
  private static void closing(Insieme insieme){
    System.out.println("Numero di elementi inseriti: " + insieme.numeroElementi());
    System.out.println("Somma di elementi inseriti: " + insieme.somma());
    System.out.println("Valore minimo: " + insieme.minimo());
    System.out.println("Valore massimo: " + insieme.massimo());
    System.out.println("Media: " + insieme.media());
    System.out.println("Deviazione Standard: " + insieme.deviazioneStandard());
  }

	public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    Insieme insieme = new Insieme();
    double num;

    do{
      System.out.print("Inserisci un numero: ");
      if(input.hasNextDouble()){
        num = input.nextDouble();
        if(num == 0){
          closing(insieme);
        }else{
          insieme.aggiungiElemento(num);
        }
      }else{
        System.out.println("La prossima volta inserisci un numero.");
        closing(insieme);
        break;
      }
    }while (num != 0);

		input.close();
  }
}
