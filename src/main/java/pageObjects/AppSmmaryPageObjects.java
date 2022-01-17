// Author: Dhanashri
package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import reusableComponents.MethodUtil;
import testBase.DriverFactory;
import testBase.TestBase;

public class AppSmmaryPageObjects extends TestBase{
	MethodUtil methodUtil = new MethodUtil();
	By txt_finalPremium = By.xpath("//h4[text()='Policy Premium with Fees and Taxes']//parent::div//p");
	By txt_feesAndTaxes = By.xpath("//h4[text()='Fees & Taxes']//parent::li//p");
	By btn_BindReq = By.xpath("//a[text()='Complete application to submit Bind Request']");
	By btn_BindPolicy = By.xpath("//button[text()='Bind Policy']");
	By txt_HeatingUpdateYear = By.xpath("//h5[contains(text(),'Heating Update Year')]//parent::div//input");
	By btn_save = By.xpath("//*[@id=\"btnSaveDraft\"]");
	By btn_ReviewApplication = By.xpath("//a[text()='Review Application ']");
	By btn_GenPolicyForms = By.xpath("//a[text()='Generate Policy Forms']");
	By btn_SendQuote = By.xpath("//a[text()='Send Quote']");
	By btn_Adjustments = By.xpath("//a[text()='Adjustments']");
	By btn_ApplicationForm = By.xpath("//*[@id=\"btnGeneratePolicyForms\"]");
	By btn_DownloadRatesheet = By.xpath("//a[text()='Download Ratesheet']");
	By Reject = By.xpath("//*[@id=\"btnPolicyReject\"]");
	
	public void SaveDraft(HashMap<String, String> testData) throws Throwable
	{
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_save), "Save Button");
		methodUtil.validateToasterMsg(testData.get("App Toast"));
	}
	public void ReviewButtonClick()
	{
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_ReviewApplication), "Review Application");
	}
	public void AllButtonsEnabledOnScreen() throws Throwable
	{
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_ApplicationForm).isEnabled(),true,"Application Form");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_Adjustments).isEnabled(),true,"Adjustments");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_SendQuote).isEnabled(),true,"Send Quote");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_ReviewApplication).isEnabled(),true,"Review Application");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_DownloadRatesheet).isEnabled(),true,"Download Ratesheet");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(Reject).isEnabled(),true,"Reject");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_save).isEnabled(),true,"Save");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_BindReq).isEnabled(),true,"Complete application to submit Bind Request");
	}
	public void completeApp(HashMap<String, String> testData) throws Throwable {
		
//		String premiumFromUI = DriverFactory.getInstance().getDriver().findElement(finalPremium).getText();
//		System.out.println("Premium is "+ premiumFromUI);
//		String feesAndTaxesFromUI = DriverFactory.getInstance().getDriver().findElement(feesAndTaxes).getText();
//		System.out.println("Fees And Taxes are "+ feesAndTaxesFromUI);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_BindReq),"btn_BindReq");
		sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(txt_HeatingUpdateYear), testData.get("Heating Update Year"));
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_GenPolicyForms),"btn_GenPolicyForms");
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_BindPolicy),"btn_BindPolicy");
		
	}
	
	public Map<String, Double> getPremium() {
		double feesAndTaxesPremium = Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(txt_feesAndTaxes).getText().toString().replace("$", "").replace(",", ""));
		double finalPremium = Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(txt_finalPremium).getText().toString().replace("$", "").replace(",", ""));
		Map<String,Double> mapOfPremium = new HashMap<String,Double>();
		mapOfPremium.put("FeesAndTaxesPremium", feesAndTaxesPremium);
		mapOfPremium.put("FinalPremium", finalPremium);
		return mapOfPremium;
		
	}
	public void validateSummaryScreenURL(HashMap<String, String> testData) throws Throwable {
		Thread.sleep(5000);
		String currenURL = DriverFactory.getInstance().getDriver().getCurrentUrl();
		System.out.println("Summary Page"+currenURL);
		assertEqualsString_custom(currenURL,testData.get("Summary Page URL"),"Summary Page URL");
	}
	
	//https://test.cogitate.us/NEEE.POS/HO3/ApplicationSummary/Index
	public void VerifyCoveragesDetails(HashMap<String, String> testData) throws Throwable
	{
		System.out.println(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Applicant Information')]//parent::div//following-sibling::div//p[contains(text(),'Name')]//parent::div//following-sibling::div")));
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Applicant Information')]//parent::div//following-sibling::div//p[contains(text(),'Name')]//parent::div//following-sibling::div")).getText().trim(),
						testData.get("Insured Name"),"Insured Name");
		for (int i=1; i<=Integer.parseInt(testData.get("No of Properties"));i++)
		{ 
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'Coverage A - Dwelling')]//parent::div//following-sibling::div")).getText().toString().replace("$", "").replace(",", "")
				,testData.get("Coverage A"+i),"Coverage A");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'Coverage B – Other Structures')]//parent::div//following-sibling::div")).getText().toString().replace("$", "").replace(",", "")
				,testData.get("Coverage B"+i),"Coverage A");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'Coverage C – Personal Property')]//parent::div//following-sibling::div")).getText().toString().replace("$", "").replace(",", "")
				,testData.get("Coverage C"+i),"Coverage C – Personal Property");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'Coverage D - Loss of use')]//parent::div//following-sibling::div")).getText().toString().replace("$", "").replace(",", "")
				,testData.get("Coverage D"+i),"Coverage D - Loss of use");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'Coverage E - Personal Liability')]//parent::div//following-sibling::div")).getText().toString().replace("$", "").replace(",", "")
				,testData.get("Coverage E"+i),"Coverage E - Personal Liability");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'Coverage F – Medical Payments')]//parent::div//following-sibling::div")).getText().toString().replace("$", "").replace(",", "")
				,testData.get("Coverage F"+i),"Coverage F – Medical Payments");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'Replacement Cost')]//parent::div//following-sibling::div")).getText()
				,testData.get("RC on Coverage C"+i),"Replacement Cost");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'Minimum Retained Premium')]//parent::div//following-sibling::div")).getText().toString().replace("%", "")
				,testData.get("Minimum Retained Premium"+i),"Minimum Retained Premium");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'AOP Deductible')]//parent::div//following-sibling::div")).getText().toString().replace("$", "").replace(",", "")
				,testData.get("AOP"+i),"AOP Deductible");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'Wind/Hail Deductible')]//parent::div//following-sibling::div")).getText().toString().replace("$", "").replace(",", "")
				,testData.get("Wind Deductible"+i),"Wind/Hail Deductible");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().
				findElement(By.xpath("//h3[contains(text(),'Property "+i+" - Coverages')]//parent::div//following-sibling::div//p[contains(text(),'Water Deductible')]//parent::div//following-sibling::div")).getText().toString().replace("$", "").replace(",", "")
				,testData.get("Wind Deductible"+i),"Wind/Hail Deductible");
		
		}
	}
	public void ToSubmitBindRequestClick() {
		// TODO Auto-generated method stub
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_BindReq),"Complete application to submit Bind Request");
	}
	
	
}
