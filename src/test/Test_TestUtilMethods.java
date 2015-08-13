package test;

import com.learning.pom.util.TestUtil;
import com.learning.pom.util.Xls_Reader;

public class Test_TestUtilMethods {

	public static void main(String[] args) 
	{
		int rNum=0;
		Xls_Reader ob = new Xls_Reader(System.getProperty("user.dir")+"/src/testdata/testCases.xlsx");
		
		System.out.println(ob.getCellData("TestCases", 0, 2));
		
		TestUtil.getdata("LoginTest", new Xls_Reader(System.getProperty("user.dir")+"/src/testdata/testCases.xlsx"));
		TestUtil.getdata("ChangePicTest", new Xls_Reader(System.getProperty("user.dir")+"/src/testdata/testCases.xlsx"));
		TestUtil.getdata("FindFriendTest", new Xls_Reader(System.getProperty("user.dir")+"/src/testdata/testCases.xlsx"));
	}

}
