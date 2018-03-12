public class Board{
  private final int gridWidth = 10;
  private final int gridHeight = 10;
  private String[][] boardPieces = new String[10][10];

  private Player player1 = new Player(0,9,0,1,"X");
  private Player player2 = new Player(9,0,0,1,"Y");

  public void createBoard(){
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

  public void updateBoard(boolean overlap){
    if(overlap == false){
      boardPieces[player2.posX][player2.posY] = "Y";
      boardPieces[player1.posX][player1.posY] = "X";
    }else{
      boardPieces[player2.posX][player2.posY] = "XY";
    }
  }

  public boolean checkForPlayer(){
    if(player1.posX == player2.posX && player1.posY == player2.posY){
      return true;
    }else{
      return false;
    }
  }

  public boolean checkForCoins(int x, int y){
    if(boardPieces[x][y] == "$"){
      return true;
    }else{
      return false;
    }
  }

  public void print(){
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
