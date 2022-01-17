package testBase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import reusableComponents.ActionEngine;
import reusableComponents.MailUtil;
import reusableComponents.PropertiesOperations;

public class TestBase extends ActionEngine {
	BrowserFactory bf = new BrowserFactory();
	MailUtil mailUtil = new MailUtil();

	@BeforeMethod
	public void LaunchApplication() throws Exception {
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));

		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().navigate().to(url);

	}

	/*
	 * @AfterMethod public void tearDown() throws InterruptedException {
	 * Thread.sleep(5000); DriverFactory.getInstance().getDriver().close(); }
	 */

	/*@AfterSuite
	public void sendReports() throws InterruptedException {
		mailUtil.sendMail();
		ExtentReportNG.extentEmail();
	}*/
}
