package com.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Listener.ListenerManager;
import Pojo.BaseClass;
import Pom.LoginPage;
import Utility.UtilityClass;
@Listeners(ListenerManager.class)

public class LoginPageTest extends BaseClass
{
    public LoginPage login;
	public SoftAssert soft;
	public String sheet="options";
	//public  String succesfulLogin="SuccesfulLoginSheet";
 
	@Parameters("Browsername")
	@BeforeMethod
	public void setup(String Browsername) throws IOException
	{
		
        Initialization(Browsername);
        login=new LoginPage();
        soft=new SoftAssert();
	}

	
	@DataProvider
	public Object[][] SuccessfullLogin_getData() throws EncryptedDocumentException, IOException 
	{
		Object[][] data=UtilityClass.Parametrization("Sheet1");
		return data;
	}
	@DataProvider
	public Object[][] UnsuccesfullLogin() throws EncryptedDocumentException, IOException
	{
		Object[][] data=UtilityClass.Parametrization("Sheet2");
		return data;
	}
	@Test()
	public void valid()
	{
		login.Home_Page();
	}
	
	@Test(priority=1,dataProvider="SuccessfullLogin_getData",  groups= {"Regression"})
	public void validCredentials(String Username,String password, String option)
	{
		login.username(Username);
		login.password(password);
		login.sessionLocation(option);
		login.Login();
		String actual=login.GetTitle();
		System.out.println(actual);
		String expected=prop.getProperty("title");
		
		Assert.assertEquals(actual,expected);
	}
	
	@Test(priority=2, dataProvider="UnsuccesfullLogin", groups= {"Regression"})
	public void invalidCredentials(String Username, String Password, String option)
	{
		login.username(Username);
		login.password(Password);
		login.sessionLocation(option);
		login.Login();
		String actual=login.ErrorMsg();
		System.out.println(actual);
		String expected=prop.getProperty("errormsg");
		Assert.assertEquals(actual, expected);
	}
    @Test(priority=3, groups= {"Smoke"})
    public void Check_OptionCount_and_data() throws EncryptedDocumentException, IOException
    {
    	int ActualCount =login.Checkoption_count();
    	System.out.println(ActualCount);
    	int ExpectedCount=4;
    	soft.assertEquals(ActualCount,ExpectedCount);
    	 //it use complusary in soft assert 
    	ArrayList<String> Actualoptions = login.Check_optiondata();
    	System.out.println(Actualoptions);
    	ArrayList<Object> Expectedoptions = UtilityClass.ReadAllOption(sheet);
    	System.out.println(Expectedoptions);
    	soft.assertEquals(Actualoptions,Expectedoptions);
    	soft.assertAll();
    	
    	
    }
	@AfterMethod
	public static void TearDown()
	{
		driver.quit();
	}
}
