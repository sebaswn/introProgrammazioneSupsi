class LibrettoDiRisparmio{
  private double saldo;
  private double interesse;

  LibrettoDiRisparmio(){
    saldo = 0.0;
  }

  LibrettoDiRisparmio(double s){
    saldo = s;
  }

  public double getSaldo(){
    return saldo;
  }

  public void setSaldo(double s){
    this.saldo = s;
  }

  public double getInteresse(){
    return interesse;
  }

  public void setInteresse(double i){
    this.interesse = i;
  }

  public double calcolaInteresseMensile(){
    return ((getSaldo()*getInteresse()));
  }

  public double calcolaSaldoMensile(){
    return (getSaldo() + (getSaldo()*getInteresse()));
  }
}
