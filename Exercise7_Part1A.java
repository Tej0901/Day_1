package collectionsPractice;
import java.util.*;

class BrowserHistoryList
{
	ArrayList<String> history = new ArrayList<String>();
	public BrowserHistoryList(String homePage) 
	{
		history.add(homePage);
	}
	
	void visit(String url)
	{
		history.add(url);
	}
	
	//1
	void sortUrls()
	{
		ArrayList<String>urlHistoryArray=history;
		Collections.sort(urlHistoryArray);
		fetchHistory(urlHistoryArray);
	}
	
	//2
	void deleteHistory(int index)
	{
		history.remove(index);
		System.out.println(history);
	}
	void deleteHistory(String url)
	{
		history.remove(url);
		System.out.println(history);
	}
	
	//3
	void fetchHistory(ArrayList<String> urlHistoryArray)
	{
		for(String url:urlHistoryArray)
		{
			System.out.println(url);
		}
		System.out.println();
	}
	
	//4
	void searchWithExtension(String extension)
	{
		for(String url:history)
		{
			if(url.endsWith(extension))
			{
				System.out.println(url);
			}
		}
	}

	//5
	int getHistorySize()
	{
		return history.size();
	}
	
	//6
	void updateHistoryUrl(int index,String updatedUrl)
	{
		history.set(index, updatedUrl);
	}
	
}

class BrowserHistorySet
{
	LinkedHashSet<String> historySet= new LinkedHashSet<>();
	public BrowserHistorySet(String homePage) 
	{
		historySet.add(homePage);
	}
	
	void visit(String url)
	{
		historySet.add(url);
	}
	
	//1
	void sortUrls()
	{
		TreeSet<String>urlTreeHashSet=new TreeSet<String>(historySet);
		for(String url:urlTreeHashSet)
		{
			System.out.println(url);
		}
	}
	
	//2
	void deleteHistory(int index)
	{
		historySet.remove(index);
		System.out.println(historySet);
	}
	void deleteHistory(String url)
	{
		historySet.remove(url);
		System.out.println(historySet);
	}
	
	//3
	void fetchHistorySet()
	{
		Iterator<String> itr = historySet.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
	
	//4
	void searchWithExtension(String extension)
	{
		for(String url:historySet)
		{
			if(url.endsWith(extension))
			{
				System.out.println(url);
			}
		}
		System.out.println();
	}

	//5
	int getHistorySize()
	{
		return historySet.size();
	}
	
	//6
	void updateHistoryUrl(String previousUrl,String updatedUrl)
	{
		if(!historySet.add(previousUrl))
		{
			historySet.remove(previousUrl);
			historySet.add(updatedUrl);
		}
	}
}

public class Exercise7_Part1 {
	public static void main(String[] args)
	{
		BrowserHistoryList tabOne = new BrowserHistoryList("www.Google.com");
		tabOne.visit("www.pec.edu");
		tabOne.visit("www.twitter.com");
		tabOne.visit("www.youtube.com");
		tabOne.visit("www.pytu.iis.in");
		BrowserHistorySet  tabTwo = new BrowserHistorySet("www.zoho.com");
		tabTwo.visit("www.people.in");
		tabTwo.visit("www.cliq.in");
		tabTwo.visit("www.insta.com");
		tabTwo.visit("www.gmail.com");
		
		//operations---
		
		
	}
}
