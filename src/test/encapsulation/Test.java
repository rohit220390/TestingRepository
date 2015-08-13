package test.encapsulation;

public class Test 
{
	public static void  main(String [] arg)
	{
		Room r  = new Room();
		r.setSpace(1000);
		School s = new School(r);
		s.teach();
		System.out.println(s.r.getSpace());
		
	}

}
