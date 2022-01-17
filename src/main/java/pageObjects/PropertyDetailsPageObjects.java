package pageObjects;

import static org.testng.Assert.assertEquals;

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

import com.mysql.cj.protocol.a.NativeConstants.StringLengthDataType;

import sun.security.util.Length;
import testBase.DriverFactory;
import testBase.TestBase;

public class PropertyDetailsPageObjects extends TestBase {  //shiva
    
	
	By txt_yearBuilt1 = By.id("txtYearHomeBuild1");
	By txt_sqft1 = By.xpath("//input[@id='txtSquareFeet1']");
	By txt_dwell1= By.xpath("//input[@id='txtDwelling1']");
	By save1= By.xpath("//a[normalize-space()='Save']");
	By previous1= By.xpath("//a[normalize-space()='Previous']");
	By noffamily = By.xpath("//*[@id=\"ddlNoOfFamilies1\"]");    
	By nofacre = By.id("txtNoAcres1");
	By protectcl = By.xpath("//*[@id=\"ddlProtectionClass1\"]");  
	By disttocoast = By.xpath("//*[@id=\"ddlDistToCoast1\"]");          //specify distance to coast is selected of 1 address
	By priheatoth = By.xpath("//select[@id='ddlPrimaryHeatingType1']//option[@value='Other'][normalize-space()='Other']\"");
	By priheatdes  = By.xpath("//input[@id='txtPriHeatDescription1']");
	By secheatoth = By.xpath("//select[@id='ddlSecondHeatingType1']//option[@value='Other'][normalize-space()='Other']");
	By secheatdes = By.xpath("//input[@id='txtSecHeatDescription1']");
	By priheatoth2 = By.xpath("//select[@id='ddlPrimaryHeatingType2']//option[@value='Other'][normalize-space()='Other']\"");
	By priheatdes2  = By.xpath("//input[@id='txtPriHeatDescription2']");
	By secheatoth2= By.xpath("//select[@id='ddlSecondHeatingType2']//option[@value='Other'][normalize-space()='Other']");
	By secheatdes2 = By.xpath("//input[@id='txtSecHeatDescription2']");
	By priheatoth3 = By.xpath("//select[@id='ddlPrimaryHeatingType3']//option[@value='Other'][normalize-space()='Other']\"");
	By priheatdes3  = By.xpath("//input[@id='txtPriHeatDescription3']");
	By secheatoth3 = By.xpath("//select[@id='ddlSecondHeatingType3']//option[@value='Other'][normalize-space()='Other']");
	By secheatdes3 = By.xpath("//input[@id='txtSecHeatDescription3']");
	By addtitle1 =By.xpath("//button[@id='address1-tab']");
	By addtitle2 =By.xpath("//button[@id='address2-tab']");
	By addtitle3 =By.xpath("//button[@id='address3-tab']");
	By circuitbr = By.xpath("//*[@id='radCircuitBreaker11']");   //click for no
	By knobtubewiring = By.xpath("//*[@id='radKnobTubeWiring01']");  //click for yes
	By presFuse =By.xpath("//*[@id='radPresentFuses01']");   //click on yes
	By txtpresFuse =  By.xpath("//*[@id=\"txtPreseFuses1\"]");   //text box for present fuse
	By dd_constypeopt5 =  By.xpath("//*[@id=\"ddlConstructionType1\"]/option[5]");   //const type opt 5
	By txtpreheatdes = By.xpath("//input[@id='txtPriHeatDescription1']");   //txt pri heat description
	By consTypelog = By.xpath("//*[@id=\"ddlConstructionType1\"]/option[4]");  //const type log  
	By cenfirinst =By.xpath("//label[@for='radCentralfire11']"); //click on no
	By cenfirbug =By.xpath("//label[@for='radBurglarAlarm01']"); //click on yes
	By ConstructionType = By.id("ddlConstructionType1"); //DD

	
	By dd_consType = By.xpath("//select[@name='ConstructionType.Value']");
	By dd_PrimaryHeatSource = By.xpath("//select[@id='ddlPrimaryHeatingType1']");
	By dd_secHeatSource = By.xpath("//select[@id='ddlSecondHeatingType1']");
	By txt_HeatingUpdateYear = By.xpath("//input[@id='txtHeatYear1']");
	By txt_roofUpdateYear = By.xpath("//input[@id='txtRoofYear1']");
	By txt_plumbingUpdateYear = By.xpath("//input[@id='txtPlumbYear1']");
	By txt_wiringUpdateYear = By.xpath("//input[@id='txtWiringYear1']");
	By btn_Save = By.xpath("//a[text()='Save & Continue']");
	By btn_Next = By.xpath("//a[text()='Next' and @pageindex=1]");
	By btn_OnlySave = By.xpath("//a[@pageindex=2 and text()='Save']");
	
	
	
	
	
	
	
	
	
	
	public void multipleaddresstitlecheck() throws InterruptedException { //shiva
		Thread.sleep(10000);
		String bodyText1 = DriverFactory.getInstance().getDriver().findElement(addtitle1).getText();
		Assert.assertEquals("Property Address 1", bodyText1);
	/*	String bodyText2 = DriverFactory.getInstance().getDriver().findElement(addtitle2).getText();
		Assert.assertEquals("Property Address 2", bodyText2);
		String bodyText3 = DriverFactory.getInstance().getDriver().findElement(addtitle3).getText();
		Assert.assertEquals("Property Address 3", bodyText3);  
		Commented by dhanashri, Need to update this code for multiple address */
	}
	 
	
	public void cirKnobPreFuse(HashMap<String, String> testData) throws InterruptedException {  //shiva
		Thread.sleep(1000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(circuitbr), "Circuit breakers ");
		Thread.sleep(1000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(knobtubewiring),"Knob & Tube wiring") ;
		Thread.sleep(1000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(presFuse),"Present Fuses");
		Thread.sleep(3000);
		sendKeysByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(txtpresFuse), "testing");
		
		Thread.sleep(1000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txtpreheatdes), "Primary Heat Description",
				testData.get("73 char"));
		
		
		
	}
	
	public void priHeatSource() {         //shiva              
		
		String ex[]  = {"Select","Oil","Electric","Gas","Pellet","Woodstove","Fireplace","Coal","Geo Thermal","Kerosene","Solar","Outdoor Wood ","Boiler","None","Other"};

		WebElement Str  = DriverFactory.getInstance().getDriver().findElement(dd_PrimaryHeatSource);
		
		clickByJavaScriptExecutor(Str,"Primary Heat");
		int j=0;
		for (int i = 1; i== ex.length+1; i++) {
		   //System.out.println("List:"+i+":"+ Str.get(i).getText()); 
			String contents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"ddlPrimaryHeatingType1\"]/option["+i+"]")).getText();
			System.out.println("Elements : "+contents+"hi");
			System.out.println("Elements : "+ex[j]);
			Assert.assertEquals(contents, ex[j]);
			j++;
		}
        
		WebElement Str1  = DriverFactory.getInstance().getDriver().findElement(dd_secHeatSource);
		
		clickByJavaScriptExecutor(Str1,"Primary Heat");
		int a=0;
		for (int b = 1; b== ex.length+1; b++) {
		   //System.out.println("List:"+i+":"+ Str.get(i).getText()); 
			String contents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"ddlSecondHeatingType1\"]/option["+b+"]")).getText();
			System.out.println("Elements : "+contents+"hi");
			System.out.println("Elements : "+ex[a]);
			Assert.assertEquals(contents, ex[a]);
			a++;
		}
	   System.out.println("Dropdown of primary and secondary heat has all elements");
	}

	
	
    public void famAcreProtectCoastConstFireBugler(HashMap<String, String> testData) throws Throwable  {    //only for 1 address //shiva
    	selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(noffamily),
				"No Of Family", testData.get("No of Family 2"));
		Thread.sleep(1000);
		clear_custom(DriverFactory.getInstance().getDriver().findElement(nofacre), "No of Acre");
		Thread.sleep(1000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(nofacre),
				"No of Acre",testData.get("sendkeys1"));
		Thread.sleep(1000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(protectcl),
				"Protect class", testData.get("Protect class 6"));
		Thread.sleep(1000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(disttocoast),
				"Distance to coast", testData.get("Distance to coast 2-5 miles"));
		Thread.sleep(1000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_consType),
				"dd_consType", testData.get("Construction Type1"));
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(cenfirinst),"Central Fire Installed");   //click on no
		Thread.sleep(1000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(cenfirbug),"Central Bugler Installed");      //click on yes
    	Thread.sleep(1000);
    		
	}
	

	public void enterPropertyDetails(HashMap<String, String> testData) throws Throwable {
		
		

		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_consType),
				"dd_consType", testData.get("Construction Type"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_PrimaryHeatSource),
				"dd_PrimaryHeatSource", testData.get("Primary Heat Source"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_secHeatSource),
				"dd_secHeatSource", testData.get("Sec Heat Source"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_HeatingUpdateYear),
				"txt_HeatingUpdateYear", testData.get("Heating Update Year"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_roofUpdateYear), "txt_roofUpdateYear",
				testData.get("Roof Update Year"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_plumbingUpdateYear),
				"txt_plumbingUpdateYear", testData.get("Plumbing Update Year"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_wiringUpdateYear),
				"txt_wiringUpdateYear", testData.get("Wiring Update Year"));

		 clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Save),"Save Button");
	}

	public void clickOnNext() {
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Next), "Next Button");
	}
	
	public void clickOnPrevious() {
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(previous1), "Previous");
	}
	
	public void clickOnSave() {
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(save1), "Save");
	}

	public void clickOnSaveAndCont() {
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Save),
				"Save And Continue Button");
	}

	public void enterPropertyDetailsForMultipleProperties(HashMap<String, String> testData) throws Throwable {
	
		for(int i=1;i<=Integer.parseInt(testData.get("No of Properties"));i++) {
			if(i==1) {
				enterPropertyDetails(testData);
				if(Integer.parseInt(testData.get("No of Properties"))==1) {
					clickOnSaveAndCont();
				}else{
					clickOnNext();
				}
			}else {
			Thread.sleep(5000);
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtYearHomeBuild"+i+"']")),
					"Year Built",testData.get("Year Built"+i));
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtSquareFeet"+i+"']")),
					"Sq Ft",testData.get("Square Feet"+i));
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='ddlNoOfFamilies"+i+"']")),
					"No of Families",testData.get("No Of Families"+i));
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtNoAcres"+i+"']")),
					"No of Acres",testData.get("No Of Acres"+i));
			
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='ddlProtectionClass"+i+"']")),
					"Prot Class",testData.get("Prot Class"+i));
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='ddlDistToCoast"+i+"']")),
					"DTC",testData.get("DTC"+i));
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtDwelling"+i+"']")),
					"Coverage A",testData.get("Coverage A"+i));
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtCurrValue"+i+"']")),
					"Current Value",testData.get("Current Value"+i));
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtImproveBuild"+i+"']")),
					"Building Improve Value",testData.get("Building Improve Value"+i));
			Thread.sleep(2000);
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='ddlConstructionType"+i+"']")),
					"Const Type",testData.get("Construction Type"+i));
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//input[contains(@id,'radCentralfire0"+i+"')]//following-sibling::label[text()='"+
							testData.get("Central Station Burglar and/or Fire Credit"+i)+"']")),"Central Fire Button");
			
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//select[@id='ddlPrimaryHeatingType"+i+"']")),"Primary Heat Source",testData.get("Primary Heat Source"+i));
			selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//select[@id='ddlSecondHeatingType"+i+"']")),"Sec Heat Source",testData.get("Sec Heat Source"+i));
			
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtHeatYear"+i+"']")),
					"Heating Update Year",testData.get("Heating Update Year"+i));
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtRoofYear"+i+"']")),
					"Roof Update Year",testData.get("Roof Update Year"+i));
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtPlumbYear"+i+"']")),
					"Plumbing Update Year",testData.get("Plumbing Update Year"+i));
			sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='txtWiringYear"+i+"']")),
					"Wiring Update Year",testData.get("Wiring Update Year"+i));
			clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@pageindex="+i+" and text()='Save']")),"btn_OnlySave");
			
			try {
				clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@pageindex="+i+" and text()='Next']")),"btn_Next");
			}catch(Exception e) {
				clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@pageindex="+i+" and text()='Save & Continue']")),"Save And Continue");
			}
		}
	}
		
	}
	
	public void buildfeetdwell(HashMap<String, String> testData)  throws Throwable {  //shiva
		clear_custom(DriverFactory.getInstance().getDriver().findElement(txt_yearBuilt1), "Year Built");
		Thread.sleep(1000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_yearBuilt1),
				"Year Built",testData.get("sendkeys1"));
		
		Thread.sleep(1000);
		clear_custom(DriverFactory.getInstance().getDriver().findElement(txt_sqft1), "Square Feet");
		Thread.sleep(1000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_sqft1),
				"Square Feet",testData.get("sendkeys1"));
		clear_custom(DriverFactory.getInstance().getDriver().findElement(txt_dwell1), "Dwelling(RCV)");
		Thread.sleep(1000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_dwell1),
				"Dwelling(RCV)",testData.get("sendkeys2"));
		Thread.sleep(2000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='panelsStayOpen-collapse1']//div[@class='row']")),"Anywhere On screen");
		Thread.sleep(10000);
		
		
	}
	
	

	public void validatePropertyScreenURL(HashMap<String, String> testData) throws Throwable { //shiva
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		String currenURL = DriverFactory.getInstance().getDriver().getCurrentUrl();
		System.out.println(currenURL);
		assertEqualsString_custom(currenURL,testData.get("PropertyDetailsPage URL"),"PropertyDetailsPage URL");
		}


	public void verifymaxcharlimit(HashMap<String, String> testData) throws InterruptedException {  //shiva
		// TODO Auto-generated method stub
		
          Thread.sleep(15000);
		
		//clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(priheatoth),"pri heat other add1");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(priheatdes), "Primary Heat Description",
				testData.get("73 char"));
		
		String typedvalue11 =DriverFactory.getInstance().getDriver().findElement(priheatdes).getText();
		int size11=typedvalue11.length();
		if(size11==50) {
			System.out.println("Max char present in primary heat source limit is 50 of property 1");
		}
		else {
			System.out.println("Char present in primary heat source is more then 50 of property 1 #failed");
		}
		Thread.sleep(100);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(secheatoth),"sec heat other add1");
		Thread.sleep(1000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(secheatdes), "sec Heat Description",
				testData.get("73 char"));
		
		String typedvalue12 =DriverFactory.getInstance().getDriver().findElement(secheatdes).getText();
		int size12=typedvalue12.length();
		if(size12==50) {
			System.out.println("Max char present in secondary heat source limit is 50");
		}
		else {
			System.out.println("Char present in secondary heat source is more then 50 #failed");
		}
	/*	clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Next), "Next Button");
		
		Thread.sleep(10000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(priheatoth2),"pri heat other 2");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(priheatdes2), "Primary Heat Description 2",
				testData.get("73 char"));
		
		String typedvalue21 =DriverFactory.getInstance().getDriver().findElement(priheatdes2).getText();
		int size21=typedvalue21.length();
		if(size21==50) {
			System.out.println("Max char present in primary heat source limit is 50 of property 2");
		}
		else {
			System.out.println("Char present in primary heat source is more then 50 of property 2 #failed");
		}
		Thread.sleep(100);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(secheatoth2),"sec heat other add 2");
		Thread.sleep(1000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(secheatdes2), "Sec Heat Description 2",
				testData.get("73 char"));
		
		String typedvalue22 =DriverFactory.getInstance().getDriver().findElement(secheatdes2).getText();
		int size22=typedvalue22.length();
		if(size22==50) {
			System.out.println("Max char present in secondary heat source limit is 50 of property 2");
		}
		else {
			System.out.println("Char present in secondary heat source is more then 50 of property 2 #failed");
		}
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Next), "Next Button");
		
		Thread.sleep(10000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(priheatoth3),"pri heat other add3");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(priheatdes3), "Primary Heat Description 3",
				testData.get("73 char"));
		
		String typedvalue31 =DriverFactory.getInstance().getDriver().findElement(priheatdes3).getText();
		int size31=typedvalue31.length();
		if(size31==50) {
			System.out.println("Max char present in primary heat source limit is 50 of property 3");
		}
		else {
			System.out.println("Char present in primary heat source is more then 50 of property 3 #failed");
		}
		Thread.sleep(100);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(secheatoth3),"sec heat other add3");
		Thread.sleep(1000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(secheatoth3), "Sec Heat Description 3",
				testData.get("73 char"));
		
		String typedvalue32 =DriverFactory.getInstance().getDriver().findElement(secheatdes3).getText();
		int size32=typedvalue32.length();
		if(size32==50) {
			System.out.println("Max char present in secondary heat source limit is 50 of property 3");
		}
		else {
			System.out.println("Char present in secondary heat source is more then 50 of property 3 #failed");
		}*/
		
	}


	public void AddOccupancyType(HashMap<String, String> testData) throws Throwable {
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(ConstructionType),
				"dd_ConType", testData.get("Construction Type1"));
		
	}
}
