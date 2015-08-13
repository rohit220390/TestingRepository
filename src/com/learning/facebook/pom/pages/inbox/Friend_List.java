package com.learning.facebook.pom.pages.inbox;

import com.learning.pom.facebook.base.Page;

public class Friend_List extends Page
{
	
	public boolean searchFriend(String SearchFriendName)
	{
		input("friend_search_name",SearchFriendName);
		return isLinkPresent(SearchFriendName);
	}

}
