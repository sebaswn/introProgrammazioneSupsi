class Player{
  String icon;
  int xPos;
  int yPos;
  int xInit;
  int yInit;
  int coins;
  int playerNumber;

  Player(int xPos, int yPos, int xInit, int yInit, String icon, int playerNumber){
    this.xPos = xPos;
    this.yPos = yPos;
    this.xInit = xInit;
    this.yInit = yInit;
    this.icon = icon;
    this.playerNumber = playerNumber;
  }

  public int getPlayerNumber(){
    return playerNumber;
  }

  public void setxPos(int xPos){
    this.xPos = xPos;
  }

  public int getxPos(){
    return this.xPos;
  }

  public void setCoins(int coins){
    this.coins = coins;
  }

  public int getCoins(){
    return this.coins;
  }

  public void setyPos(int yPos){
    this.yPos = yPos;
  }

  public int getyPos(){
    return this.yPos;
  }

  public int getxInit(){
    return this.xInit;
  }

  public int getyInit(){
    return this.yInit;
  }
}
