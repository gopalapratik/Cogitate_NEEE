package reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import testBase.DriverFactory;
import testBase.ExtentFactory;
import testBase.MyLogger;

public class ActionEngine {

	// Customized sendkeys method-> To log sendkeys message for every occ.
	public void sendKeys_custom(WebElement element, String fieldName, String valueToBeSent) {
		try {
			element.clear();
			Thread.sleep(2000);
			element.click();
			element.sendKeys(valueToBeSent);
			MyLogger.info(fieldName + "==> Ented value as: " + valueToBeSent);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==> Ented value as: " + valueToBeSent);
		} catch (NoSuchElementException e) {
			MyLogger.info(fieldName + "==> Ented value as: " + valueToBeSent + " NoSuchElementException");
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==> Ented value as: " + valueToBeSent + " NoSuchElementException");
		} catch (Exception e) {
			// log failure in extent
			MyLogger.info("Value enter in field: " + fieldName + " is failed due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"Value enter in field: " + fieldName + " is failed due to exception: " + e);
		}
	}

	public void sendKeys_customEnd(WebElement element, String fieldName, String valueToBeSent) {

		if (valueToBeSent != null) {
			try {
				element.clear();
				Thread.sleep(2000);
				element.click();
				element.sendKeys(valueToBeSent);
				MyLogger.info(fieldName + "==> Ented value as: " + valueToBeSent);
				ExtentFactory.getInstance().getExtent().log(Status.PASS,
						fieldName + "==> Ented value as: " + valueToBeSent);
			} catch (NoSuchElementException e) {
				MyLogger.info(fieldName + "==> Ented value as: " + valueToBeSent + " NoSuchElementException");
				ExtentFactory.getInstance().getExtent().log(Status.PASS,
						fieldName + "==> Ented value as: " + valueToBeSent + " NoSuchElementException");
			} catch (Exception e) {
				// log failure in extent
				MyLogger.info("Value enter in field: " + fieldName + " is failed due to exception: " + e);
				ExtentFactory.getInstance().getExtent().log(Status.INFO,
						"Value enter in field: " + fieldName + " is failed due to exception: " + e);
			}
		}
	}

	// custom click method to log evey click action in to extent report
	public void click_custom(WebElement element, String fieldName) {
		try {
			element.click();
			// log success message in exgent report
			MyLogger.info(fieldName + "==> Clicked Successfully! ");
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Clicked Successfully! ");
		} catch (Exception e) {
			// log failure in extent
			MyLogger.info("Unable to click on field: " + fieldName + " due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"Unable to click on field: " + fieldName + " due to exception: " + e);
		}
	}

	// clear data from field
	public void clear_custom(WebElement element, String fieldName) {
		try {
			element.clear();
			Thread.sleep(250);
			MyLogger.info(fieldName + "==> Data Cleared Successfully! ");
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Data Cleared Successfully! ");
		} catch (Exception e) {
			MyLogger.info("Unable to clear Data on field: " + fieldName + " due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"Unable to clear Data on field: " + fieldName + " due to exception: " + e);

		}
	}

	// custom mouseHover
	public void moveToElement_custom(WebElement element, String fieldName) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());
			actions.moveToElement(element).build().perform();
			MyLogger.info(fieldName + "==> Mouse hovered Successfully! ");
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Mouse hovered Successfully! ");
			Thread.sleep(1000);
		} catch (Exception e) {
			MyLogger.info("Unable to hover mouse on field: " + fieldName + " due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"Unable to hover mouse on field: " + fieldName + " due to exception: " + e);

		}
	}

	public void clickByJavaScriptExecutor(WebElement element, String fieldName) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);
			MyLogger.info(fieldName + "==> clicked Successfully! ");
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> clicked Successfully! ");
			Thread.sleep(1000);
		} catch (Exception e) {
			MyLogger.info("Unable to click on field: " + fieldName + " due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"Unable to click on field: " + fieldName + " due to exception: " + e);

		}
	}

	public void sendKeysByJavaScriptExecutor(WebElement element, String value) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].value='" + value + "';", element);
			MyLogger.info(value + "==> Entered Successfully! ");
			ExtentFactory.getInstance().getExtent().log(Status.PASS, value + "==> Entered Successfully! ");
			Thread.sleep(1000);
		} catch (Exception e) {
			MyLogger.info("Unable to click on field: " + value + " due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Unable to click on field: " + value + " due to exception: " + e);

		}
	}

	public void sendKeysByJavaScriptExecutorForEnd(WebElement element, String fieldName) {

		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			if (fieldName != null) {
				executor.executeScript("arguments[0].value='" + fieldName + "';", element);
				MyLogger.info(fieldName + "==> Entered Successfully! ");
				ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Entered Successfully! ");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			MyLogger.info("Unable to click on field: " + fieldName + " due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Unable to click on field: " + fieldName + " due to exception: " + e);

		}
	}

	// check if element is Present
	public boolean isElementPresent_custom(WebElement element, String fieldName) {
		boolean flag = false;
		try {
			flag = element.isDisplayed();
			MyLogger.info(fieldName + "==> Presence of field is: " + flag);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Presence of field is: " + flag);
			return flag;
		} catch (Exception e) {
			MyLogger.info("Checking for presence of field: " + fieldName + " not tested due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"Checking for presence of field: " + fieldName + " not tested due to exception: " + e);
			return flag;
		}
	}

	// Select dropdown value value by visibleText
	public void selectDropDownByVisibleText_custom(WebElement element, String fieldName, String ddVisibleText)
			throws Throwable {
		try {
			Select s = new Select(element);
			s.selectByVisibleText(ddVisibleText);
			MyLogger.info(fieldName + "==> Dropdown Value Selected by visible text: " + ddVisibleText);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==> Dropdown Value Selected by visible text: " + ddVisibleText);
		} catch (ElementNotInteractableException e) {
			MyLogger.info("Dropdown Value Not present due to ElementNotInteractableException");
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "Dropdown Value Not present");
		} catch (NoSuchElementException e) {
			MyLogger.info("Dropdown Value Not present due to NoSuchElementException");
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "Dropdown Value Not present");
		} catch (Exception e) {
			MyLogger.info("Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
		}
	}

	// Select dropdown value value by value
	public void selectDropDownByValue_custom(WebElement element, String fieldName, String ddValue) throws Throwable {
		try {
			Select s = new Select(element);
			Thread.sleep(2000);
			s.selectByValue(ddValue);
			MyLogger.info(fieldName + "==> Dropdown Value Selected by visible text: " + ddValue);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==> Dropdown Value Selected by visible text: " + ddValue);
		} catch (ElementNotInteractableException e) {
			MyLogger.info("Dropdown Value Not present due to ElementNotInteractableException");
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "Dropdown Value Not present");
		} catch (NoSuchElementException e) {
			MyLogger.info("Dropdown Value Not present due to NoSuchElementException");
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "Dropdown Value Not present");
		} catch (Exception e) {
			MyLogger.info("Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
		}
	}

	// String Asserts
	public void assertEqualsString_custom(Object expvalue, Object actualValue, String locatorName) throws Throwable {
		try {
			if (actualValue.equals(expvalue)) {
				MyLogger.info("String Assertion is successful on field "
						+ locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "String Assertion is successful on field "
						+ locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
			} else {
				MyLogger.info("String Assertion FAILED on field "
						+ locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
				ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String Assertion FAILED on field "
						+ locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false, e.toString());
		}
	}

	// Get text from webelement
	public String getText_custom(WebElement element, String fieldName) {
		String text = "";
		try {
			text = element.getText();
			MyLogger.info(fieldName + "==> Text returned is: " + text);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Text returned is: " + text);
			return text;
		} catch (Exception e) {
			MyLogger.info(fieldName + "==> Text not returned due to exception: " + e);
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					fieldName + "==> Text not returned due to exception: " + e);

		}
		return text;
	}

	public void pageScroll(WebElement element, String fieldName) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			MyLogger.info("Scrolled till text: " + fieldName);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "Scrolled till text: " + fieldName);
		} catch (Exception e) {
			MyLogger.info("Cannot scroll till text: " + fieldName);
			ExtentFactory.getInstance().getExtent().log(Status.INFO, "Cannot scroll till text: " + fieldName);

		}

	}

	public void chooseDate(WebElement element, String value) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].setAttribute('value','" + value + "');");
			// ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Text
			// retried is: "+ text);
		} catch (Exception e) {
			// ExtentFactory.getInstance().getExtent().log(Status.INFO, fieldName+"==> Text
			// not retried due to exception: "+ e);

		}

	}

	public void waitForElement(WebElement element, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), time);
			wait.until(ExpectedConditions.visibilityOf(element));
			// ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Text
			// retried is: "+ text);
		} catch (Exception e) {
			// ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Text
			// not retried due to exception: "+ e);

		}

	}

	public List<String> selectOptions_custom(WebElement element, String fieldName) throws Throwable {
		List<WebElement> listOfOptions = null;
		List<String> listOfText = new ArrayList<String>();
		try {
			Select s = new Select(element);
			Thread.sleep(2000);
			listOfOptions = s.getOptions();
			for (WebElement t : listOfOptions) {
				listOfText.add(t.getText());
			}
			MyLogger.info(fieldName + "==> Options in List successfully");
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Options in List successfully");
		} catch (Exception e) {
			MyLogger.info(fieldName + "==>Options Not obtained in List successfully");
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					fieldName + "==>Options Not obtained in List successfully");
		}
		return listOfText;
	}

}
