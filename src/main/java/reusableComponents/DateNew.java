package reusableComponents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import bsh.ParseException;
import testBase.DriverFactory;
import testBase.TestBase;

public class DateNew  extends TestBase{
	
	public void getDateExpired(String dateVal,By year, By month1) throws Throwable
	{
		//December 2, 2021
				String[] spil = dateVal.split(" ");
				String month = spil[0];
				
				String yr = spil[2].replaceAll("[\\s|\u00A0]+", "");
			
				clear_custom(DriverFactory.getInstance().getDriver().findElement(year),"");
				sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(year), "Year Entered",yr);
				System.out.println("YEAR SELECTED : " + yr);
				
				selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(month1),"Month",month);
				System.out.println("MONTH SELECTED : "+month);
				TimeUnit.SECONDS.sleep(5);
				DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[contains(@class,'flatpickr-day') and @aria-label='"+dateVal+"']")).click();
				System.out.println("Date SELECTED : "+ dateVal);
	}
	

}
