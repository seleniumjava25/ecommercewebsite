package com.eCommerce.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PricePage {
	WebDriver driver;
	private By productPrices=By.className("inventory_item_price");
	
	 public PricePage( WebDriver driver) {
		 this.driver=driver;
	 }
	
public List<WebElement> ProductsPrices() {
	
	return driver.findElements(productPrices);
}
}