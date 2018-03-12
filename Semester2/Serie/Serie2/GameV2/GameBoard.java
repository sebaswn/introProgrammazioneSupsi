class GameBoard{
  final String ANSI_YELLOW = "\u001B[33m";
  final String ANSI_RESET = "\u001B[0m";
  final String ANSI_RED = "\u001B[31m";
  final String ANSI_BLUE = "\u001B[34m";
  final int gridWidth = 10;
  final int gridHeight = 10;
  String[][] boardPieces = new String[10][10];

  public String[][] getBoardPieces(){
    return boardPieces;
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

  public void updateBoard(boolean overlap, Player player1, Player player2){
    if(overlap == false){
      boardPieces[player2.getxPos()][player2.getyPos()] = "Y";
      boardPieces[player1.getxPos()][player1.getyPos()] = "X";
    }else{
      boardPieces[player2.getxPos()][player2.getyPos()] = "XY";
    }
  }

  public boolean checkForPlayer(Player player1, Player player2){
    if(player1.getxPos() == player2.getyPos() && player1.getyPos() == player2.getyPos()){
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
}
