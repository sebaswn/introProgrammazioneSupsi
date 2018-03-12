public class Test {

	public static void main(String[] args) {

		Polinomio polinomio = new Polinomio(20, -20, 4);
		polinomio.stampa();
		// System.out.println("Per x=7 " + polinomio.calcola(7.0));

		double[] coeff = { 2.0, 3.0 };
		Polinomio polinomio1 = new Polinomio(coeff);
		polinomio1.stampa();
		System.out.println("Per x=2 " + polinomio1.calcola(2.0));

		double[] coeff1 = { 1.0, 6.0 };
		Polinomio polinomio2 = new Polinomio(coeff1);
		polinomio2.stampa();

		Polinomio risultato = polinomio2.somma(polinomio1);
		risultato.stampa();

		Polinomio prodotto = polinomio1.prodotto(polinomio2);
		prodotto.stampa();
		System.out.println(prodotto.getGrade());

	}

}
