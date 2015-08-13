package com.learning.facebook.pom.pages.inbox;

import com.learning.pom.facebook.base.Page;

public class MyProfile_Page extends Page{

	
	public void changePic()
	{
		System.out.println("Changing Profile picture");
	}
	
	
	public Friend_List loadFriendList()
	{
		click("friends_link");
		return new Friend_List();
	}
}
