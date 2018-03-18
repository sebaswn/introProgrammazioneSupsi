package cherchioECilindro;

public class Cerchio {
	private double raggio;
	private String colore;

	// Initializers
	public Cerchio() {
		raggio = 1.0;
		colore = "rosso";
	}

	public Cerchio(double r) {
		raggio = r;
		colore = "rosso";
	}

	public Cerchio(double r, String c) {
		raggio = r;
		colore = c;
	}

	// functions
	public void showInfo() {
		System.out.println(getColore());
		System.out.println(getRaggio());
	}

	public double getArea() {
		return raggio * raggio * Math.PI;
	}

	// Getters and Setters
	public String getColore() {
		return colore;
	}

	public void setColore(String c) {
		colore = c;
	}

	public void setRaggio(Double r) {
		raggio = r;
	}

	public double getRaggio() {
		return raggio;
	}

}
