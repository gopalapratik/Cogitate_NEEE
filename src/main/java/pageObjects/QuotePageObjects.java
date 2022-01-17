package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusableComponents.MethodUtil;
import testBase.DriverFactory;
import testBase.TestBase;

public class QuotePageObjects extends TestBase {
	
	By txt_insuredName = By.xpath("//input[@id='txtInsuredName']");
	By dd_FormType = By.xpath("//select[@id='ddlFormType']");
	By dd_OccupancyType = By.xpath("//select[@id='ddlOccupancyType']");
	By dd_PolicyTerm = By.xpath("//select[@id='ddlPolicyTerm']");
	By dd_noOfFamilies = By.xpath("//select[@id='ddlNoFamily']");
	By dd_ProtClass = By.xpath("//select[@id='ddlProtectionClass']");
	By txt_yearBuilt = By.xpath("//input[@id='txtYearHomeBuild']");
	By txt_sqft = By.xpath("//input[@id='txtSquareFeet']");
	By txt_noOfAcres = By.xpath("//input[@id='txtNoAcres']");
	By dd_DTC = By.xpath("//select[@id='ddlDistToCoast']");
	By txt_CurrentValue = By.xpath("//input[@id='txtCurrValue']");
	By txt_BuildingImproveValue = By.xpath("//input[@id='txtImproveBuild']");
	By txt_DwellingAmt = By.xpath("//input[@id='txtDwelling']");
	By txt_CoverageB = By.xpath("//input[@id='txtCovB']");
	By txt_CoverageC = By.xpath("//input[@id='txtCovC']");
	By txt_CoverageD = By.xpath("//input[@id='txtCovD']");
	By dd_CoverageE = By.xpath("//select[@id='ddlCovE']");
	By dd_CoverageF = By.xpath("//select[@id='ddlCovF']");
	By dd_RepCost = By.xpath("//select[@id='ddlReplacementCost']");
	By dd_TheftOfBuildingMaterials = By.xpath("//select[@id='ddlTheftOfBuildingMaterials']");
	By dd_WBC = By.xpath("//select[@id='ddlWaterBackup']");
	By dd_AOP = By.xpath("//select[@id='ddlAOPDeductible']");
	By dd_InspectionReq = By.xpath("//select[@id='ddlInspectionType']");
	By dd_PLReportType = By.xpath("//select[@id='ddlPLReportType']");
	By btn_RecalculatePremium = By.xpath("//a[text()='Re-Calculate Premium']");
	By btn_GetIndication = By.xpath("//input[@id='btnGetQuote']");
	By btn_ProceedToFormalQuote = By.xpath("//a[text()='Proceed to Formal Quote']");
	By txt_LocPremium = By.xpath("//p[text()='Basic Premium']//preceding-sibling::div");
	By txt_FeesAndTaxes = By.xpath("//p[text()='Fees and Taxes']//preceding-sibling::div");
	By txt_FinalPremium = By.xpath("//h4[contains(text(),'Premium Indication')]//following-sibling::p");
	By dd_hdnFormType = By.xpath("//input[@id='hdnFormType']");
	By dd_hdnPolicyTerm = By.xpath("//input[@id='hdnPolicyTerm']");
	By dd_hdnOccupancyType = By.xpath("//input[@id='hdnOccupancyType']");
	By dd_hdnProtectionClass = By.xpath("//input[@id='hdnProtectionClass']");
	By dd_hdnNoofFamilies = By.xpath("//input[@id='hdnNoofFamilies']");
	By dd_hdnDistancetoCoast = By.xpath("//input[@id='hdnDistancetoCoast']");
	By dd_hdnCovE = By.xpath("//input[@id='hdnCovE']");
	By dd_hdnCovF = By.xpath("//input[@id='hdnCovF']");
	By dd_hdnReplacement = By.xpath("//input[@id='hdnReplacement']");
	By rad_no_CentralFire = By.xpath("//input[@id='radCentralfire1']");
	By rad_no_CentralBurglar = By.xpath("//input[@id='radBurglarAlarm1']");
	By dd_hdnAOPDeductible = By.xpath("//input[@id='hdnAOPDeductible']");
	By btn_SendQuote = By.xpath("//a[@class='sendQuote ']");
	By txt_EmailId = By.xpath("//input[@id='txtEmailID']");
	By btn_Send = By.xpath("//button[text()='Send']");
	By btn_Cancel = By.xpath("//input[@value='Cancel']");
	By txt_SubmissionNo = By.xpath("//h2[contains(text(),'Submission')]");
	By dd_WaterDed = By.xpath("//select[@id='ddlWaterDeductible']");
	By dd_WindHailDed = By.xpath("//select[@id='ddlWindHailDeductible']");
	
	
	
	
	MethodUtil methodUtil = new MethodUtil();
	
	public void enterQuoteDetails(HashMap<String, String> testData) throws Throwable {
	
	
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_insuredName), "txt_insuredName", testData.get("Insured Name"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_FormType), "dd_FormType",
				testData.get("Form Type"));
		Thread.sleep(5000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_OccupancyType), "dd_OccupancyType",
				testData.get("Occupancy"));
		Thread.sleep(5000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_PolicyTerm), "dd_PolicyTerm",
				testData.get("Policy Term"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_noOfFamilies), "dd_noOfFamilies",
				testData.get("No Of Families1"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_ProtClass),"dd_ProtClass",
				testData.get("Prot Class1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_yearBuilt), "txt_yearBuilt", testData.get("Year Built1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_sqft), "txt_sqft", testData.get("Square Feet1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_noOfAcres), "txt_noOfAcres", testData.get("No Of Acres1"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_DTC), "dd_DTC",
				testData.get("DTC1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_DwellingAmt), "txt_DwellingAmt", testData.get("Coverage A1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CurrentValue), "txt_CurrentValue", testData.get("Current Value1"));
		Thread.sleep(5000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_BuildingImproveValue), "txt_BuildingImproveValue", testData.get("Building Improve Value1"));
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(
				By.xpath("//input[contains(@id,'radCentralfire')]//following-sibling::label[text()='"+
		testData.get("Central Station Burglar and/or Fire Credit1")+"']")),"Central Fire");
		Thread.sleep(5000);
/*		click_custom(DriverFactory.getInstance().getDriver().findElement(
				By.xpath("//input[contains(@id,'radBurglarAlarm')]//following-sibling::label[text()='"+
		testData.get("Central Station Burglar and/or Fire Credit")+"']")),"Central Burglar");*/
		click_custom(DriverFactory.getInstance().getDriver().findElement(
				By.xpath("//input[contains(@id,'noofClaims')]//following-sibling::label[text()='"+
		testData.get("No of claims")+"']")),"No of claims");
		Thread.sleep(5000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_GetIndication),"Indication button");
		
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageB), "txt_CoverageB", testData.get("Coverage B1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageC), "txt_CoverageC", testData.get("Coverage C1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageD), "txt_CoverageD", testData.get("Coverage D1"));
		selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_CoverageE), "dd_CoverageE",
				testData.get("Coverage E1"));
		selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_CoverageF), "dd_CoverageF",
				testData.get("Coverage F1"));
		selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_TheftOfBuildingMaterials), "dd_TheftOfBuildingMaterials",
				testData.get("Theft of Building Materials1"));
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_RepCost), "dd_RepCost",
					testData.get("RC on Coverage C1"));
			selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_WBC), "dd_WBC",
				testData.get("Water Backup1"));
		selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_AOP), "dd_AOP",
				testData.get("AOP1"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_InspectionReq), "dd_InspectionReq",
				testData.get("Inspection Fee"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_PLReportType), "dd_PLReportType",
				testData.get("PL Report Type"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium),"Recalculate Premium button");
		Thread.sleep(5000);
	
		
	}
	
	public void clickOnFormalQuote() {
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_ProceedToFormalQuote),"btn_ProceedToFormalQuote");
	}
	
	public Map<String, Double> getPremium() {
		double locPremium = Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(txt_LocPremium).getText().replace("$", "").replace(",", ""));
		double feesAndTaxesPremium = Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(txt_FeesAndTaxes).getText().toString().replace("$", "").replace(",", ""));
		double finalPremium = Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(txt_FinalPremium).getText().toString().replace("$", "").replace(",", ""));
		
		Map<String,Double> mapOfPremium = new HashMap<String,Double>();
		mapOfPremium.put("LocationPremium", locPremium);
		mapOfPremium.put("FeesAndTaxesPremium", feesAndTaxesPremium);
		mapOfPremium.put("FinalPremium", finalPremium);
		return mapOfPremium;
		
	}
	
	public void validateQuoteScreenURL(HashMap<String, String> testData) throws Throwable {
		Thread.sleep(5000);
		String currenURL = DriverFactory.getInstance().getDriver().getCurrentUrl();
		System.out.println(currenURL);
		assertEqualsString_custom(currenURL,testData.get("Quote Page URL"),"Quote Page URL");
	}
	
	
	public void validateCovMsgs(HashMap<String, String> testData) throws Throwable {
		fillBasicDetailsOnQuotePage(testData);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageB), "txt_CoverageB", testData.get("Coverage B1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageC), "txt_CoverageC", testData.get("Coverage C1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageD), "txt_CoverageD", testData.get("Coverage D1"));
		selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_CoverageE), "dd_CoverageE",
				testData.get("Liability"));
		selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_CoverageF), "dd_CoverageF",
				testData.get("Coverage F"));
		selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_TheftOfBuildingMaterials), "dd_TheftOfBuildingMaterials",
				testData.get("Theft of Building Materials"));
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_RepCost), "dd_RepCost",
					testData.get("RC on Coverage C1"));
			selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_WBC), "dd_WBC",
				testData.get("Water Backup"));
		selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_AOP), "dd_AOP",
				testData.get("AOP"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_InspectionReq), "dd_InspectionReq",
				testData.get("Inspection Fee"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_PLReportType), "dd_PLReportType",
				testData.get("PL Report Type"));
		
		
		
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageB), "txt_CoverageB", testData.get("Coverage B1 Updated"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium),"Recalculate Premium button");
		methodUtil.validateToasterMsg(testData.get("Cov B Msg"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageB), "txt_CoverageB", testData.get("Coverage B1"));
		
		
		
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageC), "txt_CoverageC", testData.get("Coverage C1 Updated"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium),"Recalculate Premium button");
		methodUtil.validateToasterMsg(testData.get("Cov C Msg"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageC), "txt_CoverageC", testData.get("Coverage C1"));
		
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageD), "txt_CoverageD", testData.get("Coverage D1 Updated"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium),"Recalculate Premium button");
		methodUtil.validateToasterMsg(testData.get("Cov D Msg"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageD), "txt_CoverageD", testData.get("Coverage D1"));
		
		selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_CoverageE), "dd_CoverageE",
				testData.get("Liability Updated"));
		Thread.sleep(5000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium),"Recalculate Premium button");
		methodUtil.validateToasterMsg(testData.get("Cov E Msg"));
		selectDropDownByValue_custom(DriverFactory.getInstance().getDriver().findElement(dd_CoverageE), "dd_CoverageE",
				testData.get("Liability"));
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium),"Recalculate Premium button");
		
		clickOnFormalQuote();
		
		
	}
	
	public void validateAmountField(HashMap<String, String> testData) throws Throwable {
		Thread.sleep(5000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_insuredName), "txt_insuredName", testData.get("Insured Name"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_FormType), "dd_FormType",
				testData.get("Form Type"));
		Thread.sleep(5000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_OccupancyType), "dd_OccupancyType",
				testData.get("Occupancy"));
		Thread.sleep(5000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_CurrentValue).isDisplayed(),false,"Current Value");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_BuildingImproveValue).isDisplayed(),false,"Building Value");
		
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_OccupancyType), "dd_OccupancyType",
				testData.get("Updated Occupancy1"));
		Thread.sleep(5000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_CurrentValue).isDisplayed(),true,"Current Value");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_BuildingImproveValue).isDisplayed(),true,"Building Value");
		
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_OccupancyType), "dd_OccupancyType",
				testData.get("Updated Occupancy2"));
		Thread.sleep(5000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_CurrentValue).isDisplayed(),true,"Current Value");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_BuildingImproveValue).isDisplayed(),true,"Building Value");
		
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CurrentValue), "txt_CurrentValue", testData.get("Current Value1"));
		Thread.sleep(5000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_BuildingImproveValue), "txt_BuildingImproveValue", testData.get("Building Improve Value1"));
		
		
	}
	
	public void validateDefaultValuesOfBasicProperty() throws Throwable {
		
		//Policy Term commented by Dhanashri.. beacause it is not retriving null
		
		Thread.sleep(5000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_insuredName).getAttribute("value"),"","txt_insuredName");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_hdnFormType).getAttribute("value"),"","dd_hdnFormType");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_OccupancyType).getAttribute("value"),"","dd_OccupancyType");
		//assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_hdnPolicyTerm).getAttribute("value"),"","dd_hdnPolicyTerm");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_noOfFamilies).getAttribute("value"),"","dd_noOfFamilies");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_hdnProtectionClass).getAttribute("value"),"","dd_hdnProtectionClass");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_yearBuilt).getAttribute("value"),"","txt_yearBuilt");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_sqft).getAttribute("value"),"","txt_sqft");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_noOfAcres).getAttribute("value"),"","txt_noOfAcres");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_hdnDistancetoCoast).getAttribute("value"),"","dd_hdnDistancetoCoast");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_DwellingAmt).getAttribute("value"),"","txt_DwellingAmt");
		
	
	}
	
	public void validateSecurityDetails() throws Throwable {
		
		Thread.sleep(5000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(rad_no_CentralFire).getAttribute("checked"),"true","rad_no_CentralFire");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(rad_no_CentralBurglar).getAttribute("checked"),"true","rad_no_CentralBurglar");
		
	}
	
	public void validateDefaultAOP(HashMap<String, String> testData) throws Throwable{
		
		fillBasicDetailsOnQuotePage(testData);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_hdnAOPDeductible).getAttribute("value"),"1000","dd_hdnAOPDeductible");
	}
	
	public void fillBasicDetailsOnQuotePage(HashMap<String, String> testData) throws Throwable {
		
		Thread.sleep(5000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_insuredName), "txt_insuredName", testData.get("Insured Name"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_FormType), "dd_FormType",
				testData.get("Form Type"));
		Thread.sleep(5000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_OccupancyType), "dd_OccupancyType",
				testData.get("Occupancy"));
		Thread.sleep(5000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_PolicyTerm), "dd_PolicyTerm",
				testData.get("Policy Term"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_noOfFamilies), "dd_noOfFamilies",
				testData.get("No Of Families1"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_ProtClass),"dd_ProtClass",
				testData.get("Prot Class1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_yearBuilt), "txt_yearBuilt", testData.get("Year Built1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_sqft), "txt_sqft", testData.get("Square Feet1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_noOfAcres), "txt_noOfAcres", testData.get("No Of Acres1"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_DTC), "dd_DTC",
				testData.get("DTC1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_DwellingAmt), "txt_DwellingAmt", testData.get("Coverage A1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CurrentValue), "txt_CurrentValue", testData.get("Current Value1"));
		Thread.sleep(5000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_BuildingImproveValue), "txt_BuildingImproveValue", testData.get("Building Improve Value1"));
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(
				By.xpath("//input[contains(@id,'radCentralfire')]//following-sibling::label[text()='"+
		testData.get("Central Station Burglar and/or Fire Credit1")+"']")),"Central Fire");
		Thread.sleep(5000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(
				By.xpath("//input[contains(@id,'noofClaims')]//following-sibling::label[text()='"+
		testData.get("No of claims")+"']")),"No of claims");
		Thread.sleep(5000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_GetIndication),"Indication button");
		
		
	}
	
	public void validateFinalPremiumText() throws Throwable {
		Thread.sleep(5000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_FinalPremium).isDisplayed(),true,"txt_FinalPremium");
	}
	
	public void validateSendQuote(HashMap<String, String> testData) throws Throwable {
		Thread.sleep(7000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_SendQuote),"btn_SendQuote");
		Thread.sleep(5000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_Send).isDisplayed(),true,"btn_Send");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_Cancel).isDisplayed(),true,"btn_Cancel");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_EmailId).getAttribute("value"),"testagent@test.com","txt_EmailId");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_EmailId), "txt_EmailId", testData.get("email"));
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Send),"btn_Send");
		methodUtil.validateToasterMsg(testData.get("Send Quote Toaster Msg"));
	}
	
	public void validatedefaultCovCalculations(HashMap<String, String> testData) throws Throwable {
		Thread.sleep(7000);
		double covA = Double.parseDouble(testData.get("Coverage A1"));
		double expCovB = covA * 0.1 ;
		double expCovC = covA * 0.5;
		double expCovD = covA * 0.1;
		assertEqualsString_custom(Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(txt_CoverageB).getAttribute("value")),expCovB,"txt_CovB");
		assertEqualsString_custom(Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(txt_CoverageC).getAttribute("value")),expCovC,"txt_CovC");
		assertEqualsString_custom(Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(txt_CoverageD).getAttribute("value")),expCovD,"txt_CovD");
		assertEqualsString_custom(Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(txt_CoverageD).getAttribute("value")),expCovD,"txt_CovD");
		assertEqualsString_custom(Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(dd_hdnCovE).getAttribute("value")),300000.0,"txt_CovE");
		assertEqualsString_custom(Double.parseDouble(DriverFactory.getInstance().getDriver().findElement(dd_hdnCovF).getAttribute("value")),5000.0,"txt_CovF");
	}
	
	
	public void validatedeRepCost(HashMap<String, String> testData) throws Throwable {
		Thread.sleep(7000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageC), "txt_CoverageC", testData.get("Coverage C1"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium),"Recalculate Premium button");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_hdnReplacement).getAttribute("value"),"Yes","Replacement Cost");
		
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_CoverageC), "txt_CoverageC", "0");
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium),"Recalculate Premium button");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_hdnReplacement).getAttribute("value"),"No","Replacement Cost");
		
	}
	
	public void changeOccupancy(String occupancy,boolean flag) throws Throwable {
		
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_OccupancyType), "dd_OccupancyType",occupancy);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_BuildingImproveValue), "txt_BuildingImproveValue", "0");
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_GetIndication),"Indication button");
		Thread.sleep(10000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_TheftOfBuildingMaterials).isDisplayed(),flag,"Theft of Building");
	}
	
	public void validateTheftOfBuildingMaterials() throws Throwable {
		Thread.sleep(8000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_TheftOfBuildingMaterials).isDisplayed(),false,"Theft of Building");
		changeOccupancy("Owner - Builder Risk",true);
		changeOccupancy("Owner - Building Under Reno",true);
		changeOccupancy("Owner / Tenant - Builders Risk",true);
		changeOccupancy("Owner / Tenant - Building Under Reno",true);
		changeOccupancy("Vacant - Builders Risk",true);
		changeOccupancy("Vacant - Building Under Reno",true);
		
		changeOccupancy("Owner - Seasonal",false);
		changeOccupancy("Owner - Secondary",false);
		changeOccupancy("Owner / Tenant - Primary",false);
		changeOccupancy("Owner / Tenant - Seasonal",false);
		changeOccupancy("Owner / Tenant - Secondary",false);
		changeOccupancy("Owner / Tenant - Short-Term Rental",false);
	}
	
	public void validateLandingPageForSubmission() throws Throwable {
		
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_SubmissionNo).isDisplayed(),true,"Submission No");
	}
	
	public void changeFormType(String formType,boolean flag) throws Throwable {
		
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_FormType), "dd_FormType",formType);
		Thread.sleep(5000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_OccupancyType), "dd_OccupancyType","Owner - Primary");
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_GetIndication),"Indication button");
		Thread.sleep(5000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_WaterDed).isDisplayed(),flag,"Water Deductible");
	}
	
	
	public void validateWaterDed() throws Throwable {
		
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_WaterDed).isDisplayed(),false,"Water Deductible");
		changeFormType("HO3",true);
		changeFormType("HO8",false);
		changeFormType("DP1",false);
		changeFormType("DP3",true);
	}
	
	public void changeDTC(String dTCOption,boolean flag) throws Throwable {
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_DTC), "dd_DTC",dTCOption);
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_GetIndication),"Indication button");
		Thread.sleep(5000);
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_WindHailDed).isDisplayed(),flag,"Wind Hail Deductible");
	}
	
	public void validateWindDed() throws Throwable {
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dd_WindHailDed).isDisplayed(),false,"Wind Hail Deductible");
		changeDTC("<1 Mile",true);
		changeDTC("1-2 Miles",true);
		changeDTC("2-5 Miles",true);
		changeDTC(">5 Miles",true);
		
	}
	
	//Dhanashri
	public void QuoteMandatoryFields(HashMap<String, String> testData) throws Throwable
	{
		//Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),140);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(txt_insuredName));
		//DriverFactory.getInstance().getDriver().findElement(txt_insuredName).sendKeys(testData.get("Insured Name"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_insuredName), "txt_insuredName", testData.get("Insured Name"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_FormType), "dd_FormType",
				testData.get("Form Type"));
		Thread.sleep(5000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_OccupancyType), "dd_OccupancyType",
				testData.get("Occupancy"));
		Thread.sleep(5000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_PolicyTerm), "dd_PolicyTerm",
				testData.get("Policy Term"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_ProtClass),"dd_ProtClass",
				testData.get("Prot Class1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_yearBuilt), "txt_yearBuilt", testData.get("Year Built1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_sqft), "txt_sqft", testData.get("Square Feet1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_noOfAcres), "txt_noOfAcres", testData.get("No Of Acres1"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_DTC), "dd_DTC",
				testData.get("DTC1"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_DwellingAmt), "txt_DwellingAmt", testData.get("Coverage A1"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_GetIndication),"Indication button");
	}
	
	
}
