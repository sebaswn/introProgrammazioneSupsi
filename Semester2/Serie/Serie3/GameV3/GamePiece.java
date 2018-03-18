package GameV3;

public class GamePiece {
	int posX;
  	int posY;
  	String icon;
  
  	GamePiece(int px, int py, String i){
  		setPosX(px);
  		setPosY(py);
		setIcon(i);
  	}
  	
  	
  	// Setters and Getters
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
  
 
}
