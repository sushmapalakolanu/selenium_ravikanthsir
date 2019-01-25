package flipkarttestcases;

import java.io.IOException;

import org.testng.annotations.Test;

import flipkart.BaseTest;

public class TC_002 extends BaseTest {
  @Test
 
  public void f() throws IOException 
  {
	  
	     openBrowser("chromebrowser");
		 navigate("flipkarturl");
         text("locator_name","selenium");
         handle("locator_xpath");
	 	serach("search_button_xpath");
	 	///html/body/div[2]/div/div/button
  }
}
