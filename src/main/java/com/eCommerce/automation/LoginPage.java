package com.eCommerce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	private By usernameBy=By.xpath("//input[@id='user-name']");
	private By passwordBy=By.xpath("//input[@id='password']");
	private By loginBy=By.xpath("//input[@id='login-button']");
	
	
	
	
	public LoginPage( WebDriver driver) {
		this.driver=driver;
	
	}	
	
	 
	
	
	
	 public void login(String standard_user,String secret_sauce ) {
		 //setUp();
		  driver.findElement(usernameBy).sendKeys("standard_user");
		  driver.findElement(passwordBy).sendKeys("secret_sauce");
		  driver.findElement(loginBy).click();
		  
	  }

}
