package cherchioECilindro;

public class Cilindro extends Cerchio {
	double altezza;

	// Initializers
	public Cilindro(double r) {
		super(r, "blue");
		altezza = 10;
	}

	public Cilindro(double r, double a) {
		super(r, "blue");
		altezza = a;
	}

	public Cilindro(double r, double a, String c) {
		super(r, c);
		altezza = a;
	}

	// functions
	public double getArea() {
		return 2 * Math.PI * getRaggio() * getAltezza() + 2 * Math.PI * Math.pow(getRaggio(), 2);
	}

	public double getVolume() {
		return Math.PI * Math.pow(getRaggio(), 2) * getAltezza();
	}

	public void showInfo() {
		System.out.println(getRaggio());
		System.out.println(getColore());
		System.out.println(getAltezza());
	}

	// Getter and Setter
	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double a) {
		altezza = a;
	}

}
