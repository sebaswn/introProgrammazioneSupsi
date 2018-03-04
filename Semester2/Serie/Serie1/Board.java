import java.util.Scanner;

public class Board{
  static final int gridWidth = 10;
  static final int gridHeight = 10;
  static String[][] boardPieces = new String[10][10];
  static Scanner input  = new Scanner(System.in);

  static Player player1 = new Player(0,9,0,1,"X");
  static Player player2 = new Player(9,0,0,1,"Y");

  static final String ANSI_YELLOW = "\u001B[33m";
  static final String ANSI_RESET = "\u001B[0m";
  static final String ANSI_RED = "\u001B[31m";
  static final String ANSI_BLUE = "\u001B[34m";


  public static int rollDice(){
    return  1+(int)(Math.random()*6);
  }

  public static void overlap(){
    System.out.println();
    System.out.println("You are on the same gamepiece. Let the games begin");
    int p1 = rollDice();
    int p2 = rollDice();
    System.out.println();
    System.out.println("Player 1 rolls a " + p1);
    System.out.println("Player 2 rolls a " + p2);

    if(p1 == p2){
      System.out.println("It's a tie. Roll again");
      overlap();
      return;
    }

    if(p1 > p2){
      System.out.println("Player 1 wins. He steals a coin and sends you back to the beginning.");
      if(player2.coins > 0){
        player1.coins ++;
        player2.coins --;
      }
      if(boardPieces[0][9] == " "){
        player2.posX = 0;
        player2.posY = 9;
      }else{
        player2.posX = 9;
        player2.posY = 0;
      }
    }else{
      System.out.println("Player 2 wins. He steals a coin and sends you back to the beginning.");
      if(player1.coins > 0){
        player2.coins ++;
        player1.coins --;
      }
      if(boardPieces[9][0] == " "){
        player1.posX = 9;
        player1.posY = 0;
      }else{
        player1.posX = 0;
        player1.posY = 9;
      }
    }
    updateBoard(false);
  }

  public static void gameInfo(){
    System.out.println("Player 1 has " + player1.coins + " coins.");
    System.out.println("Player 2 has " + player2.coins + " coins.");
  }

  public static void move(String dir, int player){
    Player movingPlayer;
    if(player == 1){
      movingPlayer = player1;
    }else {
      movingPlayer = player2;
    }

    boardPieces[movingPlayer.posX][movingPlayer.posY] = " ";
    switch(dir){
      case "n":
        if(movingPlayer.posX != 0){
          movingPlayer.posX --;
        }else{
          movingPlayer.posX = 9;
        }
        break;
      case "s":
        if(movingPlayer.posX != 9){
          movingPlayer.posX ++;
        }else{
          movingPlayer.posX = 0;
        }
        break;
      case "e":
        if(movingPlayer.posY != 9){
          movingPlayer.posY ++;
        }else{
          movingPlayer.posY = 0;
        }
        break;
      case "w":
        if(movingPlayer.posY != 0){
          movingPlayer.posY --;
        }else{
          movingPlayer.posY = 9;
        }
        break;
    }
    if(checkForCoins(movingPlayer.posX, movingPlayer.posY) == true){
      updateBoard(false);
      movingPlayer.coins ++;
    }else if(checkForPlayer() == true){
      updateBoard(true);
      print();
      overlap();
      updateBoard(false);
    }else{
      updateBoard(false);

    }
    checkVictory();

    print();
  }

  public static void checkVictory(){
    if(player1.coins == 10){
      System.out.println("Congratulations, player 1 wins!");
      System.exit('1');
    }else if(player2.coins == 10){
      System.out.println("Congratulations, player 2 wins!");
      System.exit('1');
    }


  }

  public static void updateBoard(boolean overlap){
    if(overlap == false){
      boardPieces[player2.posX][player2.posY] = "Y";
      boardPieces[player1.posX][player1.posY] = "X";
    }else{
      boardPieces[player2.posX][player2.posY] = "XY";
    }
  }

  public static boolean checkForPlayer(){
    if(player1.posX == player2.posX && player1.posY == player2.posY){
      return true;
    }else{
      return false;
    }
  }

  public static boolean checkForCoins(int x, int y){
    if(boardPieces[x][y] == "$"){
      return true;
    }else{
      return false;
    }
  }


  public static void moving(int moves, int player){
    while (moves > 0){
      System.out.println("");
      System.out.println("Moves left: " + moves);
      System.out.println("Which way would you like to move? North(n),East(e),South(s),West(w), Show Board(sb), Show Info(si), exit(ex)");
      System.out.print("---> ");
      if(input.hasNext() == true){
        String chosenMove = input.next();
        switch(chosenMove){
          case "s": case "n":
          case "e": case "w":
            move(chosenMove, player);
            moves --;
            break;
          case "sb":
            print();
            break;
          case "ex":
            moves = 0;
            break;
          case "si":
            gameInfo();
            break;
          default:
            System.out.println("Please input a valid in");
            break;
        }
      }
    }
  }

  public static void createBoard(){
    int min = 0;
    int max = 9;

    for(int j = 0; j < 10; j++){
      for(int k = 0; k < 10; k++){
        boardPieces[j][k] = " ";
      }
    }

    boardPieces[0][9] = "X";
    boardPieces[9][0] = "Y";

    for(int i = 0; i < 10; i++){
      int rand1 = min+(int)(Math.random()*max);
      int rand2 = min+(int)(Math.random()*max);
      if(boardPieces[rand1][rand2] == "$" || boardPieces[rand1][rand2] == "X" || boardPieces[rand1][rand2] == "Y"){
        i--;
      }else{
        boardPieces[rand1][rand2] = "$";
      }
    }
  }

  public static void print(){
    System.out.println();
    System.out.println();
    System.out.println(boardPieces[0][9]);
    for (int i = 0; i < (gridWidth * 4 +1); i++) {
      System.out.print("-");
    }
    System.out.println();

    for (int j = 0; j < gridHeight; j++) {
      System.out.print("|");
      for (int k = 0; k < gridWidth; k++) {
        if(boardPieces[j][k] == "$"){
          System.out.print(" ");
          System.out.print(ANSI_YELLOW +boardPieces[j][k]+ ANSI_RESET);
          //System.out.print(boardPieces[j][k]);
          System.out.print(" ");
        }else if(boardPieces[j][k] == "X"){
          System.out.print(" ");
          System.out.print(ANSI_RED+boardPieces[j][k]+ ANSI_RESET);
          //System.out.print(boardPieces[j][k]);
          System.out.print(" ");
        }else if(boardPieces[j][k] == "Y"){
          System.out.print(" ");
          System.out.print(ANSI_BLUE +boardPieces[j][k]+ ANSI_RESET);
          //System.out.print(boardPieces[j][k]);
          System.out.print(" ");
        }else if(boardPieces[j][k] == "XY"){
          System.out.print(boardPieces[j][k]);
          //System.out.print(boardPieces[j][k]);
          System.out.print(" ");
        }else{
          System.out.print("   ");
        }
        System.out.print("|");
      }
      System.out.println();

      for (int w = 0; w < (gridWidth * 4+1); w++) {
        System.out.print("-");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println();
  }
}
