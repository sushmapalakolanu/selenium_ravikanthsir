package com.durgasoft.project.seleniumproject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TC_003 extends BaseTest {
	
	public static final Logger log = Logger.getLogger( TC_003.class.getName());
	  
	 @Test
	  public void amazonSearch() throws IOException
	  {
		 log.info("=========== Started TC_003 ===============");
		 openBrowser("chromebrowser");
		 log.info("Selected the browser :" +prop.getProperty("chromebrowser"));
		  navigate("amazonurl");
		  log.info("Navigated to the URL :" +prop.getProperty("amazonurl"));
		  search("amazonsearch_id","sony");
		  log.info("Searched sony by using the locator :" +prop.getProperty("amazonsearch_id"));
		clickOnElement("click_xpath");
		  log.info("Clicked on search button by using locator :" +prop.getProperty("click_xpath"));
		  log.info("=========== Ended TC_003 ===============");
	  }
}
