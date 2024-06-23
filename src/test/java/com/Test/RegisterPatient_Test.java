package com.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Pojo.BaseClass;

public class RegisterPatient_Test extends BaseClass{

	@Test(priority=2)
	public void patient_Registration()
	{
		WebElement register=driver.findElement(By.xpath("//a[contains(@id,'referenceapplication-registrationapp')]")); //by partial Linked text
		register.click();
		
	}
	
	@Test(priority=3)
	public void name()
	{
		driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("Pooja");
		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("pranav");
		driver.findElement(By.xpath("//input[@name='familyName']")).sendKeys("Patil");
		//driver.findElement(By.xpath("//label[text()='Unidentified Patient']")).click();
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
	}
	@Test(priority=4)
	public void gender()
	{
		driver.findElement(By.xpath("//option[text()='Female']")).click();
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
	}
	@Test(priority=5)
	public void birthdate()
	{
		driver.findElement(By.name("birthdateDay")).sendKeys("14");
		WebElement month=driver.findElement(By.xpath("//select[@id='birthdateMonth-field']"));
		Select se = new Select(month);
		se.selectByVisibleText("June");
		driver.findElement(By.xpath("//input[@id='birthdateYear-field']")).sendKeys("2009");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		
	}
	
	
	/*@AfterMethod
	public void teardown()
	{
		driver.close();
	}*/
}
