package com.learning.facebook.pom.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.learning.facebook.pages.login.Login_Page;
import com.learning.facebook.pom.pages.inbox.Landing_Page;
import com.learning.facebook.pom.pages.inbox.MyProfile_Page;
import com.learning.pom.facebook.base.Page;
import com.learning.pom.util.TestUtil;

public class ChangePicTest 
{
	@Test
	public void changeMyPic()
	{
		Landing_Page Landingpage=null;
		if(!TestUtil.isExecutable("ChangePicTest",Page.xls1))
			throw new SkipException("Runmode set to NO");

		if(!Page.isLoggedIn)
		{
			Login_Page loginPage = new Login_Page();
			Landingpage=loginPage.doLogin();
		}
		else{
			Landingpage=Page.topMenu.goToLandingPage();
		}
		MyProfile_Page myprofile= Landingpage.gotoProfile();
		myprofile.changePic();
	}
}
