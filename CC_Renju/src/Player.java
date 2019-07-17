
public class Player {
	private String color;
	
	public Player(String color)
	{
		this.color=color;
	}

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
