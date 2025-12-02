package com.eCommerce.automation;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	    protected WebDriver driver;
		private String  browserType;
		private String environment;
		protected Properties prop;
	protected  ExtentReports extent ;
	
		
		
@BeforeSuite		
	public void beforeSuite() {	
	   extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\products"+".html");
		extent.attachReporter(spark);
	
    
	}	
		
@BeforeTest	
	public void  readGlobalConfig() throws IOException {
		 prop=ConfigReader.loadProperties("eCommerce_global.properties");
		 browserType=prop.getProperty("browser");
		 environment =prop.getProperty("environment");
		 if(environment.equalsIgnoreCase("qa")){
			Properties qaprop=ConfigReader.loadProperties("eCommerce_qa.properties");
			prop.putAll(qaprop);
		 }else if(environment.equalsIgnoreCase("dev")) {
			  Properties devprop=ConfigReader.loadProperties("eCommerce_dev.properties");
			  prop.putAll(devprop);
		 }else {
			 System.out.println("the environment no found ");
		 }
			 
		 }
		
@BeforeClass	
	  public void setUp()  {
		 
	
		  switch (browserType.toLowerCase()) {

	        case "chrome":
	            ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("incognito");
	          driver= new ChromeDriver(chromeOptions);break;

	        case "edge":
	            EdgeOptions edgeOptions = new EdgeOptions();
	            driver= new EdgeDriver(edgeOptions);break;

	        case "firefox":
	            FirefoxOptions firefoxOptions = new FirefoxOptions();
	             driver=new FirefoxDriver(firefoxOptions);break;

	        default:
	            System.out.println("Invalid browser: " + browserType);
	    }
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  launchApp(prop.getProperty("baseUrl"));
		}
		  
  

public void launchApp(String url) {
	    	 driver.get(url);
	    	 
	     } 

@AfterClass
	  public void tearDown() {
	        if(driver !=null) {
		    driver.quit();
	}
}
@AfterSuite
public void afterSuite() {
	extent.flush();
}

}