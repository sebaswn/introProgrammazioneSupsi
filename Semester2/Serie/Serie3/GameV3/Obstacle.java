package GameV3;

public class Obstacle extends GamePiece{
	String type;
	
	Obstacle(int px, int py, String i, String t) {
		super(px, py, i);
		setType(t);
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
