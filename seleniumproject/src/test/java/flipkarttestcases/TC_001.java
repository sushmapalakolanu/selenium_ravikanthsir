package flipkarttestcases;

import java.io.IOException;

import org.testng.annotations.Test;

import flipkart.BaseTest;

public class TC_001  extends BaseTest
{
  
	@Test
  public void f() throws IOException 
  {
		openBrowser("chrome");
		navigate("http://www.flipkart.com");
         text("q","selenium");
        handle("/html/body/div[2]/div/div/button");
		serach("//button[@type='submit']");
  }
}

	
