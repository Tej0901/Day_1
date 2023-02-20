package exceptionHandling;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class InvalidURLException extends Exception
{
	private static final long serialVersionUID = 1L;
}

class NoHistoryFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
}

class InvalidPositionException extends Exception
{
	private static final long serialVersionUID = 1L;	
}


class BrowserHistory
{
	//public ArrayList<String>history=new ArrayList<String>();
	int MAX_SIZE=20;
	int historyArrayIndex=-1;
	public String[] history = new String[MAX_SIZE];
	
	public BrowserHistory(String homePage) 
	{
		String url=homePage;
		this.setHistoryUrlExceptionHandling(url);
	}
	
	void visit(String url)
	{
		this.setHistoryUrlExceptionHandling(url);
	}
	
	void setHistoryUrlExceptionHandling(String url)
	{
		try 
		{
			if(url.endsWith(".com") || url.endsWith(".in") || url.endsWith(".org"))
			{
				this.history[++this.historyArrayIndex]=url;
				//this.historyArrayIndex++;
				//history.add(url);
			}
			else 
			{
				throw new InvalidURLException();
			}
		} 
		catch (InvalidURLException e) 
		{
			System.out.println("Invalid Url Extention "+e);
		}
	}
	
	String back(int steps)
	{
		String url = null;
		
		return url;
	}
	
	String forward(int steps)
	{
		String url = null;
		
		return url;
	}
	
	void get(int position)
	{
		try 
		{
			if(position>=0 && position<=historyArrayIndex)
			{
				System.out.println(this.history[position]);
				//return history.get(position);
			}
			else if(position<0)
			{
				throw new InvalidPositionException();
			}
			else
			{
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Invalid Position "+e);
		}
		catch (InvalidPositionException e) 
		{
			System.out.println("Provide only positive values "+e);
		}
		//return history[position];
		//return history.get(position) ;
	}
	
}



public class Exercise6 
{
	public static void main(String[] args) throws IOException
	{
		BrowserHistory tabOne = new BrowserHistory("www.google.com");
		System.out.println("1. Visit\n2. Back\n3. Forward\n4. GetUrl\n5. Exit\n");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true) 
		{
		switch (br.readLine()) 
		{
		case "1": 
		{
			System.out.println("enter the url: \n");
			String url=br.readLine();
			tabOne.visit(url);
			break;
		}
		case "2":
		{
			
			break;
		}
		case "3":
		{
			
			break;
		}
		case "4":
		{
			int position=br.read();
			tabOne.get(position);
			break;
		}
		default:
			System.exit(0);
		}
		
		}	
	}
}

