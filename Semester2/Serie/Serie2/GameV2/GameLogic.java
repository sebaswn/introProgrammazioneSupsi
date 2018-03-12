class GameLogic{

  public static void overlap(String [][] boardPieces){
    System.out.println();
    System.out.println("You are on the same gamepiece. Let the games begin");
    int p1 = rollDice();
    int p2 = rollDice();
    System.out.println();
    System.out.println("Player 1 rolls a " + p1);
    System.out.println("Player 2 rolls a " + p2);

    if(p1 == p2){
      System.out.println("It's a tie. Roll again");
      overlap(boardPieces);
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
    boardPieces.updateBoard(false);
  }

  public static void move(String dir, int player, Player player1, Player player2, Board[][] boardPieces){
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
    if(boardPieces.checkForCoins(movingPlayer.posX, movingPlayer.posY) == true){
      boardPieces.updateBoard(false);
      movingPlayer.coins ++;
    }else if(checkForPlayer() == true){
      boardPieces.updateBoard(true);
      boardPieces.print();
      overlap(boardPieces);
      boardPieces.updateBoard(false);
    }else{
      boardPieces.updateBoard(false);

    }
    checkVictory();

    boardPieces.print();
  }

  public static void moving(int moves, int player, Board boardPieces){
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
            boardPieces.gameInfo();
            break;
          default:
            System.out.println("Please input a valid in");
            break;
        }
      }
    }
  }

  public static void checkVictory(Player player1, Player player2){
    if(player1.coins == 10){
      System.out.println("Congratulations, player 1 wins!");
      System.exit('1');
    }else if(player2.coins == 10){
      System.out.println("Congratulations, player 2 wins!");
      System.exit('1');
    }
  }
}
