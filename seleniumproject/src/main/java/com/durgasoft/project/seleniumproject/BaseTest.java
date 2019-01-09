package com.durgasoft.project.seleniumproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BaseTest 
{
	public static WebDriver driver;
	public static String path = "./config.properties";
	   
	
public static String loaddata(String key) throws IOException
	
	{ 
		Properties prop = new Properties();
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);
		return prop.getProperty(key);
		
				
		
		
	}
	public static void openBrowser(String browser) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			// System.setProperty("webdriver.chrome.driver", "C:\\Sushma\\softwares\\drivers\\chromedriver.exe");
			          // (or)
			//System.setProperty("webdriver.chrome.driver", System.getProperty("userdir")+"//drivers//chromedriver.exe");
			      //or
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "C:\\Sushma\\softwares\\drivers\\chromedriver.exe");
			// or
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			//or
			/* through properties file */
			
			System.setProperty("webdriver.chrome.driver", loaddata("chrome_exe"));
			driver = new ChromeDriver();
			
		}
	}
	public static void navigate(String url)
	{
		driver.get(url);
	}

      public void search(String locator, String value)
      {
    	  driver.findElement(By.id(locator)).sendKeys(value);
     }
      public void clickOnElement(String locator_xpath)
      {
    		driver.findElement(By.xpath(locator_xpath)).click();
    		
    	}



	
}
