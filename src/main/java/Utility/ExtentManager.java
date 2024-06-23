package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager
{
	private static ExtentReports extent;
	private static ExtentSparkReporter reporter;
	private static ExtentTest test;
	
	public static ExtentReports SetupExtentReport()
	{
		String reportpath=System.getProperty("user.dir")+"//Reports//TestExicutionReport.html";
		reporter=new ExtentSparkReporter(reportpath);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Automation Test Exicution Report");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name","Local Host");
		extent.setSystemInfo("Envirnment","UAT");
		extent.setSystemInfo("Mohini Vaswade","QA Automation Tester");
		return extent;
	}
	
	

}
