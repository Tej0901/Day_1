package Hack;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

class Hacker 
{
	ArrayList<String>historyReceived=new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
	void getHistoryFromBrowser(Browser tab) //throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Method getMethod = null;
		try 
		{
			getMethod = Browser.class.getDeclaredMethod("getHistory");
			getMethod.setAccessible(true);
			historyReceived= (ArrayList<String>) getMethod.invoke(tab);
		} 
		catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
//		historyReceived=tab.getHistory();
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
	        System.out.println("An I/O error has occurred. "+ e );
	       
	    }
		catch(Exception e)
		{
			System.out.println("error occureed!!! "+e);
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
		      System.out.println("An error occurred! File Not Found!!! "+e);  
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	void modifyHistoryByAddingNewUrlsInFile(String newUrl,Browser tab) //throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		try (FileWriter fWriter = new FileWriter("HistoryFile.txt", true);
                PrintWriter pWriter = new PrintWriter(fWriter);) 
		{
            pWriter.println(newUrl);
            System.out.println(newUrl+" : added successfully to file");
            try 
            {
				writeBackModifiedUrlsToBrowserClass(newUrl,tab);
			} 
            catch (SecurityException | IllegalArgumentException e) 
            {
				System.out.println("error occurred!!! "+e.getMessage());
			}
        } 
		catch (IOException e) 
		{
			System.out.println("An Error Occurred!!");
            e.printStackTrace();
        }
		catch (Exception e) {
			System.out.println("error occureed!!! "+e);
		}
	}
	
	void writeBackModifiedUrlsToBrowserClass(String newUrl,Browser tab) //throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Method setMethod;
		try {
			setMethod = Browser.class.getDeclaredMethod("setHistory",String.class);
			setMethod.setAccessible(true);
			setMethod.invoke(tab, newUrl);
		} 
		catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
			 System.out.println("error occureed!!! " +e);
		}
//		tab.setHistory(newUrl);
	}
}


class Browser
{
	ArrayList<String> historyArrayList=new ArrayList<String>();
	//use reflection to access if it is private????
	private void setHistory(String history) 
	{
		historyArrayList.add(history);
	}
	
	private ArrayList<String> getHistory() 
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
	public static void main(String[] args) throws Exception
	{
		Scanner reader = new Scanner(System.in);
		Hacker hackerOne = new Hacker();
		Browser tabOne = new Browser();
		
		while(true)
		{
			System.out.println("\n1. Add url to browser\n2. Read the Urls from browser\n"
					+ "3. Get Urls And Write to History File\n4. Read the History File"
					+ "\n5. Modify the History File\n6. Exit");
			String choice=reader.nextLine();
			switch (Integer.parseInt(choice)) 
			{
				case 1: 
				{
					Method setMethod = Browser.class.getDeclaredMethod("setHistory",String.class);
					setMethod.setAccessible(true);
					String url = reader.nextLine();
					setMethod.invoke(tabOne, url);
//					tabOne.setHistory(reader.nextLine());
//					tabOne.printUrls();
					break;
				}
				case 2:
				{
					tabOne.printUrls();
					break;
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
					System.out.println("Exiting from the program  !!!!");
					System.exit(0);
					break;
				}
			}
		}
	}
}
