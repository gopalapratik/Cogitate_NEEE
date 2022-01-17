package pageObjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;

import testBase.DriverFactory;
import testBase.TestBase;

public class ReinstatementPageObjects extends TestBase {

	By sel_RequestedBy = By.xpath("//select[@id='ddlRequestedBy']//option[contains(@selected,'selected')]");
	By dd_Reason = By.xpath("//select[@id='ddlReason']");
	By txt_Remarks = By.xpath("//textarea[@id='txtReinstateNotes' or @id='txtCancellationNotes']");
	By btn_Submit = By.xpath("//a[@id='btnShowPremInfo' or @id='btnGetReinstatePremium']");
	By btn_Approve = By.xpath("//button[@id='btnApproveCancellation' or @id ='btnApproveReinstate']");
	By btn_Confirm= By.xpath("//button[text()='Yes']");
	By txt_Premium = By.xpath("//*[text()='Reinstatement Premium Information']//parent::div//h4[contains(text(),'Re-Instate')]//following-sibling::p");

	
	public void validateReinstatementDetails(HashMap<String, String> testData) throws Throwable {
		
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(sel_RequestedBy).getText(), testData.get("RequestedBy"), "Requested By");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_Remarks).getText(), testData.get("Remarks"), "Remarks");
		validateDropDownForReason(testData);
	}
	
	public void validateDropDownForReason(HashMap<String, String> testData) throws Throwable {
		
		List<String> listOfReinReason = Arrays.asList(testData.get("expReinstatementRemarks").split("\n"));
		List<String> actListOfReinReason = selectOptions_custom(
				DriverFactory.getInstance().getDriver().findElement(dd_Reason), "Rein Remarks");
		System.out.println("ExplistOfReinReason " + listOfReinReason);
		System.out.println("actListOfReinReason " + actListOfReinReason);
		assertEqualsString_custom(listOfReinReason.equals(actListOfReinReason), true, "Rein Remarks");
	}
	
	public double performReinstatement(HashMap<String, String> testData) throws Throwable {
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Reason), "Reason",testData.get("ReasonReinstatement"));
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Submit), "Submit Button");
		Thread.sleep(10000);
		double reInstatementPremium = Double.parseDouble(getText_custom(DriverFactory.getInstance().getDriver().findElement(txt_Premium), "ReinstateMent Premium").replaceAll("[^0-9.]", ""));
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Approve), "Approve Reinstatement Button");
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Confirm), "Confirm Reinstatement Button");
		return reInstatementPremium;
		
	}

}
