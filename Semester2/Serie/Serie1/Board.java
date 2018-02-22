public class Board{
  static final int gridWidth = 10;
  static final int gridHeight = 10;
  static String[][] boardPieces = new String[10][10];

  static final String ANSI_YELLOW = "\u001B[33m";
  static final String ANSI_RESET = "\u001B[0m";
  static final String ANSI_RED = "\u001B[31m";
  static final String ANSI_BLUE = "\u001B[34m";


  public static int rollDice(){
    return  1+(int)(Math.random()*6);
  }

  public static void moving(int moves){
    while (moves > 0){
      System.out.println("Which way would you like to move? North(s),East(e),South(s),West(w)");
      System.out.print("---> ");
    }
  }




  public static void createBoard(){
    int min = 0;
    int max = 9;

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
    for (int i = 0; i < (gridWidth * 4 +1); i++) {
      System.out.print("-");
    }
    System.out.println();

    for (int j = 0; j < gridHeight; j++) {
      System.out.print("|");
      for (int k = 0; k < gridWidth; k++) {
        if(boardPieces[j][k] == "$"){
          System.out.print(" ");
          //System.out.print(ANSI_YELLOW +boardPieces[j][k]+ ANSI_RESET);
          System.out.print(boardPieces[j][k]);
          System.out.print(" ");
        }else if(boardPieces[j][k] == "X"){
          System.out.print(" ");
          //System.out.print(ANSI_RED+boardPieces[j][k]+ ANSI_RESET);
          System.out.print(boardPieces[j][k]);
          System.out.print(" ");
        }else if(boardPieces[j][k] == "Y"){
          System.out.print(" ");
          //System.out.print(ANSI_BLUE +boardPieces[j][k]+ ANSI_RESET);
          System.out.print(boardPieces[j][k]);
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
