package Tests;

import java.util.Date;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AppFormSummaryPageObjects;
import pageObjects.BeforeQuotePageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.QuotePageObjects;
import reusableComponents.ExcelOperations;
import reusableComponents.ExcelUtil;
import reusableComponents.PropertiesOperations;
import testBase.ExtentFactory;
import testBase.MyLogger;
import testBase.TestBase;



public class FormsInnerTextTest extends TestBase{
	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects();
	BeforeQuotePageObjects beforeQuotePage = new BeforeQuotePageObjects();
	QuotePageObjects quotePage = new QuotePageObjects();
	String filePath = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation");
	String filePath2 = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("MultiplemanualRaterLocation");
	ExcelUtil excelUtil = new ExcelUtil(filePath, "Quote");
	ExcelUtil excelUtil2 = new ExcelUtil(filePath2, "Mappings");
	AppFormSummaryPageObjects appFormSummaryPageObjects = new AppFormSummaryPageObjects();


	ExcelOperations excel = new ExcelOperations("Quote");
	
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
	
	@Test(dataProvider = "quote", enabled=true)
	public void quote(Object obj1) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		try {
			ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);
		}catch(Exception e){
			System.out.println("Test Data for this execution run is: " + testData);
		}
//		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.startTestCase(testData.get("Test Case Name")+ " "+new Date().getTime());
		appFormSummaryPageObjects.extractTextFromPDF("C:\\Users\\Pratik Nishi\\Downloads\\NELL1220490.pdf");
		MyLogger.endTestCase(testData.get("Test Case Name"));
	}

	
}
