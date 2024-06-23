package com.practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class childBrowser_popup {
	
	@Test
	public static void childbrowser()
	{
	
	    WebDriver driver =new ChromeDriver(); //chromedriver object is created but refer to wedriver (upcasting)
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	    driver.get("https://demoqa.com/browser-windows");
	  
	   driver.findElement(By.xpath("//button[@id='windowButton']")).click(); //it will click on child window
	 
	    
	    String mainwindow = driver.getWindowHandle(); //store addres of mainwindow
	    System.out.println(mainwindow); // print address of mainwindow
	    
	    Set<String> allwindow = driver.getWindowHandles(); //it will store address of all windows open on browser
	    ArrayList<String> arr=new ArrayList<String>(allwindow); //Address of windows stored in arraylist
	    //0 index = mainwindow, 1 index=childwindow
	    String childwindow=arr.get(1);
	    System.out.println(childwindow);
	    for(int i=0; i<arr.size(); i++) //i=0; i<2;
	    {
	    	if(!mainwindow.equalsIgnoreCase(childwindow)) //true it will focus on mainwindow
	    	{
	    		driver.switchTo().window(childwindow);//focus switch to child window
	    		driver.manage().window().maximize();
	    		WebElement wb=driver.findElement(By.xpath("//h1[@id='sampleHeading']")); //find xpath of child window text
	    		System.out.println(wb.getText());
	    		
	    		
	    		driver.switchTo().window(mainwindow); //focus switch to mainwindow
	    	}
	    	break;
	    }
	    
	   
	}
	

}
