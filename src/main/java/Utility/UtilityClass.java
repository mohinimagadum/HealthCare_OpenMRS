
package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pojo.BaseClass;

public class UtilityClass extends BaseClass
{
	//Explicit wait
	public static WebDriverWait wait;
	public static Actions act;
	public static String projectpath=System.getProperty("user.dir");
	
	
	public static void WaitForElement(WebElement element)  //wait until single element to be visible
	{
	    wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void ElementTobeClickable(WebElement element) //wait until element to be clickable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void WaitForElements(List<WebElement> element) //wait until list of element to be visible
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	//Action Class
	
	public static void MoveToElement(WebElement element)
	{
		act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public static void click(WebElement element)
	{
		 act=new Actions(driver);
		 act.click(element).perform();
	}
	public static void sendKeys(WebElement element, String str)
	{
		act=new Actions(driver);
		act.sendKeys(element, str).perform();
		//act.moveToElement(element).sendKeys(str).perform(); 
	}
	
	//Parameterization
	public static Object[][] Parametrization(String Sheetname) throws EncryptedDocumentException, IOException 
	{

	      FileInputStream file = new FileInputStream(projectpath+"\\TestData\\ReadExcelData.xlsx");  //launch workbook
	      Workbook book = WorkbookFactory.create(file); //file create
	      Sheet sheet=book.getSheet(Sheetname); //"Sheetname" is name of sheet //fetch sheet from excel workbook
	      
	      int rows=sheet.getLastRowNum();
	      System.out.println("no of rows "+rows);
	
	      int columns=sheet.getRow(0).getLastCellNum();
	      System.out.println("no of columns  "+columns);
	
	      String data1=sheet.getRow(1).getCell(1).toString();
	      System.out.println(data1);
	      
	
	      Object[][] data=new Object[rows][columns];
	      for(int i=0; i<rows;i++) //row sathi
	      {
	      	for(int j=0;j<columns;j++) //coloumn sathi
	      	{
	      		data[i][j]=sheet.getRow(i+1).getCell(j).toString();
	      		//System.out.print(data[i][j]+" ");
	      	}//System.out.println();
	      }
	      return data;
	 }
	public static ArrayList<Object> ReadAllOption(String Sheetname) throws EncryptedDocumentException, IOException
	{
	      FileInputStream file = new FileInputStream(projectpath+"\\TestData\\ReadExcelData.xlsx");  //launch workbook
	      Workbook book = WorkbookFactory.create(file); //file create
	      Sheet sheet=book.getSheet(Sheetname); //"Sheetname" is name of sheet //fetch sheet from excel workbook
	      
	      int rows=sheet.getLastRowNum();
	      System.out.println("no of rows "+rows);
	
	      ArrayList<Object> data=new ArrayList<Object>();
	      for(int i=1; i<=sheet.getLastRowNum(); i++) //row sathi
	      {
	      	       data.add(sheet.getRow(i).getCell(0).getStringCellValue());
	      	
	      }return data;
	      
	      
	      
	      
	}

	//Javascript exicutor
	public static JavascriptExecutor js=(JavascriptExecutor)driver;
	 public static void JSclick(WebElement element) //click 
	 {
		 js.executeScript("arguments[0].click();", element);
		
	 }
	 public static void JSSendKeys(WebElement element, String str) // sendKeys
	 {
		 js.executeScript("arguments[0].value=arguments[1];", element,str);
	 }
	 public static void scrollWindow()
	 {
		    js.executeScript("window.scrollBy(0,500);"); //scroll down
		    js.executeScript("window.scrollBy(0,-500);"); //scroll up
		    js.executeScript("window.scrollBy(500,0);");  //scroll left
		    js.executeScript("window.scrollBy(-500,0);"); //scroll right
	 }
	 public static void scrollIntoPerticularElement(WebElement element)
	 {
		 js.executeScript("arguments[0].scrollIntoView(true);",element); //scroll to element 
	 }
	
	 //Screenshot
	 public static void TakeScreenshot(String name) throws IOException
     {
   	     File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   	     File destination=new File(Projectpath+"\\src\\test\\resources\\Screenshot"+name+".png");
   	     FileUtils.copyFile(source, destination);
     }

}
