import java.util.Scanner;

public class Game {

  static Board gameBoard = new Board();
  static boolean play = true;
  static int player = 1;
  static Scanner input  = new Scanner(System.in);

  public static void gameInfo(){
    System.out.println("Player 1 has " + gameBoard.player1.coins + " coins.");
    System.out.println("Player 2 has " + gameBoard.player2.coins + " coins.");
  }

  public static void menu(){
    boolean moved = false;
    System.out.println("");
    System.out.println("Player " + player);
    System.out.println("0. Exit");
    System.out.println("1. Show GameBoard");
    System.out.println("2. Move");
    System.out.println("3. Show game info");
    System.out.print("---> ");
    if(input.hasNextInt()){
      int choice = input.nextInt();

      switch(choice){
        case 0:
          System.out.println("Thank you for playing.");
          play = false;
          break;
        case 1:
          gameBoard.print();
          break;
        case 2:
          gameBoard.moving(gameBoard.rollDice(), player);
          moved = true;
          break;
        case 3:
          gameInfo();
          break;
        default:
          System.out.println("Please insert a valid input.");
          break;
      }
    }else{
      System.out.println("Please insert a valid input.");
      input.next();
    }

    if(player == 1 && moved == true){
      player = 2;
      moved = false;
    }else if(player == 2 && moved == true){
      player = 1;
      moved = false;
    }
  }

  public static void main(String[] args) {
    gameBoard.createBoard();
    gameBoard.print();
    while(play == true){
      menu();
    }
  }
}
