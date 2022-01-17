package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
import testBase.DriverFactory;
import testBase.ExtentFactory;
import testBase.MyLogger;
import testBase.TestBase;

public class propertydetails extends TestBase { // shiva

	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects();
	BeforeQuotePageObjects beforeQuotePage = new BeforeQuotePageObjects();
	QuotePageObjects quotePage = new QuotePageObjects();
	PolicyHolderPageObjects policyHolderPage = new PolicyHolderPageObjects();
	PropertyDetailsPageObjects propertyDetailsPage = new PropertyDetailsPageObjects();
	CoverageAndMortgageePageObjects covMor = new CoverageAndMortgageePageObjects();
	ContractsPageObjects contractspage = new ContractsPageObjects();
	AppSmmaryPageObjects appsumm = new AppSmmaryPageObjects();

	String filePath = System.getProperty("user.dir") + PropertiesOperations.getPropertyValueByKey("testDataLocation");
	String filePath2 = System.getProperty("user.dir")
			+ PropertiesOperations.getPropertyValueByKey("manualRaterLocation");
	ExcelUtil excelUtil = new ExcelUtil(filePath, "Application"); // doubt
	ExcelUtil excelUtil2 = new ExcelUtil(filePath2, "Mappings"); // doubt
	CoveragePageObjects CoveragePage = new CoveragePageObjects();
	By searchApp = By.xpath("//input[@id='txtSeachApplicationNumber']");
	By uwSaveContinue = By.xpath("//*[@id=\"btnSaveUWAndContinue\"]");
	By contractSaveContinue = By.xpath("//*[@id=\"btnSaveContractAndContinue\"]");
	By completebinds = By.xpath("//*[@id=\"frmApplicationSummary\"]/div/div[4]/div[2]/a[2]");
	By liachoose1 = By.xpath("//*[@id=\"idRadioLiability12\"]");
	By yrbuilt = By.xpath("//*[@id=\"panelsStayOpen-collapse-prop1\"]/div/div/div[1]/div/div[1]/div");
	By sqfeet = By.xpath("//*[@id=\"panelsStayOpen-collapse-prop1\"]/div/div/div[1]/div/div[2]/div");
	By dwellrcv = By.xpath("//*[@id=\"panelsStayOpen-collapse-prop1\"]/div/div/div[1]/div/div[7]/div");
	By protectcl = By.xpath("//*[@id=\"panelsStayOpen-collapse-prop1\"]/div/div/div[1]/div/div[5]/div");
	By consttype = By.xpath("//*[@id=\"panelsStayOpen-collapse-prop1\"]/div/div/div[1]/div/div[8]/div");
	By noffamily = By.xpath("//*[@id=\"panelsStayOpen-collapse-prop1\"]/div/div/div[1]/div/div[3]/div");
	By noofacre = By.xpath("//*[@id=\"panelsStayOpen-collapse-prop1\"]/div/div/div[1]/div/div[4]/div");
	By disttocoast = By.xpath("//*[@id=\"panelsStayOpen-collapse-prop1\"]/div/div/div[1]/div/div[6]/div");
	By cirbrk = By.xpath("//label[@for='radCircuitBreaker11']");
	By knobtube = By.xpath("//label[@for='radKnobTubeWiring01']");
	By presfuse = By.xpath("//label[@for='radioPresentFuses01']");
	By txtamps = By.xpath("//*[@id='txtPreseFuses1']");

	ExcelOperations excel = new ExcelOperations("App");

	// Dataprovider method --> return object array
	@Test
	@DataProvider(name = "App")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

	}

	@Test(dataProvider = "App", enabled = false, priority = 1) // shiva
	public void test1(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		} catch (Exception e) {
			System.out.println("Test Data for this execution run is: " + testData);
		}
		// MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new
		// Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		 quotePage.enterQuoteDetails(testData);
		 quotePage.clickOnFormalQuote();
		policyHolderPage.enterPolicyHolderDetails(testData);
		// propertyDetailsPage.validatePropertyScreenURL(testData);
		propertyDetailsPage.priHeatSource();
		propertyDetailsPage.buildfeetdwell(testData);
		propertyDetailsPage.famAcreProtectCoastConstFireBugler(testData);
		propertyDetailsPage.cirKnobPreFuse(testData);
		propertyDetailsPage.clickOnSaveAndCont();
		covMor.enterPriorHistoryAndInspections(testData);
		covMor.enterPropCoveragenterPropCoveragee();
		Thread.sleep(15000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(uwSaveContinue), "Save and con");
		Thread.sleep(15000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(liachoose1),
				"Liability 004 choose");
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(contractSaveContinue),
				"Save and con");
		Thread.sleep(10000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(completebinds), "Complete binds");
		Thread.sleep(10000);
		String A1 = DriverFactory.getInstance().getDriver().findElement(cirbrk).getText();
		Thread.sleep(1000);
		String A2 = DriverFactory.getInstance().getDriver().findElement(knobtube).getText();
		Thread.sleep(1000);
		String A3 = DriverFactory.getInstance().getDriver().findElement(presfuse).getText();
		Thread.sleep(3000);
		String A4 = DriverFactory.getInstance().getDriver().findElement(txtamps).getAttribute("Value");
		System.out.println(DriverFactory.getInstance().getDriver().findElement(txtamps).getText());
		Assert.assertEquals(A1, testData.get("No"));
		Assert.assertEquals(A2, testData.get("Yes"));
		Assert.assertEquals(A3, testData.get("Yes"));
		Assert.assertEquals(A4, testData.get("testing"));
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(yrbuilt).getText(),
				testData.get("sendkeys1"), "Year Built");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(sqfeet).getText(),
				testData.get("sendkeys1"), "Square Feet");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(dwellrcv).getText(),
				testData.get("sendkeys2"), "Dwelling(RCV)");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(protectcl).getText(),
				testData.get("Protect class 6"), "Protection Class");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(consttype).getText(),
				testData.get("Construction Type1"), "Construction Type");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(noffamily).getText(),
				testData.get("No of Family 2"), "No of Families");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(noofacre).getText(),
				testData.get("sendkeys1"), "# of Acres");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(disttocoast).getText(),
				testData.get("Distance to coast 2-5 miles"), "Distance to the Coast");
	}

	@Test(dataProvider = "App", enabled = false, priority = 2) // shiva
	public void savenextmultipleprop(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		} catch (Exception e) {
			System.out.println("Test Data for this execution run is: " + testData);
		}
		// MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new
		// Date().getTime());
		loginPage.login(testData);
		homePage.clickOnNewQuote();
		beforeQuotePage.navigateToQuotePage(testData);
		quotePage.enterQuoteDetails(testData);
		quotePage.clickOnFormalQuote();
		policyHolderPage.addProperty(testData);
		policyHolderPage.ClickOnSaveCont();
		propertyDetailsPage.multipleaddresstitlecheck();
		propertyDetailsPage.enterPropertyDetailsForMultipleProperties(testData);
		propertyDetailsPage.verifymaxcharlimit(testData);
	}

	
}
