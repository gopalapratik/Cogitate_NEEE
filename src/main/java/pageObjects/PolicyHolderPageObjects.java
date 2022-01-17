package pageObjects;
//Author-Rishikesh
import static org.testng.Assert.assertEquals;

import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.w3c.dom.events.MouseEvent;

import reusableComponents.MethodUtil;
import testBase.DriverFactory;
import testBase.TestBase;

public class PolicyHolderPageObjects extends TestBase {
	MethodUtil mu= new MethodUtil();
	By dd_ApplicantType = By.xpath("//select[@id='ddlApplicantType']");
	By secInsuredName = By.id("txtSecondaryFirstName");
	By InsContName = By.id("txtInspectContactName");
	By InsContNo = By.id("txtInspectContactNo");
	By btn_Save = By.xpath("//a[@id='btnSaveContinue']");
	By btn_AddAnotherProp = By.xpath("//a[@id='btnAddProp']");
	By txt_Address = By.xpath("//input[@id='txtAddressAutoComplete']");
	By btn_Add = By.xpath("//button[@id='btnAddProperty']");
	By txt_SubmissionNo = By.xpath("//p[contains(text(),'Application')]//span[1]");
	By back_btn = By.xpath("//a[normalize-space()='Not this address? Click here to go back to listing']");
    By HO3 = By.xpath("//select[@name='FormType.Value']");
    By Occupancy = By.xpath("//select[@name='OccupancyType.Value']");
    By Policy_term = By.xpath("//select[@name='PolicyTerm.Value']");
    By Homeowner_data = By.xpath("//input[@placeholder='LOB Type']");
    By Proportyaddress_D = By.xpath("//textarea[@placeholder='Property Address']");
    By MailingAddress = By.xpath("//textarea[@placeholder='Mailing Address']");
    By Applicanttype_D = By.xpath("//*[@id=\"ddlApplicantType\"]");
    By Secondaryname_D = By.cssSelector("input[placeholder='First Name'][name='ApplicantInfos[1].FirstName']");
    By Holder_name_erase = By.xpath("//input[@id='txtPrimaryFirstName']");
    By btn_SaveAndContinue = By.xpath("//*[@id=\"btnSaveContinue\"]");
    By secondary_insured_name = By.cssSelector("input[placeholder='First Name'][name='ApplicantInfos[1].FirstName']");
    By secondary_address = By.xpath("//*[@id=\"btnAddProp\"]");
    
  
    By input_SCadress = By.xpath("//input[@placeholder='Search Property Address']");
    By add_adress = By.xpath("//button[normalize-space()='Add']");
    By Mailing_addresscheckbox = By.xpath("//div[contains(@class,'accordion mt-3')]//div[2]//div[2]//div[1]//input[1]");
    By secondry_adress = By.cssSelector("body > section:nth-child(5) > form:nth-child(6) > section:nth-child(1) > div:nth-child(1) > div:nth-child(20) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > textarea:nth-child(1)");
    By MailADCheck_Box =       By.xpath("//input[@type='checkbox']");
    By SaveasDraft     = By.xpath("//a[normalize-space()='Save as Draft']");
    By Inspectionsname = By.xpath("//*[@id=\"txtInspectContactName\"]");
    By Inspecticontact = By.xpath("//input[@placeholder='Inspection Contact #']");
    By Application_ID = By.xpath("//*[@id=\"page\"]/div/div[1]/div/p/span[1]");
    By policy_STS_BTN = By.xpath("//img[@src='/NEEE.POS/Images/policy-status.svg']");
    By Searchbox  = By.xpath("//input[@placeholder='Search by Quote Indication/Formal Quote/Policy#']");
    By serach_button = By.xpath("//tbody/tr[1]/td[11]/form[1]/button[1]/span[1]");
    By btn_SearchPolicyButton = By.xpath("//*[@id=\"linkSearch\"]");
  
    			public void enterPolicyHolderDetails(HashMap<String, String> testData) throws Throwable {

		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_ApplicantType),
				"dd_ApplicantType", testData.get("ApplicantType"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(secInsuredName), "secInsuredName",
				testData.get("Sec Insured Name"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(InsContName), "InsContName",
				testData.get("Ins Contact Name"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(InsContNo), "InsContNo",
				testData.get("Ins Contact No"));
		Thread.sleep(10000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Save), "Save Button");
	}

	public void addProperty(HashMap<String, String> testData) throws InterruptedException {

		for (int i = 2; i <= Integer.parseInt(testData.get("No of Properties")); i++) {

			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_AddAnotherProp),
					"btn_AddAnotherProp");
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Address), "txt_Address",
					testData.get("address" + i));
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Add), "btn_Add");
			Thread.sleep(5000);

		}
	}

	public void validatePolicyHolderURL(HashMap<String, String> testData) throws Throwable {
		Thread.sleep(5000);
		String currenURL = DriverFactory.getInstance().getDriver().getCurrentUrl();
		System.out.println(currenURL);
		assertEqualsString_custom(currenURL, testData.get("PolicyHolder URL"), "Quote Page URL");
	}

	public String getSubmissionNo() {

		String subNo = DriverFactory.getInstance().getDriver().findElement(txt_SubmissionNo).getText();
		System.out.println("Submission No is " + subNo);
		return subNo;
	}

	




	

	public void validateCoverageScreenURL(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		String currenURL1 = DriverFactory.getInstance().getDriver().getCurrentUrl();
		System.out.println(currenURL1);
		assertEqualsString_custom(currenURL1, testData.get("Policypage URL"), "policy validate");
	}

	public void validategobackurl(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(back_btn), "back button");
		String currenURL1 = DriverFactory.getInstance().getDriver().getCurrentUrl().trim();
		System.out.println(currenURL1);
		assertEqualsString_custom(currenURL1, testData.get("backpage URL").trim(), "Back URL");
	}

	
	
	 public void HO3(HashMap<String, String> testData) throws Throwable  { 
		 // TODO Auto-generated method stub
		 Thread.sleep(5000);

			WebElement Button1  = DriverFactory.getInstance().getDriver().findElement(HO3);
			boolean actualvalue = Button1.isEnabled();
			if (actualvalue)
				System.out.println("HO3 feild is enable");
			else
				System.out.println("HO3 feild is disable");
				
		 
	 }

	public void Occupancy(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		Thread.sleep(5000);

		WebElement Button2  = DriverFactory.getInstance().getDriver().findElement(Occupancy);
		boolean actualvalue = Button2.isEnabled();
		if (actualvalue)
			System.out.println("Occupancy feild is enable");
		else
			System.out.println("Occupancyfeild is disable");
			
	}

	public void Policyterms(HashMap<String, String> testData) {
		// TODO Auto-generated method stub
		WebElement Button3  = DriverFactory.getInstance().getDriver().findElement(Policy_term);
		boolean actualvalue = Button3.isEnabled();
		if (actualvalue)
			System.out.println("Policyterm feild is enable");
		else
			System.out.println("Policyterms is disable");
		
	}

	public void Homeowner(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		String Homeownerdata =  DriverFactory.getInstance().getDriver().findElement(Homeowner_data).getAttribute("value");
		assertEqualsString_custom(Homeownerdata, testData.get("Homeowner").toString(), "Homeownere info");
	}

	public void Addressdata(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		String Proportyaddress =  DriverFactory.getInstance().getDriver().findElement(Proportyaddress_D).getAttribute("value");
		String mailingadress =  DriverFactory.getInstance().getDriver().findElement(MailingAddress).getAttribute("value");
	    assertEqualsString_custom(mailingadress,Proportyaddress,"Proporty adress");
		
	}

	
	
	public void Insuredname(HashMap<String, String> testData) throws Throwable {
	 DriverFactory.getInstance().getDriver().findElement(Holder_name_erase).clear();
     clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_SaveAndContinue),"Save And Continue Button");
     String currenURL1 = DriverFactory.getInstance().getDriver().getCurrentUrl();
     assertEqualsString_custom(currenURL1, testData.get("Policypage URL"), "policy validate");
	 
	 
	 
		
	}

	public void Secondaryinsurename(String string) {
		// TODO Auto-generated method stub
//		DriverFactory.getInstance().getDriver().findElement(Holder_name_erase).clear();
		DriverFactory.getInstance().getDriver().findElement(secondary_insured_name).sendKeys("TEST NNN");
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_SaveAndContinue),"Save And Continue Button");
		 
	}
	

	public void Addedadress(String string) {
		// TODO Auto-generated method stub
		 clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(secondary_address),"secondary Address added");
		 DriverFactory.getInstance().getDriver().findElement(input_SCadress).sendKeys("46 Ladd Rd, Northfield, VT 05663");
		 clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(add_adress),"add adress");
		 
		
	}

	public void mailingcheckbox(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(Mailing_addresscheckbox),"mailing checkbox");
		String SCaddress =  DriverFactory.getInstance().getDriver().findElement(secondry_adress).getAttribute("value");
		System.out.println(SCaddress);
		
		assertEqualsString_custom(SCaddress,testData.get("secondry_adress"), "scadress");
	}

	public void mailingadressfeild(String string) {
		// TODO Auto-generated method stub
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(Applicanttype_D),"");
	}

	public void Applicanttypedropdownlist(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		 String APPDRP = DriverFactory.getInstance().getDriver().findElement(Applicanttype_D).getText();
		 System.out.println(APPDRP);
		 assertEqualsString_custom( APPDRP,testData.get("Applicant type dropdown"),"APP TYPE DRP");

	}

	public void Policyterm(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		String PLterm = DriverFactory.getInstance().getDriver().findElement(Policy_term).getAttribute("value");
		System.out.println(PLterm);
		assertEqualsString_custom( PLterm +" Months",testData.get("Policy Term"),"policy term");
	}

	public void PrimaryAddress(String string) {
		// TODO Auto-generated method stub
		WebElement Primaryadress = DriverFactory.getInstance().getDriver().findElement(Proportyaddress_D);
		boolean value = Primaryadress.isEnabled();
		if(value)
			System.out.println("***PrimaryAddress feild is enable *** TEST CASE FAILD" );
		else
		   System.out.println("***PrimaryAddress is disable *** TEST CASE PASS");
	}

	public void MailingAddresscheckbox(String string) {
		// TODO Auto-generated method stub
		WebElement mailingadresscbx= DriverFactory.getInstance().getDriver().findElement(MailADCheck_Box);
		boolean value3 = mailingadresscbx.isSelected();
		if(value3)
			System.out.println("Checked box is checked*** TEST CASE Pass" );
		else
		   System.out.println(" Checked box is unchecked*** TEST CASE fail");
	}

	public void mailingaddressverfication(String string) {
		// TODO Auto-generated method stub
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(MailADCheck_Box),"mailing checkbox");
		WebElement mailingads = DriverFactory.getInstance().getDriver().findElement(MailingAddress);
		boolean value6 =  mailingads.isEnabled();
		if(value6)
			System.out.println("Mailing address is free feild*** TEST CASE Pass" );
		else
		   System.out.println("Mailing adress disable*** TEST CASE fail");
	}
		
	
	public void Errormsg(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
	clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(secondary_address),"Different State Address added");
    DriverFactory.getInstance().getDriver().findElement(input_SCadress).sendKeys("7655 SE Sugar Sands Cir, Hobe Sound, FL 33455");
 	clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(add_adress),"add adress");
	System.out.println(testData.get("Error"));
 	mu.validateToasterMsg(testData.get("Error"));
	
}

	public void saveasdraft(HashMap<String, String> testData) throws Throwable {
		// TODO Auto-generated method stub
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(SaveasDraft),"saveasdraft");
		mu.validateToasterMsg(testData.get("Save as draft"));
	}

public void saveasdraftverification(HashMap<String, String> testData) throws Throwable {
	// TODO Auto-generated method stub
	DriverFactory.getInstance().getDriver().findElement(secondary_insured_name).sendKeys(testData.get("secondary_insured_name"));
	DriverFactory.getInstance().getDriver().findElement(Inspectionsname).sendKeys("TEST ISP NAME");
	//DriverFactory.getInstance().getDriver().findElement(Inspecticontact).sendKeys("1111111111");
	Thread.sleep(5000);
	clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(SaveasDraft),"saveasdraft");
	String APD = DriverFactory.getInstance().getDriver().findElement(Application_ID).getText();
	System.out.println(APD);
	clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(policy_STS_BTN ),"policy_STS_BTN ");
	DriverFactory.getInstance().getDriver().findElement(Searchbox).sendKeys(APD);
	clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_SearchPolicyButton),"policy_STS_BTN ");
	clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(serach_button),"search button");
	String SC_N=DriverFactory.getInstance().getDriver().findElement(secondary_insured_name).getAttribute("value");
	System.out.println(SC_N);
	String IN_P=DriverFactory.getInstance().getDriver().findElement(Inspectionsname).getAttribute("value");
	System.out.println(IN_P);
	assertEqualsString_custom( SC_N ,testData.get("secondary_insured_name"),"secondary_insured_name");
	assertEqualsString_custom( IN_P,testData.get("Inspectionsname"),"Inspectionsname");
	
	
}



public void Applicanttype_CO(HashMap<String, String> testData) {
	// TODO Auto-generated method stub
	Select Applicanttype= new Select(DriverFactory.getInstance().getDriver().findElement(Applicanttype_D));
	Applicanttype.selectByVisibleText("Corporation");
	WebElement Button4  = DriverFactory.getInstance().getDriver().findElement(Secondaryname_D);
	
	boolean Value = Button4.isEnabled();
	if (Value)
	System.out.println("*****Secondary insured feild is enable***** Test case Failed");
else
	System.out.println("*****secondary insured feild is disable*****Test case pass");
	
}

public void Applicanttype_IND(HashMap<String, String> testData) {
	// TODO Auto-generated method stub
	Select Applicanttype= new Select(DriverFactory.getInstance().getDriver().findElement(Applicanttype_D));
	Applicanttype.selectByVisibleText("Individual");
	WebElement Button4  = DriverFactory.getInstance().getDriver().findElement(Secondaryname_D);
	
	boolean Value = Button4.isEnabled();
	if (Value)
	System.out.println("*****Secondary insured feild is enable***** Test case pass");
else
	System.out.println("*****secondary insured feild is disable*****Test case fail");
	
}

public void FillDatatosave(HashMap<String, String> testData) {
	// TODO Auto-generated method stub
	 DriverFactory.getInstance().getDriver().findElement(Holder_name_erase).sendKeys(testData.get("Insured Name"));
	
}

public void navigateOtherPages(HashMap<String, String> testData) {
	// TODO Auto-generated method stub
	clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Save),"Save button");
}

public void ClickOnSaveCont() {
	clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_SaveAndContinue),"Save And Continue Button");
}

}



	 

	
