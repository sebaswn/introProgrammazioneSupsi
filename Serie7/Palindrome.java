import java.util.Scanner;

public class Palindrome{
	
	private static boolean checkPal(String usrIn){
		usrIn = usrIn.trim();
		
		if(usrIn.length()<2){
			return true;
		}else if(usrIn.charAt(0) == usrIn.charAt(usrIn.length()-1)){
			return checkPal(usrIn.substring(1, usrIn.length()-1));
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);
		String userInput = "";
		
		System.out.print("Please insert a phrase: ");
		
		if(input.hasNext()){
			userInput = input.nextLine();
		}
		
		
		System.out.println("Palindrome: " +((checkPal(userInput.toLowerCase()) ? "Yes" : "No")));
		
	}
}