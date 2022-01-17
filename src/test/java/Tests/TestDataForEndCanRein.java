package Tests;

import java.util.Date;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AppFormSummaryPageObjects;
import pageObjects.AppSmmaryPageObjects;
import pageObjects.BeforeQuotePageObjects;
import pageObjects.CancellationPageObjects;
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



public class TestDataForEndCanRein extends TestBase{
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
	CancellationPageObjects cancellationPageObjects = new CancellationPageObjects();
	


	ExcelOperations excel = new ExcelOperations("Policy Creation");
	
	//Dataprovider method --> return object array
			@DataProvider (name = "Policy Creation")
			public Object[][] testDataSupplier() throws Exception {
				Object[][] obj = new Object[excel.getRowCount()][1];
				for (int i = 1; i <= excel.getRowCount(); i++) {
					HashMap<String, String> testData = excel.getTestDataInMap(i);
					obj[i-1][0] = testData;
				}
				return obj;
				
			}

	
	@Test(dataProvider = "Policy Creation", enabled=true)
	public void createPolicyNumbers(Object obj1) throws Throwable {
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
//		String polNo = "NELL1220506";
		
		String polNo = appFormSummaryPageObjects.clickOnBindPolicyAndExtractPolicyNo();
		ExcelUtil excelForEnd = new ExcelUtil(System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation"), "End");
		excelForEnd.setPolicyNumber(polNo,filePath,testData,4);
		ExcelUtil excelForEndDB = new ExcelUtil(System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation"), "EndDB");
		excelForEndDB.setPolicyNumber(polNo,filePath,testData,4);
		ExcelUtil excelForCan = new ExcelUtil(System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation"), "Cancellation");
		excelForCan.setPolicyNumber(polNo,filePath,testData,4);
		
		cancellationPageObjects.inputDetailsInCancellationSheet(polNo, filePath,testData);
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}

	
}
