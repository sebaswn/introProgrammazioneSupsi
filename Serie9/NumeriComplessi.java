import java.util.Scanner;

class NumeroComplesso{
  double reale, immaginaria;

  public NumeroComplesso(double real, double fake){
    reale = real;
    immaginaria = fake;
  }

  NumeroComplesso somma(NumeroComplesso num2){
    NumeroComplesso numSomm = new NumeroComplesso((reale+num2.reale), (immaginaria+num2.immaginaria));
    return numSomm;
  }

  NumeroComplesso sottrazione(NumeroComplesso num2){
    NumeroComplesso numSott = new NumeroComplesso((reale-num2.reale), (immaginaria-num2.immaginaria));
    return numSott;
  }

  NumeroComplesso multiplicazione(NumeroComplesso num2){
    NumeroComplesso numMult = new NumeroComplesso(((reale*num2.reale) - (immaginaria*num2.immaginaria)), ((reale*num2.immaginaria)+(num2.reale*immaginaria)));
    return numMult;
  }

  void mostra(){
    if(immaginaria < 0){
      System.out.println(reale + " - " + immaginaria*-1 + "i");
    }else if(immaginaria == 0){
      System.out.println(reale);
    }else{
      System.out.println(reale + " + " + immaginaria + "i");
    }
  }
}

public class NumeriComplessi{
  private static double[] askUser(){
    Scanner input = new Scanner(System.in);
    double[] numeri = new double[4];

    System.out.println("Inserire numeri ");
    System.out.println("Primo numero: ");
    for(int i=0; i<4; i = i+2){
      System.out.print("Parte Reale: ");
      if(input.hasNextDouble()){
        numeri[i] = input.nextDouble();
      }else{
        System.out.print("Inserire un numero prossima volta");
        System.exit(1);
      }
      System.out.print("Parte Immaginaria: ");
      if(input.hasNextDouble()){
        numeri[i+1] = input.nextDouble();
      }else{
        System.out.print("Inserire un numero prossima volta");
        System.exit(1);
      }
      if(i == 0){
        System.out.println("Secondo Numero: ");
      }
    }
    return numeri;
  }

  public static void main(String[] args){
    double[] num = askUser();
    NumeroComplesso num1 = new NumeroComplesso(num[0],num[1]);
    NumeroComplesso num2 = new NumeroComplesso(num[2],num[3]);

    num1.somma(num2).mostra();
    num1.sottrazione(num2).mostra();
    num1.multiplicazione(num2).mostra();
  }
}
