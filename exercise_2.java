package practice_course;

import java.util.*;

interface MultipleAccountContainers
{
	void addContainer(String containerName);
	void leaveContainer(String containeerName);
	String[] viewAllContainers();
}

class browsers implements MultipleAccountContainers
{  
	public int MaxContainerSize=10;
	String[] containers=new String[MaxContainerSize];
	public int containerArrayIndex=0;
	boolean isLocationAccessible=false;
	boolean isCameraAccessible=false;
	boolean isMicroponeAccessible=false;
	final String googleChromeVersionNumber="1.0";
	public static int GoogleChromeNoOfInstances=0;
	public static int FireFoxNoOfInstances=0;
	String browserName;
	
	public browsers() 
	{    
		System.out.println("browser function");
	}
	
	void whoAmI()
	{
		System.out.println("I am browser");
	}
	
	void setOrResetPermissions(boolean Location)
	{
		isLocationAccessible=Location;
	}
	
	void setOrResetPermissions(boolean Location,boolean Camera,boolean Microphone)
	{
		isLocationAccessible=Location;
		isCameraAccessible=Camera;
		isMicroponeAccessible=Microphone;
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


class GoogleChrome extends browsers
{
	public GoogleChrome() 
	{  
		super();
		GoogleChromeNoOfInstances++;
		browserName="GoogleChrome";
	}
	
	void whoAmI()
	{
		System.out.println("I am GoogleChrome");
	}
}


class FireFox extends browsers implements MultipleAccountContainers
{
	public FireFox() 
	{
		super();
		FireFoxNoOfInstances++;
		browserName="FireFox";
	}
	
	void whoAmI()
	{
		System.out.println("I am FireFox");
	}
}



public class exercise_2 
{
	public static void main(String[] args)
	{
		int GoogleChromeInstances=0;
		int FireFoxInstances=0;
		browsers tabOne=new GoogleChrome();
		browsers tabTwo=new FireFox();
		browsers tabThree= new FireFox();
		browsers tabFour= new GoogleChrome();
		browsers tabFive= new GoogleChrome();
		browsers[] allBrowsers = new browsers[5];
		allBrowsers[0]=tabOne;
		allBrowsers[1]=tabTwo;
		allBrowsers[2]=tabThree;
		allBrowsers[3]=tabFour;
		allBrowsers[4]=tabFive;
		
		for(int i=0;i<allBrowsers.length;i++)
		{
			if((allBrowsers[i].browserName).equalsIgnoreCase("GoogleChrome"))
			{
				GoogleChromeInstances++;
			}
			else if((allBrowsers[i].browserName).equalsIgnoreCase("FireFox"))
			{
				FireFoxInstances++;
			}
		}
		System.out.println(GoogleChromeInstances);
		System.out.println(FireFoxInstances);
		
		tabTwo.addContainer("facebookContainer"); 
		tabTwo.addContainer("Mails"); 
		tabTwo.addContainer("PrivateBrowsing");     
		String[] containers=tabTwo.viewAllContainers(); //List 3 container names 
		for(int i=0;containers[i]!=null;i++)
		{
			System.out.print(containers[i]+" ");
		}
		tabTwo.leaveContainer("PrivateBrowsing"); //delete given container
		containers=tabTwo.viewAllContainers(); 
		System.out.println();
		for(int i=0;containers[i]!=null;i++)
		{
			System.out.print(containers[i]+" ");
		}//List 2 container names 
		
	}
}
