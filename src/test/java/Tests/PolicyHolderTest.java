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

public class PolicyHolderTest extends TestBase {
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
	@DataProvider(name = "Appl")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

	}

	@Test(dataProvider = "Appl", enabled = false, priority = 1)
	public void NumberofClaims(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		} catch (Exception e) {
			System.out.println("Test Data for this execution run is: " + testData);
		}
//				MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.startTestCase(testData.get("Test Case Name") + " " + new Date(0).getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.enterQuoteDetails(testData);
		quotePage.clickOnFormalQuote();

		policyHolderPage.validateCoverageScreenURL(testData);
		System.out.println("test case 1 sucess");
		policyHolderPage.HO3(testData);
		System.out.println("test case 3 sucess");
		policyHolderPage.Occupancy(testData);
		System.out.println("test case 4 sucess");
		policyHolderPage.Policyterms(testData);
		System.out.println("test case 5 sucess");
		policyHolderPage.Homeowner(testData);
		System.out.println("test case 6 sucess");
		policyHolderPage.Addressdata(testData);
		System.out.println("test case 7 sucess");

		policyHolderPage.Policyterm(testData);
		System.out.println("test case 15 sucess");
		policyHolderPage.PrimaryAddress("testData");
		System.out.println("test case 16 Sucess");
		policyHolderPage.MailingAddresscheckbox("testData");
		System.out.println("test case 17 Sucess");
		policyHolderPage.Applicanttype_CO(testData);
		System.out.println("test case 8 sucess");
		Thread.sleep(5000);
		policyHolderPage.Applicanttype_IND(testData);
		System.out.println("test case 14 Executed");

		policyHolderPage.Insuredname(testData);
		System.out.println("test case 9 sucess");
		policyHolderPage.Secondaryinsurename("testData");
		System.out.println("test case 10 sucess");
		policyHolderPage.mailingadressfeild("testData");
		System.out.println("test case 13 sucess");
		policyHolderPage.Applicanttypedropdownlist(testData);
		System.out.println("test case 21 sucess");
		policyHolderPage.FillDatatosave(testData);
		policyHolderPage.saveasdraft(testData);
		System.out.println("test case 20 Sucess");
		policyHolderPage.mailingaddressverfication("testData");
		System.out.println("test case 18 Sucess");
		// policyHolderPage.saveasdraftverification(testData);
		// System.out.println("test case 21 Sucess");

		// CoveragePage.MyLogger.endTestCase(testData.get("Test Case Name"));
		// DriverFactory.getInstance().getDriver().quit();
	}

	@Test(dataProvider = "Appl", enabled = false, priority = 2)
	public void policyholder(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		} catch (Exception e) {
			System.out.println("Test Data for this execution run is: " + testData);
		}
		// MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.startTestCase(testData.get("Test Case Name") + " " + new Date(0).getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.enterQuoteDetails(testData);
		quotePage.clickOnFormalQuote();
		policyHolderPage.Addedadress("testData");
		System.out.println("test case 11 sucess");
		Thread.sleep(2000);
		policyHolderPage.Errormsg(testData);
		System.out.println("test case 19 Sucess");

	}

	@Test(dataProvider = "Appl", enabled = true, priority = 2)
	public void policyholder2(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		} catch (Exception e) {
			System.out.println("Test Data for this execution run is: " + testData);
		}
		// MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.startTestCase(testData.get("Test Case Name") + " " + new Date(0).getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.enterQuoteDetails(testData);
		quotePage.clickOnFormalQuote();
		policyHolderPage.validategobackurl(testData);
		System.out.println("test case 2 sucess");
	}
}
