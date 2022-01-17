package pageObjects;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;

import reusableComponents.DBUtil;
import reusableComponents.DateTimeUtil;
import reusableComponents.ExcelUtil;
import reusableComponents.MethodUtil;
import testBase.DriverFactory;
import testBase.TestBase;

public class CancellationPageObjects extends TestBase {

	By dd_CanType = By.xpath("//select[@id='ddlCancellationType']");
	By dd_RequestedBy = By.xpath("//select[@id='ddlRequestedBy']");
	By sel_RequestedBy = By.xpath("//select[@id='ddlRequestedBy']//option[contains(@selected,'selected')]");
	By dd_Reason = By.xpath("//select[@id='ddlReason']");
	By sel_Reason = By.xpath("//select[@id='ddlReason']//option[contains(@selected,'selected')]");
	By rad_WaiveMEP = By.xpath("//p[text()='Waive MEP?']//parent::div");
	By txt_RetInsFee = By.xpath(
			"//label[text()='Return Inspection Fee']//ancestor::div[@class='col-xl-3 col-lg-4 mt-3 cancellationExtras']");
	By txt_RetSerFee = By.xpath(
			"//label[text()='Return Service Fee']//ancestor::div[@class='col-xl-3 col-lg-4 mt-3 cancellationExtras']");
	By txt_Remarks = By.xpath("//textarea[@id='txtReinstateNotes' or @id='txtCancellationNotes']");
	By btn_Submit = By.xpath("//a[@id='btnShowPremInfo' or @id='btnGetReinstatePremium']");
	By btn_Approve = By.xpath("//button[@id='btnApproveCancellation' or @id ='btnApproveReinstate']");
	By btn_Confirm = By.xpath("//button[text()='Yes']");
	By btn_CanDate = By.xpath("//input[@id='txtCancelDate']");
	By txt_Premium = By.xpath("//*[text()='Return Premium Amount']//following-sibling::p");
	By txt_inpRetInsFee = By.xpath("//input[@id='txtRetFee']");
	By txt_inpRetSerFee = By.xpath("//input[@id='txtSerFee']");
	By txt_OutServiceFee = By.xpath("//h4[contains(text(),'Service Fee')]//following-sibling::p");
	By txt_OutInspectionFee = By.xpath("//h4[contains(text(),'Inspection Fee')]//following-sibling::p");

	DateTimeUtil dateTimeUtil = new DateTimeUtil();
	MethodUtil methodUtil = new MethodUtil();
	DBUtil dBUtil = new DBUtil();
	
	
	
	
	

	public void validateDropdownValues(HashMap<String, String> testData) throws Throwable {

		List<String> listOfCanTypes = Arrays.asList(testData.get("ExpCancellationType").split("\n"));
		List<String> actListOfCanType = selectOptions_custom(
				DriverFactory.getInstance().getDriver().findElement(dd_CanType), "Can Type");
		System.out.println("ExpCancellationType " + listOfCanTypes);
		System.out.println("actCancellationType " + actListOfCanType);
		assertEqualsString_custom(listOfCanTypes.equals(actListOfCanType), true, "Can Type");

		List<String> listOfRequestedBy = Arrays.asList(testData.get("ExpRequestedBy").split("\n"));
		List<String> actListOfRequestedBy = selectOptions_custom(
				DriverFactory.getInstance().getDriver().findElement(dd_RequestedBy), "dd_RequestedBy");
		System.out.println("listOfRequestedBy " + listOfRequestedBy);
		System.out.println("actListOfRequestedBy " + actListOfRequestedBy);
		assertEqualsString_custom(listOfRequestedBy.equals(actListOfRequestedBy), true, "Requested By");

		List<String> listOfReason = Arrays.asList(testData.get("ExpReason").split("\n"));
		List<String> actListOfReason = selectOptions_custom(
				DriverFactory.getInstance().getDriver().findElement(dd_Reason), "dd_Reason");
		System.out.println("listOfReason " + listOfReason);
		System.out.println("actListOfReason " + actListOfReason);
		assertEqualsString_custom(listOfReason.equals(actListOfReason), true, "Reason");

	}

	public void validateExtraFieldForProAndShortRateCancellations() throws Throwable {

		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_CanType), "Can Type",
				"Flat Cancellation");

		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(rad_WaiveMEP)
				.getAttribute("style").equals("display: none;"), true, "Waive MEP");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_RetInsFee)
				.getAttribute("style").equals("display: none;"), true, "Ret Ins Fee");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_RetSerFee)
				.getAttribute("style").equals("display: none;"), true, "Ret Serv Fee");

		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_CanType), "Can Type",
				"Pro Rate Cancellation");

		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(rad_WaiveMEP)
				.getAttribute("style").equals("display: none;"), false, "Waive MEP");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_RetInsFee)
				.getAttribute("style").equals("display: none;"), false, "Ret Ins Fee");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_RetSerFee)
				.getAttribute("style").equals("display: none;"), false, "Ret Serv Fee");

		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_CanType), "Can Type",
				"Short Rate Cancellation");

		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(rad_WaiveMEP)
				.getAttribute("style").equals("display: none;"), false, "Waive MEP");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_RetInsFee)
				.getAttribute("style").equals("display: none;"), false, "Ret Ins Fee");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_RetSerFee)
				.getAttribute("style").equals("display: none;"), false, "Ret Serv Fee");
	}

	public void cancelPolicy(HashMap<String, String> testData) throws Throwable {

		inputDetailsForCancellation(testData);
		submitCancellation();
		Thread.sleep(10000);
		approveAndConfirmCancellation();

	}
	
	public void approveAndConfirmCancellation() throws InterruptedException {
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Approve),
				"Approve Cancellation Button");
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Confirm),
				"Confirm Cancellation Button");
		Thread.sleep(30000);
	}

	public void inputDetailsForCancellation(HashMap<String, String> testData) throws Throwable {
		
		

		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_CanDate), "Cancellation Calendar");
		dateTimeUtil.selectDateFromCalendar(dateTimeUtil.getDateInCancellationFormat(testData.get("Can Eff Date")));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_CanType), "Can Type",
				testData.get("CancellationType"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_RequestedBy),
				"Requested By", testData.get("RequestedBy"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Reason), "Reason",
				testData.get("Reason"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Remarks), "Remarks",
				testData.get("Remarks"));
		clickByJavaScriptExecutor(
				DriverFactory.getInstance().getDriver().findElement(By
						.xpath("//label[contains(@for,'rdbWaiveMep') and text()='" + testData.get("Waive MEP") + "']")),
				"Waive MEP");
		Thread.sleep(6000);
	}

	public void submitCancellation() {
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Submit), "Submit Button");

	}

	public String getPremium() {

		String premium = getText_custom(DriverFactory.getInstance().getDriver().findElement(txt_Premium), "Premium")
				.replaceAll("[^0-9.]", "");
		return premium;

	}



	public void changeRequestedBy(HashMap<String, String> testData) throws Throwable {

		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_RequestedBy),
				"Requested By", testData.get("Updated RequestedBy"));
	}
	
	public void validateExtraFees(HashMap<String, String> testData) throws Throwable {
		
		/*assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_OutServiceFee).isDisplayed(), false, "txt_OutServiceFee");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_OutInspectionFee).isDisplayed(), false, "txt_OutServiceFee");*/
		
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_inpRetInsFee), "Ret Ins Fee","100");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_inpRetSerFee), "Ret Service Fee","10");
		submitCancellation();
		methodUtil.validateToasterMsg(testData.get("ExpServFeeToasterMsg"));
		
		
		
		
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_inpRetInsFee), "Ret Ins Fee",testData.get("Inspection Fee"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_inpRetSerFee), "Ret Service Fee",testData.get("Service Fee"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_RequestedBy),
				"Requested By", testData.get("RequestedBy"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Reason), "Reason",
				testData.get("Reason"));
		submitCancellation();
		
		
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_OutServiceFee).isDisplayed(), true, "txt_OutServiceFee");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(txt_OutInspectionFee).isDisplayed(), true, "txt_OutServiceFee");
		
		
	}
	
	public void inputDetailsInCancellationSheet(String polNo,String filePath,HashMap<String, String> mapOfTestData) throws ClassNotFoundException, SQLException, IOException, ParseException {
		
		String policyInfoId = dBUtil.getResultFromDB("Select * from pas.PolicyInfo_trn where PolicyNumber = '"+polNo+"' and SystemType ='P'", "PolicyInfoId");
		String effDate = dateTimeUtil.getDateInEndPageForPolicyEffectiveAndExpirationDate(dBUtil.getResultFromDB("Select * from pas.PolicyInfo_trn where PolicyNumber = '"+polNo+"' and SystemType ='P'", "PEffective"));
		String expDate = dateTimeUtil.getDateInEndPageForPolicyEffectiveAndExpirationDate(dBUtil.getResultFromDB("Select * from pas.PolicyInfo_trn where PolicyNumber = '"+polNo+"' and SystemType ='P'", "PExpiration"));
		String policyTerm = dBUtil.getResultFromDB("Select l.name,p.Value from pas.policyLOBAttributes p "
				+ "inner join pas.lobattributes l on "
				+ "p.lobattributeid = l.lobattributeid "
				+ "where l.name ='Policy Term' and p.policyinfoid =" + policyInfoId,"Value").trim() +" Months";
		int premium = (int) (Double.parseDouble(dBUtil.getResultFromDB("Select * from pas.PremiumDetails_trn where policyInfoid = "+ policyInfoId,"PolicyPremium")));
		ExcelUtil excelUtil = new ExcelUtil(filePath,"Cancellation");
		excelUtil.setDetailsInCanSheet(effDate, expDate, policyTerm,  premium,  filePath, mapOfTestData);
		
	}

}
