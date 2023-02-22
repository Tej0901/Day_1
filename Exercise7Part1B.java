package exercise7part1b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

class BrowserHistory
{
	Set<String> history = new Set()<String>();
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


public class Exercise7Part1B {
	
	public static void main(String[] args)
	{
		
	}

}
