package GameV3;

import java.util.Scanner;

public class Menu {
	Scanner input = new Scanner(System.in);
	static int playerTurn = 1;

	public boolean runMenu(Player player1, Player player2, Board gameBoard, Dice dice, GameLogic gameLogic) {
		boolean moved = false;
		System.out.println("");
		System.out.println("Player " + playerTurn);
		System.out.println("0. Exit");
		System.out.println("1. Show GameBoard");
		System.out.println("2. Move");
		System.out.println("3. Show game info");
		System.out.print("---> ");
		if (input.hasNextInt()) {
			switch (input.nextInt()) {
			case 0:
				System.out.println("Thank you for playing.");
				return false;
			case 1:
				gameBoard.print();
				break;
			case 2:
				moving(dice.rollDice(), playerTurn, player1, player2, gameBoard, gameLogic);
				moved = true;
				break;
			case 3:
				gameLogic.gameInfo(player1, player2);
				break;
			default:
				System.out.println("Please insert a valid input.");
				break;
			}
		} else {
			System.out.println("Please insert a valid input.");
			input.next();
		}

		if (playerTurn == 1 && moved == true) {
			playerTurn = 2;
			moved = false;
		} else if (playerTurn == 2 && moved == true) {
			playerTurn = 1;
			moved = false;
		}
		return true;
	}

	public void moving(int moves, int player, Player player1, Player player2, Board gameBoard, GameLogic gameLogic) {
		gameBoard.print();
		while (moves > 0) {
			
			System.out.println("");
			System.out.println("Moves left: " + moves);
			System.out.println(
					"Which way would you like to move? North(n),East(e),South(s),West(w), Show Board(sb), Show Info(si), exit(ex)");
			System.out.print("---> ");
			if (input.hasNext() == true) {
				String chosenMove = input.next();
				switch (chosenMove) {
				case "s":
				case "n":
				case "e":
				case "w":
					gameLogic.move(chosenMove, player, player1, player2, gameBoard);
					moves--;
					break;
				case "sb":
					gameBoard.print();
					break;
				case "ex":
					moves = 0;
					break;
				case "si":
					gameLogic.gameInfo(player1, player2);
					break;
				default:
					System.out.println("Please input a valid in");
					break;
				}
			}
		}
	}

}
