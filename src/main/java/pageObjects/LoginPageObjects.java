package pageObjects;


import java.util.HashMap;

import org.openqa.selenium.By;

import testBase.DriverFactory;
import testBase.TestBase;

public class LoginPageObjects extends TestBase  {

	By userName = By.xpath("//input[@id='txtUserName']");
	By passWord = By.xpath("//input[@name='password']");
	By btn_login = By.xpath("//input[@id='btnSubmit']");


	//login to App
	public void login(HashMap<String, String> testData) {
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(userName), "User Name", testData.get("username"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(passWord), "Password", testData.get("password"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_login), "LoginButton");
	}
	
	public void loginWithInvalidCred(HashMap<String, String> testData) {
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(userName), "User Name", testData.get("Invalidusername"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(passWord), "Password", testData.get("invalidpassword"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_login), "LoginButton");
	}
	
	


}


