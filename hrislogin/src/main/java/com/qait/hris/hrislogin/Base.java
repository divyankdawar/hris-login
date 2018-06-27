package com.qait.hris.hrislogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base
{
      public WebDriver driver = null;
      public WebDriver getDriver() {
    	  System.setProperty("webdriver.chrome.driver","G:\\selenium\\hrislogin\\exefiles\\chromedriver.exe");          
		  driver = new ChromeDriver();
    	  return driver;	  	  
	}
}
