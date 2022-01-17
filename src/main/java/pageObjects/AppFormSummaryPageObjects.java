// Author: Pratik Dhanashri
package pageObjects;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testautomationguru.utility.PDFUtil;

import reusableComponents.ExpiryDateValue;
import testBase.DriverFactory;
import testBase.TestBase;

public class AppFormSummaryPageObjects extends TestBase {
	ExpiryDateValue ED = new ExpiryDateValue();

	By btn_GenPolForms = By.xpath("//a[text()='Generate Policy Forms']");
	By btn_DownloadRatesheet = By.xpath("//a[text()='Download Ratesheet']");
	By btn_Reject = By.xpath("//*[@id=\"btnPolicyReject\"]");
	By btn_Hold = By.xpath("//*[@id=\"btnPolicyOnHold\"]");
	By btn_DownloadApplication = By.xpath("//*[@id=\"btnDownloadApplicationForm\"]");
	By btn_ReviewApplication = By.xpath("//*[@id=\"idReviewApplication\"]");
	By Mortgagee_x = By.xpath("//*[@id=\"ddlNoOfMortgagee-1\"]");
	By AdditionalIn_x = By.xpath("//*[@id=\"ddlAdditionalInsured-1\"]");
	By LossPayee_x = By.xpath("//*[@id=\"ddlLossPayee-1\"]");
	By txt_InsContactName = By.xpath("//*[@id='txtInspectContactName']");
	By txt_InsContactNo = By.xpath("//*[@id='txtInspectContactNo']");
	By txt_HeatYear = By.xpath("//*[@id='txtHeatYear1']");
	By txt_RoofYear = By.xpath("//*[@id='txtRoofYear1']");
	By txt_PlumbingYear = By.xpath("//*[@id='txtPlumbYear1']");
	By txt_WiringYear = By.xpath("//*[@id='txtWiringYear1']");
	By btn_GenPolicyForms = By.xpath("//*[@id='btnGeneratePolicyForms']");
	By txt_ReqFormNames = By.xpath("//h5[text()='Required Forms']//parent::div//tbody//td[2]");
	By txt_ReqFormNo = By.xpath("//h5[text()='Required Forms']//parent::div//tbody//td[2]//p");
	By txt_OptFormNames = By
			.xpath("//h5[text()='Optional Forms']//parent::div//tbody//tr[@class!='displayHide']//td[2]//span");
	By txt_OptFormNo = By
			.xpath("//h5[text()='Optional Forms']//parent::div//tbody//tr[@class!='displayHide']//td[2]//p");
	By chk_OptForm = By.xpath(
			"//h5[text()='Optional Forms']//parent::div//tbody//tr[@class!='displayHide']//td[1]//input[@checked='checked']//ancestor::td//following-sibling::td//span");
	By txt_PolicyNumber = By.xpath("//h1[contains(text(),'Congratulations')]");
	By btn_BindPolicy = By.xpath("//button[@id='btnPoliciyBind']");
	By btn_PrimHeatDesc = By.xpath("//input[@id='txtPriHeatDescription1']");
	
	public void enterUWResponse(HashMap<String, String> testData) throws Throwable {
		click_custom(DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//div[contains(text(),'Are any of the following true?')]"
						+ "//ancestor::div[@class='appQuesWrap']//following-sibling::div[@class='appBtnWrap']"
						+ "//label[contains(text(),'" + testData.get("UWQ2") + "')]")),
				"UW Question");

		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//div[contains(text(),'Is any applicant considered high-profile such as politician, entertainer or professional athlete?')]"
						+ "//ancestor::div[@class='appQuesWrap']//following-sibling::div[@class='appBtnWrap']"
						+ "//label[contains(text(),'" + testData.get("UWQ3") + "')]")),
				"UW Question");

		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//div[contains(text(),'Is any applicant considered high-profile such as politician, entertainer or professional athlete?')]"
						+ "//ancestor::div[@class='appShow']//following-sibling::div[@class='appHide cls145']//input")),
				"txt_uwText", "Testing");

		click_custom(DriverFactory.getInstance().getDriver()
				.findElement(By.xpath(
						"//div[contains(text(),'Coverage declined, cancelled or non-renewed during the last 3 years?')]"
								+ "//ancestor::div[@class='appQuesWrap']//following-sibling::div[@class='appBtnWrap']"
								+ "//label[contains(text(),'" + testData.get("UWQ4") + "')]")),
				"UW Question");

		click_custom(DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//div[contains(text(),'Any business on the premises?')]"
						+ "//ancestor::div[@class='appQuesWrap']//following-sibling::div[@class='appBtnWrap']"
						+ "//label[contains(text(),'" + testData.get("UWQ5") + "')]")),
				"UW Question");

		click_custom(DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//div[contains(text(),'Any existing and/or unrepaired damage to the property?')]"
						+ "//ancestor::div[@class='appQuesWrap']//following-sibling::div[@class='appBtnWrap']"
						+ "//label[contains(text(),'" + testData.get("UWQ6") + "')]")),
				"UW Question");

		for (int i = 1; i <= Integer.parseInt(testData.get("noofclaims")); i++) {
			Thread.sleep(2000);
			click_custom(
					DriverFactory.getInstance().getDriver().findElement(
							By.xpath("//input[@id='txtClaimLossDate" + i + "']//following-sibling::input")),
					"Claim Date");
			Thread.sleep(2000);
			click_custom(DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//div[contains(@class,'flatpickr-calendar animate open')]//span[@aria-label='"
							+ testData.get("Claim Date") + "']")),
					"Date");
			sendKeys_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//input[@id='txtClaimAmount" + i + "']")), "txtClaimAmount", "1000");
			selectDropDownByVisibleText_custom(
					DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//select[@id='ddlIncidentType" + i + "']")),
					"dd_typeOfIncident", "Fire and Lightning");
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//textarea[@id='txtClaimRemark" + i + "']")), "txt_claimRemark", "Testing" + i);
		}

		click_custom(DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//div[@class='gradBtnGroup claimed col-100 floatLft']//label[text()='"
						+ testData.get("noOfMortgagee") + "']")),
				"No Of Mortgagee");

		for (int i = 1; i <= Integer.parseInt(testData.get("noOfMortgagee")); i++) {
			sendKeys_custom(
					DriverFactory.getInstance().getDriver().findElement(
							By.xpath("//input[@id='txtMortgageeName" + testData.get("noOfMortgagee") + "']")),
					"Name" + i, "Name" + i);
			sendKeys_custom(
					DriverFactory.getInstance().getDriver().findElement(
							By.xpath("//input[@id='txtMailingAddress" + testData.get("noOfMortgagee") + "']")),
					"Add" + i, "Add" + i);
			sendKeys_custom(
					DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//input[@id='txtLoanNumber" + testData.get("noOfMortgagee") + "']")),
					"LoanNo" + i, "LoanNo" + i);
		}

		// click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Continue),"Continue
		// button");

	}

	public void VerifyPropertyAddressDetails(HashMap<String, String> testData) throws Throwable {
		for (int i = 1; i <= Integer.parseInt(testData.get("No of Properties")); i++) {
			System.out.println(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'Year Built')]//following-sibling::div\n"))
					.getText());
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'Year Built')]//following-sibling::div\n"))
					.getText(), testData.get("Year Built" + i), "Year Built");

			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'Square Feet')]//following-sibling::div\n"))
					.getText(), testData.get("Square Feet" + i), "Square Feet");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'No of Families')]//following-sibling::div\n"))
					.getText(), testData.get("No Of Families" + i), "No of Families");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'# of Acres')]//following-sibling::div\n"))
					.getText(), testData.get("No Of Acres" + i), "No of Acres");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'Protection Class')]//following-sibling::div\n"))
					.getText(), testData.get("Prot Class" + i), "Protection Class");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'Distance to the Coast')]//following-sibling::div\n"))
					.getText(), testData.get("DTC" + i), "Distance to the Coast");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'Dwelling(RCV)')]//following-sibling::div\n"))
					.getText().toString().replace("$", "").replace(",", ""), testData.get("Coverage A" + i),
					"Dwelling(RCV)");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'Construction Type')]//following-sibling::div\n"))
					.getText(), testData.get("Construction Type" + i), "Construction Type");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'Central Fire Installed?')]//following-sibling::div\n"))
					.getText(), testData.get("Central Fire Installed?" + i), "Central Fire Installed?");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Build')]//parent::h2//following-sibling::div//h5[contains(text(),'Central Burglar Alarm installed?')]//following-sibling::div\n"))
					.getText(), testData.get("Central Station Burglar and/or Fire Credit" + i),
					"Central Burglar Alarm installed?");
			assertEqualsString_custom(
					DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//*[@id=\"ddlPrimaryHeatingType" + i + "\"]")).isEnabled(),
					true, "Primary Heating Type");
			assertEqualsString_custom(
					DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//*[@id=\"txtPriHeatDescription" + i + "\"]")).isEnabled(),
					true, "Primary Heat Description");
			assertEqualsString_custom(
					DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//*[@id=\"ddlSecondHeatingType" + i + "\"]")).isEnabled(),
					true, "Secondary Heating Type");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//*[@id=\"txtHeatYear" + i + "\"]")).isEnabled(), true, "Heat Year");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//*[@id=\"txtRoofYear" + i + "\"]")).isEnabled(), true, "Roof Year");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//*[@id=\"txtPlumbYear" + i + "\"]")).isEnabled(), true, "Plumb Year");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//*[@id=\"txtWiringYear" + i + "\"]")).isEnabled(), true, "Wiring Year");
		}
	}

	public void VerifyPropertyAddressCoveragesDetails(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		for (int i = 1; i <= Integer.parseInt(testData.get("No of Properties")); i++) {
			// Policy Deductibles
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Coverage')]//parent::h2//following-sibling::div//h5[contains(text(),'All Other Perils')]//following-sibling::div\n"))
					.getText().toString().replace("$", "").replace(",", ""), testData.get("AOP" + i),
					"All Other Perils");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Coverage')]//parent::h2//following-sibling::div//h5[contains(text(),'Wind/Hail Deductible')]//following-sibling::div\n"))
					.getText().toString().replace("$", "").replace(",", ""), testData.get("Wind Deductible" + i),
					"Wind/Hail Deductible");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Coverage')]//parent::h2//following-sibling::div//h5[contains(text(),'Water Damage Deductible')]//following-sibling::div\n"))
					.getText().toString().replace("$", "").replace(",", ""),
					testData.get("Water Damage Deductible" + i), "Water Damage Deductible");
			// Coverage Details
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Coverage')]//parent::h2//following-sibling::div//h5[contains(text(),'Coverage A - Dwelling')]//following-sibling::div\n"))
					.getText().toString().replace("$", "").replace(",", ""), testData.get("Coverage A" + i),
					"Coverage A - Dwelling");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Coverage')]//parent::h2//following-sibling::div//h5[contains(text(),'Coverage B - Other structures')]//following-sibling::div\n"))
					.getText().toString().replace("$", "").replace(",", ""), testData.get("Coverage B" + i),
					"Coverage B - Other structures");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Coverage')]//parent::h2//following-sibling::div//h5[contains(text(),'Coverage C - Personal Property')]//following-sibling::div\n"))
					.getText().toString().replace("$", "").replace(",", ""), testData.get("Coverage C" + i),
					"Coverage C - Personal Property");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Coverage')]//parent::h2//following-sibling::div//h5[contains(text(),'Coverage D - Loss of use')]//following-sibling::div\n"))
					.getText().toString().replace("$", "").replace(",", ""), testData.get("Coverage D" + i),
					"Coverage D - Loss of use");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Coverage')]//parent::h2//following-sibling::div//h5[contains(text(),'Coverage E - Personal Liability')]//following-sibling::div\n"))
					.getText().toString().replace("$", "").replace(",", ""), testData.get("Coverage E" + i),
					"Coverage E - Personal Liability");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Coverage')]//parent::h2//following-sibling::div//h5[contains(text(),'Coverage F – Medical Payments')]//following-sibling::div\n"))
					.getText().toString().replace("$", "").replace(",", ""), testData.get("Coverage F" + i),
					"Coverage F – Medical Payments");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//button[contains(text(),'Property Address " + i
							+ " - Coverage')]//parent::h2//following-sibling::div//h5[contains(text(),'Water Backup Coverage')]//following-sibling::div\n"))
					.getText(), testData.get("Water Backup" + i), "Water Backup Coverage");

			assertEqualsString_custom(
					DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//*[@id=\"ddlNoOfMortgagee-" + i + "\"]")).isEnabled(),
					true, "Mortgagee Details"); // Mortgagee Details DD enable
			assertEqualsString_custom(
					DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//*[@id=\"ddlAdditionalInsured-" + i + "\"]")).isEnabled(),
					true, "Additional Insured"); // AdditionalInsured DD enable
			assertEqualsString_custom(DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//*[@id=\"ddlLossPayee-" + i + "\"]")).isEnabled(), true, "Loss Payee"); // LossPayee
																													// DD
																													// enable

		}
	}

	public void ValidateUWrules(HashMap<String, String> testData) throws Throwable {
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//button[contains(text(),'Underwriting Factors')]//parent::h2//following-sibling::div//h5[contains(text(),'Does the applicant own any Dogs?')]//following-sibling::div\n"))
				.getText(), testData.get("UWQ1"), "UWQ1");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//button[contains(text(),'Underwriting Factors')]//parent::h2//following-sibling::div//h5[contains(text(),'Does the applicant have a swimming pool?')]//following-sibling::div\n"))
				.getText(), testData.get("UWQ2"), "UWQ2");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//button[contains(text(),'Underwriting Factors')]//parent::h2//following-sibling::div//h5[contains(text(),'Is business conducted at the insured location?')]//following-sibling::div\n"))
				.getText(), testData.get("UWQ3"), "UWQ3");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//button[contains(text(),'Underwriting Factors')]//parent::h2//following-sibling::div//h5[contains(text(),'Has any coverage been declined, cancelled of non-renewed during the last three (3) years?')]//following-sibling::div\n"))
				.getText(), testData.get("UWQ4"), "UWQ4");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//button[contains(text(),'Underwriting Factors')]//parent::h2//following-sibling::div//h5[contains(text(),'Has Applicant had a foreclosure, repossession, bankruptcy or filed for bankruptcy during the past five (5) years?')]//following-sibling::div\n"))
				.getText(), testData.get("UWQ5"), "UWQ5");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//button[contains(text(),'Underwriting Factors')]//parent::h2//following-sibling::div//h5[contains(text(),'Has Applicant had a judgement or lien during the past five (5) years?')]//following-sibling::div\n"))
				.getText(), testData.get("UWQ6"), "UWQ6");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//button[contains(text(),'Underwriting Factors')]//parent::h2//following-sibling::div//h5[contains(text(),'During the last five (5) years has any applicant been indicted for or convicted of any degree of the crime of fraud, bribery, arson or any other arson-related crime in connection with this or other property?')]//following-sibling::div\n"))
				.getText(), testData.get("UWQ7"), "UWQ7");

	}

	public void ReviewButton() {
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_ReviewApplication),
				"Review Application");
	}

	public void ValidatePolicyHistoryAndInspections(HashMap<String, String> testData) throws Throwable {
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//button[contains(text(),'Prior History and Inspections')]//parent::h2//following-sibling::div//h5[contains(text(),'Is the property currently insured?')]//following-sibling::div\n"))
				.getText(), testData.get("Is the property currently insured?"), "Is the property currently insured?");
		if (testData.get("Is the property currently insured?").equals("Yes")) {
			assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
					"//button[contains(text(),'Prior History and Inspections')]//parent::h2//following-sibling::div//h5[contains(text(),'Prior Insurance Company')]//following-sibling::div\n"))
					.getText(), testData.get("Prior Insurance Company"), "Prior Insurance Company");
			System.out.println(ED.ChangeFormatOfDate(testData.get("Insurance Expiry Date")));
			assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
					"//button[contains(text(),'Prior History and Inspections')]//parent::h2//following-sibling::div//h5[contains(text(),'Insurance Expiry Date')]//following-sibling::div\n"))
					.getText(), ED.ChangeFormatOfDate(testData.get("Insurance Expiry Date")), "Insurance Expiry Date");
		} else {
			assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
					"//button[contains(text(),'Prior History and Inspections')]//parent::h2//following-sibling::div//h5[contains(text(),'Is the property currently insured?')]//following-sibling::div\n"))
					.getText(), testData.get("Is the property currently insured?"),
					"Is the property currently insured?");
		}
		if (testData.get("No of claims").equals("0")) {
			assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath(
					"//button[contains(text(),'Prior History and Inspections')]//parent::h2//following-sibling::div//h5[contains(text(),'Number of home insurance claims in the last 5 years?')]//following-sibling::div\n"))
					.getText(), testData.get("No of claims"), "Number of home insurance claims in the last 5 years?");
		} else {
			int z = 1;
			for (int i = 1; i <= Integer.parseInt(testData.get("No of claims")); i++) {
				System.out.println(ED.ChangeFormatOfDate(testData.get("Claim Date " + i)));
				assertEqualsString_custom(
						DriverFactory.getInstance().getDriver()
								.findElement(By.xpath("//div[@class='col-xl-2 col-lg-3'][" + i + "]//div")).getText(),
						ED.ChangeFormatOfDate(testData.get("Claim Date " + i)), "Date of Loss");
				for (int j = z; j <= Integer.parseInt(testData.get("No of claims")) * i;) {
					assertEqualsString_custom(
							DriverFactory.getInstance().getDriver()
									.findElement(By.xpath("//div[@class='col-xl-3 col-lg-3'][" + j + "]//div"))
									.getText().toString().replace("$", "").replace(",", ""),
							testData.get("Claim Amount " + i), "Amount Paid");
					j++;
					assertEqualsString_custom(DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//div[@class='col-xl-3 col-lg-3'][" + j + "]//div")).getText(),
							testData.get("Incident " + i), "Type of Incident");
					j++;
					assertEqualsString_custom(DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//div[@class='col-xl-3 col-lg-3'][" + j + "]//div")).getText(),
							testData.get("Claim Desc " + i), "Claim Description");
					j++;
				}
				z = z + 3;

			}
		}

	}

	// Complete implementation pending
	public void VerifyMortgageeDetails(HashMap<String, String> testData) throws Throwable {
		int a = Integer.parseInt(testData.get("Mortgagee"));
		// String
		// b=DriverFactory.getInstance().getDriver().findElement(Mortgagee).getText();
		if (!testData.get("Mortgagee").equals("0")) {
			for (int i = 0, j = 1; i < a && j <= a; i++, j++) {
				Thread.sleep(5000);
				assertEqualsString_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id=\"txtMortgageeName1-" + i + "\"]")).getAttribute("value").trim(),
						testData.get("Mortgagee Name " + j), "Mortgagee Name");

				System.out.println(testData.get("Mortgagee Address " + j) + "testData.get(\"Mortgagee Address \"+j)");
				System.out.println(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id=\"txtMailingAddress1-" + i + "\"]")).getAttribute("value")
						+ "D");

				assertEqualsString_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id=\"txtMailingAddress1-" + i + "\"]")).getAttribute("value"),
						testData.get("Mortgagee Address " + j), "Mortgagee Address");

				assertEqualsString_custom(
						DriverFactory.getInstance().getDriver()
								.findElement(By.xpath("//*[@id=\"txtLoanNumber1-" + i + "\"]")).getAttribute("value"),
						testData.get("Loan Number " + j), "Loan Number");
				assertEqualsString_custom(
						DriverFactory.getInstance().getDriver()
								.findElement(By.xpath("//*[@id=\"grpMortgageeId1-" + i + "\"]")).getAttribute("value"),
						testData.get("assigned " + j), "assigned-yes or no");
			}
		}

	}

	// Complete implementation pending
	public void VerifyAdditionalIntrest(HashMap<String, String> testData) throws Throwable {
		int a = Integer.parseInt(testData.get("Additional Insured"));
		// String
		// b=DriverFactory.getInstance().getDriver().findElement(Mortgagee).getText();
		if (!testData.get("Additional Insured").equals("0")) {
			for (int i = 0, j = 1; i < a && j <= a; i++, j++) {
				Thread.sleep(5000);
				assertEqualsString_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id=\"txtLossPayeeName1-" + i + "\"]")).getAttribute("value"),
						testData.get("Name Test " + j), "Name Test");
				assertEqualsString_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id=\"txtLPMailingAddress1-" + i + "\"]")).getAttribute("value"),
						testData.get("Address Test " + j), "Address Test");
				assertEqualsString_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id=\"txtLossPayeeInterest1-" + i + "\"]")).getAttribute("value"),
						testData.get("Interest Test " + j), "Interest Test");
			}
		}
	}

	// Complete implementation pending
	public void VerifyLossPayee(HashMap<String, String> testData) throws Throwable {
		int a = Integer.parseInt(testData.get("No of Loss Payee"));
		// String
		// b=DriverFactory.getInstance().getDriver().findElement(Mortgagee).getText();
		if (!testData.get("No of Loss Payee").equals("0")) {
			for (int i = 0, j = 1; i < a && j <= a; i++, j++) {
				Thread.sleep(5000);
				assertEqualsString_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id=\"txtLossPayeeName1-" + i + "\"]")).getAttribute("value"),
						testData.get("Loss Name " + j), "Loss Name");
				assertEqualsString_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id=\"txtLPMailingAddress1-" + i + "\"]")).getAttribute("value"),
						testData.get("Loss Address " + j), "Loss Addres");
				assertEqualsString_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id=\"txtLossPayeeInterest1-" + i + "\"]")).getAttribute("value"),
						testData.get("Loss Interest " + j), "Loss Interest");
			}
		}
	}

	public void AllButtonsEnabledOnScreen() throws Throwable {

		assertEqualsString_custom(
				DriverFactory.getInstance().getDriver().findElement(btn_DownloadRatesheet).isEnabled(), true,
				"Download Ratesheet");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_Reject).isEnabled(), true,
				"Reject");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_Hold).isEnabled(), true,
				"On-Hold");
		assertEqualsString_custom(
				DriverFactory.getInstance().getDriver().findElement(btn_DownloadApplication).isEnabled(), true,
				"Download Application");
		assertEqualsString_custom(
				DriverFactory.getInstance().getDriver().findElement(btn_ReviewApplication).isEnabled(), true,
				"Review Application");
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(btn_GenPolForms).isEnabled(),
				true, "Generate Policy Forms");

	}

	public void validateSummaryScreenURL(HashMap<String, String> testData) throws Throwable {
		Thread.sleep(5000);
		String currenURL = DriverFactory.getInstance().getDriver().getCurrentUrl();
		// System.out.println("Summary Page"+currenURL);
		assertEqualsString_custom(currenURL, testData.get("Summary Form Page URL"), "Summary Form Page URL");

	}

	public void enterDetailsNotEnteredIntoApp() {

		sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(txt_InsContactName),
				"txt_InsContactName");
		sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(txt_InsContactNo),
				"9999999999");
		sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(txt_HeatYear), "1990");
		sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(txt_RoofYear), "1990");
		sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(txt_PlumbingYear), "1990");
		sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(txt_WiringYear), "1990");
		sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_PrimHeatDesc), "Test");
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_GenPolicyForms),
				"PolicyForms");

	}


	
	public void validateReqForm(HashMap<String, String> testData) throws Throwable {
		List<String> listOfFormNames = new ArrayList<String>();
		List<WebElement> webListOfFormNames = DriverFactory.getInstance().getDriver().findElements(txt_ReqFormNames);
		Map<String,String> mapOfActualForm = new HashMap<String,String>();
		Map<String,String> mapOfActualFormNameCorrectness = new HashMap<String,String>();
		Thread.sleep(5000);
		for (WebElement l : webListOfFormNames) {
			if (l.getText() != null || l.getText() != "") {
				String[] temp = l.getText().trim().split("\n");
				listOfFormNames.add(temp[0]);
				listOfFormNames.add(temp[1]);
				mapOfActualForm.put(temp[1],temp[0]);
				mapOfActualFormNameCorrectness.put(temp[0],temp[1]);
			}
		}

		System.out.println("Map Of Actual Forms " + mapOfActualForm);
		
		
		String[] strOfFormNamesAndNum = testData.get("Exp Req Form").split("\n");

		List<String> tempListOfFormNamesAndNum = Arrays.asList(strOfFormNamesAndNum);

		Map<String, String> mapOfExpectedForm = new LinkedHashMap<String, String>();
		Map<String, String> mapOfExpectedFormNameCorrectness = new LinkedHashMap<String, String>();

		for (int i = 0; i < tempListOfFormNamesAndNum.size(); i = i + 1) {

			String[] tempFormNameAndNum = strOfFormNamesAndNum[i].split("&");
			mapOfExpectedForm.put(tempFormNameAndNum[0], tempFormNameAndNum[1]);
			mapOfExpectedFormNameCorrectness.put(tempFormNameAndNum[1], tempFormNameAndNum[0]);

		}

		System.out.println("Map Of Required Forms " + mapOfExpectedForm);

		if (mapOfExpectedForm.equals(mapOfActualForm)) {
			assertEquals(true, true);
		}else {
			HashSet<String> expFormNoComparison = new HashSet<>(mapOfExpectedForm.keySet());
			expFormNoComparison.addAll(mapOfActualForm.keySet());

			expFormNoComparison.removeAll(mapOfExpectedForm.keySet());

			System.out.println("Extra Form number present in Actual are " + expFormNoComparison);

			HashSet<String> actFormNoComparison = new HashSet<>(mapOfActualForm.keySet());
			actFormNoComparison.addAll(mapOfExpectedForm.keySet());

			actFormNoComparison.removeAll(mapOfActualForm.keySet());

			System.out.println("Extra Form number present in Expected are  " + actFormNoComparison);
			
			// Validating Form names similarity
			HashSet<String> expFormNameComparison = new HashSet<>(mapOfExpectedFormNameCorrectness.keySet());
			expFormNameComparison.addAll(mapOfActualFormNameCorrectness.keySet());

			expFormNameComparison.removeAll(mapOfExpectedFormNameCorrectness.keySet());

			System.out.println("Incorrect Form name present in Actual are " + expFormNameComparison);

			HashSet<String> actFormNameComparison = new HashSet<>(mapOfActualFormNameCorrectness.keySet());
			actFormNameComparison.addAll(mapOfExpectedFormNameCorrectness.keySet());

			actFormNameComparison.removeAll(mapOfActualFormNameCorrectness.keySet());

			System.out.println("As per expected Form Name should be  " + actFormNameComparison);
			
			assertEquals(true, false, "Form mismatch between actual and expected");
		}
		
		
		
		
	}

	public void validateOptForm(HashMap<String, String> testData) throws Throwable {
		
		Map<String,String> mapOfActualForm = new HashMap<String,String>();
		Map<String,String> mapOfActualFormNameCorrectness = new HashMap<String,String>();

		List<WebElement> webListOfFormNames = DriverFactory.getInstance().getDriver().findElements(txt_OptFormNames);
		List<WebElement> webListOfFormNo = DriverFactory.getInstance().getDriver().findElements(txt_OptFormNo);
		for (int i=0;i<webListOfFormNames.size();i++) {
			if (!webListOfFormNames.get(i).getText().equals(null) || webListOfFormNames.get(i).getText().equals("")) {
				String[] formName = webListOfFormNames.get(i).getText().trim().split("\n");
				String[] formNo = webListOfFormNo.get(i).getText().trim().split("\n");
				mapOfActualFormNameCorrectness.put(formName[0], formNo[0]);
				mapOfActualForm.put(formNo[0], formName[0]);
			}
		}
		
		System.out.println("Map Of Actual Optional Forms " + mapOfActualForm);
		
		
		String[] strOfFormNamesAndNum = testData.get("Exp Opt Form").split("\n");

		List<String> tempListOfFormNamesAndNum = Arrays.asList(strOfFormNamesAndNum);

		Map<String, String> mapOfExpectedForm = new LinkedHashMap<String, String>();
		Map<String, String> mapOfExpectedFormNameCorrectness = new LinkedHashMap<String, String>();

		for (int i = 0; i < tempListOfFormNamesAndNum.size(); i = i + 1) {

			String[] tempFormNameAndNum = strOfFormNamesAndNum[i].split("&");
			mapOfExpectedForm.put(tempFormNameAndNum[0], tempFormNameAndNum[1]);
			mapOfExpectedFormNameCorrectness.put(tempFormNameAndNum[1], tempFormNameAndNum[0]);

		}

		System.out.println("Map Of Expected Optional Forms " + mapOfExpectedForm);

		if (mapOfExpectedForm.equals(mapOfActualForm)) {
			assertEquals(true, true);
		}else {
			HashSet<String> expFormNoComparison = new HashSet<>(mapOfExpectedForm.keySet());
			expFormNoComparison.addAll(mapOfActualForm.keySet());

			expFormNoComparison.removeAll(mapOfExpectedForm.keySet());

			System.out.println("Extra Form number present in Actual are " + expFormNoComparison);

			HashSet<String> actFormNoComparison = new HashSet<>(mapOfActualForm.keySet());
			actFormNoComparison.addAll(mapOfExpectedForm.keySet());

			actFormNoComparison.removeAll(mapOfActualForm.keySet());

			System.out.println("Extra Form number present in Expected are  " + actFormNoComparison);
			
			// Validating Form names similarity
			HashSet<String> expFormNameComparison = new HashSet<>(mapOfExpectedFormNameCorrectness.keySet());
			expFormNameComparison.addAll(mapOfActualFormNameCorrectness.keySet());

			expFormNameComparison.removeAll(mapOfExpectedFormNameCorrectness.keySet());

			System.out.println("Incorrect Form name present in Actual are " + expFormNameComparison);

			HashSet<String> actFormNameComparison = new HashSet<>(mapOfActualFormNameCorrectness.keySet());
			actFormNameComparison.addAll(mapOfExpectedFormNameCorrectness.keySet());

			actFormNameComparison.removeAll(mapOfActualFormNameCorrectness.keySet());

			System.out.println("As per expected Form Name should be  " + actFormNameComparison);
			
			assertEquals(true, false, "Form mismatch between actual and expected");
		}
	}

	

	public void validateCheckedForms(HashMap<String, String> testData) throws Throwable {
		List<String> actListOfFormNames = new ArrayList<String>();
		List<String> expListOfFormNames = new ArrayList<String>();
		List<WebElement> webListOfChkFormNames = DriverFactory.getInstance().getDriver().findElements(chk_OptForm);
		for (WebElement l : webListOfChkFormNames) {
			if (!l.getText().equals(null) || l.getText().equals("")) {
				String[] temp = l.getText().trim().split("\n");
				actListOfFormNames.add(temp[0]);
			}
		}

		System.out.println("List of actual checked Optional Forms Name is " + actListOfFormNames);
		String[] strArrOfFormNames = testData.get("Opt Checked Form Names").split("\n");
		for(String s : strArrOfFormNames) {
			expListOfFormNames.add(s.trim());
		}
		
		System.out.println("List of expected checked Optional Forms Name is " + expListOfFormNames );
		
		if (expListOfFormNames.equals(actListOfFormNames)) {
			assertEquals(true, true);
		}else {
			List<String> extraFormListFromExp = new ArrayList<>(expListOfFormNames);
			extraFormListFromExp.removeAll(actListOfFormNames);
			
			System.out.println("Extra Forms in Expected are "+ extraFormListFromExp);
			
			List<String> extraFormListFromAct = new ArrayList<>(actListOfFormNames);
			extraFormListFromAct.removeAll(expListOfFormNames);
			
			System.out.println("Extra Forms in Actuals are "+ extraFormListFromAct);
		}
		
	}
	
	public void extractTextFromPDF(String filePath) throws IOException, InterruptedException {
		
		
		/*DriverFactory.getInstance().getDriver().get("file:///C:/Movie/Attachment2.pdf");
		String currentURL = DriverFactory.getInstance().getDriver().getCurrentUrl(); 
		URL url = new URL(currentURL);
		System.out.println("URL is "+ currentURL);
		InputStream is = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;
		
		document = PDDocument.load(fileParse);
		Thread.sleep(5000);
		
		String pdfContent = new PDFTextStripper().getText(document);
		System.out.println("PDF Content is "+ pdfContent);*/
		
		PDFUtil pdfUtil = new PDFUtil();
		String content = pdfUtil.getText(filePath);
		System.out.println("Content is "+ content);
		
		
	}
	
	public String clickOnBindPolicyAndExtractPolicyNo() throws InterruptedException {
		Thread.sleep(5000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_BindPolicy), "Bind Policy");
		Thread.sleep(60000);
		String polNo = "NELL" + getText_custom(DriverFactory.getInstance().getDriver().findElement(txt_PolicyNumber),"Policy No").replaceAll("[^0-9]", "");
		System.out.println("Policy Number is "+ polNo);
		return polNo;
		
	}

}
