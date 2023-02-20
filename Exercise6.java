package exceptionHandling;
import java.io.*;
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
	int currentUrlIndex=-1;
	public ArrayList<String>history=new ArrayList<String>();
	
	public BrowserHistory(String homePage) 
	{
		
		String url=homePage;
		setHistoryUrlExceptionHandling(url);
	}
	
	void visit(String url)
	{
		setHistoryUrlExceptionHandling(url);
	}
	
	void setHistoryUrlExceptionHandling(String url)
	{
		try 
		{
			if(url.endsWith(".com") || url.endsWith(".in") || url.endsWith(".org"))
			{
				history.add(url);
				++currentUrlIndex;
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
	
	void back(int steps) 
	{
		for(int i=0;i<steps;i++)
		{
			--currentUrlIndex;
		}
		backAndForwardExceptionHandling(currentUrlIndex,steps,"Backward");
		//return history.get(currentUrlIndex);
	}
	
	void forward(int steps) 
	{
		for(int i=0;i<steps;i++)
		{
			++currentUrlIndex;
		}
		backAndForwardExceptionHandling(currentUrlIndex,steps,"Forward");
//		return history.get(currentUrlIndex);
	}
	
	void backAndForwardExceptionHandling(int currentUrlIndex,int steps,String mode)
	{
		try 
		{
			if(currentUrlIndex>=0 && currentUrlIndex<history.size())
			{
				System.out.println("url we got after "+steps+" "+mode+": "+history.get(currentUrlIndex));
			}
			else 
			{
				throw new NoHistoryFoundException();
			}
		}
		catch (NoHistoryFoundException e) 
		{
			if(mode.equals("Forward"))
			{
				this.currentUrlIndex=currentUrlIndex-steps;
			}
			else 
			{
				this.currentUrlIndex=currentUrlIndex+steps;
			}
			System.out.println("No History Found "+e);
		}
	}
	
	void get(int position)
	{
		try 
		{
			if(position>=0 && position< history.size())
			{
				//return history.get(position);
				System.out.println(history.get(position-1));
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
	}
	
}


public class Exercise6 
{
	public static void main(String[] args) throws IOException
	{
		int steps=0;
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
			steps=Integer.parseInt(br.readLine());
			tabOne.back(steps);
//			System.out.println("url we got after "+steps+" forward: "+url);
			break;
		}
		case "3":
		{
			steps=Integer.parseInt(br.readLine());
			tabOne.forward(steps);
//			System.out.println("url we got after "+steps+" forward: "+url);
			break;
		}
		case "4":
		{   
			int position=Integer.parseInt(br.readLine());
			tabOne.get(position);
			break;
		}
		default:
			System.exit(0);
		}
		}	
	}
}

