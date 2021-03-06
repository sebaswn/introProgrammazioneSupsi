import java.util.Scanner;

enum Morra{
		CARTA, FORBICE, SASSO, QUIT
	}
	
public class MorraCinese{
	static Scanner input  = new Scanner(System.in);
	
	public static void main (String[] args){  
		int numberOfGames = getNumberOfGames(), count = 0, comp = 0, usr = 0;
		int tst = numberOfGames;
		int[] wins = new int[numberOfGames]; //0 = computer, 1 = user
		String compMove, userMove;
		
		//enum.valueOf("FIORI");
		
		do{
			userMove =  getUserMove();
			System.out.println("");
			System.out.println("");
			System.out.println("User: "+userMove);
			if(userMove == "QUIT"){
				break;
			}
			compMove = Morra.values()[0 + (int)(Math.random() * 3)].name(); 
			System.out.println("Computer: "+compMove);
			if(userMove.equals(compMove)){
				System.out.println("Tie! Try again");
			}else if(Morra.valueOf(userMove).ordinal() == 0 && Morra.valueOf(compMove).ordinal() == 2){
				System.out.println("user Wins");
				numberOfGames --;
				wins[numberOfGames] = 1; 
				usr ++;
			}else if(Morra.valueOf(userMove).ordinal() == 2 && Morra.valueOf(compMove).ordinal() == 0){
				System.out.println("comp Wins");
				numberOfGames --;
				wins[numberOfGames] = 0; 
				comp ++;
			}else if(Morra.valueOf(userMove).ordinal() > Morra.valueOf(compMove).ordinal()){ 
				System.out.println("user Wins");
				numberOfGames --;
				wins[numberOfGames] = 1; 
				usr ++;
			}else if(Morra.valueOf(userMove).ordinal() < Morra.valueOf(compMove).ordinal()){ 
				System.out.println("comp Wins");
				numberOfGames --;
				wins[numberOfGames] = 0; 
				comp ++;
			}
			count ++;
			
			System.out.println("");
			System.out.println("");
			
		}while(numberOfGames > 0);
		
		for(int i = 0; i <numberOfGames; i++){
			switch(wins[i]){
				case 0: comp ++;
					break;
				case 1: usr ++;
					break;
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Games played: " + count );
		System.out.println("User won: " + usr + "("+ ((usr * 100.0f) / tst) + "%)");
		System.out.println("Computer won: " + comp + "("+ ((comp * 100.0f) / tst) + "%)");
		System.out.println("");
		System.out.println("");
		input.close();
	}
		
	public static String getUserMove(){
		char userChar = '\u0000';
		String[] move = {"CARTA", "FORBICE", "SASSO", "QUIT"};
		
		do{
			System.out.print("Insert your move (c = carta; f = forbice; s = sasso; q = quit): ");
			if(input.hasNext()){
				userChar = input.nextLine().toLowerCase().charAt(0);
				if(userChar != 'c' && userChar != 'f' && userChar != 's' && userChar != 'q'){
					System.out.println((char) 27 + "[31m Please enter one of the approved values." + (char) 27 + "[0m");
					userChar = '\u0000';
				}
			}else{
				System.out.println((char) 27 + "[31m Please enter c, f, s, or q." + (char) 27 + "[0m");
				input.nextLine();
			}
		}while(userChar == '\u0000');

		switch (userChar){
			case 'c': return move[0];
			case 'f': return move[1];
			case 's': return move[2];
			case 'q': return move[3];
		}
		return "";
	}
	
	public static int getNumberOfGames(){
		int numberGames;
		
		do{
			System.out.print("Insert number of games you want to play: ");
			if(input.hasNextInt()){
				numberGames = input.nextInt();
				if(numberGames < 0){
					System.out.println((char) 27 + "[31m Please enter a positive whole number." + (char) 27 + "[0m");
				}
			}else{
				System.out.println((char) 27 + "[31m Please enter a positive whole number." + (char) 27 + "[0m");
				numberGames = 0;
				input.nextLine();
			}
		}while(numberGames<=0);
		input.nextLine();
		System.out.println("");
		return numberGames;
	}
}
