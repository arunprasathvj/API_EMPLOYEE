package Utills;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reports extends TestListenerAdapter {
	
	public  ExtentHtmlReporter htmlreporter;
	public  ExtentReports extent ;
	public  ExtentTest test ;
	
	public  void onStart (ITestContext testContext) {
		
		htmlreporter=new ExtentHtmlReporter("./reports/report.html");
		htmlreporter.config().setDocumentTitle("API AUTOMATION");
		htmlreporter.config().setReportName("TEST");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Projectname ","Employee Details ");
		extent.setSystemInfo("HostName", "Local Environment");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Prasath - G");
		
		
	} 
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test Cases Are Passed "+result.getName());
		
	}
     public void onTestFailure(ITestResult result) {
    	 test=extent.createTest(result.getName());
    	 test.log(Status.FAIL, "Test Cases Failled is"+result.getName());
    	 test.log(Status.FAIL, "Test Cases Failled is"+result.getThrowable());
		
	}
     public void onTestSkipped(ITestResult result) {
		test = extent .createTest(result.getName());
		test.log(Status.SKIP, "Test Cases Skipped " + result.getName());
		
	}
     public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	

}
