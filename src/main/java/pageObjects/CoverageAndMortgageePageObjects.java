// Author: Dhanashri
package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import reusableComponents.DateSelector;
import reusableComponents.DateTimeUtil;
import testBase.DriverFactory;
import testBase.TestBase;

public class CoverageAndMortgageePageObjects extends TestBase {
	
	DateTimeUtil dateTimeUtil = new DateTimeUtil();
	DateSelector ds=new DateSelector();
	
	By dd_InspectionType = By.xpath("//select[@id='ddlInspectionType']");
	By dd_PLReportType = By.xpath("//select[@id='ddlPLReportType']");
	By dd_AOP = By.xpath("//select[@id='ddlAOPDeductible1']");
	By txt_CovB = By.xpath("//input[@id='txtBOtherStructure1']");
	By txt_CovC = By.xpath("//input[@id='txtCPersonalProperty1']");
	By txt_CovD = By.xpath("//input[@id='txtDLossOfUse1']");
	By dd_CovE = By.xpath("//select[@id='ddlEPersonalLiability1']");
	By dd_CovF = By.xpath("//select[@id='ddlFMedicalPayment1']");
	By dd_WBC = By.xpath("//select[@id='ddlWaterBackupCoverage1']");
	By btn_ItemizedBill = By.xpath("//button[@id='btnSchdPropModal']");
	By dd_ClassPP = By.xpath("//select[@id='ddlClass1']");
	By txt_PP = By.xpath("//input[@id='txtDescription1']");
	By txt_AOI = By.xpath("//input[@id='txtAmount1']");
	By dd_minRetPrem = By.xpath("//select[@id='ddlMinRetainPremium']");
	By dd_NoOFMortgagee = By.xpath("//select[@id='ddlNoOfMortgagee1']");
	By txt_MortName = By.xpath("//input[@id='txtMortgageeName1_1']");
	By txt_MortAdd = By.xpath("//textarea[@id='txtMailingAddress1_1']");
	By txt_LoanNumber = By.xpath("//input[@id='txtLoanNumber1_1']");
	By rad_Mortgagee = By.xpath("//input[@id='radMortIsPayee01_1']//following-sibling::label[contains(text(),'Yes')]");
	By dd_AddIns = By.xpath("//select[@id='ddlNoOfAddInsured1']");
	By dd_LossPayee = By.xpath("//select[@id='ddlNoOfLossPayee1']");
	By btn_SaveAndContinue = By.xpath("//*[@id=\"btnSaveAndContinue\"]");
	By btn_Next = By.xpath("//a[@id='btnSaveAndContinuePrHist']");
	By LossPayee= By.xpath("//*[@id=\"ddlNoOfLossPayee1\"]");
	By AddInsured= By.xpath("//*[@id=\"ddlNoOfAddInsured1\"]");
	By NoMort= By.xpath("//*[@id=\"ddlNoOfMortgagee1\"]");
	By Btn_Sproperty = By.xpath("//*[@id=\"btnSchdPropModal\"]");
	By Amount_Sproperty = By.xpath("//*[@id=\"totalAmount\"]");
	By Submit_Sproperty = By.xpath("//*[@id=\"btnScheduledPropSubmit\"]");
	By TotalAmount_Sproperty = By.xpath("//*[@id=\"txtSchdlProperty1\"]");
	By NoClaims = By.xpath("//*[@id=\"ddlNoOfClaims\"]");
	By txt_PleaseExplain = By.xpath("//*[@id='txtPropertyNotInsuredExplain']");
	
							
	//Number of claims
		public void enterPriorHistoryAndInspections(HashMap<String, String> testData) throws Throwable {
			Select Company= new Select(DriverFactory.getInstance().getDriver().findElement(NoClaims));
			Company.selectByVisibleText(testData.get("No of claims"));
			//JavascriptExecutor j = (JavascriptExecutor)DriverFactory.getInstance().getDriver();
			//j.executeScript("window.scrollBy(0,1000)");
			//DateSelector.selectDateByjs(dateval,Year, Month);
			Thread.sleep(5000);
			for (int i = 1; i <= Integer.parseInt(testData.get("No of claims")); i++) {
				Thread.sleep(5000);
				click_custom(
						DriverFactory.getInstance().getDriver().findElement(
								By.xpath("//input[@id='txtClaimLossDate" + i + "']//parent::div")),
						"Claim Date");
				Thread.sleep(5000);
				String dateval=testData.get("Claim Date "+i);
				String x="flatpickr-calendar animate open arrowTop";
				//By Year=By.xpath("/html/body/div["+j+"]/div[1]/div/div/div/input");
				//By Month=By.xpath("/html/body/div["+j+"]/div[1]/div/div/select");
				ds.selectDate(dateval);
				
			/*click_custom(DriverFactory.getInstance().getDriver().findElement(
						By.xpath("//div[contains(@class,'flatpickr-calendar animate open')]//span[@aria-label='"
								+ dateTimeUtil.getTodaysDateForClaims() + "']")),"Date");*/
				
				sendKeys_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//input[@id='txtClaimAmount" + i + "']")), "Claim Amount", testData.get("Claim Amount "+i) );
				selectDropDownByVisibleText_custom(
						DriverFactory.getInstance().getDriver()
								.findElement(By.xpath("//select[@id='ddlIncidentType" + i + "']")),
						"dd_InspectionType", testData.get("Incident "+i));
				
				sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(
						By.xpath("//textarea[@id='txtClaimRemark" + i + "']")), "Claim Desc Amount", testData.get("Claim Desc "+i));
				
				pageScroll(DriverFactory.getInstance().getDriver().findElement(
						By.xpath("//input[@id='txtClaimLossDate" + i + "']//parent::div")),"Claim Loss Date");
	}

			/*selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_InspectionType),
					"dd_InspectionType", testData.get("Inspection Type"));
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_PLReportType),
					"dd_PLReportType", testData.get("PLReport Type"));*/
			
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_PleaseExplain),"Pls Explain text","Pls Explain text");
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Next), "Next Button");
		}
		
	


	public void enterPropCoverageForMultipleLocations(HashMap<String, String> testData) throws Throwable {
		
		
		
		for(int i=1;i<=Integer.parseInt(testData.get("No of Properties"));i++) {
			Thread.sleep(5000);
			
			if(i==1) {
				if(Integer.parseInt(testData.get("No of Properties"))==1) {
					clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_SaveAndContinue),"Save & Continue Button");
				}else {
				clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[text()='Next' and @pageindex="+i+"]")),"Next Button");
				}
			}else {
				sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtBOtherStructure"+i+"']")), "Coverage B", testData.get("Coverage B"+i));
				sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtCPersonalProperty"+i+"']")), "Coverage C", testData.get("Coverage C"+i));
				sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtDLossOfUse"+i+"']")), "Coverage D", testData.get("Coverage D"+i));
				selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(
						By.xpath("//select[@id='ddlWaterBackupCoverage"+i+"']")), "ddlWaterBackupCoverage",testData.get("Water Backup"+i));
				
				clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(
						By.xpath("//div[@id='divReplacementCost"+i+"']//label[text()='"+testData.get("RC on Coverage C"+i)+"']")),"RC on Coverage C" +i);
				
				clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[text()='Save' and @pageindex="+i+"]")),"Save Button");
				try {
					clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[text()='Next' and @pageindex="+i+"]")),"Next Button");
				}catch(Exception e) {
					clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[text()='Save & Continue' and @pageindex="+i+"]")),"Save & Continue Button");
				}}}}
			//}
		
		
		



	public void MultipleMortgageeSingleProperty(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		String c=testData.get("Mortgagee").toString();
		Select Com= new Select(DriverFactory.getInstance().getDriver().findElement(NoMort));	
		Thread.sleep(2000);
		Com.selectByValue(c);
	
		for (int i = 1; i <= Integer.parseInt(testData.get("Mortgagee")) ; i++) {
			Thread.sleep(5000);
			sendKeys_custom(DriverFactory.getInstance().getDriver()
			.findElement(By.xpath("//*[@id=\"txtMortgageeName" + i +"_1"+"\"]")), "Mortgagee Name", testData.get("Mortgagee Name "+i));
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(
			By.xpath("//*[@id=\"txtMailingAddress" + i +"_1"+"\"]")), "Mortgagee Address",testData.get("Mortgagee Address "+i));
			
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//*[@id=\"txtLoanNumber" + i +"_1"+"\"]")), "Loan Number", testData.get("Loan Number "+i));
			
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(
					By.id("radMortIsPayee0"+ i +"_1")), "Yes Button");
			Thread.sleep(1000);
	}
		
	}
	public void MultipleLossPayeeSingleProperty(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		 String b=testData.get("No of Loss Payee").toString();
		Select Comp= new Select(DriverFactory.getInstance().getDriver().findElement(LossPayee));	
		Comp.selectByValue(b);
		
		for (int i = 1; i <= Integer.parseInt(testData.get("No of Loss Payee")) ; i++) {
			Thread.sleep(5000);
			sendKeys_custom(DriverFactory.getInstance().getDriver()
			.findElement(By.xpath("//*[@id=\"txtLossPayeeName" + i +"_1"+"\"]")), "Loss Payee Name",testData.get("Loss Name "+i));
			
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(
			By.xpath("//*[@id=\"txtLPMailingAddress" + i +"_1"+"\"]")), "Loss Payee Address",testData.get("Loss Address "+i));
			
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//*[@id=\"txtLossPayeeInterest" + i +"_1"+"\"]")), "Loss Payee Interest", testData.get("Loss Interest "+i));
			Thread.sleep(1000);
	}
	}

	public void MultipleAdditionalInsuredSingleProperty(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		 String a=testData.get("Additional Insured").toString();
			Select Company= new Select(DriverFactory.getInstance().getDriver().findElement(AddInsured));	
			Company.selectByValue(a);
			
		for (int i = 1; i <=Integer.parseInt(testData.get("Additional Insured")); i++) {
			Thread.sleep(3000);
			sendKeys_custom(DriverFactory.getInstance().getDriver()
			.findElement(By.xpath("//*[@id=\"txtAddInsuredName" + i +"_1"+"\"]")), "Insured Name", testData.get("Name Test "+i));
			
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(
			By.xpath("//*[@id=\"txtAIMailingAddress" + i +"_1"+"\"]")), "Mailing Address", testData.get("Address Test "+i));
			
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//*[@id=\"txtInterestType" + i +"_1"+"\"]")), "Interest Type", testData.get("Interest Test "+i));		
			Thread.sleep(1000);
	}
	}
	
	public void ValidateScheduledProperty(HashMap<String, String> testData) throws Throwable
	{
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(Btn_Sproperty), "Scheduled Property Button");
		boolean Page=DriverFactory.getInstance().getDriver().getPageSource().contains("Itemized Details");
		Assert.assertTrue(Page);
		int a=0;
		for (int i = 1; i <=Integer.parseInt(testData.get("Personal Property")); i++) {
			Thread.sleep(3000);
			
			Select Company= new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"ddlClass" + i +"\"]")));	
			Company.selectByVisibleText("Cameras");
			
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(
			By.xpath("//*[@id=\"txtDescription" + i +"\"]")), "Presonal Property description", "Property description" + i);
			
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//*[@id=\"txtAmount" + i +"\"]")), "Amount", "100");	
			a= a + Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"txtAmount" + i +"\"]")).getAttribute("value"));
			System.out.println(a);
	}
		DriverFactory.getInstance().getDriver().findElement(Amount_Sproperty).click();
		Assert.assertEquals(a,Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(Amount_Sproperty).getAttribute("value")),"Total Amount");
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(Submit_Sproperty), "Submit Button");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(TotalAmount_Sproperty).getAttribute("value"),
				DriverFactory.getInstance().getDriver().findElement(Amount_Sproperty).getAttribute("value"),"Total Amount");
}




	public void enterPropCoveragenterPropCoveragee() {
		// TODO Auto-generated method stub
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_SaveAndContinue),
				"Save And Continue Button");
		
	}

}
