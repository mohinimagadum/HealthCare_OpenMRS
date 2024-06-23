package Listener;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Pojo.BaseClass;
import Utility.ExtentManager;
import Utility.UtilityClass;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
public class ListenerManager<capabalities>  extends BaseClass implements ITestListener
{
	private static ExtentReports extent=ExtentManager.SetupExtentReport(); //extends ExtentManager class
	private static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
    WebDriver driver;
   
  
	//below all method comes Automatic (Rightclick on this page -> source -> Override/implements method -> select All option ->finish)
	public void onTestStart(ITestResult result) 
	{
		//Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
		String testcasename=result.getMethod().getMethodName();
		ExtentTest extenttest=extent.createTest(testcasename);
		test.set(extenttest);
		test.get().log(Status.INFO, testcasename+ " is Started at: "+CaptureCurrentTime());  //Logs (it will print browser name cap.getBrowserName())
		
	}
	public void onTestSuccess(ITestResult result) 
	{
	    
		String testcasename=result.getMethod().getMethodName();
		test.get().log(Status.INFO, testcasename+ " is Passed at: "+CaptureCurrentTime());   //logs
	}
	public void onTestFailure(ITestResult result)
	{
		try {
			UtilityClass.TakeScreenshot("FailedTestCase");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String testcasename=result.getMethod().getMethodName();
		test.get().log(Status.INFO, testcasename+ " is Failed at: "+CaptureCurrentTime());
		test.get().log(Status.FAIL, testcasename+ " is Failed becouse:  "+result.getThrowable()); //result.getThrowable() it will print exception 
		
	}
	public void onTestSkipped(ITestResult result)
	{
		String testcasename=result.getMethod().getMethodName();
		test.get().log(Status.INFO, testcasename+ " is Skipped");
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	public void onStart(ITestContext context) {
		
	}
	public void onFinish(ITestContext context) 
	{
		extent.flush(); //it is compulasory used then onlyextent roprt generate
		
	}
	public static String CaptureCurrentTime()
	{
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-DD HH:mm:ss");
		LocalDateTime currenttime=LocalDateTime.now();
		String formatedtime=currenttime.format(formatter);
		return formatedtime;
	}
	
	
	
	
	
	

}
