package collectionsPractice;
import java.util.*;

class BrowserHistory
{
	ArrayList<String> history = new ArrayList<String>();
	public BrowserHistory(String homePage) 
	{
		history.add(homePage);
	}
	
	void visit(String url)
	{
		history.add(url);
	}
	
	void sortUrls(ArrayList<String> urlHistoryArray)
	{
		Collections.sort(urlHistoryArray);
		fetchHistory(urlHistoryArray);
	}
	
	void deleteHistory(int index)
	{
//		String url=history.get(index);
		history.remove(index);
		System.out.println(history);
//		return url;
	}
	
	void deleteHistory(String url)
	{
		history.remove(url);
		System.out.println(history);
	}
	
	void fetchHistory(ArrayList<String> urlHistoryArray)
	{
		for(String url:urlHistoryArray)
		{
			System.out.println(url);
		}
		System.out.println();
	}
	
	void searchWithExtension(String extension)
	{
//		ArrayList<String>urlsWithParticularExtensions=new ArrayList<String>();
		for(String url:history)
		{
			if(url.endsWith(extension))
			{
//				urlsWithParticularExtensions.add(url);
				System.out.println(url);
			}
		}
//		System.out.println(urlsWithParticularExtensions);
	}

	int getHistorySize()
	{
		return history.size();
	}
	
	void updateHistoryUrl(int index,String updatedUrl)
	{
		history.set(index, updatedUrl);
	}
	
}

public class Exercise7 {
	public static void main(String[] args)
	{
		BrowserHistory tabOne = new BrowserHistory("www.Google.com");
		tabOne.visit("www.pec.edu");
	}

}
