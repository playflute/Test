import java.util.Scanner;

public class GameController {

	public static void main(String[] args) {
		ChessBoard c=new ChessBoard();
		Player lily=new Player("White");
		Player tom=new Player("Black");
		
		Referee john=new Referee();
		
		Scanner s=new Scanner(System.in);
		int x,y;
		String result;
		for(;;)
		{
			//1.0 White player put down chess
			System.out.println("White player please input your target row position :");
			x=s.nextInt();
			System.out.println("White player please input your target column position :");
			y=s.nextInt();
	
			while(c.getGrid()[x][y]!=-1)
			{
				System.out.println("The position has already been occupied,white player please re-enter:");
				System.out.println("White player please input your target row position :");
				x=s.nextInt();
				System.out.println("White player please input your target column position :");
				y=s.nextInt();
				
				
			}
			lily.putDownChess(c, x, y);
			Recorder.record("white", x, y);
			System.out.println("Do you want to undo? Press yes to roll back, press any other key to skip");
			String choice=s.next();
			
   		    if(choice.equals("yes"))
   		    {
				Recorder.undo();
				c.setGrid(x, y, -1);
				
   		    }
			c.showBoard();
			//2.0 Referee judge
			result=john.judge(c);
			if(result.equals("White win")||result.equals("Balck win"))
			{
				System.out.println(result);
				break;
			}
			//3.0 Black player put down chess
			System.out.println("Black player please input your target row position :");
			x=s.nextInt();
			System.out.println("Black player please input your target column position :");
			y=s.nextInt();
			while(c.getGrid()[x][y]!=-1)
			{
				System.out.println("The position has already been occupied,Black player please re-enter:");
				System.out.println("Black player please input your target row position :");
				x=s.nextInt();
				System.out.println("Black player please input your target column position :");
				y=s.nextInt();
				
				
			}
			tom.putDownChess(c, x, y);
			Recorder.record("Black", x, y);
			System.out.println("Do you want to undo?");
			choice=s.next();
   		    if(choice.equals("yes"))
   		    {
				Recorder.undo();
				c.setGrid(x, y, -1);
   		    }
			c.showBoard();
			//4.0 Referee judge
			result=john.judge(c);
			if(result.equals("White win")||result.equals("Balck win"))
			{
				System.out.println(result);
				break;
			}
		}
		
		
		

	}

}
