package cherchioECilindro;

public class Test {

	public static void main(String[] args) {
		Cerchio cerchio1 = new Cerchio();
		Cerchio cerchio2 = new Cerchio(1.5);
		Cerchio cerchio3 = new Cerchio(2, "Rosa");

		Cilindro cilindro1 = new Cilindro(1.5);
		Cilindro cilindro2 = new Cilindro(1.5, 4);
		Cilindro cilindro3 = new Cilindro(2, 5, "Verde");

		System.out.println("Cerchio 1");
		cerchio1.showInfo();
		System.out.println(cerchio1.getArea());
		System.out.println();

		System.out.println("Cerchio 2");
		cerchio2.showInfo();
		System.out.println(cerchio2.getArea());
		System.out.println();

		System.out.println("Cerchio 3");
		cerchio3.showInfo();
		System.out.println(cerchio3.getArea());
		System.out.println();

		System.out.println("Cilindro 1");
		cilindro1.showInfo();
		System.out.println(cilindro1.getArea());
		System.out.println(cilindro1.getVolume());
		System.out.println();

		System.out.println("Cilindro 2");
		cilindro2.showInfo();
		System.out.println(cilindro2.getArea());
		System.out.println(cilindro2.getVolume());
		System.out.println();

		System.out.println("Cilindro 3");
		cilindro3.showInfo();
		System.out.println(cilindro3.getArea());
		System.out.println(cilindro3.getVolume());
		System.out.println();

	}

}
