package practice_course;

public class callByValue {
	int data=50;
	void change(int data)
	{
		this.data=data+100;
		
	}
	
	public static void main(String[] args)
	{
		callByValue op = new callByValue();
		op.change(500);
		System.out.println(op.data);
	}

}
