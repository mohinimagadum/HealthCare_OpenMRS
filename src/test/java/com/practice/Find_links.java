package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Find_links
{
	public static WebDriver driver;
	@Test
	public void links()
	{
		WebDriver driver=new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		List<WebElement> list=driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		WebElement career=driver.findElement(By.linkText("Careers"));
		career.click();
		
		
	}

}
