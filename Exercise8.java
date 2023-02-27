package Hack;
import java.io.*;
import java.util.*;


class Hacker
{
	ArrayList<String>historyReceived=new ArrayList<String>();
	void getHistoryFromBrowser(Browser tab)
	{
		historyReceived=tab.getHistory();
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
	        FileWriter fWriter = new FileWriter("HistoryFile.txt");
	        for(String url:urls)
	        {
	        	fWriter.write(url);
	        	fWriter.write("\n");
	        }
	        System.out.println("Successfully Written Urls From Browser To History File..");
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
	
	void readHistoryFile()
	{
		try 
		{
		      File fileObject = new File("HistoryFile.txt");
		      Scanner myReader = new Scanner(fileObject);
		      System.out.println("Contents In the History File...");
		      while (myReader.hasNextLine())
		      {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } 
		catch (FileNotFoundException e) 
		{
		      System.out.println("An error occurred! File Not Found!!!");
		      e.printStackTrace();
		    }
	}
	
	void modifyHistoryByAddingNewUrlsInFile(String newUrl,Browser tab)
	{
		try (FileWriter fWriter = new FileWriter("HistoryFile.txt", true);
                BufferedWriter bWriter = new BufferedWriter(fWriter);
                PrintWriter pWriter = new PrintWriter(bWriter);) 
		{
            pWriter.println(newUrl);
            System.out.println(newUrl+" : added successfully to file");
            writeBackModifiedUrlsToBrowserClass(newUrl,tab);
        } 
		catch (IOException e) 
		{
			System.out.println("An Error Occurred!!");
            e.printStackTrace();
        }
	}
	
	void writeBackModifiedUrlsToBrowserClass(String newUrl,Browser tab)
	{
		tab.setHistory(newUrl);
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
	
	public void printUrls()
	{
		for(String url:historyArrayList)
		{
			System.out.println(url);
		}
		System.out.println();
	}
}


public class Exercise8 
{
	public static void main(String[] args)
	{
		Hacker hackerOne = new Hacker();
		Browser tabOne = new Browser();
		Scanner reader = new Scanner(System.in);
		while(true)
		{
			System.out.println("\n1. Add url to browser\n2. Read the Urls from browser\n"
					+ "3. Get Urls And Write to History File\n4. Read the History File"
					+ "\n5. Modify the History Filen\n6. Exit");
			String choice=reader.nextLine();
			switch (Integer.parseInt(choice)) 
			{
				case 1: 
				{
					tabOne.setHistory(reader.nextLine());
					tabOne.printUrls();
					break;
				}
				case 2:
				{
					tabOne.printUrls();
				}
				case 3:
				{
					hackerOne.getHistoryFromBrowser(tabOne);
					break;
				}
				case 4:
				{
					hackerOne.readHistoryFile();
					break;
				}
				case 5:
				{
					hackerOne.modifyHistoryByAddingNewUrlsInFile(reader.nextLine(),tabOne);
					break;
				}
				case 6:
				{
					System.out.println("Exiting from program  !!!!");
					System.exit(0);
					break;
				}
			}
		}
	}
}
