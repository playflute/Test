import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Stack;

public class Recorder {
	private static int count=0;
	public static Stack<Step> allStep=new Stack<Step>();
	private static ArrayList<Step> records=new ArrayList<Step>();
	
	public static void record(String color,int x, int y)
	{
		//1.0 add the current step into arrayList
		records.add(new Step(x,y,color));
		//2.0 persist steps in file
		try
		{
			
			FileSystem f=FileSystems.getDefault();
			Path path=f.getPath("C:/01UI/MVCOA/bin/abc.txt");
			BufferedWriter fileOut = Files.newBufferedWriter(path, Charset.forName("UTF-16"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			for(Step element:records)
			{
				fileOut.write(element.getColor()+"("+element.getRow()+","+element.getColumn()+")");
				fileOut.newLine();
			}

			fileOut.flush();
			fileOut.close();
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//3.0 push the current step into stack
		allStep.push(new Step(x,y,color));
	}
	
	public static void undo()
	{
		//1.0 pop out the current step from the stack
		Step unwanted=allStep.pop();
		
		//2.0 remove the last step in arrayList
		records.remove(records.size()-1);
		
		//3.0 persist steps in file
		try
		{
			
			FileSystem f=FileSystems.getDefault();
			Path path=f.getPath("C:/01UI/MVCOA/bin/abc.txt");
			BufferedWriter fileOut = Files.newBufferedWriter(path, Charset.forName("UTF-16"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			for(Step element:records)
			{
				fileOut.write(element.getColor()+"("+element.getRow()+","+element.getColumn()+")");
				fileOut.newLine();
			}

			fileOut.flush();
			fileOut.close();
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//4.0 roll back the chessboard
		
		
		
	}
}
