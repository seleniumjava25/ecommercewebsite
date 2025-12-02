package com.eCommerce.automation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class AddProductsTest extends BaseClass {
	public static ExtentTest	test;
	
	@Test
	public void checkoutinf() throws IOException {   
	   //addProductToCart() ;
		test=extent.createTest("verify checkout information");
		
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		LoginPage lg=new LoginPage(driver );
		lg.login(username,password );
	test.info("Logged in with username: " + username);
	 
	ScreenShotUtil	ScreenShotUtil=new ScreenShotUtil();
         String  screenshotPath	=ScreenShotUtil.captureScreenShot("patien login", driver);
         test.addScreenCaptureFromPath(screenshotPath,"login successfully");
		
		AddProductPage addprotocart=new AddProductPage(driver);
		addprotocart.elementToCart();
	     CheckoutInformationPage checoutInfo  = new CheckoutInformationPage(driver);
	      String firsn=prop.getProperty("name");
	      String lastn=prop.getProperty("last");
	      String codep=prop.getProperty("code");
	      
	      
	     checoutInfo.fillCheckoutInfo(firsn,lastn, codep);
	  test.addScreenCaptureFromPath(screenshotPath,"you successfully fill out the data");
	     String  expectedtext  =checoutInfo.OverviewPage();
	     String actialtext="Checkout: Overview";
	    Assert.assertEquals(actialtext,  expectedtext); 
	   test.pass("you enter information successfully");
	    checoutInfo.clickFinish();
	    String expectedMsg=checoutInfo.OrderSuccess();
	    String actualMsg="Thank you for your order!"; 
	    Assert.assertEquals(actualMsg,expectedMsg);
	    System.out.println("you have been successfully you order");
	    test.pass("successfully you order pass ");
 
	    LogoutPage  lgout=new LogoutPage(driver);
	     lgout.logout();
	    
	     String expectedtitle=driver.getTitle();
	     String actualTitle="Swag Labs";
	     Assert.assertEquals(actualTitle, expectedtitle);
	     test.pass("you logout successfully");
	    /* String currentUrl = driver.getCurrentUrl();
	     Assert.assertTrue(currentUrl.contains("login"), "Logout failed!");*/
	 
	    String logout=ScreenShotUtil.captureScreenShot(" patient logout ", driver);
                   test.addScreenCaptureFromPath(logout, "logout successfully");
	}
	
}
	 	
		
		 
		 

