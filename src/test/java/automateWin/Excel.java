package automateWin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Excel {
	WebDriver driver;
	Reusable reuse;
	@BeforeClass
	public void initialize(){
		reuse = new Reusable();
		driver  = reuse.invokeApplication("G:/Automation_burndown_chart.xlsx", "H:\\Softwares\\selenium\\Winium.Desktop.Driver.exe");
	}
	
	@Test
	public void initiate(){
			try {
			reuse.waitForElement(By.name("Developer"), 10);
			boolean flag = reuse.validateElementDisplayed(By.name("Developer"));
			if(flag == true){
				driver.findElement(By.name("Developer")).click();
			}
			reuse.softAssert.assertTrue(reuse.validateElementDisplayed(By.name("Developer")));
			driver.findElement(By.name("Visual Basic")).click();
			driver.close(); 
			reuse.softAssert.assertAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
