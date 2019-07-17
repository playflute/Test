
public class ChessBoard {
	private int[][] grid;
	public ChessBoard()
	{
		grid=new int[15][15];
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[0].length;j++)
			{
				grid[i][j]=-1;
			}
		}
	}
	
	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}
	
	public void setGrid(int row,int column,int value) {
		grid[row][column]=value;
	}

	public void showBoard()
	{
		for(int[] row:grid)
		{
			for(int element:row)
			{
				System.out.print(element+"\t");
			}
			System.out.println();
		}
	}

}
