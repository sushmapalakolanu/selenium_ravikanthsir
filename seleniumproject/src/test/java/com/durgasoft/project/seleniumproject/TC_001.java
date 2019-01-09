package com.durgasoft.project.seleniumproject;

import java.io.IOException;

import org.testng.annotations.Test;

@Test
public class TC_001 extends BaseTest {
  public void f() throws IOException 
  {
	   openBrowser("CHROME");
	  navigate("http://www.amazon.in");
	  search("twotabsearchtextbox","sony");
	clickOnElement("//input[@value='Go']");
	    }


}


