package oops;

import java.util.*;

interface MultipleAccountContainers
{
	void addContainer(String containerName);
	void leaveContainer(String containeerName);
	String[] viewAllContainers();
}

class Browser
{	
	static final int visitedURLsSize=20;
	private String[] visitedURLs = new String[visitedURLsSize];           //Browser Specific
	int visitedURLsIndex=0;
	
	static final int allURsArraySize=40;
	private static String[] allURLsArray = new String[allURsArraySize];   //It stores All the URLs from All Browsers, Not Browser Specific
	static int allURlsIndex=0;

	public Browser() {
		System.out.println("Inside browser Constructor");
	}
	
	public Browser(String[] url)
	{
		if(this.visitedURLsIndex>=visitedURLsSize &&  allURlsIndex>=allURsArraySize)
		{
			//exception occurs!!!!
			System.exit(0);
		}
		this.setVisitedURLs(url);
	}
	
	//set URL method
	public void setVisitedURLs(String[] url)
	{
		this.visitedURLs=url;
		this.visitedURLsIndex=this.visitedURLs.length;
		this.setAllURLs(url);
	}
	
	//Get URL method
	public void getVisitedURLs()
	{	
		getHistoryCount(this.visitedURLs);
	}
	
	public void getHistoryCount(String[] visitedURLs)
	{	
		Map<String,Integer> mapping = new HashMap();
	    for(String x: visitedURLs)
	    {
	        if(!mapping.containsKey(x))
	        {
	            mapping.put(x,1);
	        }
	        else
	        {
	            mapping.put(x, mapping.get(x)+1);
	        }
	    }
	    //System.out.println(mapping);
	    for (String name: mapping.keySet()) {
	        String key = name.toString();
	        String value = mapping.get(name).toString();
	        System.out.println(key + " ##" + value);
	    }
	}
	
	//Set All URLs method
	public void setAllURLs(String[] url) 
	{
		for(String link : url) 
		{
			allURLsArray[allURlsIndex] = link;
			allURlsIndex++;
		}
	}
	
	//Get All URLs method
	public void getAllURLs()
	{
		String[] duplicateURLsArray = allURLsArray;
		int duplicateURLsArrayIndex=allURlsIndex;
		
		for(int i=duplicateURLsArrayIndex-1;i>=0;i--)
		{
			System.out.println(duplicateURLsArray[i]);
		}
		System.out.println("\n");
		//getHistoryCount(allURLsArray);
	}
	
	//add URl method
	public void addVisitedURLs(String url)
	{
		if(this.visitedURLsIndex>=visitedURLsSize &&  allURlsIndex>=allURsArraySize)
		{
			//exception occurs!!!!
			System.exit(0);
		}
		this.visitedURLs= addURL(visitedURLs,visitedURLsIndex,url);
		this.visitedURLsIndex++;
		allURLsArray[allURlsIndex]=url;
		allURlsIndex++;
	}
	
	//resizing Array method
	public String[] addURL(String[] visitedURLs, int visitedURLsIndex, String url)
	{
		String[] updatedURLs=new String[visitedURLsIndex+1];
		for(int i=0;i<visitedURLsIndex;i++)
		{
			updatedURLs[i]=visitedURLs[i];
		}
		updatedURLs[visitedURLsIndex]=url;
		return updatedURLs;
	}

	
	void whoAmI()
	{
		System.out.println("I am browser");
	}
}



//GoogleChrome Class
class GoogleChrome extends Browser
{
	private final String versionNumber = "1.0";
	private boolean isLocationAccessible=false,isCameraAccessible=false,isMicrophoneAccessible=false;
	
	public GoogleChrome() 
	{
		super();
//		System.out.println("Inside GoogleChrome Constructor");
	}
	
	public void whoAmI() 
	{
		System.out.println("I am Google Chrome");
	}
	
	public void setPermissions(boolean isLocationAccessible,boolean isCameraAccessible,boolean isMicrophoneAccessible) 
	{
		this.isLocationAccessible = isLocationAccessible;
		this.isCameraAccessible = isCameraAccessible;
		this.isMicrophoneAccessible = isMicrophoneAccessible;
	}
	
	public void setPermissions(boolean set) 
	{
		this.isLocationAccessible = set;
		this.isCameraAccessible = set;
		this.isMicrophoneAccessible = set;
	}
	
	public String getVersionNumber() 
	{
		return this.versionNumber;
	}
	
	public boolean getIsLocationAccessible() 
	{
		return this.isLocationAccessible;
	}
	
	public boolean getIsCameraAccessible() 
	{
		return this.isCameraAccessible;
	}
	
	public boolean getIsMicrophoneAccessible() 
	{
		return this.isMicrophoneAccessible;
	}
	
}


//FireFox class
class FireFox extends Browser implements MultipleAccountContainers
{
	private int MaxContainerSize=10;
	String[] containers=new String[MaxContainerSize];
	private int containerArrayIndex=0;
	
	public FireFox() 
	{
		super();
//		System.out.println("Inside FireFox Constructor");
	}
	
	void whoAmI()
	{
		System.out.println("I am FireFox");
	}
	
	public void addContainer(String containerName) 
	{
		this.containers[this.containerArrayIndex]=containerName;
		this.containerArrayIndex++;
	}

	public void leaveContainer(String containerName) 
	{
		for(int i=0;i<containerArrayIndex;i++)
		{
			if(this.containers[i].equalsIgnoreCase(containerName))
					{
						this.containers[i]=null;
					}
		}
	}
	
	public String[] viewAllContainers()
	{
		return containers;
	}
	
}



public class OopsConcept
{
	//main method
	public static void main(String[] args)
	{
		
		//exercise-1
		String[] sampleInputUrls1 = {"www.pec.edu","www.javatpoint.com","www.GFG.com"};
		Browser googleChrome = new Browser(sampleInputUrls1);
		String[] sampleInputUrls2 =  {"www.google.com","www.youtube.com"};
		Browser fireFox = new Browser(sampleInputUrls2);
		
		googleChrome.addVisitedURLs("www.zoho.com");
		fireFox.addVisitedURLs("www.gmail.com");
		googleChrome.addVisitedURLs("www.git.com");
		fireFox.addVisitedURLs("www.busindia.com");
		fireFox.addVisitedURLs("www.busindia.com");
		googleChrome.addVisitedURLs("www.twitter.com");
		googleChrome.addVisitedURLs("www.twitter.com");
		
		System.out.println("Print history of GoogleChrome Browser:");
		googleChrome.getVisitedURLs();
		System.out.println("-----------------------------");
		
		System.out.println("Print history of FireFox Browser: ");
		fireFox.getVisitedURLs();
		System.out.println("-----------------------------");
		
		System.out.println("Print All URLs Visited: ");
		googleChrome.getAllURLs();
		System.out.println("-----------------------------");
		
		
		
		//exercise-2
		int GoogleChromeInstances=0;
		int FireFoxInstances=0;
		
		Browser b = new Browser();//1
		
		Browser tabOne=new GoogleChrome();//2
		Browser tabTwo=new FireFox();//3
		Browser tabThree= new FireFox();//4
		Browser tabFour= new GoogleChrome();//5
		Browser tabFive= new GoogleChrome();//6
		
		//3
		System.out.println("------------------------------");
		b.whoAmI();
		tabOne.whoAmI();
		tabTwo.whoAmI();
		System.out.println("-----------------------------");
		
		//4
		((GoogleChrome) tabOne).setPermissions(true);
		((GoogleChrome) tabOne).setPermissions(true, false, true);
		System.out.println("\n-------------------\n");
		System.out.println("Google Chrome details\n");
		System.out.println("Location Access : " + ((GoogleChrome) tabOne).getIsLocationAccessible());
		System.out.println("Camera Access : " + ((GoogleChrome) tabOne).getIsCameraAccessible());
		System.out.println("Micophone Access : " + ((GoogleChrome) tabOne).getIsMicrophoneAccessible());
		
		//5
		System.out.println("Version No : " + ((GoogleChrome) tabOne).getVersionNumber());
		
		//6
		Browser[] allBrowsers = {tabOne,tabTwo,tabThree,tabFour,tabFive};
			
		for(int i = 0; i < 5; i++) 
		{
			GoogleChromeInstances = (allBrowsers[i] instanceof GoogleChrome) ? ++GoogleChromeInstances : GoogleChromeInstances; //ternary operation
			FireFoxInstances = (allBrowsers[i] instanceof FireFox) ? ++FireFoxInstances : FireFoxInstances;	
		}
		
		//wrapper class exercise - 3//-----------------
		Integer GoogleChromeInstancesObject = GoogleChromeInstances;
		Integer fireFoxInstancesObject  = FireFoxInstances;
		GoogleChromeInstances=GoogleChromeInstancesObject;
		FireFoxInstances=fireFoxInstancesObject;
		//---------------------
		
		System.out.println("-----------------------------");
		System.out.println("No of Instances of GoogleChrome Browser: "+GoogleChromeInstances +", "+ GoogleChromeInstancesObject);
		System.out.println("No of Instances of FireFox Browser: "+FireFoxInstances+", "+fireFoxInstancesObject);
		System.out.println("-----------------------------\n");
		
		//7
		((MultipleAccountContainers) tabTwo).addContainer("facebookContainer"); 
		((MultipleAccountContainers) tabTwo).addContainer("Mails"); 
		((MultipleAccountContainers) tabTwo).addContainer("PrivateBrowsing");
		
		String[] containers=((MultipleAccountContainers) tabTwo).viewAllContainers(); 
		for(int i=0;containers[i]!=null;i++)
		{
			System.out.print(containers[i]+" ");
		}
		System.out.println("\n\n-----------------------------");
		((MultipleAccountContainers) tabTwo).leaveContainer("PrivateBrowsing"); 
		
		containers=((MultipleAccountContainers) tabTwo).viewAllContainers(); 
		System.out.println();
		for(int i=0;containers[i]!=null;i++)
		{
			System.out.print(containers[i]+" ");
		} 
		System.out.println("\n-----------------------------");
	}
}
 


