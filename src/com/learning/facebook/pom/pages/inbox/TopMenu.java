package com.learning.facebook.pom.pages.inbox;

import org.openqa.selenium.By;

import com.learning.pom.facebook.base.Page;

public class TopMenu 
{
	//To Logout from application
	public void logOut()
	{
		Page.driver.findElement(By.xpath(Page.prop1.getProperty("top_menu_list"))).click();
		Page.driver.findElement(By.xpath(Page.prop1.getProperty("top_menu_logout"))).click();
	}
	
	//To Search any text on top menu
	public void Search(String SearchText)
	{
		
	}

	//To Go to Landing Page
	public Landing_Page goToLandingPage()
	{
		Page.driver.findElement(By.xpath(Page.prop1.getProperty("homepage_link"))).click();
		return new Landing_Page();
	}
}
