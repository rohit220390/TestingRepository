package test.encapsulation;

public class School extends Institution
{
	//School IS A Institution  - Inheritance
	//School HAS A Room - Encapsulation 
	Room r = null;
	public School(Room r)
	{
		this.r = r;
	}
}
