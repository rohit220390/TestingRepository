package com.learning.facebook.pom.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.learning.facebook.pages.login.Login_Page;
import com.learning.facebook.pom.pages.inbox.Friend_List;
import com.learning.facebook.pom.pages.inbox.Landing_Page;
import com.learning.facebook.pom.pages.inbox.MyProfile_Page;
import com.learning.pom.facebook.base.Page;
import com.learning.pom.util.TestUtil;

public class FindFriendTest 
{
	@Test
	public void searchFriend()
	{
		Landing_Page Landingpage=null;
		if(!TestUtil.isExecutable("FindFriendTest",Page.xls1))
			throw new SkipException("Runmode set to NO");
		if(!Page.isLoggedIn)
		{
			Login_Page loginPage = new Login_Page();
			Landingpage=loginPage.doLogin();
		}
		else{
			Landingpage=Page.topMenu.goToLandingPage();
		}
		
		MyProfile_Page profile = Landingpage.gotoProfile();
		Friend_List friendlist = profile.loadFriendList();
		friendlist.searchFriend("Rohit Gupta");
	}
}
