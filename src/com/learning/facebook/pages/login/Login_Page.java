package com.learning.facebook.pages.login;




import java.io.IOException;

import org.testng.Assert;

import com.learning.facebook.pom.pages.inbox.Landing_Page;
import com.learning.pom.facebook.base.Page;
import com.learning.pom.util.ErrorUtil;





public class Login_Page extends Page
{	

	public Landing_Page doLogin(String uname, String password)
	{
		try
		{
		Assert.assertEquals("Welcome to Facebook - Log in, sign up or learn more", driver.getTitle());
		}catch(Throwable t)
		{
			Page.takeScreenShot("Login.jpg");
		}
		driver.get(prop.getProperty("testsiteLandingPage"));
		System.out.println(isElementPresent("//input[@id='email']"));
		input("email", uname);
		input("password",password);
		click("login_btn");
		if(isElementPresent("go_to_profile"))
			return new Landing_Page();
		else
			return null;
	}

	/**
	 * 
	 * For Login with Default User name and Password
	 * 
	 */
	
	public Landing_Page doLogin(){
		
		return doLogin(prop.getProperty("defaultUserName"),prop.getProperty("defaultPassword"));
	}



}
