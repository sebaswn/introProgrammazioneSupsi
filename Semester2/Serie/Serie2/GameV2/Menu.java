class Menu{
  public static boolean menu(Player player1, Player player2, int playerTurn, GameBoard gameBoard, Dice dice, GameLogic gameLogic){

    boolean moved = false;
    System.out.println("");
    System.out.println("Player " + playerTurn);
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
          return false;
          break;
        case 1:
          gameBoard.print();
          break;
        case 2:
          gameLogic.moving(Dice.rollDice(), player);
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
}
