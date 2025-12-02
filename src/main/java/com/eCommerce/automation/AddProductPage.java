package com.eCommerce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProductPage {
	WebDriver driver;
	private By addToCart=By.xpath("(//button[contains(text(),'Add to cart')])[1]");
	private By shoppingLink=By.className("shopping_cart_link");
	private By checkoutLink=By.id("checkout");
	
	
	public AddProductPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
public void elementToCart() {	
	driver.findElement(addToCart).click();
	driver.findElement(shoppingLink).click();
	driver.findElement(checkoutLink).click();

}
}