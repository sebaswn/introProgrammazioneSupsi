

class Frazione{
  int denominatore, numeratore;

  public Frazione(int num, int denom){
    numeratore = num;
    denominatore = denom;
  }

  Frazione somma(Frazione fraz2){
    int num = (numeratore*fraz2.denominatore)+(fraz2.numeratore*denominatore);
    int denom = (denominatore * fraz2.denominatore);
    Frazione frazSommato = new Frazione(num, denom);
    return frazSommato;
  }

  Frazione multiplicazione(Frazione fraz2){
    int num = (numeratore*fraz2.numeratore);
    int denom = (denominatore * fraz2.denominatore);
    Frazione frazSommato = new Frazione(num, denom);
    return frazSommato;
  }

  Frazione opposto(){
    Frazione frazOpposto= new Frazione(numeratore * -1, denominatore);
    return frazOpposto;
  }

  Frazione inverso(){
    Frazione frazInverso= new Frazione(denominatore, numeratore);
    return frazInverso;
  }

  void show(){
    System.out.println(numeratore + "/" +denominatore);
  }
}

public class OperazioniConFrazioni{
  public static void main(String[] args){
    Frazione frazione1 = new Frazione(7,2);
    Frazione frazione2 = new Frazione(5,7);
    Frazione frazione3 = new Frazione(34,425);
    Frazione frazione4 = new Frazione(12,23);
    Frazione frazione5 = new Frazione(32,333);
    Frazione frazione6 = new Frazione(1123,70934);
    Frazione frazione7 = new Frazione(71,21);
    Frazione frazione8 = new Frazione(54,73);

    frazione1.somma(frazione2).show();
    frazione1.multiplicazione(frazione2).show();
    frazione1.opposto().show();
    frazione1.inverso().show();
  }
}
