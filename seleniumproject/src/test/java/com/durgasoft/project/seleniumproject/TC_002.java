package com.durgasoft.project.seleniumproject;

import java.io.IOException;

import org.testng.annotations.Test;

public class TC_002 extends BaseTest
{
  @Test
  public void f() throws IOException
  {
	  
	  openBrowser("chromebrowser");
	  navigate("amazonurl");
	  search("amazonsearch_id","sony");
	clickOnElement("click_xpath");
  }
}
 