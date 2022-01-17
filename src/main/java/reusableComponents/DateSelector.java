package reusableComponents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

public class DateSelector extends TestBase{
	
	
	public void selectDate(String dateVal) throws Throwable {
		// TODO Auto-generated method stub
		String[] spil = dateVal.split(" ");
		String month = spil[0];
		String yr = spil[2].replaceAll("[\\s|\u00A0]+", "");
		/*
		* flatpickr-calendar animate open arrowTop
		* flatpickr-calendar animate showTimeInput open arrowBottom
		*/
		// xpath for Year
		By year = By.xpath("//*[contains(@class, 'flatpickr-calendar animate open')]//*[@class = 'flatpickr-months']//*[@class = 'flatpickr-month']//*[@class = 'flatpickr-current-month']//*[@class = 'numInputWrapper']//*[@class = 'numInput cur-year']");
		// xpath for Month
		By month1 = By.xpath("//*[contains(@class, 'flatpickr-calendar animate open')]//*[@class = 'flatpickr-months']//*[@class = 'flatpickr-month']//*[@class = 'flatpickr-current-month']//*[@class = 'flatpickr-monthDropdown-months']");
		// clearing the year value
		clear_custom(DriverFactory.getInstance().getDriver().findElement(year), "");
		// replacing Calendar Value
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(year), "Year Entered", yr);
		// selecting month by visible text
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(month1), "Month", month);
		TimeUnit.SECONDS.sleep(5);
		// selecting date
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[contains(@class, 'flatpickr-calendar animate open')]//*[@class = 'flatpickr-innerContainer']//*[@class = 'flatpickr-rContainer']//*[@class = 'flatpickr-days']//*[@class = 'dayContainer']//*[contains(@class,'flatpickr-day') and @aria-label='"
		+ dateVal + "']")), "Date Selected : " + dateVal);}
	
	
	
}
