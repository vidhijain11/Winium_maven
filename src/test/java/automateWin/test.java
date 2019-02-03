package automateWin;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class test {

	public static void main(String[] args) {
		WiniumDriver driver =null;
		DesktopOptions options=new DesktopOptions();
		options.setApplicationPath("G:/Automation_burndown_chart.xlsx");
		try{
			 driver= new WiniumDriver(new URL("http://loclahost:4444"),options);
			}catch(MalformedURLException e){
			e.printStackTrace();
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		driver.close();

	}

}
