package oops;

interface MultipleAccountContainers
{
	void addContainer(String containerName);
	void leaveContainer(String containeerName);
	String[] viewAllContainers();
}

class Browser
{
	String browserName;
	
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
		for(int i=(this.visitedURLsIndex)-1;i>=0;i--)
		{
			System.out.println(this.visitedURLs[i]);
		}
		System.out.println("\n");
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
		for(int i=allURlsIndex-1;i>=0;i--)
		{
			System.out.println(allURLsArray[i]);
		}
		System.out.println("\n");
	}
	
	//add URl method
	public void addVisitedURLs(String url)
	{
		if(this.visitedURLsIndex>=visitedURLsSize &&  allURlsIndex>=allURsArraySize)
		{
			//exception occurs!!!!
			System.exit(0);
		}
//		this.visitedURLs[this.visitedURLsIndex]=url;
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
	
	public GoogleChrome() {
		super();
		//System.out.println("Inside GoogleChrome Constructor");
		browserName="GoogleChrome";
	}
	
	public void whoAmI() {
		System.out.println("I am Google Chrome");
	}
	
	public void setPermissions(boolean isLocationAccessible,boolean isCameraAccessible,boolean isMicrophoneAccessible) {
		this.isLocationAccessible = isLocationAccessible;
		this.isCameraAccessible = isCameraAccessible;
		this.isMicrophoneAccessible = isMicrophoneAccessible;
	}
	
	public void setPermissions(boolean set) {
		this.isLocationAccessible = set;
		this.isCameraAccessible = set;
		this.isMicrophoneAccessible = set;
	}
}



//FireFox Class
class FireFox extends Browser implements MultipleAccountContainers
{
	private int MaxContainerSize=10;
	String[] containers=new String[MaxContainerSize];
	private int containerArrayIndex=0;
	
	public FireFox() 
	{
		super();
		//System.out.println("Inside FireFox Constructor");
		browserName="FireFox";
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
		
		System.out.println("------------------------------");
		b.whoAmI();
		tabOne.whoAmI();
		tabTwo.whoAmI();
		System.out.println("-----------------------------");
		
		//6
		Browser[] allBrowsers = new Browser[5];
		allBrowsers[0]=tabOne;
		allBrowsers[1]=tabTwo;
		allBrowsers[2]=tabThree;
		allBrowsers[3]=tabFour;
		allBrowsers[4]=tabFive;
		
//		for(int i=0;i<allBrowsers.length;i++)
//		{
//			if((allBrowsers[i].browserName).equalsIgnoreCase("GoogleChrome"))
//			{
//				GoogleChromeInstances++;
//			}
//			else if((allBrowsers[i].browserName).equalsIgnoreCase("FireFox"))
//			{
//				FireFoxInstances++;
//			}   
//		}	
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
 


