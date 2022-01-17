package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;

import testBase.DriverFactory;
import testBase.ExtentFactory;
import testBase.MyLogger;
import testBase.TestBase;

public class AccountDashBoardPageObjects extends TestBase {

	By dd_LogOut = By.xpath("//h3[@class='username']");
	By btn_Logout = By.xpath("//a[text()='Logout']");
	By txt_subNo = By.xpath("//div[@class='policyNo']");
	By txt_SearchSubNo = By.xpath("//input[@placeholder='Search Account, Quotes and Submission']");
	By btn_Search = By
			.xpath("//input[@placeholder='Search Account, Quotes and Submission']//following-sibling::button");
	By txt_SearchedSubNo = By.xpath("//div[@id='divApplicationList']");
	By btn_ViewUWAlerts = By.xpath("//a[text()='VIEW UW ALERTS']");
	By txt_UWRefMsgs = By.xpath("//div[text()='UW Alerts']//parent::div//following-sibling::div[@class='formWrap']");
	By btn_AccountDashBoard = By.xpath("//a[text()='Account Dashboard']");

	public void logout() {

		click_custom(DriverFactory.getInstance().getDriver().findElement(dd_LogOut), "Logout Dropdown");
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Logout), "Logout button");

	}

	public String getSubmissionNumber() throws InterruptedException {
		String getSubno = DriverFactory.getInstance().getDriver().findElement(txt_subNo).getText();
		MyLogger.info("POlicyInfoID is "+ getSubno);
		return getSubno;
	}

	public void navigateToUWRefButton(String subNO) throws InterruptedException {
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_AccountDashBoard),
				"Account DashBoard Button");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_SearchSubNo), "txt_SearchSubNo", subNO);
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Search), "Search Button");
		Thread.sleep(5000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//h4[text()='"+subNO+"']//ancestor::div[@id='divApplicationList']")),
				"Searched Submission Number");
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_ViewUWAlerts), "UW Alerts");
		

	}
	
	public void validateAppRefMsgs(HashMap<String, String> testData) throws Throwable {
		
		String allText = DriverFactory.getInstance().getDriver().findElement(txt_UWRefMsgs).getText();

		String[] msg = allText.split("\n");

		List<String> tempListOfMessages = Arrays.asList(msg);

		List<String> listOfMessages = new ArrayList<String>(tempListOfMessages);
		
		listOfMessages.remove("Submission");
		listOfMessages.remove("CANCEL");
		
		int count =0;
		ExtentFactory.getInstance().getExtent().info("Actual message are ");
		for( String l:listOfMessages) {
			MyLogger.info(++count +". " + l);
			ExtentFactory.getInstance().getExtent().info(count +". " + l);
		}

		String[] expMsgs = testData.get("Expected Result").split("\n");
		
		List<String> tempListOfExpMessages = Arrays.asList(expMsgs);

		List<String> listOfExpMessages = new ArrayList<String>(tempListOfExpMessages);
		
		count =0;
		MyLogger.info("Expected message are ");
		ExtentFactory.getInstance().getExtent().info("Expected message are ");
		for (String exp : expMsgs) {
			MyLogger.info(++count +". " + exp);
			ExtentFactory.getInstance().getExtent().info(count +". " + exp);
		}

		for (String exp : expMsgs) {
			if (listOfMessages.contains(exp)) {
				MyLogger.info("Matched Message is " + exp);
				listOfMessages.remove(exp);
				listOfExpMessages.remove(exp);
			}

		}
		
		ExtentFactory.getInstance().getExtent().info("Extra messages in Actual are " + listOfMessages + "\n" + "Extra messages in Expected are " + listOfExpMessages);
		
//		try {
			assertEqualsString_custom(listOfMessages.size(), listOfExpMessages.size(),"Expected messages are not same as actual");
//		}catch(Exception e) {
//			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Extra messages in Actual are " + listOfMessages + "\n" + "Extra messages in Expected are " + listOfExpMessages);
//			MyLogger.info("Extra messages in Actual are " + listOfMessages);
//			MyLogger.info("Extra messages in Expected are " + listOfExpMessages);
//			MyLogger.info("Extra messages in Actual are " + listOfMessages);
//			MyLogger.info("Extra messages in Expected are " + listOfMessages);
//		}
		
	}

}
