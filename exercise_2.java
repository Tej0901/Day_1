package practice_course;

import java.util.*;

class browser
{  
	boolean isLocationAccessible=false;
	boolean isCameraAccessible=false;
	boolean isMicroponeAccessible=false;
	final String versionNumber="1.0";
	
	public browser() 
	{    
		System.out.println("inside browser");
	}
	
	void whoAmI()
	{
		System.out.println("I am browser");
	}
}

class GoogleChrome extends browser
{
	public GoogleChrome() 
	{   super();
		System.out.println("inside GoogleChrome");
		
	}
	
	void whoAmI()
	{
		System.out.println("I am GoogleChrome");
	}
}
class FireFox extends browser
{
	public FireFox() 
	{
		super();
		System.out.println("FireFox constructor");
	}
	void whoAmI()
	{
		System.out.println("I am FireFox");
	}
}

public class exercise_2 {
	public static void main(String[] args)
	{
		browser tabOneBrowser=new GoogleChrome();
		browser tabtwoBrowser=new FireFox();
		browser tabThree= new FireFox();
		browser tabFour= new GoogleChrome();
		browser tabFive= new GoogleChrome();
		browser[] allBrowsers = new browser[5];
		
		
	}

}
