package practice_course;

import java.util.*;

interface MultipleAccountContainers
{
	void addContainer();
	void leaveContainer();
}

class browsers
{  
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

class FireFox extends browsers
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


public class exercise_2 {
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
	}

}
