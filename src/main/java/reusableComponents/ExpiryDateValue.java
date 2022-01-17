// Author: Dhanashri
package reusableComponents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import bsh.ParseException;
import testBase.DriverFactory;
import testBase.TestBase;

public class ExpiryDateValue extends TestBase{
	
/*	public void selectDateByjs(String dateVal,By year, By month1) throws Throwable
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
		TimeUnit.SECONDS.sleep(8);
		
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[contains(@class,'flatpickr-day') and @aria-label='"+dateVal+"']")).click();
		System.out.println("Date SELECTED : "+ dateVal);
	}*/
	public String ChangeFormatOfDate(String cancellationDate){
		  String[] strArray = cancellationDate.split(" ",3);

		String result = dateParser(strArray[0]);
		System.out.println(result+"previous");
		
		if(result.length() ==1)
		{
			String appendA = "0";
		 result+=appendA;
		}
		
		System.out.println(result+ "New");
		
	
		
		return result +"/"+strArray[1].replace(",","")+"/"+strArray[2];
}
	public static String dateParser(String str)
	{
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("December", "12");
    map.put("November", "11");
    map.put("October", "10");
    map.put("September", "09");
    map.put("August", "08");
    map.put("July", "07");
    map.put("June", "06");
    map.put("May", "05");
    map.put("April", "04");
    map.put("March", "03");
    map.put("February", "02");
    map.put("January", "01");
	return map.get(str);
}
}