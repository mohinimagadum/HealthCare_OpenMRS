package com.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pojo.BaseClass;

public class Javascript_Executor extends BaseClass
{
	BaseClass base;
	
	@Test 
	public void javascript() throws InterruptedException, IOException
	{
	    base=new BaseClass();
	    base.Initialization("chrome");
	    driver.manage().window().maximize();
	    driver.get("https://www.facebook.com/login/");
		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // it wait for page loading before throwing exception
	    JavascriptExecutor js=(JavascriptExecutor)driver; //typecast driver to javascriptexecutor
	    
	    //Sendkeys using javascript executor
	    WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
	    String id="mohini@gmail.com";
	    js.executeScript("arguments[0].value=arguments[1];", username,id); //enter userid
	    
	    //click on login btn
	    WebElement login=driver.findElement(By.xpath("//button[@id='loginbutton']"));
	    js.executeScript("arguments[0].click();", login); //click on login btn
	    username.sendKeys(Keys.ENTER);
	    
	    js.executeScript("window.scrollBy(0,500)"); //scroll down
	    Thread.sleep(4000);
	    js.executeScript("window.scrollBy(0,-500)"); //scroll up
	    js.executeScript("window.scrollBy(500,0)");  //scroll left
	    js.executeScript("window.scrollBy(-500,0)"); //scroll right
	    
	    //scroll into perticulor element
	    By career =By.linkText("Careers");
	    WebElement career1=driver.findElement(career);
	    js.executeScript("arguments[0].scrollIntoView(true);",career1); //scroll to element 
	    
	}
	

}
