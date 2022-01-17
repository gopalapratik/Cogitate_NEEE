package Tests;

import java.util.Date;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CancellationPageObjects;
import pageObjects.EndPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ReinstatementPageObjects;
import reusableComponents.DateTimeUtil;
import reusableComponents.ExcelOperations;
import reusableComponents.ExcelUtil;
import reusableComponents.PropertiesOperations;
import testBase.ExtentFactory;
import testBase.MyLogger;
import testBase.TestBase;

public class EndDBTest extends TestBase {
	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects();
	CancellationPageObjects cancellationPage = new CancellationPageObjects();
	ReinstatementPageObjects reinstatementPageObjects = new ReinstatementPageObjects();
	String filePath = System.getProperty("user.dir") + PropertiesOperations.getPropertyValueByKey("testDataLocation");
	String filePath2 = System.getProperty("user.dir")
			+ PropertiesOperations.getPropertyValueByKey("cancellationFilePath");
	ExcelUtil excelUtil = new ExcelUtil(filePath, "Cancellation");
	ExcelUtil excelUtil2 = new ExcelUtil(filePath2, "Input");
	DateTimeUtil dateTimeUtil = new DateTimeUtil();
	EndPageObjects endPageObjects = new EndPageObjects();

	ExcelOperations excel = new ExcelOperations("EndDB");
	

	// Dataprovider method --> return object array
	@DataProvider(name = "EndDB")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData =  excel.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

	}
	
	

	@Test(dataProvider = "EndDB", enabled = true)
	public void dBvalidationsOnEndorsementPage(Object obj1) throws Throwable {
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
		homePage.clickOnEndorseBtn();
		endPageObjects.dbValidation(testData);
		
	}
	

	
}
