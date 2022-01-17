package reusableComponents;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import testBase.DriverFactory;
import testBase.TestBase; 

public class DateTimeUtil  extends TestBase  {
	
	By txt_Year = By.xpath("//input[@class='numInput cur-year']");
	By dd_Month = By.xpath("//select[@class='flatpickr-monthDropdown-months']");
	
	
	
	public String getTodaysDateForClaims() {
		
//		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");  
//		  LocalDateTime now = LocalDateTime.now(); 
//		  Date date = new Date();
//	      System.out.println(dtf.format((TemporalAccessor) date));  
		  
	      DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

	      Date date = new Date();
	      return dateFormat.format(date); 
	      
		
	}
	
	public String getDateInCancellationFormat(String cancellationDate) throws ParseException {
		 DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
		 DateFormat reqFormat = new SimpleDateFormat("MMMM dd, yyyy");
		 
		 System.out.println("Required Format is "+ reqFormat.format(inputFormat.parse(cancellationDate)));
		 return reqFormat.format(inputFormat.parse(cancellationDate));
		 
		
	}
	
	public String getDateInEndPageForPolicyEffectiveAndExpirationDate(String endDate) throws ParseException {
		 DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		 DateFormat reqFormat = new SimpleDateFormat("MM/dd/yyyy");
		 
		 System.out.println("Required Format is "+ reqFormat.format(inputFormat.parse(endDate)));
		 return reqFormat.format(inputFormat.parse(endDate));
		 
		
	}
	
	public void selectDateFromCalendar(String dateVal) throws Throwable
	{
		String[] splitDate = dateVal.split(" ");
		
		String month = splitDate[0];
		String day =  splitDate[1].replaceAll("[^0-9]", "");
		String year = splitDate[2];
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Year), "Year Entered",year);
		Thread.sleep(2000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Month),"Month",month);
		Thread.sleep(2000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[@class='flatpickr-day ' and text()="+day+"]")), day);
	}
	
	
	
	/*public void selectDate(String dateVal, String CalenderAnimateOpenFirstClassAttribute) throws Throwable {
		// CalenderAnimateOpenFirstClass is the first class of the opened calendar, this
		// is setting as a a variable because flatpickr calendar has some different
		// class while opening.

		// Format should be December 2, 2021
		String[] spil = dateVal.split(" ");
		String month = spil[0];
		String yr = spil[2].replaceAll("[\\s|\u00A0]+", "");

		
		* flatpickr-calendar animate open arrowTop
		* flatpickr-calendar animate showTimeInput open arrowBottom
		

		// xpath for Year
		By year = By.xpath("//*[@class = '" + CalenderAnimateOpenFirstClassAttribute
		+ "']//*[@class = 'flatpickr-months']//*[@class = 'flatpickr-month']//*[@class = 'flatpickr-current-month']//*[@class = 'numInputWrapper']//*[@class = 'numInput cur-year']");
		// xpath for Month
		By month1 = By.xpath("//*[@class = '" + CalenderAnimateOpenFirstClassAttribute
		+ "']//*[@class = 'flatpickr-months']//*[@class = 'flatpickr-month']//*[@class = 'flatpickr-current-month']//*[@class = 'flatpickr-monthDropdown-months']");
		// clearing the year value
		clear_custom(DriverFactory.getInstance().getDriver().findElement(year), "");
		// replacing Calendar Value
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(year), "Year Entered", yr);
		// selecting month by visible text
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(month1), "Month", month);
		TimeUnit.SECONDS.sleep(2);
		// selecting date
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class = '"
		+ CalenderAnimateOpenFirstClassAttribute
		+ "']//*[@class = 'flatpickr-innerContainer']//*[@class = 'flatpickr-rContainer']//*[@class = 'flatpickr-days']//*[@class = 'dayContainer']//*[contains(@class,'flatpickr-day') and @aria-label='"
		+ dateVal + "']")), "Date Selected : " + dateVal);



		}*/

}
