package com.qait.hris.hrislogin;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageVerification extends Base {
	public PageVerification (WebDriver driver) {
		this.driver =driver;
	}
	public void openbrowser() {
		driver.get("https://hris.qainfotech.com/login.php");
		String pagetitle =driver.getTitle();
		System.out.println(driver);
		
		Assert.assertEquals("HRIS Login",pagetitle);
		System.out.println("page verified");
		
	}
	
	public void validateInvalidlogin(){
		WebElement invalidLoginMessage = driver.findElement(By.xpath("//div[contains(@class,'loginTxt')/div]"));
		Assert.assertTrue(invalidLoginMessage.getText().contains("Invalid Login"));
		
	}

}
