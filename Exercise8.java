package Hack;
import java.io.*;
import java.util.*;


class Hacker
{
	ArrayList<String>historyReceived=new ArrayList<String>();
	void getHistoryFromBrowser()
	{
		Browser tabOne = new Browser();
		historyReceived=tabOne.getHistory();
		writeHistoryToFile(historyReceived);	
	}
	
	void writeHistoryToFile(ArrayList<String> urls)
	{
		try 
		{
	        File fileObject = new File("HistoryFile.txt");
	        if (fileObject.createNewFile()) 
	        {
	            System.out.println("File created: "+ fileObject.getName());
	        }
	        else 
	        {
	        	File fileObjectOne = new File("HistoryFile.txt");
	        	fileObjectOne.delete();
	            File fileObjectTwo=new File("myfile.txt");
	        }
	        FileWriter fWriter = new FileWriter("myfile.txt");
	        for(String url:urls)
	        {
	        	fWriter.write(url);
	        }
	        fWriter.close();
	    }
	    catch (IOException e) 
		{
	        System.out.println("An I/O error has occurred.");
	        e.printStackTrace();
	    }
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	void modifyHistoryInFile()
	{
		
	}
	
	void writeBackModifiedUrlsToBrowserClass()
	{
		
	}
}


class Browser
{
	ArrayList<String> historyArrayList=new ArrayList<String>();
	public void setHistory(String history) 
	{
		historyArrayList.add(history);
	}
	
	public ArrayList<String> getHistory() 
	{
		return historyArrayList;
	}
}


public class Exercise8 
{
	public static void main(String[] args)
	{
		Hacker hackerOne = new Hacker();
		Scanner reader = new Scanner(System.in);
		while(true)
		{
			System.out.println("1. Add url\n2. Get Urls And Write to History File\n3. Read the History File\n4. Modify the History File\n5. Exit");
			String choice=reader.nextLine();
			switch (Integer.parseInt(choice)) 
			{
				case 1: 
				{
					break;
				}
				case 2:
				{
					break;
				}
				case 3:
				{
					break;
				}
				case 4:
				{
					break;
				}
				case 5:
				{
					System.out.println("Exiting from program  !!!!");
					System.exit(0);
					
					break;
				}
			}
		}
	}
}
