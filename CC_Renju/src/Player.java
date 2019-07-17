
public class Player {
	//color of a certain player
	private String color;
	

	
	//This methods is intended to return the color of the player
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void putDownChess(ChessBoard c,int i,int j)
	{
		if(this.color.equals("Black"))
			c.getGrid()[i][j]=1;
		else
			c.getGrid()[i][j]=0;
	}

	
	

}
