package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.DriverFactory;
import testBase.TestBase;

public class HomePageObjects extends TestBase{


	By btn_NewQuote = By.xpath("//a[@data-bs-original-title='Generate Quote']");
	By txt_UWBtn = By.xpath("//div[@class='userName']");
	By dd_Logout =By.xpath("//a[@id='logout']");
	By txt_PolNo = By.xpath("//input[@id='txtSeachApplicationNumber']");
	By btn_Search = By.xpath("//button[@id='button-addon2']");
	By btn_Can = By.xpath("//button[contains(@id,'btnCancellation')]");
	By btn_Rein = By.xpath("//button[contains(@id,'btnReinstate')]");
	By btn_End = By.xpath("//button[contains(@id,'btnEndorse')]");
	
	//click on New Quote
	public void clickOnNewQuote() throws InterruptedException {
		Thread.sleep(30000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_NewQuote), "Generate Quote");
	}
	
	public void logout() throws InterruptedException {
		Thread.sleep(30000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(txt_UWBtn), "txt_UWBtn");
		click_custom(DriverFactory.getInstance().getDriver().findElement(dd_Logout), "dd_Logout");
	}
	
	public void searchPolicy(HashMap<String, String> testData) throws InterruptedException {
		Thread.sleep(30000);
		sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(txt_PolNo),  testData.get("PolicyNo"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Search), "btn_Search");
	}
	
	public void clickOnCancelBtn() throws InterruptedException {
		Thread.sleep(15000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Can), "Can button");
	}
	
	public void clickOnReinstateBtn() throws InterruptedException {
		Thread.sleep(8000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Rein), "Reinstatement button");
	}
	
	public void validateStatus(HashMap<String, String> testData,String status) throws Throwable {
		Thread.sleep(15000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//td[contains(text(),'"+testData.get("PolicyNo")+"')]//following-sibling::td[4]")).getText().trim(), status, "Status");
	}
	
	public void clickOnEndorseBtn() throws InterruptedException {
		Thread.sleep(15000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_End), "End button");
	}
	
	
	
	
	
	
}
