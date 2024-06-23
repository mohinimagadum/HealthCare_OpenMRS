package com.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Listener.ListenerManager;
import Pojo.BaseClass;
import Pom.HomePage;
import Pom.LoginPage;
@Listeners(ListenerManager.class)
public class HomePageTest extends BaseClass {
	
	
    @BeforeClass()
    @Parameters("Browsername")
	public void setup(String Browsername) throws IOException
	{
	    Initialization(Browsername);
	    LoginPage login=new LoginPage() ;
		login.Home_Page();
	}
	
	@Test(priority=1)
	public void VerifyHeading()
	{
		String actual="Logged in as Super User (admin) at Registration Desk.";
		String expected=prop.getProperty("HomePageHeading");
		Assert.assertEquals(actual,expected);
	}
	
	@Test(dependsOnMethods = {"VerifyHeading"})
	public void findPatientRecord()
	{
		HomePage home=new HomePage() ;
		home.FindPatientRecord();
	}
	
	@Test()
	public void RegisterPatient()
	{
		HomePage home=new HomePage() ;
		 //home.RegisterPatient();
	}
	
	@Test(dependsOnMethods = {"findPatientRecord"})
	public void logout()
	{
		HomePage home=new HomePage() ;
		home.Logout();
		
		String actual="Login";
		String expected=prop.getProperty("login");
		Assert.assertEquals(actual, expected);
		
	}
	
	


}
