package GameV3;

public class Game {
	public static void main(String[] args) {
		System.out.println("Initializing");
		Menu menu = new Menu();
		Board gameBoard = new Board();
		Player player1 = new Player(0, 9, 1, "X");
		Player player2 = new Player(9, 0, 2, "Y");
		Dice dice = new Dice();
		GameLogic gameLogic = new GameLogic();
		boolean playing = true;
		
		
		gameBoard.createBoard(player1, player2);
		
		while (playing == true) {
			playing = menu.runMenu(player1, player2, gameBoard, dice, gameLogic);
		}
	}
}
