class Test{
  public static void main(String[] args) {
    LibrettoDiRisparmio libro1 = new LibrettoDiRisparmio(200);
    LibrettoDiRisparmio libro2 = new LibrettoDiRisparmio(300);

    libro1.setInteresse(0.04);
    libro2.setInteresse(0.04);

    System.out.println("-----------------------------------");
    System.out.println("Interesse: 4%");
    System.out.println();
    System.out.print("Interesse Mensile libretto 1: ");
    System.out.println(libro1.calcolaInteresseMensile());
    System.out.print("Nuovo saldo: ");
    System.out.println(libro1.calcolaSaldoMensile());
    System.out.println();
    System.out.print("Interesse Mensile libretto 2: ");
    System.out.println(libro2.calcolaInteresseMensile());
    System.out.print("Nuovo saldo: ");
    System.out.println(libro2.calcolaSaldoMensile());
    System.out.println("-----------------------------------");
    System.out.println();

    libro1.setInteresse(0.05);
    libro2.setInteresse(0.05);

    System.out.println("-----------------------------------");
    System.out.println("Interesse: 5%");
    System.out.println();
    System.out.print("Interesse Mensile libretto 1: ");
    System.out.println(libro1.calcolaInteresseMensile());
    System.out.print("Nuovo saldo: ");
    System.out.println(libro1.calcolaSaldoMensile());
    System.out.println();
    System.out.print("Interesse Mensile libretto 2: ");
    System.out.println(libro2.calcolaInteresseMensile());
    System.out.print("Nuovo saldo: ");
    System.out.println(libro2.calcolaSaldoMensile());
    System.out.println("-----------------------------------");

  }
}
