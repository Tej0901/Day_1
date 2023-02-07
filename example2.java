package javaprog;
import java.util.Scanner;

class account
{
	int accNo;
	String name;
	float amt;
	void insert(int i,String n,float amount)
	{
		accNo=i;
		name=n;
		amt=amount;
	}
	void deposit(int a)
	{
		amt=amt+a;
		System.out.println("balance amount "+amt);
	}
	void withdraw(int b)
	{
		if(amt<b)
		{
			System.out.println("insuficient balance");
		}
		else
		{
			amt=amt-b;
			System.out.println("amount withdrawn "+b );
			System.out.println("balance amount "+amt);
		}
	}
	void checkBalance()
	{
		System.out.println("balance amount "+amt);
	}
	void displayDetails()
	{
		System.out.println(accNo+" "+name+" "+amt);
	}
}
public class example2 {
	public static void main(String[] args)
	{
	account a1=new account();
	a1.insert(81,"siva",10000);
	int opt=0;
	while(opt<5)
	{
	System.out.println("1: deposit");
	System.out.println("2: withdraw");
	System.out.println("3: check_balance");		
	System.out.println("4: display details");
	System.out.println("5: Exit");
	System.out.println("enter the  choice: ");
	Scanner myobj=new Scanner(System.in);
	opt=myobj.nextInt();
	switch(opt)
	{
	case 1:
	{
		System.out.println("enter the deposit amt: ");
		Scanner obj2=new Scanner(System.in);
		int depAmt=obj2.nextInt();
		a1.deposit(depAmt);
		break;
	}
	case 2:
	{
		System.out.println("enter the withdraw amt: ");
		Scanner obj3=new Scanner(System.in);
		int withdrawAmt=obj3.nextInt();
		a1.withdraw(withdrawAmt);
		break;
	}
	case 3:
	{
		a1.checkBalance();
		break;
	}
	case 4:
	{
		a1.displayDetails();
		break;
	}
	case 5:
	{
		//break;
		System.out.println("exiting from  program");
		System.exit(1);
	}
	}
	}
	}
}

