package com.learning.facebook.pom.pages.inbox;



import com.learning.pom.facebook.base.Page;



public class Landing_Page extends Page
{
	
	
	public MyProfile_Page gotoProfile()
	{
		click("go_to_profile");
		return new MyProfile_Page();
	}
}
