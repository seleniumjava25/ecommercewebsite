package com.eCommerce.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
	WebDriver driver;
	WebDriverWait wait;
	private By  menuBy=By.xpath("//button[@id='react-burger-menu-btn']");
	private By logoutBy=By.id("logout_sidebar_link");
	


public LogoutPage(WebDriver driver ) {
	this.driver=driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

}


public void logout() {
	
	
		WebElement menuclick=driver.findElement(menuBy);
		wait.until(ExpectedConditions.elementToBeClickable(menuclick)) ;
		menuclick.click();
		wait.until(ExpectedConditions.elementToBeClickable(logoutBy));
		 driver.findElement(logoutBy).click();
		
	
}
}


