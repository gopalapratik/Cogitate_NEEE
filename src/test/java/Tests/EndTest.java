package Tests;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

public class EndTest extends TestBase {
	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects();
	CancellationPageObjects cancellationPage = new CancellationPageObjects();
	ReinstatementPageObjects reinstatementPageObjects = new ReinstatementPageObjects();
	String filePathForRater = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("RaterForEnd");
	String filePathForEndCalc = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("endFilePath");
	ExcelUtil excelUtil = new ExcelUtil(filePathForRater, "Mappings");
	ExcelUtil excelUtilForEnd = new ExcelUtil(filePathForEndCalc, "Input");
	DateTimeUtil dateTimeUtil = new DateTimeUtil();
	EndPageObjects endPageObjects = new EndPageObjects();

	ExcelOperations excel = new ExcelOperations("End");
	

	// Dataprovider method --> return object array
	@DataProvider(name = "End")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData =  excel.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

	}
	
	

	@Test(dataProvider = "End", enabled = false)
	public void performingEndorsementAndValidationWithManualRaterAndValidatingEndorsementLogic(Object obj1) throws Throwable {
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
		endPageObjects.performEndorsement(testData);
		HashMap<String, String> finalMapOfProperties = endPageObjects.createMapFromDBFOrManualRaterValidations(testData);
		excelUtil.setCellData(finalMapOfProperties,filePathForRater);
		String filePathForRaterRef = System.getProperty("user.dir")+"//src//test//resources//Manual Rater//Reference//"+testData.get("Test Case Name")+".xlsx";
		excelUtil.copyExcelFile(filePathForRater,filePathForRaterRef);
		
		Map<String, Double> mapOfPremiumFromExcel =excelUtil.getPremiumFromExcel();
		Map<String, Double> mapOfPremiumFromUI = endPageObjects.getPremiumFromUI();
		Double raterPremiumFromExcel = mapOfPremiumFromExcel.get("LocationPremium");
		Double raterPremiumFromUI = mapOfPremiumFromUI.get("Revised Premium");
		assertEqualsString_custom(raterPremiumFromExcel, raterPremiumFromUI, "Revised Premium");
		
		HashMap<String,String> mapOfEndParameters = endPageObjects.createMapForEndCalculations(testData,mapOfPremiumFromUI.get("Prior Term Premium"),raterPremiumFromUI);
		
		excelUtilForEnd.setCellData(mapOfEndParameters, filePathForEndCalc);
		String filePathForEndRef = System.getProperty("user.dir") + "//src//test//resources//Endorsement Calculations//Reference//"
				+ testData.get("Test Case Name") + ".xlsx";
		excelUtilForEnd.copyExcelFile(filePathForEndCalc, filePathForEndRef);
		
		Double endPremiumFromExcel = excelUtilForEnd.getPremiumFromExcelForEnd();
		Double endPremiumFromUI = mapOfPremiumFromUI.get("Endorsed Premium");
		assertEqualsString_custom(endPremiumFromExcel,endPremiumFromUI,"Endorsed Premium");
		
	}
	
	@Test(dataProvider = "End", enabled = true)
	public void validatingSecondEndDetailsWithFirstEnd(Object obj1) throws Throwable {
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
		endPageObjects.performEndorsement(testData);
		HashMap<String, String> finalMapOfProperties = endPageObjects.createMapFromDBFOrManualRaterValidations(testData);
		excelUtil.setCellData(finalMapOfProperties,filePathForRater);
		String filePathForRaterRef = System.getProperty("user.dir")+"//src//test//resources//Manual Rater//Reference//"+testData.get("Test Case Name")+".xlsx";
		excelUtil.copyExcelFile(filePathForRater,filePathForRaterRef);
		
		Map<String, Double> mapOfPremiumFromExcel =excelUtil.getPremiumFromExcel();
		Map<String, Double> mapOfPremiumFromUI = endPageObjects.getPremiumFromUI();
		Double raterPremiumFromExcel = mapOfPremiumFromExcel.get("LocationPremium");
		Double raterPremiumFromUI = mapOfPremiumFromUI.get("Revised Premium");
		assertEqualsString_custom(raterPremiumFromExcel, raterPremiumFromUI, "Revised Premium");
		
		HashMap<String,String> mapOfEndParameters = endPageObjects.createMapForEndCalculations(testData,mapOfPremiumFromUI.get("Prior Term Premium"),raterPremiumFromUI);
		
		excelUtilForEnd.setCellData(mapOfEndParameters, filePathForEndCalc);
		String filePathForEndRef = System.getProperty("user.dir") + "//src//test//resources//Endorsement Calculations//Reference//"
				+ testData.get("Test Case Name") + ".xlsx";
		excelUtilForEnd.copyExcelFile(filePathForEndCalc, filePathForEndRef);
		
		Double endPremiumFromExcel = excelUtilForEnd.getPremiumFromExcelForEnd();
		Double endPremiumFromUI = mapOfPremiumFromUI.get("Endorsed Premium");
		assertEqualsString_custom(endPremiumFromExcel,endPremiumFromUI,"Endorsed Premium");
		
		endPageObjects.confirmEnd();
		homePage.searchPolicy(testData);
		homePage.clickOnEndorseBtn();
		HashMap<String, String> finalMapOfPropertiesOnSecEnd =endPageObjects.validatePreviousDetailOfEnd(testData);
		assertEqualsString_custom(finalMapOfProperties,finalMapOfPropertiesOnSecEnd,"Unit LOB Attributes From DB");
		
		
		
	}

	
}
