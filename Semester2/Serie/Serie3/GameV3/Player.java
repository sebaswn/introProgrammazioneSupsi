package GameV3;

public class Player extends GamePiece {
	int playerNumber;
	int coinsCollected;
	int potionsCollected;
	int gemsCollected;
	int xInit;
	int yInit;

	Player(int px, int py, int pn, String i) {
		super(px, py, i);
		setPlayerNumber(pn);
		setxInit(px);
		setyInit(py);
	}

	// getters and setters
	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public int getCoinsCollected() {
		return coinsCollected;
	}

	public void setCoinsCollected(int coinsCollected) {
		this.coinsCollected = coinsCollected;
	}

	public int getxInit() {
		return xInit;
	}

	public void setxInit(int xInit) {
		this.xInit = xInit;
	}

	public int getyInit() {
		return yInit;
	}

	public void setyInit(int yInit) {
		this.yInit = yInit;
	}

	public int getPotionsCollected() {
		return potionsCollected;
	}

	public void setPotionsCollected(int potionsCollected) {
		this.potionsCollected = potionsCollected;
	}

	public int getGemsCollected() {
		return gemsCollected;
	}

	public void setGemsCollected(int gemsCollected) {
		this.gemsCollected = gemsCollected;
	}

}
