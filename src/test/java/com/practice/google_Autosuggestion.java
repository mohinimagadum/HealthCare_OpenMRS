package com.practice;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pojo.BaseClass;

public class google_Autosuggestion extends BaseClass
{
	BaseClass base;
	@Test
	public void Autosuggestion() throws IOException
	{
		 base =new BaseClass();
		 base.Initialization("chrome");
		 driver.manage().window().maximize();
		 driver.get("https://www.google.com/");
		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // it wait for page loading before throwing exception
		 WebElement search=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		 search.sendKeys("google");
		 List<WebElement> options=driver.findElements(By.xpath("//ul[@jsname='bw4e9b']/li"));
		 System.out.println("No of Options: "+options.size());
		 
		 for(WebElement opt:options)
		 {
			 System.out.println(opt.getText());
		 }
		 
		 
	}
   
    
}
