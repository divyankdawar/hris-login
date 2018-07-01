package com.qait.hris.hrislogintest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qait.hris.hrislogin.Base;
import com.qait.hris.hrislogin.Loginpage;
import com.qait.hris.hrislogin.PageVerification;

public class MyTest {

	WebDriver driver;
	Loginpage obj1;
	Base select_browser;
	
	PageVerification obj2 = new PageVerification(driver);

	@BeforeClass
	public void launchBrowser() {
		Base b = new Base();
		driver = b.getDriver();
		PageVerification objj = new PageVerification(driver);
		objj.openbrowser();
	}

	@Test(priority = 0)
	public void loginUsingInvalidCredentials() {
		Loginpage obj1 = new Loginpage(driver);
		obj1.Login("fewqer", "wqwdeqwde");
		//obj2.validateInvalidlogin();
		Assert.assertTrue(obj2.driver.getCurrentUrl().contains("login"));
		System.out.println("Wrong creditional verified");
		
	}

	@Test(priority = 1)
	public void loginUsingBlankCredentials() {
		Loginpage obj2 = new Loginpage(driver);
		obj2.Login("", "");
		Assert.assertTrue(obj2.driver.getCurrentUrl().contains("login"));
		System.out.println("Blank creditional verified");
	}

	@Test(priority = 2)
	public void loginUsingCorrectUsername() {
		Loginpage obj3 = new Loginpage(driver);
		obj3.Login("divyankdawar", "12456grtg");
		Assert.assertTrue(obj3.driver.getCurrentUrl().contains("login"));
		System.out.println("Wrong creditional verified");
	}

	@Test(priority = 3)
	public void loginUsingInvalidPassword() {
		Loginpage obj4 = new Loginpage(driver);
		obj4.Login("divyankdawar", "12456grtg");
		Assert.assertTrue(obj4.driver.getCurrentUrl().contains("login"));
		System.out.println("Correct username and wrong pass verified");
	}

	@Test(priority = 4)
	public void loginUsingCorrectCredentials() {
		Loginpage obj5 = new Loginpage(driver);
		obj5.Login("divyankdawar", "Qait@123");
		Assert.assertTrue(obj5.driver.getCurrentUrl().contains("Your"));
		System.out.println("Correct username and correct pass verified");
	}
	
		@Test(priority=5)
	public void logout() {

		driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[1]/div[2]/ul/li/a")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[1]/div[2]/ul/li/ul/li[4]/a/span")).click();
		

	}
	  @Test(priority=6)
	  public void rememberMe() {
		  driver.findElement(By.cssSelector("#txtUserName")).sendKeys("divyankdawar");
		  driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Qait@123");
		  driver.findElement(By.name("txtSsi")).click();
		  driver.findElement(By.cssSelector("#txtPassword")).submit();  
		  Assert.assertEquals("https://hris.qainfotech.com:8086/empFeedback/yourFeedback", driver.getCurrentUrl());
	  } 
	  
	  //tc7 - successful login
	  @Test(priority=7)
	  public void successfulLogin() {
		  driver.findElement(By.name("txtUserName")).sendKeys("divyankdawar");
		  driver.findElement(By.name("txtPassword")).sendKeys("Qait@123");
		  driver.findElement(By.name("txtPassword")).submit();  
		  Assert.assertEquals("https://hris.qainfotech.com:8086/empFeedback/yourFeedback", driver.getCurrentUrl());
	  }
	  
	  
	  @Test(priority=8)
	  public void timeSheet_applyLeave() {
		  driver.findElement(By.className("time")).click();
		  driver.findElement(By.className("apply_leave")).click();
	  }

}

}
