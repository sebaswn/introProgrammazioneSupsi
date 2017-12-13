import java.util.Scanner;

public class DatiPersonali{
	public static void main(String[] args){
		String name = "";
		String surname;
		String address;
		int year = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please insert your personal data as asked: ");
		
		System.out.print("Name: ");
		name = input.nextLine();
		if (name.isEmpty()){
			System.out.println((char) 27 + "[31m You did not insert anything! Please try again." + (char) 27 + "[0m");
			 System.exit(0);
		}
		
		System.out.print("Surname: ");
		surname = input.nextLine();
		if (surname.isEmpty()){
			System.out.println((char) 27 + "[31m You did not insert anything! Please try again." + (char) 27 + "[0m");
			 System.exit(0);
		}
		
		System.out.print("Address: ");
		address = input.nextLine();
		if (address.isEmpty()){
			System.out.println((char) 27 + "[31m You did not insert anything! Please try again." + (char) 27 + "[0m");
			 System.exit(0);
		}
		
		System.out.print("Birth Year: ");
		
		if (input.hasNextInt()){
			year = input.nextInt();
		}else{
			System.out.println((char) 27 + "[31m You did not insert anything! Please try again." + (char) 27 + "[0m");
			 System.exit(0);
		}
		
		processInput(name, surname, address, year);
	}
	
	public static void processInput(String userName, String userSurname, String userAddress, int userYear){
		int userAge = (2017 - userYear);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Hello " + userName + " " + userSurname +", we have saved your information in our database as follows: ");
		System.out.println("");
		System.out.println("Name: " + userName);
		System.out.println("Surname: " + userSurname);
		System.out.println("Address: " + userAddress);
		System.out.println("Age: " + userAge);
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
}