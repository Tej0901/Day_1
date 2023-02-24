package Hack;
import java.io.*;
import java.util.*;

class Hacker
{
	void getHistoryFromBrowser()
	{
		
	}
	
	void setHistoryToFile()
	{
		
	}
}

public class Exercise8 
{
	public static void main(String[] args)
	{
		Hacker hackerOne = new Hacker();
		try 
		{
	        File Obj = new File("myfile.txt");
	        if (Obj.createNewFile()) 
	        {
	            System.out.println("File created: "+ Obj.getName());
	        }
	        else 
	        {
	        	File Obj1 = new File("myfile.txt");
	        	Obj1.delete();
	            System.out.println("File already exists., so deleting the file and creating again a new file...");
	            File Obj2=new File("myfile.txt");
	        }
	        FileWriter fWriter = new FileWriter("myfile.txt");
	        fWriter.write("hello this is chinthapatla venkata siva sai teja vardhan");
	        fWriter.close();
	        
	        Scanner reader = new Scanner(Obj);
	        while(reader.hasNext())
	        {
	        	System.out.println(reader.nextLine());
	        }
	    }
	    catch (IOException e) 
		{
	        System.out.println("An error has occurred.");
	        e.printStackTrace();
	    }
		
	}
}
