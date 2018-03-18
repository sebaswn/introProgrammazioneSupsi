package GameV3;

import java.util.Scanner;

public class GameLogic {

	public static void checkVictory(Player player1, Player player2) {
		if (player1.coinsCollected == 10) {
			System.out.println("Congratulations, player 1 wins!");
			System.exit('1');
		} else if (player2.coinsCollected == 10) {
			System.out.println("Congratulations, player 2 wins!");
			System.exit('1');
		}
	}

	public void gameInfo(Player player1, Player player2) {
		System.out.println("Player 1");
		System.out.println("      Coins: " + player1.getCoinsCollected());
		System.out.println("    Potions: " + player1.getPotionsCollected());
		System.out.println("       Gems: " + player1.getGemsCollected());

		System.out.println("Player 2");
		System.out.println("      Coins: " + player2.getCoinsCollected());
		System.out.println("    Potions: " + player2.getPotionsCollected());
		System.out.println("       Gems: " + player2.getGemsCollected());

	}

	public void move(String dir, int player, Player player1, Player player2, Board gameBoard) {
		Player movingPlayer;
		if (player == 1) {
			movingPlayer = player1;
		} else {
			movingPlayer = player2;
		}

		gameBoard.removePlayer(movingPlayer.posX, movingPlayer.posY);
		System.out.println(movingPlayer.posX + " " + movingPlayer.posY);
		switch (dir) {
		case "n":
			if (movingPlayer.posX != 0) {
				movingPlayer.posX--;
				if (gameBoard.checkForObstacle(movingPlayer.posX, movingPlayer.posY) == true) {
					System.out.println("You can't move in this direction, there is a "
							+ gameBoard.getBoardPieces()[movingPlayer.posX][movingPlayer.posY].getIcon());
					movingPlayer.posX++;
				}

			} else {
				movingPlayer.posX = 9;
			}

			break;
		case "s":
			if (movingPlayer.posX != 9) {
				movingPlayer.posX++;
				if (gameBoard.checkForObstacle(movingPlayer.posX, movingPlayer.posY) == true) {
					System.out.println("You can't move in this direction, there is a "
							+ gameBoard.getBoardPieces()[movingPlayer.posX][movingPlayer.posY].getIcon());
					movingPlayer.posX--;
				}
			} else {
				movingPlayer.posX = 0;
			}
			break;
		case "e":
			if (movingPlayer.posY != 9) {
				movingPlayer.posY++;
				if (gameBoard.checkForObstacle(movingPlayer.posX, movingPlayer.posY) == true) {
					System.out.println("You can't move in this direction, there is a "
							+ gameBoard.getBoardPieces()[movingPlayer.posX][movingPlayer.posY].getIcon());
					movingPlayer.posY--;
				}
			} else {
				movingPlayer.posY = 0;
			}
			break;
		case "w":
			if (movingPlayer.posY != 0) {
				movingPlayer.posY--;
				if (gameBoard.checkForObstacle(movingPlayer.posX, movingPlayer.posY) == true) {
					System.out.println("You can't move in this direction, there is a "
							+ gameBoard.getBoardPieces()[movingPlayer.posX][movingPlayer.posY].getIcon());
					movingPlayer.posY++;
				}
			} else {
				movingPlayer.posY = 9;
			}
			break;
		}
		if (gameBoard.checkForCoins(movingPlayer.posX, movingPlayer.posY) == true) {
			movingPlayer.setCoinsCollected(movingPlayer.getCoinsCollected() + 1);
		} else if (gameBoard.checkForGems(movingPlayer.posX, movingPlayer.posY) == true) {
			movingPlayer.setGemsCollected(movingPlayer.getGemsCollected() + 1);
		} else if (gameBoard.checkForPotions(movingPlayer.posX, movingPlayer.posY) == true) {
			movingPlayer.setPotionsCollected(movingPlayer.getPotionsCollected() + 1);
		} else if (gameBoard.checkForPotions(movingPlayer.posX, movingPlayer.posY) == true) {
			movingPlayer.setPotionsCollected(movingPlayer.getPotionsCollected() + 1);
		} else if (gameBoard.checkForPlayerOverlap(player1, player2) == true) {
			overlap2(gameBoard, player1, player2, movingPlayer);
		} else {

		}
		checkVictory(player1, player2);
		gameBoard.updateBoard(player1, player2);

		gameBoard.print();
	}

	public static void overlap2(Board gameBoard, Player player1, Player player2, Player movingPlayer) {
		Dice dice = new Dice();
		Scanner input = new Scanner(System.in);
		Player attackingPLayer = movingPlayer;
		Player defendingPlayer;
		if (attackingPLayer.getPlayerNumber() == 1) {
			defendingPlayer = player2;
		} else {
			defendingPlayer = player1;
		}

		System.out.println();
		System.out.println("You are on the same gamepiece. Let the games begin");
		boolean needToRoll = true;

		if (defendingPlayer.getGemsCollected() > 0) {
			System.out.println("Player " + defendingPlayer.getPlayerNumber() + ", you have a gem.");
			System.out.println("Would you like to use it to teleport away? (y/n)");

			boolean answered = false;
			while (answered == false) {
				if (input.hasNextLine()) {
					switch (input.next()) {
					case "y":
						//gameBoard.removePlayer(defendingPlayer.getPosX(), defendingPlayer.getPosY());
						gameBoard.setPlayer(0 + (int) (Math.random() * 9), 0 + (int) (Math.random() * 9),
								defendingPlayer);
						gameBoard.updateBoard(player1, player2);
						defendingPlayer.setGemsCollected(defendingPlayer.getCoinsCollected()-1);
						answered = true;
						needToRoll = false;
						break;
					case "n":
						answered = true;
						break;
					default:
						System.out.println("Please Insert a Valid input.");
					}
				}
			}
		}

		if (attackingPLayer.getPotionsCollected() > 0 && needToRoll == true) {
			System.out.println("Player " + attackingPLayer.getPlayerNumber() + ", you have a potion.");
			System.out.println("Would you like to use it to win automatically? (y/n)");

			boolean answered = false;
			while (answered == false) {
				if (input.hasNextLine()) {
					switch (input.next()) {
					case "y":
						defendingPlayer.setCoinsCollected(defendingPlayer.getCoinsCollected() - 1);
						attackingPLayer.setCoinsCollected(attackingPLayer.getCoinsCollected() + 1);
						defendingPlayer.setPotionsCollected(defendingPlayer.getPotionsCollected()-1);
						if (gameBoard.getBoardPieces()[defendingPlayer.getxInit()][defendingPlayer
								.getyInit()] == null) {
							gameBoard.removePlayer(defendingPlayer.getxInit(), defendingPlayer.getyInit());
							gameBoard.setPlayer(defendingPlayer.getxInit(), defendingPlayer.getyInit(),
									defendingPlayer);
							gameBoard.updateBoard(player1, player2);
						} else {
							gameBoard.removePlayer(attackingPLayer.getxInit(), attackingPLayer.getyInit());
							gameBoard.setPlayer(attackingPLayer.getxInit(), attackingPLayer.getyInit(),
									defendingPlayer);
							gameBoard.updateBoard(player1, player2);
						}
						answered = true;
						needToRoll = false;
						break;
					case "n":
						answered = true;
						break;
					default:
						System.out.println("Please Insert a Valid input.");
					}
				}
			}
		}

		boolean rolled = false;
		if (needToRoll == true) {
			while (rolled == false) {

				System.out.println("Time to Roll.");
				int defenderRoll = dice.rollDice();
				int attackerRoll = dice.rollDice();

				System.out.println("Player " + defendingPlayer.getPlayerNumber() + " rolled a " + defenderRoll);
				System.out.println("Player " + attackingPLayer.getPlayerNumber() + " rolled a " + attackerRoll);

				if (defenderRoll > attackerRoll) {
					System.out.println("Player " + defendingPlayer.getPlayerNumber() + " wins.");
					rolled = true;
					if (gameBoard.getBoardPieces()[attackingPLayer.getxInit()][attackingPLayer.getyInit()] == null) {
						gameBoard.removePlayer(attackingPLayer.getxInit(), attackingPLayer.getyInit());
						gameBoard.setPlayer(attackingPLayer.getxInit(), attackingPLayer.getyInit(), attackingPLayer);
						gameBoard.updateBoard(player1, player2);
					} else {
						gameBoard.removePlayer(defendingPlayer.getxInit(), defendingPlayer.getyInit());
						gameBoard.setPlayer(defendingPlayer.getxInit(), defendingPlayer.getyInit(), attackingPLayer);
						gameBoard.updateBoard(player1, player2);
					}
				} else if (defenderRoll < attackerRoll) {
					System.out.println("Player " + defendingPlayer.getPlayerNumber() + " wins.");
					rolled = true;
					if (gameBoard.getBoardPieces()[defendingPlayer.getxInit()][defendingPlayer.getyInit()] == null) {
						gameBoard.removePlayer(defendingPlayer.getxInit(), defendingPlayer.getyInit());
						gameBoard.setPlayer(defendingPlayer.getxInit(), defendingPlayer.getyInit(), defendingPlayer);
						gameBoard.updateBoard(player1, player2);
					} else {
						gameBoard.removePlayer(attackingPLayer.getxInit(), attackingPLayer.getyInit());
						gameBoard.setPlayer(attackingPLayer.getxInit(), attackingPLayer.getyInit(), defendingPlayer);
						gameBoard.updateBoard(player1, player2);
					}
				}
			}
		}

		
	}

	public static void overlap(Board gameBoard, Player player1, Player player2) {
		Dice d = new Dice();

		System.out.println();
		System.out.println("You are on the same gamepiece. Let the games begin");
		int p1 = d.rollDice();
		int p2 = d.rollDice();
		System.out.println();
		System.out.println("Player 1 rolls a " + p1);
		System.out.println("Player 2 rolls a " + p2);

		if (p1 == p2) {
			System.out.println("It's a tie. Roll again");
			overlap(gameBoard, player1, player2);
			return;
		}

		if (p1 > p2) {
			System.out.println("Player 1 wins. He steals a coin and sends you back to the beginning.");
			if (player2.coinsCollected > 0) {
				player1.coinsCollected++;
				player2.coinsCollected--;
			}
			if (gameBoard.getBoardPieces()[0][9] == null) {
				player2.posX = 0;
				player2.posY = 9;
			} else {
				player2.posX = 9;
				player2.posY = 0;
			}
		} else {
			System.out.println("Player 2 wins. He steals a coin and sends you back to the beginning.");
			if (player1.coinsCollected > 0) {
				player2.coinsCollected++;
				player1.coinsCollected--;
			}
			if (gameBoard.getBoardPieces()[9][0] == null) {
				player1.posX = 9;
				player1.posY = 0;
			} else {
				player1.posX = 0;
				player1.posY = 9;
			}
		}
		gameBoard.updateBoard(player1, player2);
	}

}
