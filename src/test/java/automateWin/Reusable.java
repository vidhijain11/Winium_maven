package automateWin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.asserts.SoftAssert;

public class Reusable {
	SoftAssert softAssert;
	WiniumDriver driver = null;
	WebDriverWait wait;
	
	Reusable(){
		softAssert = new SoftAssert();
	}
	boolean validateElementDisplayed(By element){
		boolean flag = false;
		try {
			Boolean ele = driver.findElement(element).isDisplayed();
			if (ele.equals(true)){
					flag = true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
			return flag;
		
		}
		
	void waitForElement(By element, int timeSeconds){
		
		try {
			wait = new WebDriverWait(driver, timeSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.getMessage();
		}
	}
	WiniumDriver invokeApplication(String applicationPath, String winiumDriverPath){
		
		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath(applicationPath);
		File drivePath = new File(winiumDriverPath); //Set winium driver path 
	    WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(4444).withVerbose(true).withSilent(false).buildDesktopService(); 
		try {
			service.start();
			driver = new WiniumDriver(new URL("http://localhost:4444"), options);
			 driver = new WiniumDriver(service, options);
			}
		catch(IOException ioe){
			ioe.getMessage();
		}
		return driver;
	}
	

}
	
		