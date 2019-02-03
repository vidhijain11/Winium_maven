package automateWin;

import java.io.File;
import java.nio.channels.NonWritableChannelException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class EReports {

ExtentReports extent;
ExtentTest logger;

@BeforeTest()
void startTest(){
	extent= new ExtentReports("G:\\selenium eclipse\\Learn_winium\\test-output\\STMExtentReport"+ getdatetimestamp()+".html", false);
	extent.addSystemInfo("Host Name", "Learn Winium");
	extent.addSystemInfo("Environment", "Functional Testing");
	extent.loadConfig(new File("G:\\selenium eclipse\\Learn_winium\\extentReport-Config.xml"));
	
	
	 }
@Test
void passTest(){
	try {
		logger = extent.startTest("passTest"); //test name
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test case passed");
	} catch (Exception e) {
		e.getMessage();
	}
	
}
@Test
void failTest(){
	try {
		logger = extent.startTest("failTest"); //test name
		//Assert.assertTrue(false);
		logger.log(LogStatus.FAIL, "Test case fail");
	} catch (Exception e) {
		e.getMessage();
	}
	
}
@Test
void skipTest(){
	try {
		logger = extent.startTest("skipTest");
		throw new SkipException("skipping test");
	} catch (Exception e) {
		e.getMessage();
	}
	
}

@AfterMethod
void getResult(ITestResult result){
	if(result.getStatus()==ITestResult.FAILURE){
		logger.log(LogStatus.FAIL, "Test Completion");
	}
	else if(result.getStatus()==ITestResult.SUCCESS){
		logger.log(LogStatus.PASS, "Test failed");
	}
	else if(result.getStatus()==ITestResult.SKIP){
		logger.log(LogStatus.SKIP, "Test skipped");
	}
	extent.endTest(logger);
}

@AfterTest
public void endReport(){
	extent.flush();
	extent.close();
}
String getdatetimestamp(){	
	
	Date date = new Date();	
	System.out.println(date);
	SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
	String unique = sf.format(date);
	return unique;
}	
}

