package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import testBase.DriverFactory;
import testBase.TestBase;

public class BeforeQuotePageObjects extends TestBase {

	By btn_HomeOwners = By.xpath("//p[contains(text(),'Homeowners / Dwelling Fire')]//parent::a");
	By btn_SubmissionNo = By.xpath("//label[text()='No']");
	By btn_SubmissionYes = By.xpath("//label[text()='Yes']");
	By txt_EnterSubmission = By.xpath("//input[@id='AIMSubmissionInput']");
	By txt_Add = By.xpath("//input[@id='txtAddressAutoComplete']");
	By dd_Agency = By.xpath("//select[@name='AgencyId']");
	By dd_Agent = By.xpath("//select[@id='ddlAgents']");
	By btn_Submit = By.xpath("//button[@id='submitAddress2']");
	By btn_SubmitForSubmission = By.xpath("//button[@id='SubmitSubmissionID']");
	
	
	public void navigateToQuotePage(HashMap<String, String> testData) throws Throwable {
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_HomeOwners), "btn_HomeOwners");
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_SubmissionNo), "btn_SubmissionNo");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Add), "txt_Add", testData.get("address1"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Agency), "dd_AgencyID",
				testData.get("Agency"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Agent), "dd_Agent",
				testData.get("Agent"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Submit), "btn_Submit");
		
		
		
	}
	
	public void navigateToQuotePageWithIncorrectAdd(HashMap<String, String> testData) throws Throwable {
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_HomeOwners), "btn_HomeOwners");
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_SubmissionNo), "btn_SubmissionNo");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Add), "txt_Add", testData.get("InvalidAddress"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Agency), "dd_AgencyID",
				testData.get("Agency"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Agent), "dd_Agent",
				testData.get("Agent"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Submit), "btn_Submit");
		
		
		
	}
	
	public void navigateToQuotePageWithSubNo(String subNo) throws Throwable {
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_HomeOwners), "btn_HomeOwners");
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_SubmissionYes), "btn_SubmissionYes");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_EnterSubmission), "txt_EnterSubmission",subNo);
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_SubmitForSubmission), "btn_SubmitForSubmission");
		
		
		
	}
	
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

