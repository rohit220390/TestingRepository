package com.learning.pom.facebook.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.learning.facebook.pom.pages.inbox.TopMenu;
import com.learning.pom.util.Xls_Reader;

public class Page {
	public static WebDriver driver = null;
	public static Xls_Reader xls1 = new Xls_Reader(System.getProperty("user.dir")+"/src/testdata/testCases.xlsx");
	public static TopMenu topMenu=null ;
	public static Properties prop = null;
	public static Properties prop1 = null;
	FileInputStream fl,f2;
	public static boolean isLoggedIn;


	public Page() {

		if (driver == null) {
			prop = new Properties();
			prop1=new Properties();
			try {
				fl = new FileInputStream(System.getProperty("user.dir")+ "/src/com/learning/pom/facebook/properties/config.properties");

				prop.load(fl);

				f2 = new FileInputStream(System.getProperty("user.dir")+ "\\src\\com\\learning\\pom\\facebook\\properties\\gui.properties");
				prop1.load(f2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			topMenu = new TopMenu();

		}
	}

	public void click(String xpathkey) {
		try {
			driver.findElement(By.xpath(prop1.getProperty(xpathkey))).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void input(String xpathkey, String text) {
		try {
			driver.findElement(By.xpath(prop1.getProperty(xpathkey))).sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isElementPresent(String xpath) {
		try {
			driver.findElement(By.xpath(prop1.getProperty(xpath)));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isLinkPresent(String xpath)
	{
		try {
			driver.findElement(By.linkText(prop1.getProperty(xpath)));
		} catch (Exception e) {
			return false;
		}
		return true;	
	}

	public static void takeScreenShot(String fileName) {
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"/Screenshots/"+fileName));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
