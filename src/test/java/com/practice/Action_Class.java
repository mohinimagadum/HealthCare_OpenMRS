package com.practice;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pojo.BaseClass;

public class Action_Class extends BaseClass {
	BaseClass base;
	Actions action;
	
	@Test()
	public void actionClass() throws InterruptedException, IOException
	{
		base=new BaseClass();
		base.Initialization("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // it wait for page loading before throwing exception
		WebElement search=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		action =new Actions(driver);
		action.sendKeys(search, "pune").perform(); //alternate of sendkeys()
		//action.moveToElement(search).sendKeys("pune").perform(); //alternate of sendkeys()
		
		 WebElement element=driver.findElement(By.xpath("//ul[@jsname='bw4e9b']/li[4]"));
		 action.moveToElement(element).perform();
		 
		 action.sendKeys(Keys.PAGE_UP).perform();
		 action.sendKeys(Keys.PAGE_DOWN).perform();
		// action.doubleClick(element).perform();
		// action.clickAndHold(element).perform();
		 Thread.sleep(5000);
		// action.release(element).perform();
		 action.contextClick(element).perform(); //right click
		 action.click(element).perform();
		 
		 
		 
		
	}
	

}
