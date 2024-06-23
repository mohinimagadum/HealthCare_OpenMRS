package com.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Parametrization 
{
	@Test
	public void read_excel_data() throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\HP\\Desktop\\ReadExcelData.xlsx");  //launch workbook
		Workbook book = WorkbookFactory.create(file); //file create
		Sheet sheet=book.getSheet("Sheet1"); //"Sheet1" is name of sheet //fetch sheet from excel workbook
		
		int rows=sheet.getLastRowNum();
		System.out.println("no of rows "+rows);
		
		int columns=sheet.getRow(0).getLastCellNum();
		System.out.println("no of columns  "+columns);
		
		String data1=sheet.getRow(1).getCell(1).toString();
		System.out.println(data1);
		
		Object[][] data=new Object[rows][columns];
		for(int i=0; i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).toString();
				System.out.print(data[i][j]+" ");
			}System.out.println();
		}
		
		
		
		
	}
	

}
