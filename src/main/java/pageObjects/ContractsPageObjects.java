package pageObjects;
//Author-Rishikesh

import static org.testng.Assert.assertEquals;
//Rishikesh
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

import testBase.DriverFactory;
import testBase.TestBase;

public class ContractsPageObjects extends TestBase{

	
	By btn_Save = By.xpath("//a[text()='Save & Continue']");
	By rad_Liability = By.xpath("//input[@name='RadioLiabilityContract']");
	By input_feild_NXO004 = By.xpath("//*[@id=\"idChkTxtBoxCoverage10\"]");
	By input_feild_NXA101 = By.xpath("//*[@id=\"idChkTxtBoxCoverage19\"]");
	By input_feild_NXH133 = By.xpath("//*[@id=\"idChkTxtBoxCoverage28\"]");
	By input_feild_NXF213 = By.xpath("//*[@id=\"idChkTxtBoxCoverage37\"]");
	By input_feild_NXF285 = By.xpath("//*[@id=\"idChkTxtBoxCoverage64\"]");
	By input_feild_NXF221 = By.xpath("//*[@id=\"idChkTxtBoxCoverage73\"]");
	By btn_RecalculatePrem = By.xpath("//*[@id='btnSaveContractAndContinue']");
	By btn_CompleteApp = By.xpath("//*[text()='Complete application to submit Bind Request']");
	
	By coverage_A = By.xpath("//div[@class='row mt-3']//div[1]//div[1]//h3[1]");
	By NXO004 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[1]/div/div[2]/div[5]/div[2]/div");
	By NXA101 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[2]/div/div[2]/div[5]/div[2]/div");
	By NXH133 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[3]/div/div[2]/div[5]/div[2]/div");
	By NXF213 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[4]/div/div[2]/div[5]/div[2]/div");
	By NXK285 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[5]/div/div[2]/div[5]/div[2]/div");
	By NXE221 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[6]/div/div[2]/div[5]/div[2]/div");
	
	By TIV_NXO004 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[1]/div/div[2]/div[6]/div[2]/div");
	By TIV_NXA101 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[2]/div/div[2]/div[6]/div[2]/div");
	By TIV_NXH133 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[3]/div/div[2]/div[6]/div[2]/div");
	By TIV_NXF213 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[4]/div/div[2]/div[6]/div[2]/div");
	By TIV_NXK285 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[5]/div/div[2]/div[6]/div[2]/div");
	By TIV_NXE221 = By.xpath("//*[@id=\"frmApplicationContract\"]/div/div[1]/div/div/div[6]/div/div[2]/div[6]/div[2]/div");
	private By TIV_NXF221;
	
	
	public void enterContractsPageData(HashMap<String, String> testData) throws Throwable {
		
		
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(rad_Liability),"Liability button");
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_RecalculatePrem),"Recalculate button");
		Thread.sleep(5000);
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_CompleteApp),"Complete App");
		
		
	
	}

	
	

	public void navigateOtherPages(HashMap<String, String> testData) {
		// TODO Auto-generated method stub
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(btn_Save),"Save button");
	}




	public void textfeild(HashMap<String, String> testData) {
		// TODO Auto-generated method stub
		WebElement Tetxt= DriverFactory.getInstance().getDriver().findElement(input_feild_NXO004);
		boolean value = Tetxt.isEnabled();
		if(value)
			System.out.println("***Feild is enable *** TEST CASE Pass" );
		else
		   System.out.println("***Feild is disable *** TEST CASE Fail");
	}




	public void getcoverageA(HashMap<String, String> testData) {
		// TODO Auto-generated method stub
		String Cov_A= DriverFactory.getInstance().getDriver().findElement(coverage_A).getText();
	    System.out.println(Cov_A);
	    String[] A=Cov_A.split(":");
	    String[] B = A[1].split("/");
	    String TIV = B[1];
	    String Coverage = B[0];
//	    System.out.println(TIV);
//	    System.out.println(Coverage);
	    int TIV_Main = Integer.parseInt(TIV.toString().replace("$","").replace(",","").replace("," ,""));
	    System.out.println(TIV_Main);
	    int Coverage_main = Integer.parseInt(Coverage.toString().replace(" $","").replace(",","").replace("," ,""));
	    System.out.println(Coverage_main);
	    //
	    int TIV_val_NXO004 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXO004).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXO004);
	    int TIV_val_NXA101 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXA101).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXA101);
	    int TIV_val_NXH133 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXH133).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXH133);
	    int TIV_val_NXF213 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXF213).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXF213);
	    int TIV_val_NXK285 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXK285).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXK285);
	    int TIV_val_NXE221 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXE221).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXE221);
	    //
	    int Contract_NXO004 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXO004).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXO004);
	    int Contract_NXA101 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXA101).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXA101);
	    int Contract_NXH133 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXH133).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXH133);
	    int Contract_NXF213 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXF213).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXF213);
	    int Contract_NXK285 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXK285).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXK285);
	    int Contract_NXE221 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXE221).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXE221);
	    //
	    int input_NXO004 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXO004).getAttribute("value"));
	    System.out.println(input_NXO004);
	    int input_NXA101 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXA101).getAttribute("value"));
	    System.out.println(input_NXA101);
	    int input_NXH133 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXH133).getAttribute("value"));
	    System.out.println(input_NXH133);
	    int input_NXF213 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXF213).getAttribute("value"));
	    System.out.println(input_NXF213);
	    int input_NXF285 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXF285).getAttribute("value"));
	    System.out.println(input_NXF285);
	    int input_NXF221 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXF221).getAttribute("value"));
	    System.out.println(input_NXF221);
	    
	    int Total = ((Contract_NXO004*input_NXO004)+(Contract_NXA101*input_NXA101)+(Contract_NXH133*input_NXH133)+(Contract_NXF213*input_NXF213)+(Contract_NXK285*input_NXF285)+(Contract_NXE221*input_NXF221))/100;
	    System.out.println(Total);
	}




	public void Contract1(HashMap<String, String> testData) throws InterruptedException {
		// TODO Auto-generated method stub
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXO004).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXA101).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXH133).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF213).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF221).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF285).clear();
		
//		DriverFactory.getInstance().getDriver().findElement(input_feild_NXO004).sendKeys(testData.get("percentage1"));
		
		String contract_per = testData.get("percentage1");
		System.out.println("VALUEEEEEEEEEEEEEE : "+contract_per);
		Thread.sleep(500);
		
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(input_feild_NXO004),"Contract value",contract_per);
		String Cov_A= DriverFactory.getInstance().getDriver().findElement(coverage_A).getText();
	    System.out.println(Cov_A);
	    String[] A=Cov_A.split(":");
	    String[] B = A[1].split("/");
	    String TIV = B[1];
	    String Coverage = B[0];
//	    System.out.println(TIV);
//	    System.out.println(Coverage);
	    int TIV_Main = Integer.parseInt(TIV.toString().replace("$","").replace(",","").replace("," ,""));
	    System.out.println(TIV_Main);
	    int Coverage_main = Integer.parseInt(Coverage.toString().replace(" $","").replace(",","").replace("," ,""));
	    System.out.println(Coverage_main);
		int TIV_val_NXO004 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXO004).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXO004);
	    int Contract_NXO004 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXO004).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXO004);
	    int input_NXO004 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXO004).getAttribute("value"));
	    System.out.println(input_NXO004);
	    int Cov_VAL =(Contract_NXO004*input_NXO004)/100;
	    int Cov_TV = (TIV_val_NXO004*input_NXO004)/100;
	    if (Cov_VAL>=Coverage_main && Cov_TV>=TIV_Main)
	    System.out.println("valid combination");
	    else
	    System.out.println("INvalid combination");
	    	
	    
	    
	   
	}




	public void Contract2(HashMap<String, String> testData) throws InterruptedException {
		// TODO Auto-generated method stub
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXO004).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXA101).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXH133).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF213).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF221).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF285).clear();
		
		String contract_per4 = testData.get("percentage1");
		System.out.println("VALUEEEEEEEEEEEEEE : "+contract_per4);
		Thread.sleep(500);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(input_feild_NXA101),"Contract value",contract_per4);
		String Cov_A= DriverFactory.getInstance().getDriver().findElement(coverage_A).getText();
	    System.out.println(Cov_A);
	    String[] A=Cov_A.split(":");
	    String[] B = A[1].split("/");
	    String TIV = B[1];
	    String Coverage = B[0];
//	    System.out.println(TIV);
//	    System.out.println(Coverage);
	    int TIV_Main = Integer.parseInt(TIV.toString().replace("$","").replace(",","").replace("," ,""));
	    System.out.println(TIV_Main);
	    int Coverage_main = Integer.parseInt(Coverage.toString().replace(" $","").replace(",","").replace("," ,""));
	    System.out.println(Coverage_main);
		int TIV_val_NXA101 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXA101).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXA101);
	    int Contract_NXA101 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXA101).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXA101);
	    int input_NXA101 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXA101).getAttribute("value"));
	    System.out.println(input_NXA101);
	    int Cov_VAL_NXA101 =(Contract_NXA101*input_NXA101)/100;
	    int Cov_TV_NXA101 = (TIV_val_NXA101*input_NXA101)/100;
	    if (Cov_VAL_NXA101>=Coverage_main && Cov_TV_NXA101>=TIV_Main)
	    System.out.println("valid combination");
	    else
	    System.out.println("INvalid combination");

		
	}




	public void Contraxt3(HashMap<String, String> testData) throws InterruptedException {
		// TODO Auto-generated method stub
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXO004).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXA101).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXH133).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF213).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF221).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF285).clear();
		
		String contract_per = testData.get("percentage1");
		System.out.println("VALUEEEEEEEEEEEEEE : "+contract_per);
		Thread.sleep(500);
		click_custom(DriverFactory.getInstance().getDriver().findElement(input_feild_NXH133), "Contract value 3");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(input_feild_NXH133),"Contract value",contract_per);
		String Cov_A= DriverFactory.getInstance().getDriver().findElement(coverage_A).getText();
	    System.out.println(Cov_A);
	    String[] A=Cov_A.split(":");
	    String[] B = A[1].split("/");
	    String TIV = B[1];
	    String Coverage = B[0];
//	    System.out.println(TIV);
//	    System.out.println(Coverage);
	    int TIV_Main = Integer.parseInt(TIV.toString().replace("$","").replace(",","").replace("," ,""));
	    System.out.println(TIV_Main);
	    int Coverage_main = Integer.parseInt(Coverage.toString().replace(" $","").replace(",","").replace("," ,""));
	    System.out.println(Coverage_main);
		int TIV_val_NXH133 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXH133).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXH133);
	    int Contract_NXH133 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXH133).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXH133);
	    int input_NXH133 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXH133).getAttribute("value"));
	    System.out.println(input_NXH133);
	    int Cov_VAL_NXH133 =(Contract_NXH133*input_NXH133)/100;
	    int Cov_TV_NXH133 = (TIV_val_NXH133*input_NXH133)/100;
	    if (Cov_VAL_NXH133>=Coverage_main && Cov_TV_NXH133>=TIV_Main)
	    System.out.println("valid combination");
	    else
	    System.out.println("INvalid combination");
	}




	public void Contraxt4(HashMap<String, String> testData) throws InterruptedException {
		// TODO Auto-generated method stub
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXO004).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXA101).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXH133).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF213).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF221).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF285).clear();
		
		String contract_per = testData.get("percentage1");
		System.out.println("VALUEEEEEEEEEEEEEE : "+contract_per);
		Thread.sleep(500);
		click_custom(DriverFactory.getInstance().getDriver().findElement(input_feild_NXF213), "Contract value 4");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(input_feild_NXF213),"Contract value",contract_per);
		String Cov_A= DriverFactory.getInstance().getDriver().findElement(coverage_A).getText();
	    System.out.println(Cov_A);
	    String[] A=Cov_A.split(":");
	    String[] B = A[1].split("/");
	    String TIV = B[1];
	    String Coverage = B[0];
//	    System.out.println(TIV);
//	    System.out.println(Coverage);
	    int TIV_Main = Integer.parseInt(TIV.toString().replace("$","").replace(",","").replace("," ,""));
	    System.out.println(TIV_Main);
	    int Coverage_main = Integer.parseInt(Coverage.toString().replace(" $","").replace(",","").replace("," ,""));
	    System.out.println(Coverage_main);
		int TIV_val_NXF213 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXF213).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXF213);
	    int Contract_NXF213 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXF213).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXF213);
	    int input_NXF213 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXF213).getAttribute("value"));
	    System.out.println(input_NXF213);
	    int Cov_VAL_NXF213 =(Contract_NXF213*input_NXF213)/100;
	    int Cov_TV_NXF213 = (TIV_val_NXF213*input_NXF213)/100;
	    if (Cov_VAL_NXF213>=Coverage_main && Cov_TV_NXF213>=TIV_Main)
	    System.out.println("valid combination");
	    else
	    System.out.println("INvalid combination");
		
	}




	public void Contraxt5(HashMap<String, String> testData) throws InterruptedException {
		// TODO Auto-generated method stub
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXO004).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXA101).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXH133).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF213).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF221).clear();
		DriverFactory.getInstance().getDriver().findElement(input_feild_NXF285).clear();
		
		String contract_per = testData.get("percentage1");
		System.out.println("VALUEEEEEEEEEEEEEE : "+contract_per);
		Thread.sleep(500);
		click_custom(DriverFactory.getInstance().getDriver().findElement(input_feild_NXF221), "Contract value 5");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(input_feild_NXF221),"Contract value",contract_per);
		String Cov_A= DriverFactory.getInstance().getDriver().findElement(coverage_A).getText();
	    System.out.println(Cov_A);
	    String[] A=Cov_A.split(":");
	    String[] B = A[1].split("/");
	    String TIV = B[1];
	    String Coverage = B[0];
//	    System.out.println(TIV);
//	    System.out.println(Coverage);
	    int TIV_Main = Integer.parseInt(TIV.toString().replace("$","").replace(",","").replace("," ,""));
	    System.out.println(TIV_Main);
	    int Coverage_main = Integer.parseInt(Coverage.toString().replace(" $","").replace(",","").replace("," ,""));
	    System.out.println(Coverage_main);
		int TIV_val_NXF221 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(TIV_NXF221).getText().toString().replace("$","").replace(",",""));
	    System.out.println(TIV_val_NXF221);
	    int Contract_NXF221 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(NXE221).getText().toString().replace("$","").replace(",",""));
	    System.out.println(Contract_NXF221);
	    int input_NXF221 = Integer.parseInt(DriverFactory.getInstance().getDriver().findElement(input_feild_NXF213).getAttribute("value"));
	    System.out.println(input_NXF221);
	    int Cov_VAL_NXF221 =(Contract_NXF221*input_NXF221)/100;
	    int Cov_TV_NXF221 = (TIV_val_NXF221*input_NXF221)/100;
	    if (Cov_TV_NXF221>=Coverage_main && Cov_TV_NXF221>=TIV_Main)
	    System.out.println("valid combination");
	    else
	    System.out.println("INvalid combination");
		
		
	}


	public void SaveContractsPageData() {
		// TODO Auto-generated method stub
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"idRadioLiability12\"]")).click();
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"btnSaveContractDraftAndContinue\"]")),"Save button");
	}
	
	public void SaveContractsPageDataD() {
		// TODO Auto-generated method stub
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"idRadioLiability12\"]")).click();
		clickByJavaScriptExecutor(DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"btnSaveContractAndContinue\"]")),"Save and Cont button");
	}


	public void Contraxt6(HashMap<String, String> testData) {
		// TODO Auto-generated method stub
		
	}
	
	}

	
	

