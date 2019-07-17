
public class Referee implements Judgeable {

	@Override
	public String judge(ChessBoard c) {
		if((this.judgeRow(c).equals("no winner"))&&(this.judgeColumn(c).equals("no winner")))
			return "no winner";
		else if((this.judgeRow(c).equals("White win"))||(this.judgeColumn(c).equals("White win")))
			return "White win";
		else
			return "Balck win";
	}
	
	private String judgeRow(ChessBoard c)
	{
		int blackCounter,whiteCounter;
		blackCounter=whiteCounter=0;
		for (int i=0;i<c.getGrid().length;i++)
		{
			for(int j=0;j<c.getGrid()[0].length;j++)
			{
				if(c.getGrid()[i][j]==0)
				{
					whiteCounter++;
					blackCounter=0;
				}
				else if(c.getGrid()[i][j]==1)
				{
					blackCounter++;
					whiteCounter=0;
				}
				else
				{
					whiteCounter=blackCounter=0;
				}
				
				if(whiteCounter==5)
					return "White win";
				else if(blackCounter==5)
					return "Balck win";
			}

			
		}
		return "no winner";
		
		
	}
	
	private String judgeColumn(ChessBoard c)
	{
		int blackCounter,whiteCounter;
		blackCounter=whiteCounter=0;
		for(int j=0;j<c.getGrid()[0].length;j++)		
		{
			for (int i=0;i<c.getGrid().length;i++)
			{
				if(c.getGrid()[i][j]==0)
				{
					whiteCounter++;
					blackCounter=0;
				}
				else if(c.getGrid()[i][j]==1)
				{
					blackCounter++;
					whiteCounter=0;
				}
				else
				{
					whiteCounter=blackCounter=0;
				}
				
				if(whiteCounter==5)
					return "White win";
				else if(blackCounter==5)
					return "Balck win";
			}

			
		}
		return "no winner";
		
		
	}
	


}
