// Author: Dhanashri
package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testBase.DriverFactory;
import testBase.TestBase;

public class UWPageObjects extends TestBase{

	By BreedDescription = By.xpath("//*[@id=\"id2\"]");
	By BiteHistory = By.xpath("//*[@id=\"id3\"]");
	By foottraffic = By.xpath("//*[@id=\"id8\"]");
	By LastThree = By.xpath("//*[@id=\"id10\"]");
	By btn_SaveAndContinue = By.xpath("//*[@id=\"btnSaveUWAndContinue\"]");
	
	public void enterUWResponse(HashMap<String, String> testData) throws Throwable {
		
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'Does the applicant own any Dogs?')]"
				+ "//parent::div//following-sibling::div/div//label[text()='"+testData.get("UWQ1")+"']")),"UW Question 1");
		if(testData.get("UWQ1").equals("Yes"))
		{
			assertEqualsString_custom(DriverFactory.getInstance().getDriver().
					findElement(BreedDescription).isEnabled(),true,"BreedDescription");
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(BreedDescription), "BreedDescription","BreedDescription");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver().
					findElement(BiteHistory).isEnabled(),true,"BiteHistory");
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(BiteHistory), "BiteHistory","BiteHistory");
		}
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'Does the applicant have a swimming pool?')]"
				+ "//parent::div//following-sibling::div/div//label[text()='"+testData.get("UWQ2")+"']")),"UW Question 2");

		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'Is the pool fenced with a self-locking gate?')]"
				+ "//parent::div//following-sibling::div/div//label[text()='"+testData.get("UWQ3")+"']")),"UW Question 3");
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'Is business conducted at the insured location?')]"
				+ "//parent::div//following-sibling::div/div//label[text()='"+testData.get("UWQ4")+"']")),"UW Question 4");
		if(testData.get("UWQ1").equals("Yes"))
		{
			assertEqualsString_custom(DriverFactory.getInstance().getDriver().
					findElement(By.xpath("//p[contains(text(),'Is there foot traffic?')]")).isEnabled(),true,"Is there foot traffic");
			click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'Is there foot traffic?')]"
					+ "//parent::div//following-sibling::div/div//label[text()='"+testData.get("Is there foot traffic")+"']")),"");
			if(testData.get("Is there foot traffic").equals("Yes"))
			{
				assertEqualsString_custom(DriverFactory.getInstance().getDriver().
						findElement(foottraffic).isEnabled(),true,"foottraffic");
				sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(foottraffic), "foottraffic","foottraffic");
			}
		}
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'Is there foot traffic?')]"
				+ "//parent::div//following-sibling::div/div//label[text()='"+testData.get("UWQ5")+"']")),"UW Question 5");
		Thread.sleep(1000);
		
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),"
				+ "'Has any coverage been declined, cancelled of non-renewed during the last three (3) years?')]"
				+ "//parent::div//following-sibling::div/div//label[text()='"+testData.get("UWQ6")+"']")),"UW Question 6");
		
		if(testData.get("UWQ6").equals("Yes"))
		{
			assertEqualsString_custom(DriverFactory.getInstance().getDriver().
					findElement(LastThree).isEnabled(),true,"LastThree");
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(LastThree), "LastThree","LastThree");
		}
		Thread.sleep(1000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'"
				+ "Has Applicant had a foreclosure, repossession, bankruptcy or filed for bankruptcy during the past five (5) years?')]"
				+ "//parent::div//following-sibling::div/div//label[text()='"+testData.get("UWQ7")+"']")),"UW Question 7");
		
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'"
				+ "Has Applicant had a judgement or lien during the past five (5) years?')]"
				+ "//parent::div//following-sibling::div/div//label[text()='"+testData.get("UWQ8")+"']")),"UW Question 7");
		
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'"
				+ "During the last five (5) years has any applicant been indicted for or convicted of any degree of the crime of fraud, "
				+ "bribery, arson or any other arson-related crime in connection with this or other property?')]"
				+ "//parent::div//following-sibling::div/div//label[text()='"+testData.get("UWQ9")+"']")),"UW Question 8");
	}
	public void validateUWScreenURL(HashMap<String, String> testData) throws Throwable {
		Thread.sleep(5000);
		String currenURL = DriverFactory.getInstance().getDriver().getCurrentUrl();
		System.out.println(currenURL);
		assertEqualsString_custom(currenURL,testData.get("UW Page URL"),"UW Page URL");
	}	
		
		
/*		for(int i=1;i<=Integer.parseInt(testData.get("noofclaims"));i++) {
			Thread.sleep(2000);
			click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtClaimLossDate"+i+"']//following-sibling::input")),"Claim Date");
			Thread.sleep(2000);
			click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(@class,'flatpickr-calendar animate open')]//span[@aria-label='"+testData.get("Claim Date")+"']")),"Date");
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtClaimAmount"+i+"']")), "txtClaimAmount", "1000");
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='ddlIncidentType"+i+"']")), "dd_typeOfIncident", "Fire and Lightning");
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//textarea[@id='txtClaimRemark"+i+"']")), "txt_claimRemark", "Testing"+i);
		}
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='gradBtnGroup claimed col-100 floatLft']//label[text()='"+testData.get("noOfMortgagee")+"']")),"No Of Mortgagee");

		for(int i=1;i<=Integer.parseInt(testData.get("noOfMortgagee"));i++) {
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtMortgageeName"+testData.get("noOfMortgagee")+"']")),"Name"+i,"Name"+i);
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtMailingAddress"+testData.get("noOfMortgagee")+"']")),"Add"+i,"Add"+i);
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtLoanNumber"+testData.get("noOfMortgagee")+"']")),"LoanNo"+i,"LoanNo"+i);
		}
*/		
		
	
	
	public void UWSave() throws Throwable {
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_SaveAndContinue),
				"Save And Continue Button");
	}
}
