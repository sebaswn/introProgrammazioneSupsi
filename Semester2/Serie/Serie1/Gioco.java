import java.util.Scanner;

public class Gioco {

  static Board gameBoard = new Board();
  static boolean play = true;
  static int player = 1;
  static Scanner input  = new Scanner(System.in);

  public static void menu(){

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
          System.out.println("Moving...");
          break;
        case 3:
          System.out.println("Game info...");
          break;
      }
    }

    if(player == 1){
      player = 2;
    }else{
      player = 1;
    }
  }

  public static void main(String[] args) {

    gameBoard.createBoard();

    while(play == true){
      menu();
    }
  }
}
