package Tests;

import java.util.Date;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AppFormSummaryPageObjects;
import pageObjects.AppSmmaryPageObjects;
import pageObjects.BeforeQuotePageObjects;
import pageObjects.ContractsPageObjects;
import pageObjects.CoverageAndMortgageePageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.PolicyHolderPageObjects;
import pageObjects.PropertyDetailsPageObjects;
import pageObjects.QuotePageObjects;
import pageObjects.UWPageObjects;
import reusableComponents.ExcelOperations;
import reusableComponents.ExcelUtil;
import reusableComponents.PropertiesOperations;
import testBase.ExtentFactory;
import testBase.MyLogger;
import testBase.TestBase;



public class FormsTest extends TestBase{
	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects();
	BeforeQuotePageObjects beforeQuotePage = new BeforeQuotePageObjects();
	QuotePageObjects quotePage = new QuotePageObjects();
	PolicyHolderPageObjects policyHolderPage = new PolicyHolderPageObjects();
	PropertyDetailsPageObjects propertyDetailsPage = new PropertyDetailsPageObjects();
	CoverageAndMortgageePageObjects coverageAndMortgageePage = new CoverageAndMortgageePageObjects();
	UWPageObjects uWPageObjects = new UWPageObjects();
	ContractsPageObjects contractsPage = new ContractsPageObjects();
	AppSmmaryPageObjects appSummaryPage = new AppSmmaryPageObjects();
	AppFormSummaryPageObjects appFormSummaryPageObjects = new AppFormSummaryPageObjects();
	String filePath = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation");
	String filePath2 = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("MultiplemanualRaterLocation");
	ExcelUtil excelUtil = new ExcelUtil(filePath, "Application");
	ExcelUtil excelUtil2 = new ExcelUtil(filePath2, "Mappings");


	ExcelOperations excel = new ExcelOperations("Forms");
	
	//Dataprovider method --> return object array
			@DataProvider (name = "Forms")
			public Object[][] testDataSupplier() throws Exception {
				Object[][] obj = new Object[excel.getRowCount()][1];
				for (int i = 1; i <= excel.getRowCount(); i++) {
					HashMap<String, String> testData = excel.getTestDataInMap(i);
					obj[i-1][0] = testData;
				}
				return obj;
				
			}
	
/*	@Test(dataProvider = "Forms", enabled=false)
	public void validateForms(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
//		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.enterQuoteDetails(testData);
		quotePage.clickOnFormalQuote();
		policyHolderPage.addProperty(testData);
		policyHolderPage.enterPolicyHolderDetails(testData);
		propertyDetailsPage.enterPropertyDetailsForMultipleProperties(testData);
		coverageAndMortgageePage.enterPriorHistoryAndInspections(testData);
		coverageAndMortgageePage.enterPropCoverageForMultipleLocations(testData);
		uWPageObjects.UWSave();
		contractsPage.enterContractsPageData(testData);
		appFormSummaryPageObjects.enterDetailsNotEnteredIntoApp();
		appFormSummaryPageObjects.validateReqForm();
		appFormSummaryPageObjects.validateOptForm();
		Map<String, Double> mapOfPremium = appSummaryPage.getPremium();
		System.out.println("mapOfPremium is "+ mapOfPremium);
		//appSummaryPage.completeApp(testData);
		
		
		excelUtil2.setCellData(testData,filePath2);
		String filePath3 = System.getProperty("user.dir")+"//src//test//resources//Manual Rater//Reference//"+testData.get("Test Case Name")+".xlsx";
		excelUtil2.copyExcelFile(filePath2,filePath3);
		Map<String, Double> mapOfPremiumFromExcel =excelUtil2.getPremiumFromExcel();
		System.out.println("mapOfPremiumFromExcel is "+ mapOfPremiumFromExcel);
		assertEqualsString_custom(mapOfPremium.get("FeesAndTaxesPremium"),mapOfPremiumFromExcel.get("FeesAndTaxesPremium"),"Fees And Taxes Premium ");
		assertEqualsString_custom(mapOfPremium.get("FinalPremium"),mapOfPremiumFromExcel.get("FinalPremium"),"Final Premium ");
		MyLogger.endTestCase(testData.get("Test Case Name"));
		
		
	}*/
	
			/*Map<String, Double> mapOfPremium = appSummaryPage.getPremium();
			System.out.println("mapOfPremium is "+ mapOfPremium);
			//appSummaryPage.completeApp(testData);
			
			
			excelUtil2.setCellData(testData,filePath2);
			String filePath3 = System.getProperty("user.dir")+"//src//test//resources//Manual Rater//Reference//"+testData.get("Test Case Name")+".xlsx";
			excelUtil2.copyExcelFile(filePath2,filePath3);
			Map<String, Double> mapOfPremiumFromExcel =excelUtil2.getPremiumFromExcel();
			System.out.println("mapOfPremiumFromExcel is "+ mapOfPremiumFromExcel);
			assertEqualsString_custom(mapOfPremium.get("FeesAndTaxesPremium"),mapOfPremiumFromExcel.get("FeesAndTaxesPremium"),"Fees And Taxes Premium ");
			assertEqualsString_custom(mapOfPremium.get("FinalPremium"),mapOfPremiumFromExcel.get("FinalPremium"),"Final Premium ");*/
	
	@Test(dataProvider = "Forms", enabled=true)
	public void validateReqAndOptForms(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
//		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		loginPage.login(testData);
		/*homePage.searchPolicy(testData);
		homePage.clickOnFormalQuote();
		appFormSummaryPageObjects.enterDetailsNotEnteredIntoApp();
		appFormSummaryPageObjects.validateReqForm(testData);
		appFormSummaryPageObjects.validateOptForm(testData);
		appFormSummaryPageObjects.validateCheckedForms(testData);
		MyLogger.endTestCase(testData.get("Test Case Name"));*/
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.enterQuoteDetails(testData);
		quotePage.clickOnFormalQuote();
		policyHolderPage.addProperty(testData);
		policyHolderPage.enterPolicyHolderDetails(testData);
		propertyDetailsPage.enterPropertyDetailsForMultipleProperties(testData);
		coverageAndMortgageePage.enterPriorHistoryAndInspections(testData);
		coverageAndMortgageePage.enterPropCoverageForMultipleLocations(testData);
		uWPageObjects.UWSave();
		contractsPage.enterContractsPageData(testData);
		appFormSummaryPageObjects.enterDetailsNotEnteredIntoApp();
		appFormSummaryPageObjects.validateReqForm(testData);
		appFormSummaryPageObjects.validateOptForm(testData);
		appFormSummaryPageObjects.validateCheckedForms(testData);
		MyLogger.endTestCase(testData.get("Test Case Name"));
		
		
	}

	
}
