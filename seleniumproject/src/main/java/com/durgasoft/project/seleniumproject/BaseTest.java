package com.durgasoft.project.seleniumproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BaseTest 
{
	public static WebDriver driver;
	public static String path = "./config.properties";
	public static Properties prop;
	public static WebElement e;
	
	
/*public static String loaddata(String key) throws IOException
	
	{ 
		Properties prop = new Properties();
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);
		return prop.getProperty(key);
	}*/
	public static void openBrowser(String browser) throws IOException
	{
		if(prop == null)
		{
			prop = new Properties();
			File f = new File(path);
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
		}
		
			/*if(browser.equalsIgnoreCase("chrome"))
		{
			// System.setProperty("webdriver.chrome.driver", "C:\\Sushma\\softwares\\drivers\\chromedriver.exe");
			          // (or)
			//System.setProperty("webdriver.chrome.driver", System.getProperty("userdir")+"//drivers//chromedriver.exe");
			      //or
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "C:\\Sushma\\softwares\\drivers\\chromedriver.exe");
			// or
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			//or
			 through properties file 
			
			System.setProperty("webdriver.chrome.driver", loaddata("chromeexe"));
			driver = new ChromeDriver();
			
		}*/
		
		if(prop.getProperty(browser).equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeexe"));
			driver = new ChromeDriver();
			
		}
		
		
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	}
	public static void navigate(String url)
	
	{
		//driver.get(url);
		driver.get(prop.getProperty(url));
	}

      public void search(String locator, String value)
      {
    	 // driver.findElement(By.id(locator)).sendKeys(value);
    	 // driver.findElement(By.id(prop.getProperty(locator))).sendKeys(value);
    	  getElement(locator).sendKeys(value);
    	  
    	  
     }
      public void clickOnElement(String locator_xpath)
      {
    		//driver.findElement(By.xpath(locator_xpath)).click();
    		//driver.findElement(By.xpath(prop.getProperty(locator_xpath))).click();
    		getElement( locator_xpath).click();
    		
    	}
      public  WebElement getElement(String element)
      {
    	 // WebElement e;
    	  
    	  if(element.endsWith("_id"))
    	  {
    		  e = driver.findElement(By.id(prop.getProperty(element)));
    		  
    		  
    	  }
    	  else if(element.endsWith("_xpath"))
    	  {
    		 e = driver.findElement(By.xpath(prop.getProperty(element)));
    		  
    	  }
		return e;
    	  
    	  
    	  
		
      }



	
}
