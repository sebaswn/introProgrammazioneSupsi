public class Polinomio {
	private double coefficiente[];
	int grado;

	public Polinomio() {
	}

	public Polinomio(double coefficiente[]) {
		this.coefficiente = coefficiente;
		grado = coefficiente.length - 1;
	}

	public Polinomio(double max, double min, int grado) {
		coefficiente = new double[grado + 1];
		this.grado = grado;
		for (int i = grado; i >= 0; i--) {
			coefficiente[i] = Math.random() * (max - min) + min;
		}
	}

	public int getGrade() {
		grado = coefficiente.length - 1;
		return grado;
	}

	public void stampa() {
		int tmp = grado;
		for (int i = coefficiente.length - 1; i >= 0; i--) {
			System.out.print(coefficiente[i]);
			if (tmp == 1) {
				System.out.print("x");
			} else if (tmp < 1) {
				System.out.print("");
			} else if (tmp > 1) {
				System.out.print("x^" + tmp);
			}
			System.out.print("   ");
			tmp--;
		}
		System.out.println();
	}

	public double calcola(double x) {
		double totale = 0;
		int tmp = grado;
		for (int i = coefficiente.length - 1; i >= 0; i--) {
			totale += coefficiente[i] * Math.pow(x, tmp);
			if (tmp > 0)
				tmp--;
		}
		return totale;
	}

	public Polinomio somma(Polinomio addendo) {
		Polinomio risultato = new Polinomio();
		int gradoTot;
		int tmpCiclo;
		if (grado < addendo.grado) {
			gradoTot = addendo.grado;
			tmpCiclo = grado + 1;
			risultato.grado = gradoTot;
			risultato.coefficiente = new double[gradoTot + 1];
			for (int i = 0; i < risultato.grado + 1; i++) {
				risultato.coefficiente[i] = addendo.coefficiente[i];
			}
		} else {
			gradoTot = grado;
			tmpCiclo = addendo.grado + 1;
			risultato.grado = gradoTot;
			risultato.coefficiente = new double[gradoTot + 1];
			for (int i = 0; i < risultato.grado + 1; i++) {
				risultato.coefficiente[i] = coefficiente[i];
			}
		}
		for (int i = 0; i < tmpCiclo; i++) {
			risultato.coefficiente[i] = coefficiente[i] + addendo.coefficiente[i];
		}
		return risultato;
	}

	public Polinomio prodotto(Polinomio fattore) { // prodotto da fare
		int gradoTot = grado + fattore.grado;
		Polinomio risultato = new Polinomio();
		risultato.grado = gradoTot;
		risultato.coefficiente = new double[gradoTot + 1];
		for (int i = 0; i < fattore.grado + 1; i++) {
			for (int k = 0; k < grado + 1; k++) {
				risultato.coefficiente[i + k] += coefficiente[i] * fattore.coefficiente[k];
			}
		}
		return risultato;
	}
}
