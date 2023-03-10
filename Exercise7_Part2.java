package collectionsPractice;
import java.util.*;
import java.util.Map.Entry;

class BrowserHistoryMap
{
	public LinkedHashMap<String,ArrayList<String>> historyMap=new LinkedHashMap<String,ArrayList<String>>();
	public BrowserHistoryMap(String url) 
	{
		String duplicateUrl=url;
		String[] extension = duplicateUrl.split("\\.");
		ArrayList<String> urlsWithGivenExtension=new ArrayList<String>();
		urlsWithGivenExtension.add(url);
		historyMap.put(extension[extension.length-1],urlsWithGivenExtension);
		//System.out.println(historyMap);
	}
	
	void visit(String url) 
	{
		String duplicateUrl = url;
		String[] extension = duplicateUrl.split("\\.");
		if(historyMap.containsKey(extension[extension.length-1]))
		{
			ArrayList<String> urlsWithGivenExtension = historyMap.get(extension[extension.length-1]);
			urlsWithGivenExtension.add(url);
			historyMap.put(extension[extension.length-1], urlsWithGivenExtension);
		}
		else 
		{
			ArrayList<String> urlsWithGivenExtension = new ArrayList<String>();
			urlsWithGivenExtension.add(url);
			historyMap.put(extension[extension.length-1], urlsWithGivenExtension);
		}
	}
	
	void fetchHistory()
	{
		System.out.println(historyMap);
	}
	
	void fetchHistory(String extension)
	{
		System.out.println(historyMap.get(extension));
		System.out.println();
	}
	
	void deleteHistoryWithParticularExtension(String extension)
	{
		try 
		{
			historyMap.remove(extension);
			System.out.println(historyMap);
		} 
		catch (Exception e) 
		{
			System.out.println("Extension Key Not Found to Delete values!!!"+e);
		}
	}
	
	void getSizeWithParticularExtension(String extension)
	{
		try 
		{
			System.out.println(historyMap.get(extension).size());
		} 
		catch (NullPointerException e) 
		{
			System.out.println("Url Extension Not Found to get size");
		}
	}
	
	void searchUrlWithParticularWord(String searchWord)
	{
		for (Entry<String, ArrayList<String>> e : historyMap.entrySet())
		{
			ArrayList<String>dummyArrayList=e.getValue();
			for(String url:dummyArrayList)
			{
				if(url.contains(searchWord))
				{
					System.out.println(url);
				}
			}
		}
		System.out.println();
	}
}

public class Exercise7_Part2 
{
	public static void main(String[] args)
	{
		BrowserHistoryMap tabThree = new BrowserHistoryMap("www.google.com");
		tabThree.visit("www.zoho.org");
		tabThree.visit("www.people.in");
		tabThree.visit("www.cliq.in");
		tabThree.visit("www.insta.com");
		tabThree.visit("www.gmail.com");
		
		tabThree.fetchHistory("com");
		tabThree.deleteHistoryWithParticularExtension("tej");
		tabThree.getSizeWithParticularExtension("in");
		tabThree.searchUrlWithParticularWord("in");
		
	}

}
