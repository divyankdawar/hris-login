package com.qait.hris.hrislogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage extends Base {

	public Loginpage(WebDriver driver) {
		this.driver = driver;

	}

	By UserName = By.id("txtUserName");
	By Password = By.id("txtPassword");

	By sub = By.name("Submit");
	By tab = By.className("active");

	public void Login(String user, String Pass) {
		driver.findElement(tab).click();
		driver.findElement(UserName).sendKeys(user);
		driver.findElement(Password).sendKeys(Pass);
		driver.findElement(sub).click();

	}
}
