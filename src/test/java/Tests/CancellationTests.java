package Tests;

import java.util.Date;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CancellationPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ReinstatementPageObjects;
import reusableComponents.DateTimeUtil;
import reusableComponents.ExcelOperations;
import reusableComponents.ExcelUtil;
import reusableComponents.MailUtil;
import reusableComponents.PropertiesOperations;
import testBase.ExtentFactory;
import testBase.MyLogger;
import testBase.TestBase;

public class CancellationTests extends TestBase {
	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects();
	CancellationPageObjects cancellationPage = new CancellationPageObjects();
	ReinstatementPageObjects reinstatementPageObjects = new ReinstatementPageObjects();
	//String filePath = System.getProperty("user.dir") + PropertiesOperations.getPropertyValueByKey("testDataLocation");
	String filePath = System.getProperty("user.dir")
			+ PropertiesOperations.getPropertyValueByKey("cancellationFilePath");
	//ExcelUtil excelUtil = new ExcelUtil(filePath, "Cancellation");
	ExcelUtil excelUtil = new ExcelUtil(filePath, "Input");
	DateTimeUtil dateTimeUtil = new DateTimeUtil();

	ExcelOperations excel = new ExcelOperations("Cancellation");
	MailUtil mailUtil = new MailUtil();

	// Dataprovider method --> return object array
	@DataProvider(name = "Cancellation")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

	}

	@Test(dataProvider = "Cancellation", enabled = false)
	public void validationsOnCancellationPage(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		} catch (Exception e) {
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name") + " " + new Date().getTime());
		loginPage.login(testData);
		homePage.searchPolicy(testData);
		homePage.clickOnCancelBtn();
		cancellationPage.validateDropdownValues(testData);
		cancellationPage.validateExtraFieldForProAndShortRateCancellations();
		cancellationPage.validateExtraFees(testData);
		
	}

	@Test(dataProvider = "Cancellation", enabled = false)
	public void validateDetailsFromReinstatePage(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		} catch (Exception e) {
			System.out.println("Test Data for this execution run is: " + testData);
		}
		MyLogger.startTestCase(testData.get("Test Case Name") + " " + new Date().getTime());
		loginPage.login(testData);
		homePage.searchPolicy(testData);
		homePage.clickOnCancelBtn();
		cancellationPage.cancelPolicy(testData);
		homePage.searchPolicy(testData);
		homePage.validateStatus(testData,"Cancelled");
		homePage.searchPolicy(testData);
		homePage.clickOnReinstateBtn();
		reinstatementPageObjects.validateReinstatementDetails(testData);
		reinstatementPageObjects.performReinstatement(testData);
		homePage.searchPolicy(testData);
		homePage.validateStatus(testData,"Reinstated");
	}

	@Test(dataProvider = "Cancellation", enabled = true)
	public void validateCancellationLogicCalculationsAndReinstatement(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		} catch (Exception e) {
			System.out.println("Test Data for this execution run is: " + testData);
		}
		// MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.startTestCase(testData.get("Test Case Name") + " " + new Date().getTime());
		loginPage.login(testData);
		homePage.searchPolicy(testData);
		homePage.clickOnCancelBtn();
		cancellationPage.inputDetailsForCancellation(testData);
		cancellationPage.submitCancellation();
		cancellationPage.changeRequestedBy(testData);
		cancellationPage.submitCancellation();
		Double premiumFromUI = Double.parseDouble(cancellationPage.getPremium());
		excelUtil.setCellData(testData, filePath);
		String filePath2 = System.getProperty("user.dir") + "//src//test//resources//Cancellation Calculations//Reference//"
				+ testData.get("Test Case Name") + ".xlsx";
		excelUtil.copyExcelFile(filePath, filePath2);
		Double premiumFromExcel = excelUtil.getPremiumFromExcelForCan();
		assertEqualsString_custom(premiumFromExcel,premiumFromUI,"Return Premium");
		
		cancellationPage.approveAndConfirmCancellation();
		homePage.searchPolicy(testData);
		homePage.validateStatus(testData,"Cancelled");
		homePage.searchPolicy(testData);
		homePage.clickOnReinstateBtn();
		double premiumFromReinstatement = reinstatementPageObjects.performReinstatement(testData);
		homePage.searchPolicy(testData);
		homePage.validateStatus(testData,"Reinstated");
		assertEqualsString_custom(premiumFromUI,premiumFromReinstatement,"Reinstatement Premium");
		MyLogger.endTestCase(testData.get("Test Case Name"));
		
	}
	
	/*@Test(dataProvider = "Cancellation", enabled = false)
	public void validateCancellationLogicCalculationsAndReinstatement2(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		} catch (Exception e) {
			System.out.println("Test Data for this execution run is: " + testData);
		}
		// MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.startTestCase(testData.get("Test Case Name") + " " + new Date().getTime());
		loginPage.login(testData);
		homePage.searchPolicy(testData);
		homePage.clickOnCancelBtn();
		
		
		cancellationPage.inputDetailsForCancellation(testData);
		cancellationPage.submitCancellation();
		cancellationPage.changeRequestedBy(testData);
		cancellationPage.submitCancellation();
		Double premiumFromUI = Double.parseDouble(cancellationPage.getPremium());
		excelUtil.setCellData(testData, filePath);
		String filePath2 = System.getProperty("user.dir") + "//src//test//resources//Cancellation Calculations//Reference//"
				+ testData.get("Test Case Name") + ".xlsx";
		excelUtil.copyExcelFile(filePath, filePath2);
		Double premiumFromExcel = excelUtil.getPremiumFromExcelForCan();
		assertEqualsString_custom(premiumFromExcel,premiumFromUI,"Return Premium");
		
		
		
		cancellationPage.approveAndConfirmCancellation();
		homePage.searchPolicy(testData);
		homePage.validateStatus(testData,"Cancelled");
		homePage.searchPolicy(testData);
		homePage.clickOnReinstateBtn();
		double premiumFromReinstatement = reinstatementPageObjects.performReinstatement(testData);
		homePage.searchPolicy(testData);
		homePage.validateStatus(testData,"Reinstated");
		assertEqualsString_custom(premiumFromUI,premiumFromReinstatement,"Reinstatement Premium");
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}*/
}
