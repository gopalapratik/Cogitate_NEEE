package Tests;
//Author-Rishikesh

import java.sql.Date;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AppSmmaryPageObjects;
import pageObjects.BeforeQuotePageObjects;
import pageObjects.ContractsPageObjects;
import pageObjects.CoverageAndMortgageePageObjects;
import pageObjects.CoveragePageObjects;
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

public class Contractstest extends TestBase {
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
	String filePath = System.getProperty("user.dir") + PropertiesOperations.getPropertyValueByKey("testDataLocation");
	String filePath2 = System.getProperty("user.dir")
			+ PropertiesOperations.getPropertyValueByKey("manualRaterLocation");
	ExcelUtil excelUtil = new ExcelUtil(filePath, "Application");
	ExcelUtil excelUtil2 = new ExcelUtil(filePath2, "Mappings");
	CoveragePageObjects CoveragePage = new CoveragePageObjects();

	ExcelOperations excel = new ExcelOperations("App");

	// Dataprovider method --> return object array
	@DataProvider(name = "Appli")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

}
	 @Test(dataProvider = "Appli", enabled=true, priority=1)
	public void NumberofClaims(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
//		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date(0).getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		Thread.sleep(500);
		quotePage.enterQuoteDetails(testData);
		quotePage.clickOnFormalQuote();
		Thread.sleep(500);
		policyHolderPage.navigateOtherPages(testData);
		Thread.sleep(500);
		propertyDetailsPage.clickOnSaveAndCont();
		Thread.sleep(500);
		propertyDetailsPage.AddOccupancyType(testData);
		propertyDetailsPage.clickOnSaveAndCont();
		CoveragePage.propertycurrentlyinsured(testData);
		CoveragePage.ClickNextButton();
		CoveragePage.clickOnSaveAndCont();
		uWPageObjects.UWSave();
		
	contractsPage.textfeild(testData);
		contractsPage.getcoverageA(testData);
		contractsPage.Contract1(testData);
		contractsPage.Contract2(testData);
		contractsPage.Contraxt3(testData);
		contractsPage.Contraxt4(testData);
		contractsPage.Contract1(testData);
		contractsPage.SaveContractsPageData();
	}
}
