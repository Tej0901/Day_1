package practice_course;
import java.util.*;

class browser
{
	private static String[] urls=new String[100];
	static int index=0;
	public browser() {
		// TODO Auto-generated constructor stub
	}
	
	browser(String input)
	{
		urls[index]=input;
		index++;
	}
	
	public static void printUrl()
	{
		for(int i=0;urls[i]!=null;i++) {
		System.out.println(urls[i]);
	}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Enter the urls: ");
		Scanner scanner = new Scanner(System.in);
		browser[] chromeBrowsers=new browser[10];
		for(int i=0;i<5;i++) {
		chromeBrowsers[i]=new browser(scanner.nextLine());
		}
		printUrl();
	}
}
 
