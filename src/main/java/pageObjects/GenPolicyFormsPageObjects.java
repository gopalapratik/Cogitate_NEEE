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

public class GenPolicyFormsPageObjects extends TestBase{

	
	By btn_BindPol = By.xpath("//button[text()='Bind Policy']");
	
	
	
	public void enterUWResponse(HashMap<String, String> testData) throws Throwable {
		
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'Are any of the following true?')]"
				+ "//ancestor::div[@class='appQuesWrap']//following-sibling::div[@class='appBtnWrap']"
				+ "//label[contains(text(),'"+testData.get("UWQ2")+"')]")),"UW Question");

		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'Is any applicant considered high-profile such as politician, entertainer or professional athlete?')]"
				+ "//ancestor::div[@class='appQuesWrap']//following-sibling::div[@class='appBtnWrap']"
				+ "//label[contains(text(),'"+testData.get("UWQ3")+"')]")),"UW Question");
		
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'Is any applicant considered high-profile such as politician, entertainer or professional athlete?')]"
				+ "//ancestor::div[@class='appShow']//following-sibling::div[@class='appHide cls145']//input")), "txt_uwText", "Testing");
		
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'Coverage declined, cancelled or non-renewed during the last 3 years?')]"
				+ "//ancestor::div[@class='appQuesWrap']//following-sibling::div[@class='appBtnWrap']"
				+ "//label[contains(text(),'"+testData.get("UWQ4")+"')]")),"UW Question");
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'Any business on the premises?')]"
				+ "//ancestor::div[@class='appQuesWrap']//following-sibling::div[@class='appBtnWrap']"
				+ "//label[contains(text(),'"+testData.get("UWQ5")+"')]")),"UW Question");
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'Any existing and/or unrepaired damage to the property?')]"
				+ "//ancestor::div[@class='appQuesWrap']//following-sibling::div[@class='appBtnWrap']"
				+ "//label[contains(text(),'"+testData.get("UWQ6")+"')]")),"UW Question");
		
		
		for(int i=1;i<=Integer.parseInt(testData.get("noofclaims"));i++) {
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
		
		//click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Continue),"Continue button");
		
		
		
	}
	
	
	
}
