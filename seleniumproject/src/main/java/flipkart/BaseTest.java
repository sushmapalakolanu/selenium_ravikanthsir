package flipkart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BaseTest 
{
	public static WebDriver driver;
	public static String path = "./data.properties";
	public static Properties p;
	public static WebElement e;
	
	
	/*public static String loaddata(String exe) throws IOException
	{
		Properties p = new Properties();
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		p.load(fis);
		return p.getProperty(exe);
	}*/
	
	public static void openBrowser( String browser) throws IOException
	{
		if(p == null)
		{
			 p = new Properties();
			File f = new File(path);
			FileInputStream fis = new FileInputStream(f);
			p.load(fis);
			
		}
		/*if(browser.equalsIgnoreCase("CHROME"))
		{
			// static path local path
			System.setProperty("webdriver.chrome.driver", "C:\\Sushma\\softwares\\drivers\\chromedriver.exe");
			//dynamic path
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			//dynamic path
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver =new ChromeDriver();
			//dynamic path_environment variables
			//through propertie files
			//System.setProperty("webdriver.chrome.driver", loaddata("chromeexe") );
			//driver = new ChromeDriver();
		
		}*/
		if(p.getProperty(browser).equalsIgnoreCase("CHROME"))
		{
		System.setProperty("webdriver.chrome.driver", p.getProperty("chromeexe") );
		driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	public static  void navigate(String url) 
	{
		driver.get(p.getProperty(url));
		
	}
	
	public static void text(String elelocator_name, String value) 
	{
		//driver.findElement(By.name(p.getProperty(elelocator_name))).sendKeys((value));
		getElement(elelocator_name).sendKeys(value);
		
		
	}
	public static void handle(String elelocator_xpath)
	{
		//driver.findElement(By.xpath(p.getProperty(elelocator_xpath))).click();
		getElement(elelocator_xpath).click();
		
		
		
	}
    public static void serach(String search_xpath) 
	
	{
		//driver.findElement(By.xpath(p.getProperty(search_xpath))).click();
    	getElement(search_xpath).click();
		
		
		
	}
    public static  WebElement getElement( String element )
    {
    	if(element.endsWith("_name"))
    	{
   		  e = driver.findElement(By.name(p.getProperty(element)));
   		  
   		  
   	  }
   	  else if(element.endsWith("_xpath"))
   	  {
   		 e = driver.findElement(By.xpath(p.getProperty(element)));
   		  
   	  }
   	  return e;
    }

}
