package com.learning.pom.util;

import java.util.Hashtable;

public class TestUtil 
{

	public static boolean isExecutable(String testName,Xls_Reader reader)
	{
		for(int rNum=1;rNum<reader.getRowCount("TestCases");rNum++)
		{
			if(testName.equals(reader.getCellData("TestCases", "TCID", rNum)))
			{
				if(reader.getCellData("TestCases", "Runmode", rNum).equals("Y"))
					return true;
				else
					return false;

			}
		}
		return false;
	}

	public static Object[][] getdata(String testName,Xls_Reader reader)
	{

		System.out.println("*******************************");
		//find the test in excel file
		//find the number of columns in the test
		//find the number of rows in the test
		//print the data of the test
		//put the data in object array

		int testCaseStartIndex=0;

		for(int rNum=1;rNum<reader.getRowCount("Test Data");rNum++)
		{
			if(testName.equals(reader.getCellData("Test Data",0, rNum)))
			{
				testCaseStartIndex=rNum;
				break;
			}

		}
		System.out.println("Test starts from - "+testCaseStartIndex);

		//Total number of columns in	 test

		int colStartIndex=testCaseStartIndex+1;
		int cols=0;
		while(!reader.getCellData("Test Data", cols, colStartIndex).equals(""))
		{
			cols++;
		}
		System.out.println("Total number of columns - "+cols);

		// Total number of rows in Test

		int dataStartIndex=testCaseStartIndex+2;
		int rows=0;
		while(!reader.getCellData("Test Data", 0, dataStartIndex+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total number of rows - "+rows);

		//Printing Test Data
		
		Object [][] data = new Object[rows][1];
		Hashtable <String,String> table = null;
		
		for(int rNum=dataStartIndex;rNum<(dataStartIndex+rows);rNum++)
		{
			table=new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++)
			{
				table.put(reader.getCellData("Test Data", cNum, colStartIndex),reader.getCellData("Test Data", cNum, rNum));
				//System.out.print(reader.getCellData("Test Data", cNum, rNum)+ " -- ");
			}
			//System.out.println();
			data[rNum-dataStartIndex][0]=table;
		}
		return data;
	}
}
