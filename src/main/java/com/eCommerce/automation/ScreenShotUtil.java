package com.eCommerce.automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil extends BaseClass {

	public String captureScreenShot (String screenshotName ,WebDriver driver) throws IOException {
		
		
//Part 1 – Take screenshot as a File
TakesScreenshot tc=(TakesScreenshot) driver;

//Part 2 – Store screenshot into a File object
File srcFile = tc.getScreenshotAs(OutputType.FILE);


// 3) Define destination where screenshot will be saved
String destPath = System.getProperty("user.dir")+"\\ScreenShots\\" + screenshotName + ".png";

File destFile = new File(destPath);

// 3) Copy screenshot to the destination
FileUtils.copyFile(srcFile, destFile);

// 4) Return final path so ExtentReports can use it
return destPath;
}
}