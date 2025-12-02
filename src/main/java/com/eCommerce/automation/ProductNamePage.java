package com.eCommerce.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductNamePage {
	WebDriver driver;
   private By productNames = By.className("inventory_item_name");

	   
   
   public ProductNamePage(WebDriver driver) {
	        this.driver = driver;
	    }
   
   
// Return product names as List<String>
   public List<WebElement> getProductNames() {
	   
	   return driver.findElements(productNames);
	   }
	   
}