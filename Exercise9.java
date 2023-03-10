package multithreading;
import java.util.*;

public class Exercise9
{
	public static void main(String[] args)
	{
		ArrayList<String> historyArrayList=new ArrayList<String>();
//		historyArrayList.add("www.zoho.com");
//		historyArrayList.add("www.Google.in");
//		historyArrayList.add("www.pec.edu");
	
		// Thread created for read operation
		Thread readHistory = new Thread(new Runnable() 
		{
			public void run()
			{
				synchronized (historyArrayList)
				{
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter the element : ");
					historyArrayList.add(sc.nextLine());
					System.out.println(historyArrayList);
					System.out.println("Url Written Successfully");
				}
			}
		});
		
		//Thread Created for Deletion operation
		Thread deleteHistory = new Thread(new Runnable() 
		{
			public void run()
			{
				synchronized (historyArrayList)
				{
					try 
					{
						historyArrayList.remove(historyArrayList.size()-1);
						System.out.println("\nLast Url Deleted successfully");
						System.out.println(historyArrayList);
					} 
					catch (Exception e) 
					{
						System.out.println("Invalid Deletion "+e);
					}
				}
			}
		});
//		readHistory.setPriority(Thread.MAX_PRIORITY);
//		deleteHistory.setPriority(Thread.MIN_PRIORITY);
		
		// Read thread is started
		readHistory.start();
		// Deletion thread is started
		deleteHistory.start();
		
//		deleteHistory.interrupted();
//		boolean flag=deleteHistory.isAlive();
//		System.out.println(flag);
		
	}
	
}


