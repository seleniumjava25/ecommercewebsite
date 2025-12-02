package com.eCommerce.automation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ProdectsNameTest extends BaseClass {
	
	WebDriverWait wait;
	
 
 
@Test 
 public void sortProductName() throws IOException {

	
ExtentTest test=extent.createTest("sorting the products A--->Z and Z--->A");

	String username=prop.getProperty("username");
	String password=prop.getProperty("password");
	LoginPage lg=new LoginPage(driver );
	lg.login(username,password );
	test.info("login with valid username and valis password");
	ProductNamePage productslist=new ProductNamePage(driver);
    List<WebElement> products = productslist.getProductNames();
    List<String> productNamesList = new ArrayList<>();

 for (WebElement pro : products) {
     productNamesList.add(pro.getText());
 }
System.out.println("Before Sorting:");
      System.out.println(productNamesList);
System.out.println("After Sorting (A–Z):");	      
     Collections.sort(productNamesList);
     System.out.println(productNamesList);
   test.info("you soting order successfully A to Z");  
System.out.println("After Sorting (Z-A):");	    
    Collections.reverse(productNamesList);
    System.out.println(productNamesList);
    test.info("you soting order successfully Z to A");   

	
}	
	

	 
}
	
	
	
	
	
	


