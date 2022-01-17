package pageObjects;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import reusableComponents.DBUtil;
import reusableComponents.DateTimeUtil;
import testBase.DriverFactory;
import testBase.TestBase;

public class EndPageObjects extends TestBase {

	DBUtil dBUtil = new DBUtil();
	By btn_Save = By.xpath("//a[text()='Save & Continue']");
	By btn_Update = By.xpath("//*[contains(@id,'divUpdate') and @style!='display:none']//a[text()=' Update ']");
	By btn_PolicyHolder = By.xpath("//a[text()='Policy Holder']");
	By btn_BuildInterior = By.xpath("//a[text()='Build, Interior & Exterior']");
	By btn_PriorHistory = By.xpath("//a[text()='Prior History and Inspections']");
	By btn_CovAndMort = By.xpath("//a[text()='Coverage & Mortgage']");
	By btn_Underwriting = By.xpath("//a[text()='Underwriting']");
	By btn_Contracts = By.xpath("//a[text()='Contracts']");
	By btn_Adjustments = By.xpath("//a[text()='Adjustments']");

	By btn_EditApplicant = By.xpath("//a[@id='btnEditApplicant']");
	By btn_EditPriorHistory = By.xpath("//a[@id='btnEditPriorHistory']");
	By btn_EditUnderWriting = By.xpath("//a[@id='btnEditRiskQualifiers']");
	By btn_EditContracts = By.xpath("//a[@id='btnEditContracts']");
	By btn_EditAdjustments = By.xpath("//a[@id='btnEditAdjustmentDetails']");

	By dd_InspectionReq = By.xpath("//select[@id='ddlInspectionType']");
	By txt_AgentCommission = By.xpath("//input[@id='txtAgentCommiss']");

	By btn_RecalculatePremium = By.xpath("//button[@id='btnGetPremium']");
	By txt_PriorTermPremium = By.xpath("//h4[text()='Prior Term Premium']//following-sibling::p");
	By txt_RevisedPremium = By.xpath("//h4[text()='Revised Term Premium']//following-sibling::p");
	By txt_EndPremium = By.xpath("//h4[text()='Endorsed Premium']//following-sibling::p");
	By txt_PolicyTerm = By.xpath("//span[text()='Policy Period']//following-sibling::br");
	By btn_EndDate = By.xpath("//input[@placeholder ='Endorsement effective date' and @type='text']");
	By btn_GenForms = By.xpath("//button[@id='btnSubmitForApproval']");
	By btn_ApproveEnd = By.xpath("//button[@id='btnGenerateForms']");

	Map<String, String> mapOfLOBAttributes, mapOfPolicyAttributes;
	DateTimeUtil dateTimeUtil = new DateTimeUtil();

	public void performEndorsement(HashMap<String, String> testData) throws Throwable {

		/*
		 * int noOfUnits = Integer.parseInt(dBUtil.
		 * getResultFromDB("Select count(*) count from pas.policyunits where unitType = 'HO' and "
		 * +
		 * "policyinfoid = (Select  policyinfoid  from pas.PolicyInfo_trn where SystemType ='P' and PolicyNumber = '"
		 * + testData.get("PolicyNo") + "'", "policyinfoid"));
		 */

		int policyInfoId = Integer
				.parseInt(dBUtil.getResultFromDB("Select  *  from pas.PolicyInfo_trn where SystemType ='P' "
						+ "and PolicyNumber = '" + testData.get("PolicyNo") + "'", "policyinfoid"));
		List<String> policyUnits = dBUtil.getResultFromDBAsList(
				"Select * from pas.policyunits where unitType = 'HO' and policyinfoid = " + policyInfoId,
				"PolicyUnitId");

		if (testData.get("FlagPolicyHolder").equals("Y")) {
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_PolicyHolder),
					"Policy Holder Details");
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_EditApplicant),
					"Edit btn Applicant");

			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Update), "btn_Update");
		}

		if (testData.get("FlagBuild").equals("Y")) {
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_BuildInterior),
					"btn_BuildInterior");
			for (int i = 0; i < policyUnits.size(); i++) {
				int j = i + 1;

			}

			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Update), "btn_Update");
		}

		if (testData.get("FlagPriorHistory").equals("Y")) {
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_PriorHistory),
					"btn_PriorHistory");
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_EditPriorHistory),
					"btn_EditPriorHistory");
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_InspectionReq),
					"dd_InspectionReq", testData.get("Inspection Fee"));

			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Update), "btn_Update");
		}

		if (testData.get("FlagCov").equals("Y")) {
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_CovAndMort),
					"btn_CovAndMort");
			for (int i = 0; i < policyUnits.size(); i++) {
				int j = i + 1;
				clickByJavaScriptExecutor(
						DriverFactory.getInstance().getDriver()
								.findElement(By.xpath("//a[@id='btnEditCoverages' and @data-unitnumber=" + j + "]")),
						"Edit Coverage " + j);
				Thread.sleep(2000);
				sendKeysByJavaScriptExecutorForEnd(
						DriverFactory.getInstance().getDriver()
								.findElement(By.xpath("//input[@id='txtBOtherStructure" + j + "']")),
						testData.get("Coverage B" + j));
				sendKeysByJavaScriptExecutorForEnd(
						DriverFactory.getInstance().getDriver()
								.findElement(By.xpath("//input[@id='txtCPersonalProperty" + j + "']")),
						testData.get("Coverage C" + j));
				clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath(
						"//*[contains(@id,'divUpdate') and @style!='display:none']//a[text()=' Update ' and @data-unitnumber="
								+ j + "]")),
						"btn_Update");
				Thread.sleep(21000);

			}

		}

		if (testData.get("FlagUnderWriting").equals("Y")) {
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Underwriting),
					"btn_Underwriting");
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_EditUnderWriting),
					"btn_EditUnderWriting");

			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Update), "btn_Update");
		}

		if (testData.get("FlagContracts").equals("Y")) {
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Contracts),
					"btn_Contracts");
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_EditContracts),
					"btn_EditContracts");

			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Update), "btn_Update");
			Thread.sleep(25000);
		}

		if (testData.get("FlagAdjustments").equals("Y")) {
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Adjustments),
					"btn_Adjustments");
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_EditAdjustments),
					"btn_EditAdjustments");
			sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(txt_AgentCommission),
					testData.get("Agent Commission"));
			Thread.sleep(5000);

			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Update), "btn_Update");
		}

		pageScroll(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium), "Recalculate Premium");
		Thread.sleep(15000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_EndDate),
				"Endorsement Calendar");
		dateTimeUtil
				.selectDateFromCalendar(dateTimeUtil.getDateInCancellationFormat(testData.get("End Effective Date")));
		Thread.sleep(15000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium),
				"Recalculate Premium");
		Thread.sleep(21000);

	}

	public void dbValidation(HashMap<String, String> testData) throws Throwable {

		int policyInfoId = Integer
				.parseInt(dBUtil.getResultFromDB("Select  *  from pas.PolicyInfo_trn where SystemType ='P' "
						+ "and PolicyNumber = '" + testData.get("PolicyNo") + "'", "policyinfoid"));
		List<String> policyUnits = dBUtil.getResultFromDBAsList(
				"Select * from pas.policyunits where unitType = 'HO' and policyinfoid = " + policyInfoId,
				"PolicyUnitId");

		System.out.println("Size of policyunits is " + policyUnits.size());
		for (int i = 0; i < policyUnits.size(); i++) {
			int j = i + 1;

			mapOfLOBAttributes = dBUtil.getResultFromDBAsMap(
					"Select l.name,u.value from pas.unitLOBattributes u\n" + "inner join pas.lobattributes l on\n"
							+ "u.lobattributeid = l.lobattributeid\n" + "where u.policyunitid = " + policyUnits.get(i),
					"name", "value");
			System.out.println(mapOfLOBAttributes);

			validateDifferentUnitAttributesOnEndPageWithDB("lblYearHomeBuild", "Year Built", mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblSquareFeet", "Square Feet", mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblNoOfFamilies", "No of Families", mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblNoAcres", "No Of Acres", mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblProtectionClass", "Protection Class", mapOfLOBAttributes,
					j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblDistToCoast", "Distance to the Coast",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblDwelling", "Dwelling Amount", mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblConstructionType", "Construction Type",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblCentralFireInstalled", "Central Fire Installed?",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblCentralBurglarAlarmInstalled",
					"Central Burglar Alarm Installed?", mapOfLOBAttributes, j);

			validateDifferentUnitAttributesOnEndPageWithDB("lblPrimaryHeatingType", "Primary Heat Source",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblPriHeatDescription", "Primary Heat Source Description",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblSecondHeatingType", "Secondary Heat Source",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblHeatYear", "Heating Update Year", mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblRoofYear", "Roof Update Year", mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblPlumbYear", "Plumbing Update Year", mapOfLOBAttributes,
					j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblWiringYear", "Wiring Update Year", mapOfLOBAttributes,
					j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblCircuitBrk", "Circuit Breakers", mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblKnobTube", "Knob and Tube Wiring", mapOfLOBAttributes,
					j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblPresFuses", "Present Fuses", mapOfLOBAttributes, j);

			// Coverage And Mortgage History - DB names are having space incorrectly which
			// needs to be resolved
			validateDifferentUnitAttributesOnEndPageWithDB("lblAOPDeductible", "AOP Deductible ", mapOfLOBAttributes,
					j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblWindHailDed", "Wind/Hail Deductible", mapOfLOBAttributes,
					j);
			/*
			 * validateDifferentUnitAttributesOnEndPageWithDB("lblWaterDamageDeductible",
			 * "Water Deductible", mapOfLOBAttributes, j);
			 */
			validateDifferentUnitAttributesOnEndPageWithDB("lblDwellingAmount", "Coverage A – Other Structures",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblBOtherStructure", "Coverage B – Other Structures",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblCPersonalProperty", "Coverage C – Personal Property ",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblDLossOfUse", "Coverage D - Loss of use",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblEPersonalLiability", "Coverage E: Personal Liability  ",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblFMedicalPayment", "Coverage F – Medical Payments ",
					mapOfLOBAttributes, j);
			// validateDifferentUnitAttributesOnEndPageWithDB("lblWaterBackupCoverage","Water
			// Backup",mapOfLOBAttributes,j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblReplCost", "Replacement Cost", mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblSchdlProperty", "Scheduled Property", mapOfLOBAttributes,
					j);

			// Backend Id in html needs to be corrected from dev end for Scheduled Property
			// validateDifferentUnitAttributesOnEndPageWithDB("lblMinRetainPremium","Min
			// Retained Premium",mapOfLOBAttributes,j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblNoOfMortgagee", "No Of Mortgagee", mapOfLOBAttributes,
					j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblNoOfAddInsured", "No Of Additional Insured",
					mapOfLOBAttributes, j);
			validateDifferentUnitAttributesOnEndPageWithDB("lblNoOfLossPayee", "No On Loss Payee", mapOfLOBAttributes,
					j);

		}

		// Validating Policy details information

		mapOfPolicyAttributes = dBUtil.getResultFromDBAsMap(
				"Select l.name,p.Value from pas.policyLOBAttributes p\n" + "inner join pas.lobattributes l on\n"
						+ "p.lobattributeid = l.lobattributeid\n" + "where p.policyinfoid = " + policyInfoId,
				"name", "value");
		System.out.println(mapOfPolicyAttributes);

		validatePolicyAttributesOnEndPageWithDB("lblFormType", "Form Type", mapOfPolicyAttributes);
		validatePolicyAttributesOnEndPageWithDB("lblPolicyTerm", "Policy Term", mapOfPolicyAttributes);
		validatePolicyAttributesOnEndPageWithDB("lblNoOfClaims", "No. of claims", mapOfPolicyAttributes);
		validatePolicyAttributesOnEndPageWithDB("lblApplicantType", "Applicant Type", mapOfPolicyAttributes);
		validatePolicyAttributesOnEndPageWithDB("lblInspectContactName", "Inspection Contact Name",
				mapOfPolicyAttributes);
		validatePolicyAttributesOnEndPageWithDB("lblInspectContactNo", "Inspection Contact No", mapOfPolicyAttributes);
		validatePolicyAttributesOnEndPageWithDB("lblAgentCommiss", "Agency Fee", mapOfPolicyAttributes);
		// UW question answers
		
		  validatePolicyAttributesOnEndPageWithDB("lblquestionToggleInput0",
		  "ApplicantOwnDogs", mapOfPolicyAttributes);
		  validatePolicyAttributesOnEndPageWithDB("lblquestionToggleInput3",
		  "SwimmingPool", mapOfPolicyAttributes);
		  validatePolicyAttributesOnEndPageWithDB("lblquestionToggleInput5",
		  "IsBusinessConducted", mapOfPolicyAttributes);
		  validatePolicyAttributesOnEndPageWithDB("lblquestionToggleInput8",
		  "CoverageDeclined", mapOfPolicyAttributes);
		  validatePolicyAttributesOnEndPageWithDB("lblquestionToggleInput10",
		  "Foreclosure", mapOfPolicyAttributes);
		  validatePolicyAttributesOnEndPageWithDB("lblquestionToggleInput11",
		  "Judgement", mapOfPolicyAttributes);
		  validatePolicyAttributesOnEndPageWithDB("lblquestionToggleInput12",
		  "Convicted", mapOfPolicyAttributes);
		 

	}

	public void validateDifferentUnitAttributesOnEndPageWithDB(String nameOfId, String dBName,
			Map<String, String> mapOfLOBAttributes, int noOnId) throws Throwable {
		if (!dBName.equals("Distance to the Coast")) {
			assertEqualsString_custom(
					getText_custom(DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//*[@id='" + nameOfId + "" + noOnId + "']")), dBName).trim()
									.replaceAll("[^A-Za-z0-9.]", ""),
					mapOfLOBAttributes.get(dBName).replace("[0]", "None"), dBName);
		} else {
			if (mapOfLOBAttributes.get(dBName).equals("5")) {
				assertEqualsString_custom(getText_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id='" + nameOfId + "" + noOnId + "']")), dBName).trim()
								.replaceAll("[^0-9]", ""),
						mapOfLOBAttributes.get(dBName), dBName);
			} else {
				assertEqualsString_custom(getText_custom(DriverFactory.getInstance().getDriver()
						.findElement(By.xpath("//*[@id='" + nameOfId + "" + noOnId + "']")), dBName).trim()
								.replaceAll("[^0-9]", "").substring(1),
						mapOfLOBAttributes.get(dBName), dBName);
			}
		}
	}

	public void validatePolicyAttributesOnEndPageWithDB(String nameOfId, String dBName,
			Map<String, String> mapOfPolicyAttributes) throws Throwable {
		
		System.out.println("From Application : "+getText_custom(
				DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id='" + nameOfId + "']")),
				dBName).trim().replaceAll("[^A-Za-z0-9.]", "").replaceAll("Months", "").toLowerCase());
		
		System.out.println("From DB : "+mapOfPolicyAttributes.get(dBName).toLowerCase());
		
		assertEqualsString_custom(
				getText_custom(
						DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id='" + nameOfId + "']")),
						dBName).trim().replaceAll("[^A-Za-z0-9.]", "").replaceAll("Months", "").toLowerCase(),
				mapOfPolicyAttributes.get(dBName).toLowerCase(), dBName);
	}

	public HashMap<String, String> createMapFromDBFOrManualRaterValidations(HashMap<String, String> testData)
			throws NumberFormatException, ClassNotFoundException, SQLException {

		int policyInfoId = Integer
				.parseInt(dBUtil.getResultFromDB("Select  *  from pas.PolicyInfo_trn where SystemType ='EQ' "
						+ "and PolicyNumber = '" + testData.get("PolicyNo") + "' order by 1 desc", "policyInfoId"));

		List<String> policyUnits = dBUtil.getResultFromDBAsList(
				"Select * from pas.policyunits where unitType = 'HO' and policyinfoid = " + policyInfoId,
				"PolicyUnitId");
		Map<String, String> mapOfPropUnit1 = new HashMap<>();
		Map<String, String> mapOfPropUnit2 = new HashMap<>();
		Map<String, String> mapOfPropUnit3 = new HashMap<>();
		Map<String, String> finalMapOfProperties = new HashMap<String, String>();

		for (int i = 0; i < policyUnits.size(); i++) {
			int j = i + 1;

			System.out.println("Unit Number" + j);

			String state = dBUtil.getResultFromDB(
					"Select state from common.Address_trn where AddressId = (Select u.value from pas.unitLOBattributes u\n"
							+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
							+ "where u.policyunitid = " + policyUnits.get(i) + " and l.Name='Property Address')",
					"state");

			String formType = dBUtil.getResultFromDB(
					"Select ProgramType from pas.PolicyInfo_trn where PolicyInfoId =" + policyInfoId, "ProgramType");

			String occupancy = dBUtil.getResultFromDB("Select l.name,p.Value from pas.policyLOBAttributes p\n"
					+ "inner join pas.lobattributes l on\n" + "p.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Occupancy Type' and p.policyinfoid =" + policyInfoId, "Value");

			String policyTerm = dBUtil.getResultFromDB("Select l.name,p.Value from pas.policyLOBAttributes p\n"
					+ "inner join pas.lobattributes l on\n" + "p.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Policy Term' and p.policyinfoid =" + policyInfoId, "Value");

			String protectionClass = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Protection Class' and u.policyunitid = " + policyUnits.get(i), "Value");

			String covA = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Coverage A – Other Structures' and u.policyunitid = " + policyUnits.get(i),
					"Value");

			String covB = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Coverage B – Other Structures' and u.policyunitid = " + policyUnits.get(i),
					"Value");

			String covC = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Coverage C – Personal Property ' and u.policyunitid = " + policyUnits.get(i),
					"Value");

			String covD = dBUtil.getResultFromDB(
					"Select l.name,u.value from pas.unitLOBattributes u\n" + "inner join pas.lobattributes l on\n"
							+ "u.lobattributeid = l.lobattributeid\n"
							+ "where l.name = 'Coverage D - Loss of use' and u.policyunitid = " + policyUnits.get(i),
					"Value");

			String covE = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Coverage E: Personal Liability  ' and u.policyunitid = " + policyUnits.get(i),
					"Value");

			String loss = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Loss Assessment' and u.policyunitid = " + policyUnits.get(i), "Value");

			String replacementCost = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Replacement Cost' and u.policyunitid = " + policyUnits.get(i), "Value");

			String centralFire = dBUtil.getResultFromDB(
					"Select l.name,u.value from pas.unitLOBattributes u\n" + "inner join pas.lobattributes l on\n"
							+ "u.lobattributeid = l.lobattributeid\n"
							+ "where l.name = 'Central Fire Installed?' and u.policyunitid = " + policyUnits.get(i),
					"Value");

			String centralBurglar = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Central Burglar Alarm Installed?' and u.policyunitid = " + policyUnits.get(i),
					"Value");

			String cantralFireOrBurglar = "No";

			if (centralFire.equals("Yes") || centralBurglar.equals("Yes")) {
				cantralFireOrBurglar = "Yes";
			}

			String aOPDed = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'AOP Deductible ' and u.policyunitid = " + policyUnits.get(i), "Value");

			String noOfAcres = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'No Of Acres' and u.policyunitid = " + policyUnits.get(i), "Value");

			String noOfFamilies = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'No of Families' and u.policyunitid = " + policyUnits.get(i), "Value");

			String scheduledProperty = dBUtil.getResultFromDB(
					"Select l.name,u.value from pas.unitLOBattributes u\n" + "inner join pas.lobattributes l on\n"
							+ "u.lobattributeid = l.lobattributeid\n"
							+ "where l.name = 'Scheduled Property' and u.policyunitid = " + policyUnits.get(i),
					"Value");

			String theft = dBUtil.getResultFromDB(
					"Select l.name,u.value from pas.unitLOBattributes u\n" + "inner join pas.lobattributes l on\n"
							+ "u.lobattributeid = l.lobattributeid\n"
							+ "where l.name = 'Theft of Building Materials' and u.policyunitid = " + policyUnits.get(i),
					"Value");

			String waterBackUp = dBUtil.getResultFromDB("Select l.name,u.value from pas.unitLOBattributes u\n"
					+ "inner join pas.lobattributes l on\n" + "u.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Water Backup' and u.policyunitid = " + policyUnits.get(i), "Value");

			String renewalCredits = dBUtil.getResultFromDB("Select l.name,p.Value from pas.policyLOBAttributes p\n"
					+ "inner join pas.lobattributes l on\n" + "p.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Renewal Credits' and p.policyinfoid =" + policyInfoId, "Value");

			String noOfClaims = dBUtil.getResultFromDB("Select l.name,p.Value from pas.policyLOBAttributes p\n"
					+ "inner join pas.lobattributes l on\n" + "p.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'No. of claims' and p.policyinfoid =" + policyInfoId, "Value");

			String inspectionType = dBUtil.getResultFromDB("Select l.name,p.Value from pas.policyLOBAttributes p\n"
					+ "inner join pas.lobattributes l on\n" + "p.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Inspection Type' and p.policyinfoid =" + policyInfoId, "Value");

			String reportType = dBUtil.getResultFromDB("Select l.name,p.Value from pas.policyLOBAttributes p\n"
					+ "inner join pas.lobattributes l on\n" + "p.lobattributeid = l.lobattributeid\n"
					+ "where l.name = 'Report Type' and p.policyinfoid =" + policyInfoId, "Value");

			if (j == 1) {
				mapOfPropUnit1.put("State", state);
				mapOfPropUnit1.put("Form Type", formType);
				mapOfPropUnit1.put("Occupancy", occupancy);
				mapOfPropUnit1.put("Policy Term", policyTerm);
				mapOfPropUnit1.put("Prot Class", protectionClass);
				mapOfPropUnit1.put("Coverage A1", covA);
				mapOfPropUnit1.put("Coverage B1", covB);
				mapOfPropUnit1.put("Coverage C1", covC);
				mapOfPropUnit1.put("Coverage D1", covD);
				mapOfPropUnit1.put("Central Station Burglar and/or Fire Credit", cantralFireOrBurglar);
				mapOfPropUnit1.put("AOP", aOPDed);
				mapOfPropUnit1.put("No Of Acres", noOfAcres);
				mapOfPropUnit1.put("No Of Families", noOfFamilies);
				mapOfPropUnit1.put("Liability", covE);
				mapOfPropUnit1.put("Loss Assement", loss);
				mapOfPropUnit1.put("RC on Coverage C1", replacementCost);
				mapOfPropUnit1.put("Scheduled Property", scheduledProperty);
				mapOfPropUnit1.put("Theft of Building Materials", theft);
				mapOfPropUnit1.put("Water Backup", waterBackUp);
				mapOfPropUnit1.put("Renewal Credits", renewalCredits);
				mapOfPropUnit1.put("No Of Claims", noOfClaims);
				mapOfPropUnit1.put("Inspection Fee", inspectionType);
				mapOfPropUnit1.put("PL Report Type", reportType);
			} else if (j == 2) {

				mapOfPropUnit2.put("Prot Class2", protectionClass);
				mapOfPropUnit2.put("Coverage A2", covA);
				mapOfPropUnit2.put("Coverage B2", covB);
				mapOfPropUnit2.put("Coverage C2", covC);
				mapOfPropUnit2.put("Coverage D2", covD);
				mapOfPropUnit2.put("Central Station Burglar and/or Fire Credit2", cantralFireOrBurglar);
				mapOfPropUnit2.put("AOP2", aOPDed);
				mapOfPropUnit2.put("No Of Acres2", noOfAcres);
				mapOfPropUnit2.put("RC on Coverage C2", replacementCost);
				mapOfPropUnit2.put("Water Backup2", waterBackUp);
				/*
				 * mapOfPropUnit2.put("State", state); mapOfPropUnit2.put("Form Type",
				 * formType); mapOfPropUnit2.put("Occupancy", occupancy);
				 * mapOfPropUnit2.put("Policy Term", policyTerm);
				 * mapOfPropUnit2.put("No Of Families", noOfFamilies);
				 * mapOfPropUnit2.put("Liability", covE); mapOfPropUnit2.put("Loss Assement",
				 * loss); mapOfPropUnit2.put("Scheduled Property", scheduledProperty);
				 * mapOfPropUnit2.put("Theft of Building Materials", theft);
				 * mapOfPropUnit2.put("Renewal Credits", renewalCredits);
				 * mapOfPropUnit2.put("No Of Claims", noOfClaims);
				 * mapOfPropUnit2.put("Inspection Fee", inspectionType);
				 * mapOfPropUnit2.put("PL Report Type", reportType);
				 */
			} else if (j == 3) {

				mapOfPropUnit3.put("Prot Class3", protectionClass);
				mapOfPropUnit3.put("Coverage A3", covA);
				mapOfPropUnit3.put("Coverage B3", covB);
				mapOfPropUnit3.put("Coverage C3", covC);
				mapOfPropUnit3.put("Coverage D3", covD);
				mapOfPropUnit3.put("Central Station Burglar and/or Fire Credit3", cantralFireOrBurglar);
				mapOfPropUnit3.put("AOP3", aOPDed);
				mapOfPropUnit3.put("No Of Acres3", noOfAcres);
				mapOfPropUnit3.put("RC on Coverage C3", replacementCost);
				mapOfPropUnit3.put("Water Backup3", waterBackUp);
				/*
				 * mapOfPropUnit3.put("State", state); mapOfPropUnit3.put("Form Type",
				 * formType); mapOfPropUnit3.put("Occupancy", occupancy);
				 * mapOfPropUnit3.put("Policy Term", policyTerm);
				 * mapOfPropUnit3.put("No Of Families", noOfFamilies);
				 * mapOfPropUnit3.put("Liability", covE); mapOfPropUnit3.put("Loss Assement",
				 * loss); mapOfPropUnit3.put("Scheduled Property", scheduledProperty);
				 * mapOfPropUnit3.put("Theft of Building Materials", theft);
				 * mapOfPropUnit3.put("Renewal Credits", renewalCredits);
				 * mapOfPropUnit3.put("No Of Claims", noOfClaims);
				 * mapOfPropUnit3.put("Inspection Fee", inspectionType);
				 * mapOfPropUnit3.put("PL Report Type", reportType);
				 */

			}

			finalMapOfProperties.putAll(mapOfPropUnit1);
			finalMapOfProperties.putAll(mapOfPropUnit2);
			finalMapOfProperties.putAll(mapOfPropUnit3);

		}

		System.out.println(mapOfPropUnit1);
		System.out.println(mapOfPropUnit2);
		System.out.println(mapOfPropUnit3);

		return (HashMap<String, String>) finalMapOfProperties;

	}

	public Map<String, Double> getPremiumFromUI() {
		Map<String, Double> mapOfPremium = new HashMap<>();
		mapOfPremium.put("Prior Term Premium",
				Double.parseDouble(
						getText_custom(DriverFactory.getInstance().getDriver().findElement(txt_PriorTermPremium),
								"Prior Term Premium").replaceAll("[^0-9.]", "")));
		mapOfPremium.put("Revised Premium",
				Double.parseDouble(
						getText_custom(DriverFactory.getInstance().getDriver().findElement(txt_RevisedPremium),
								"Revised Premium").replaceAll("[^0-9.]", "")));

		String strEndPremium = getText_custom(DriverFactory.getInstance().getDriver().findElement(txt_EndPremium),
				"Endorsed Premium").replaceAll("[^0-9.(]", "");
		strEndPremium = strEndPremium.replace("(", "-");
		mapOfPremium.put("Endorsed Premium", Double.parseDouble(strEndPremium));
		System.out.println("Map of Premiums from UI is " + mapOfPremium);
		return mapOfPremium;
	}

	public HashMap<String, String> createMapForEndCalculations(HashMap<String, String> testData,
			double priorTermPremium, double revisedPremium)
			throws ClassNotFoundException, SQLException, ParseException {

		HashMap<String, String> mapOfEndParams = new HashMap<>();

		String effectiveDate = dateTimeUtil.getDateInEndPageForPolicyEffectiveAndExpirationDate(
				dBUtil.getResultFromDB("Select  *  from pas.PolicyInfo_trn where SystemType ='P' "
						+ "and PolicyNumber = '" + testData.get("PolicyNo") + "'", "PEffective"));
		String endDate = dateTimeUtil.getDateInEndPageForPolicyEffectiveAndExpirationDate(
				dBUtil.getResultFromDB("Select  *  from pas.PolicyInfo_trn where SystemType ='P' "
						+ "and PolicyNumber = '" + testData.get("PolicyNo") + "'", "PExpiration"));
		mapOfEndParams.put("Effective Date", effectiveDate);
		mapOfEndParams.put("End Date", endDate);
		mapOfEndParams.put("End Eff Date", testData.get("End Effective Date"));
		mapOfEndParams.put("Prior Term Premium", String.valueOf(Math.round(priorTermPremium)));
		mapOfEndParams.put("Revised Term Premium", String.valueOf(Math.round(revisedPremium)));
		System.out.println(mapOfEndParams);
		return mapOfEndParams;

	}

	public void confirmEnd() throws InterruptedException {
		Thread.sleep(21000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_GenForms), "Generate Forms");
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_ApproveEnd), "Approve End");
		Thread.sleep(21000);
	}

	public HashMap<String, String> validatePreviousDetailOfEnd(HashMap<String, String> testData)
			throws ParseException, Throwable {

		pageScroll(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium), "Recalculate Premium");
		Thread.sleep(15000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_EndDate),
				"Endorsement Calendar");
		dateTimeUtil
				.selectDateFromCalendar(dateTimeUtil.getDateInCancellationFormat(testData.get("End Effective Date2")));
		Thread.sleep(15000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePremium),
				"Recalculate Premium");
		Thread.sleep(15000);
		HashMap<String, String> finalMapOfProperties = createMapFromDBFOrManualRaterValidations(testData);
		return finalMapOfProperties;

	}

}
