package com.learning.facebook.pom.testCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learning.facebook.pages.login.Login_Page;
import com.learning.facebook.pom.pages.inbox.Landing_Page;
import com.learning.pom.facebook.base.Page;
import com.learning.pom.util.ErrorUtil;
import com.learning.pom.util.TestUtil;

public class LoginTestcase {

	@Test(dataProvider = "getData")
	public void loginTest(Hashtable<String, String> data) {
		String testDataType = data.get("Flag");

		// To check if the Test case runmode is set to No

		if (!TestUtil.isExecutable("LoginTest", Page.xls1))
			throw new SkipException("Runmode set to NO");

		// To Check if the data in Specified test is set to no

		if (!data.get("Runmode").equals("Y"))
			throw new SkipException("Runmode set to No for data set");

		if(Page.isLoggedIn)
		{
			Page.topMenu.logOut();
		}
		Login_Page login = new Login_Page();
		Landing_Page land_page = login.doLogin(data.get("username"),data.get("Password"));
		if (testDataType.equals("Y") && land_page == null)
		{
			try
			{
				Assert.assertTrue(false, "Not able to login with correct data");
			}catch(Throwable t)
			{
				Page.takeScreenShot("Login");
				ErrorUtil.addVerificationFailure(t);			
			}
			Page.isLoggedIn=false;
			return;
		}
		else if (!testDataType.equals("Y") && land_page != null)
		{
			Assert.assertTrue(false, "Able to login with incorrect data");
			Page.isLoggedIn=false;
			return;
		}
		if(testDataType.equals("Y"))
			Page.isLoggedIn=true;
		else
			Page.isLoggedIn=false;
	}

	@DataProvider
	public Object[][] getData() {
		return TestUtil.getdata("LoginTest", Page.xls1);
	}
}
