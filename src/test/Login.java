package test;


import com.learning.facebook.pages.login.Login_Page;
import com.learning.facebook.pom.pages.inbox.Friend_List;
import com.learning.facebook.pom.pages.inbox.Landing_Page;
import com.learning.facebook.pom.pages.inbox.MyProfile_Page;

public class Login {

	public static void main(String[] args) 
	{		
		Login_Page lp = new Login_Page();
		Landing_Page land_Page=lp.doLogin("rohit.220390", "Saluja2203");
		MyProfile_Page myprof_Page=land_Page.gotoProfile();
		Friend_List friends=myprof_Page.loadFriendList();
		friends.searchFriend("Rohit Gupta");
	}

}
