package collectionsPractice;
import java.util.*;
//import java.util.stream.Collectors;
import java.util.stream.Stream;



class BrowserHistoryList
{
	public ArrayList<String> history = new ArrayList<String>();
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
		ArrayList<String>urlHistoryArray=new ArrayList<String>(history);
		Collections.sort(urlHistoryArray);
		System.out.println("Sorted history List: ");
		for(String url:urlHistoryArray)
		{
			System.out.println(url);
		}
		System.out.println();
	}
	
	//2
	void deleteHistory(int index)
	{
		try 
		{
			System.out.println("After deletion of "+history.get(index)+" :");
			history.remove(index);
			System.out.println(history);
		} 
		catch (Exception e) 
		{
			System.out.println("Invalid Index!!"+e+"\n");
		}
		
	}
	void deleteHistory(String url)
	{
		if(history.contains(url)) {
		System.out.println("After deletion of "+url+" :");
		history.remove(url);
		System.out.println(history);
		}
		else
		{
			System.out.println("URL Not Found!!!");
		}
	}
	
	//3
	void fetchHistory()
	{
		System.out.println("Stored urlsList are: ");
		for(String url:history)
		{
			System.out.println(url);
		}
		System.out.println();
	}
	
	//4
	void searchWithExtension(String extension)
	{
		boolean flag=false;
		System.out.println("Urls List with extension : "+extension+" : ");
		for(String url:history)
		{
			if(url.endsWith(extension))
			{
				System.out.println(url);
				flag=true;
			}
		}
		if(!flag)
		{
			System.out.println("No Url Found with the given Extension !!!");
		}
		System.out.println();
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
	public LinkedHashSet<String> historySet= new LinkedHashSet<>();
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
 
//		Set<String>sortedUrls=new TreeSet<String>(historySet);     //O(n*logn)
		Stream<String> sortedUrls = historySet.stream().sorted();  //O(n*logn)
		System.out.println("Sorted url Set is: ");
		sortedUrls.forEach(System.out::println);
//		System.out.println(sortedUrls);
//		for(String url:sortedUrls)
//		{
//			System.out.println(url);
//		}
		System.out.println();
	}
	
	//2
	void deleteHistory(int index)
	{
		try 
		{
			ArrayList<String> list = new ArrayList<String>(historySet);
			String url=list.get(index);
			historySet.remove(url);
			System.out.println("After deletion of "+url+" :");
			System.out.println(historySet);
		} 
		catch (Exception e) 
		{
			System.out.println("Invalid Index Number!!! "+e);
		}
	}
	
	void deleteHistory(String url)
	{
		if(historySet.contains(url))
		{
			System.out.println("After deletion of "+url+" :");
			historySet.remove(url);
			System.out.println(historySet);
		}
		else 
		{
			System.out.println("URL Not Found!!");
		}
	}

	//3
	void fetchHistory()
	{
		Iterator<String> itr = historySet.iterator();
		System.out.println("Stored URLs set is: ");
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println();
	}
	
	//4
	void searchWithExtension(String extension)
	{
		boolean flag=false;
		System.out.println("Urls Set with extension : "+extension+" : ");
		for(String url:historySet)
		{
			if(url.endsWith(extension))
			{
				System.out.println(url);
				flag=true;
			}
		}
		if(!flag)
		{
			System.out.println("No url exist with given Extension!!!");
		}
		System.out.println();
	}

	//5
	int getHistorySize()
	{
		return historySet.size();
	}
	
	//6
	void updateHistoryUrl(String oldUrl,String updatedUrl)
	{
		if(!historySet.add(oldUrl))
		{
			historySet.remove(oldUrl);
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

		tabOne.fetchHistory();
		tabOne.sortUrls();
		tabOne.fetchHistory();
		tabOne.searchWithExtension(".com");
		tabOne.deleteHistory(-1);
		tabOne.deleteHistory("www.Google.comm");
		int size=tabOne.getHistorySize();
		System.out.println("\nSize of List is: "+size+"\n");
		tabOne.updateHistoryUrl(0, "www.pec.ptu.edu");
		tabOne.fetchHistory();
		
		
		tabTwo.fetchHistory();
		tabTwo.sortUrls();
		tabTwo.fetchHistory();
		tabTwo.searchWithExtension(".in");
		tabTwo.deleteHistory("www.insta.com");
		size=tabTwo.getHistorySize();
		System.out.println("\nSize of Set is: "+size+"\n");
		tabTwo.updateHistoryUrl("www.people.in", "www.pec.ptu.edu");
		tabTwo.fetchHistory();
	}
}
