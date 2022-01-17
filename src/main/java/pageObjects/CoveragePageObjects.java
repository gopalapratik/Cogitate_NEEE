//// Author: Dhanashri
package pageObjects;


import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import reusableComponents.DateTimeUtil;
import reusableComponents.ExpiryDateValue;
import reusableComponents.MethodUtil;
import testBase.DriverFactory;
import testBase.TestBase;
import reusableComponents.DateNew;
import reusableComponents.DateSelector;

public class CoveragePageObjects extends TestBase{
	DateNew DN= new DateNew();
	ExpiryDateValue ED=new ExpiryDateValue();
	DateTimeUtil dateTimeUtil = new DateTimeUtil();
	By dd_IDFraud = By.xpath("//select[@id='IDFraud']");
	By btn_Submit = By.xpath("//a[text()='SUBMIT']");
	By btn_OK = By.xpath("//button[@id='btnSaveAndContinueForAgent']");
	By PriorHistoyTab = By.id("priorhistory-tab");
	By Btn_Yes=By.xpath("//input[@id='propertyInsured0']");
	By Btn_No=By.xpath("//input[@id='propertyInsured1']");
	By PropertyNotInsuredExplain=By.id("txtPropertyNotInsuredExplain");
	By NoOfClaims=By.id("//*[@id=\"ddlNoOfClaims\"]");
	By DateNoLoss=By.id("//*[@id=\"txtClaimLossDate1\"]");
	By AmountPaid=By.id("//*[@id=\"txtClaimAmount1\"]");
	By IncidentType=By.id("//*[@id=\"ddlIncidentType1\"]");
	By ClaimDes=By.id("//*[@id=\"txtClaimRemark1\"]");
	By btn_save = By.xpath("//*[@id=\"btnSaveAsDraftPrHist\"]");
	MethodUtil methodUtil = new MethodUtil();
	By txt_PleaseExplain = By.xpath("//input[@id='txtPropertyNotInsuredExplain']");
	By btn_Next = By.xpath("//a[@id='btnSaveAndContinuePrHist']");
	By PriorCompany = By.xpath("//*[@id=\"ddlInsuranceCompanies\"]");  //DD
	By ExpiryDate = By.xpath("//*[@id=\"panelsStayOpen-collapse1\"]/div/div[1]/div[4]/div/input[2]");
	By CovA = By.xpath("//*[@id=\"txtDwellingAmount1\"]");
	By CovB = By.xpath("//*[@id=\"txtBOtherStructure1\"]");
	By CovC = By.xpath("//*[@id=\"txtCPersonalProperty1\"]");
	By CovD = By.xpath("//*[@id=\"txtDLossOfUse1\"]");
	By Replacost = By.xpath("//*[@id=\"lblrbReplCost01\"]");
	By CovE_DD = By.xpath("//*[@id=\"ddlEPersonalLiability1\"]");
	By CovF_DD = By.xpath("//*[@id=\"ddlFMedicalPayment1\"]");
	By water_Backup = By.xpath("//*[@id=\"ddlWaterBackupCoverage1\"]");
	By AOP = By.xpath("//*[@id=\"ddlAOPDeductible1\"]");
	By WaterDamage = By.xpath("//*[@id=\"ddlWaterDamageDeductible1\"]");
	By Year=By.cssSelector("body > div.flatpickr-calendar.animate.open.arrowBottom > div.flatpickr-months > div > div > div > input");
	By Month=By.cssSelector("body > div.flatpickr-calendar.animate.open.arrowBottom > div.flatpickr-months > div > div > select");
	By WindHail = By.xpath("//*[@id=\"ddlWindHailDed1\"]");
	By yesNo = By.xpath("//*[@class = 'pageContainer']//*[@id = 'coveragecontainer']//*[@id = 'propertyTabContent']//*[@id = 'address1']//*[@id = 'frmSaveCoveragesDetails1']//*[@class = 'accordion mt-3']//*[@class = 'accordion-item']//*[@class = 'accordion-collapse collapse show']//*[@class = 'accordion-body pt-0']//*[@class = 'row']//*[@class = 'col-xl-3 col-lg-4 mt-3 hideDP']//*[@class = 'btn-group']//*[@class = 'btn btn-outline-primary active']");//*[@class = 'pageContainer']//*[@id = 'coveragecontainer']//*[@id = 'propertyTabContent']//*[@id = 'address1']//*[@id = 'frmSaveCoveragesDetails1']//*[@class = 'accordion mt-3']//*[@class = 'accordion-item']//*[@class = 'accordion-collapse collapse show']//*[@class = 'accordion-body pt-0']//*[@class = 'row']//*[@class = 'col-xl-3 col-lg-4 mt-3 hideDP']//*[@class = 'btn-group']//*[@class = 'btn btn-outline-primary active']
	By btn_Save = By.xpath("//a[text()='Save & Continue']");
	
	public void enterCoverageDetails(HashMap<String, String> testData) throws Throwable {
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='divWaterDed']//label[contains(text(),'"+testData.get("waterDed")+"')]")),"Water Ded");
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='divTheftDed']//label[contains(text(),'"+testData.get("theftDed")+"')]")),"Theft Ded");
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_IDFraud), "ID Fraud", testData.get("IDFraud"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Submit),"Submit button");
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_OK),"OK button");
		Thread.sleep(20000); }
	
	// Coverage Page URL Testing
	public void validateCoverageScreenURL(HashMap<String, String> testData) throws Throwable {
		Thread.sleep(5000);
		String currenURL = DriverFactory.getInstance().getDriver().getCurrentUrl();
		System.out.println(currenURL);
		assertEqualsString_custom(currenURL,testData.get("Coverage Page URL"),"Coverage Page URL");
	}
	// Tab Name Test
	public void HistoryTabName(HashMap<String, String> testData) throws Throwable
	{
		Assert.assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Prior History and Inspections"));
		for (int i=1; i<=Integer.parseInt(testData.get("No of Properties")); i++)
				{
			Assert.assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Property "+i+" - Coverages"));
				}
	}
	// Save Draft Button
	public void SaveDraft(HashMap<String, String> testData) throws Throwable
	{
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_save), "Save Button");
		methodUtil.validateToasterMsg(testData.get("App Toast"));
	}
	// Is the property currently insured?  Answer: No
	public void propertycurrentlyinsured(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		if(testData.get("Is the property currently insured?").equals("No")) {
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_PleaseExplain), "Please Explain","test");}
		else {
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(Btn_Yes), "Yes Button");
			Select Company= new Select(DriverFactory.getInstance().getDriver().findElement(PriorCompany));
			Company.selectByVisibleText(testData.get("Prior Insurance Company"));
			
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(ExpiryDate), "Expiry Date");
			String dateval=testData.get("Insurance Expiry Date");
			DN.getDateExpired(dateval,Year,Month);
		}
}
//Is the property currently insured?  Answer: yes

	//Next and Continue Button
	public void ClickNextButton()
	{
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Next), "Next and Continue Button");
	}
	public void ValidateCoverageA() throws Throwable
	{
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(CovA).isEnabled(),false,"Coverage A"); //Covrage A should not be editable
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(CovB).isEnabled(),true,"Coverage B"); //Covrage B should be editable
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(CovC).isEnabled(),true,"Coverage C"); //Covrage C should be editable
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(CovD).isEnabled(),true,"Coverage D"); //Covrage D should be editable
		
		String coverageA=(DriverFactory.getInstance().getDriver().findElement(CovA).getAttribute("value"));
		String coverageB=(DriverFactory.getInstance().getDriver().findElement(CovB).getAttribute("value"));
		String coverageC=(DriverFactory.getInstance().getDriver().findElement(CovC).getAttribute("value"));
		String coverageD=(DriverFactory.getInstance().getDriver().findElement(CovD).getAttribute("value"));
		assertTrue( Integer.parseInt(coverageA)  > Integer.parseInt(coverageB) );//Coverage A should be greater than Coverage B
		assertTrue( Integer.parseInt(coverageA)  > Integer.parseInt(coverageC) );//Coverage A should be greater than Coverage C
		assertTrue( Integer.parseInt(coverageA)  > Integer.parseInt(coverageD) );//Coverage A should be greater than Coverage D
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(Replacost).isEnabled(),true,"Replacement Cost"); 
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(CovC), "0","Coverage C=0");//Coverage C is set to 0 checking for replacement cost is disable or not
		WebElement textbox = DriverFactory.getInstance().getDriver().findElement(CovC);
		textbox.sendKeys(Keys.ENTER);
		System.out.println(DriverFactory.getInstance().getDriver().findElement(yesNo).getText());
		assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(yesNo).getText(),"No","Replacement Cost");
		
		//Assert.assertEquals(ans,"No","Button Disable");
		}
	
	public void ValidateOptions(HashMap<String, String> testData) throws Throwable
	{
		//Coverage E- Personal Liability
		String arr[]= {"0","100000", "300000", "500000", "1000000"};
		Select CoverageE = new Select(DriverFactory.getInstance().getDriver().findElement(CovE_DD));
		List<WebElement> Evalues=CoverageE.getOptions();
		for(int i=0; i<Evalues.size(); i++)
		{
			Assert.assertEquals(arr[i], Evalues.get(i).getAttribute("value"));
		}
		 
		//Coverage F – Medical Payments
		String arr1[]= {"0","5000"};
		Select CoverageF = new Select(DriverFactory.getInstance().getDriver().findElement(CovF_DD));
		List<WebElement> Fvalues=CoverageF.getOptions();
		for(int i=0; i<Fvalues.size(); i++)
		{
			Assert.assertEquals(arr1[i], Fvalues.get(i).getAttribute("value"));
		}

		// All Other Perils
		String arr3[]= {"1000","2500","5000","10000"};
		Select AOP1 = new Select(DriverFactory.getInstance().getDriver().findElement(AOP));
		List<WebElement> AOPvalues=AOP1.getOptions();
		//System.out.println(AOPvalues.size());
		for(int i=0; i<AOPvalues.size(); i++)
		{
			Assert.assertEquals(arr3[i], AOPvalues.get(i).getAttribute("value"));
		}
	}
	public void ValdateDefaultValues(HashMap<String, String> testData) throws Throwable
	{
		assertEqualsString_custom(1000, Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(AOP).getAttribute("value")),"Default Value AOP");
		if(testData.get("State").equals("VT")) {
			System.out.println("This is VT state");
		assertEqualsString_custom(1000, Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(WindHail).getAttribute("value")),"Default Value WindHail");
		// Wind/Hail Deductible
				String arrWH[]= {"0","1000","2500","5000","10000","1","2","3"};
				Select WH = new Select(DriverFactory.getInstance().getDriver().findElement(WindHail));
				List<WebElement> WHvalues=WH.getOptions();
				//System.out.println(WHvalues.size());
				for(int i=0; i<WHvalues.size(); i++)
				{
					Assert.assertEquals(arrWH[i], WHvalues.get(i).getAttribute("value"));
				}
		}
		else{    //Need to add code
			System.out.println("Other than VT");
		}
		//Water Damage deductible
		if(testData.get("Form Type").equals("HO3") || testData.get("Form Type").equals("DP3")) {
			System.out.println("Form type Ho3 or DP3");
			assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(WaterDamage).isEnabled(),true,"WaterDamage Displayed");
			assertEqualsString_custom(1000, Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(WaterDamage).getAttribute("value")),"Default Value WaterDamage");
			// Water Backup Coverage
			String arr2[]= {"0","1000","2500","5000","10000"};
			Select water = new Select(DriverFactory.getInstance().getDriver().findElement(WaterDamage));
			List<WebElement> Wvalues=water.getOptions();
			//System.out.println(Wvalues.size());
			for(int i=0; i<Wvalues.size(); i++)
			{
				Assert.assertEquals(arr2[i], Wvalues.get(i).getAttribute("value"));
			}	
		}
		else{    
			assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(WaterDamage).isEnabled(),false,"WaterDamage not display");
		}
		
		// Water Backup
				System.out.println("Water Backup");
				if(testData.get("Form Type").equals("HO3") || testData.get("Form Type").equals("HO1") || testData.get("Form Type").equals("HO8")) {
					assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(water_Backup).isEnabled(),true,"isDisplayed Water Backup");
					assertEqualsString_custom(Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(water_Backup).getAttribute("value")),0,"Default Value WaterBackup");
					// Water Backup Coverage
					String arr2[]= {"0","5000","10000","25000","50000"};
					Select water = new Select(DriverFactory.getInstance().getDriver().findElement(water_Backup));
					List<WebElement> Wvalues=water.getOptions();
					for(int i=0; i<Wvalues.size(); i++)
					{
						Assert.assertEquals(arr2[i], Wvalues.get(i).getAttribute("value"));
					} 
				}
					else{    
						assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(water_Backup).isDisplayed(),false,"WaterDamage not display");
				}
	}

	public void clickOnSaveAndCont() {
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Save),
				"Save And Continue Button");
		
	}
	
		
		// Loss Assessment  not having Form Type Ho6
			/*	if(testData.get("Form Type").equals("HO6")) {
					assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(water_Backup).isDisplayed(),true,"WaterDamage Displayed");
					assertEqualsString_custom(1000, Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(water_Backup).getAttribute("value")),"Default Value WaterDamage");
					// Water Backup Coverage
					String arr2[]= {"0","5000","10000","25000","50000"};
					Select water = new Select(DriverFactory.getInstance().getDriver().findElement(water_Backup));
					List<WebElement> Wvalues=water.getOptions();
					System.out.println(Wvalues.size());
					for(int i=0; i<Wvalues.size(); i++)
					{
						Assert.assertEquals(arr2[i], Wvalues.get(i).getAttribute("value"));
					}	
					else{    
						assertEqualsString_custom(DriverFactory.getInstance().getDriver().findElement(water_Backup).isDisplayed(),false,"WaterDamage not display");
				}
			
				}*/

}

