package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentEmailReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reusableComponents.PropertiesOperations;


public class ExtentReportNG {
	
	 static ExtentReports extent;
	 static SimpleDateFormat format;
	 static Date date;
	 public static String actualDate;
	 
	
	

	public static ExtentReports setupExtentReport() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		actualDate = format.format(date);
		
		/*String reportPath = System.getProperty("user.dir")+
				"/Reports/ExecutionReport_"+actualDate+".html";*/
		String reportPath = getReportPath(actualDate);
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		
		 extent = new ExtentReports();
		 extent.attachReporter(sparkReport);
		
		 
		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("RPS Automation");
		
		extent.setSystemInfo("Executed on Environment: ", PropertiesOperations.getPropertyValueByKey("url"));
		extent.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
		return extent;
	}
	
	public static String getReportPath(String actualDate) {
		
		String reportPath = System.getProperty("user.dir")+
				"/Reports/ExecutionReport_"+actualDate+".html";
		return reportPath;
		
	}
	
	public static void extentEmail() {
		ExtentEmailReporter email = new ExtentEmailReporter("C:\\Users\\Pratik Nishi\\AutomationForRPS\\NEEE\\Reports");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(email);
	}
	
	


}
