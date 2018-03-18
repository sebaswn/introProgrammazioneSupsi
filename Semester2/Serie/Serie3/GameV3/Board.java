package GameV3;

import java.util.Scanner;

public class Board {
	final int gridWidth = 10;
	final int gridHeight = 10;
	GamePiece[][] boardPieces = new GamePiece[10][10];
	Scanner input = new Scanner(System.in);

	public void updateBoard(Player player1, Player player2) {
		boardPieces[player2.posX][player2.posY] = player2;
		boardPieces[player1.posX][player1.posY] = player1;
	}

	public boolean checkForPlayerOverlap(Player player1, Player player2) {
		if (player1.posX == player2.posX && player1.posY == player2.posY) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkForCoins(int x, int y) {
		if (boardPieces[x][y] == null) {
			return false;
		} else if (boardPieces[x][y].getIcon() == "$") {
			return true;
		}
		return false;
	}

	public boolean checkForGems(int x, int y) {
		if (boardPieces[x][y] == null) {
			return false;
		} else if (boardPieces[x][y].getIcon() == "*") {
			return true;
		}
		return false;
	}

	public boolean checkForPotions(int x, int y) {
		if (boardPieces[x][y] == null) {
			return false;
		} else if (boardPieces[x][y].getIcon() == "@") {
			return true;
		}
		return false;
	}

	public boolean checkForObstacle(int x, int y) {
		if (boardPieces[x][y] == null) {
			return false;
		} else if (boardPieces[x][y].getIcon() == "=" || boardPieces[x][y].getIcon()== "^") {
			return true;
		}
		return false;
	}

	public void createBoard(Player player1, Player player2) {
		int min = 0;
		int max = 9;

		for (int j = 0; j < 10; j++) {
			for (int k = 0; k < 10; k++) {
				boardPieces[j][k] = null;
			}
		}

		boardPieces[0][9] = player1;
		boardPieces[9][0] = player2;

		for (int i = 0; i < 10; i++) {
			int rand1 = min + (int) (Math.random() * max);
			int rand2 = min + (int) (Math.random() * max);

			if (boardPieces[rand1][rand2] != null) {
				i--;
			} else {
				boardPieces[rand1][rand2] = new Coin(rand1, rand2, "$");
			}
		}

		for (int i = 0; i < 2; i++) {
			int rand1 = min + (int) (Math.random() * max);
			int rand2 = min + (int) (Math.random() * max);

			if (boardPieces[rand1][rand2] != null) {
				i--;
			} else {
				boardPieces[rand1][rand2] = new Potion(rand1, rand2, "@");
			}
		}

		for (int i = 0; i < 2; i++) {
			int rand1 = min + (int) (Math.random() * max);
			int rand2 = min + (int) (Math.random() * max);

			if (boardPieces[rand1][rand2] != null) {
				i--;
			} else {
				boardPieces[rand1][rand2] = new Gem(rand1, rand2, "*");
			}
		}

		for (int i = 0; i < 7; i++) {
			int rand1 = min + (int) (Math.random() * max);
			int rand2 = min + (int) (Math.random() * max);

			if (boardPieces[rand1][rand2] != null) {
				i--;
			} else {
				boardPieces[rand1][rand2] = new Obstacle(rand1, rand2, "=", "Rock");
			}
		}
		
		for (int i = 0; i < 8; i++) {
			int rand1 = min + (int) (Math.random() * max);
			int rand2 = min + (int) (Math.random() * max);

			if (boardPieces[rand1][rand2] != null) {
				i--;
			} else {
				boardPieces[rand1][rand2] = new Obstacle(rand1, rand2, "^", "Tree");
			}
		}
	}

	public void print() {
		System.out.println();
		System.out.println();
		System.out.println("$ --> Coins; @ --> Potion; * --> Gem; = --> Rock; ^ --> Tree ");
		for (int i = 0; i < (gridWidth * 4 + 1); i++) {
			System.out.print("-");
		}
		System.out.println();

		for (int j = 0; j < gridHeight; j++) {
			System.out.print("|");
			for (int k = 0; k < gridWidth; k++) {
				if (boardPieces[j][k] == null) {
					System.out.print("   ");
				} else {
					System.out.print(" ");
					System.out.print(boardPieces[j][k].getIcon());
					System.out.print(" ");
				}

				System.out.print("|");
			}
			System.out.println();

			for (int w = 0; w < (gridWidth * 4 + 1); w++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	// Setters and Getters
	public GamePiece[][] getBoardPieces() {
		return boardPieces;
	}

	public void removePlayer(int x, int y) {
		boardPieces[x][y] = null;
	}

	public void setPlayer(int x, int y, GamePiece player) {
		boardPieces[x][y] = player;
	}

	public int getGridwidth() {
		return gridWidth;
	}

	public int getGridheight() {
		return gridHeight;
	}

}
