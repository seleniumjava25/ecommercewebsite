package com.eCommerce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
	WebDriver driver;
	private By firstName=By.id("first-name");
	private By lastName=By.id("last-name");
	private By codePostal=By.id("postal-code");
	private By continueBtn=By.id("continue");
	private By checkout=By.xpath("//span[contains(text(),'Checkout')]");
	private By headertext=By.className("complete-header");
	private By finishclick=By.id("finish");
	



 public CheckoutInformationPage(WebDriver driver) {
	this.driver=driver;
	}

 public void fillCheckoutInfo(String name,String last,String codep) {
	 
	    driver.findElement(firstName).sendKeys(name);
	    driver.findElement(lastName).sendKeys(last);
	    driver.findElement(codePostal).sendKeys(codep);
	    driver.findElement(continueBtn).click();
 }
 
 public String OverviewPage() {
	return driver.findElement(checkout).getText(); 
}
 
 public void clickFinish() {
	   driver.findElement(finishclick).click() ; 
}


 public String OrderSuccess() {
	    return  driver.findElement(headertext).getText();
	 
 

}}