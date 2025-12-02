package com.eCommerce.automation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class ProductsPricesTest extends BaseClass {
	ExtentTest test;

	

@Test	
public void  verifyPriceSorting(){
	  test=extent.createTest("sorting the price of product from hight to low and from liw to hight");
		
	String username=prop.getProperty("username");
	String password=prop.getProperty("password");
	LoginPage lg=new LoginPage(driver );
	lg.login(username,password );
	test.info("login with valid username and valid password ");
	PricePage priceProducts=new PricePage(driver);
	List<WebElement> priceElements =priceProducts.ProductsPrices();
	 ArrayList<Double> prices = new ArrayList<>();

   for (WebElement pr : priceElements) {
       String priceTxt = pr.getText().replace("$", "").trim();
       prices.add(Double.parseDouble(priceTxt));
   }
   
 System.out.println("Before sorting price ");
       System.out.println(prices);
      Collections.sort(prices);  
 System.out.println("After sorting price hight to low  "); 
      System.out.println(prices);
     test.pass("you sorting the passs with assending order"); 
      Collections.reverse(prices);
System.out.println("Sorting price low to hight  "); 
      System.out.println(prices);
      test.pass("you sorting the passs with descending order"); 
   

}



}
