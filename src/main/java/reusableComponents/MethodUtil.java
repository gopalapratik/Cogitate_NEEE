package reusableComponents;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;

import testBase.DriverFactory;
import testBase.TestBase;

public class MethodUtil extends TestBase{
	
	By txt_ToastBox  = By.xpath("//div[contains(@class,'toast toast')]"); 
	By txt_ToastMsg  = By.xpath("//div[@class='toast-message']");
	
	public void validateToasterMsg(String ExpMsg) throws Throwable {
		moveToElement_custom(DriverFactory.getInstance().getDriver().findElement(txt_ToastBox),"Toast Error Message");
		String toastMsg = DriverFactory.getInstance().getDriver().findElement(txt_ToastMsg).getText();
		System.out.println(toastMsg);
		assertEqualsString_custom(toastMsg.trim(),ExpMsg.trim(),"Toast Message");
	}
	
	public String getDesiredValue(String orgText,String text1,String text2) {
		
		orgText = orgText.substring(orgText.indexOf(text1));
		orgText = orgText.substring(0, orgText.indexOf(text2)).replaceAll("[^0-9.]", "");
		return orgText;
		
	}

}
