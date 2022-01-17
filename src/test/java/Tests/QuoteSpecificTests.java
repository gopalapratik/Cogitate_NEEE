package Tests;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BeforeQuotePageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.PolicyHolderPageObjects;
import pageObjects.QuotePageObjects;
import reusableComponents.ExcelOperations;
import reusableComponents.MethodUtil;
import testBase.ExtentFactory;
import testBase.MyLogger;
import testBase.TestBase;



public class QuoteSpecificTests extends TestBase{
	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects();
	BeforeQuotePageObjects beforeQuotePage = new BeforeQuotePageObjects();
	QuotePageObjects quotePage = new QuotePageObjects();
	MethodUtil methodUtil = new MethodUtil();
	PolicyHolderPageObjects policyHolderPageObjects = new PolicyHolderPageObjects();
	HashMap<String, String> testData;
	

	ExcelOperations excel = new ExcelOperations("QuoteSpecific");
	
	//Dataprovider method --> return object array
			@DataProvider (name = "quote")
			public Object[][] testDataSupplier() throws Exception {
				Object[][] obj = new Object[excel.getRowCount()][1];
				for (int i = 1; i <= excel.getRowCount(); i++) {
					HashMap<String, String> testData = excel.getTestDataInMap(i);
					obj[i-1][0] = testData;
				}
				return obj;
				
			}
			
	
	/*@Test(dataProvider = "quote", enabled=true, priority=1)
	public void validateOtherStateMsg(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePageWithIncorrectAdd(testData);
		methodUtil.validateToasterMsg(testData.get("Invalid State Toast Msg"));
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	@Test(dataProvider = "quote", enabled=true, priority=2)
	public void validateLogoutMsg(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.logout();
		methodUtil.validateToasterMsg(testData.get("Logout Toast Msg"));
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	@Test(dataProvider = "quote", enabled=true, priority=3)
	public void validateIncorrectCredentialsMsg(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.loginWithInvalidCred(testData);
		methodUtil.validateToasterMsg(testData.get("Invalid Cred Toast Msg"));
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}*/
	// Need to change Address 
	@Test(dataProvider = "quote", enabled=false, priority=1)
	public void validateQuoteScreenURLAndMsg(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.validateQuoteScreenURL(testData);
		//methodUtil.validateToasterMsg(testData.get("Third Party Add Msg"));
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	@Test(dataProvider = "quote", enabled=false, priority=2)
	public void validateCovMsg(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.validateCovMsgs(testData);
		//policyHolderPageObjects.validatePolicyHolderURL(testData);
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	@Test(dataProvider = "quote", enabled=false, priority=3)
	public void validateAmountField(Object obj1) throws Throwable {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.validateAmountField(testData);
		MyLogger.endTestCase(testData.get("Test Case Name"));
		
		
	}
	// Need to change Address
	@Test(dataProvider = "quote", enabled=true, priority=4)
	public void validateDefaultValues(Object obj1) throws Throwable {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.validateDefaultValuesOfBasicProperty();
		quotePage.validateSecurityDetails();
		quotePage.validateDefaultAOP(testData);
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	
	@Test(dataProvider = "quote", enabled=false, priority=5)
	public void validateQuoteIndication(Object obj1) throws Throwable {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.fillBasicDetailsOnQuotePage(testData);
		quotePage.validateFinalPremiumText();
		quotePage.validateSendQuote(testData);
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	@Test(dataProvider = "quote", enabled=false, priority=6)
	public void validateCovCalculationsAndDefault(Object obj1) throws Throwable {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.fillBasicDetailsOnQuotePage(testData);
		quotePage.validatedefaultCovCalculations(testData);
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	@Test(dataProvider = "quote", enabled=false, priority=7)
	public void validateReplacementCost(Object obj1) throws Throwable {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.fillBasicDetailsOnQuotePage(testData);
		quotePage.validatedeRepCost(testData);
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	@Test(dataProvider = "quote", enabled=false, priority=8)
	public void validateTheftOfBuildingMaterials(Object obj1) throws Throwable {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.fillBasicDetailsOnQuotePage(testData);
		quotePage.validateTheftOfBuildingMaterials();
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	
	
	@Test(dataProvider = "quote", enabled=false, priority=9)
	public void validateLandingPageForSubmission(Object obj1) throws Throwable {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.enterQuoteDetails(testData);
		quotePage.clickOnFormalQuote();
		String subNo = policyHolderPageObjects.getSubmissionNo();
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePageWithSubNo(subNo);
		quotePage.validateLandingPageForSubmission();
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	@Test(dataProvider = "quote", enabled=false, priority=10)
	public void validateWaterDedForVariousForms(Object obj1) throws Throwable {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.fillBasicDetailsOnQuotePage(testData);
		quotePage.validateWaterDed();
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	
	@Test(dataProvider = "quote", enabled=false, priority=11)
	public void validatewindHailDedForVariousDTCOptions(Object obj1) throws Throwable {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.fillBasicDetailsOnQuotePage(testData);
		quotePage.validateWindDed();
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}
	

	
}
