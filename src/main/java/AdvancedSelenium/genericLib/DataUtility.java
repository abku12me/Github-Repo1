package AdvancedSelenium.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {
	
	public String datafromprpoerties(String key) throws IOException
	{
		FileInputStream fil=new FileInputStream("C:\\Users\\mishr\\OneDrive\\Desktop\\Abhishek\\Practice file\\DatadrivenTesting.txt");
		Properties pro=new Properties();
		pro.load(fil);
		String value=pro.getProperty(key);
		return value;
	}
	
	public String datafromExcelsheet(String sheetname,int num1,int num2) throws EncryptedDocumentException, IOException
	{
		FileInputStream fil=new FileInputStream("C:\\Users\\mishr\\OneDrive\\Desktop\\Abhishek\\Practice file\\Excelfile.xlsx");
		
		Workbook book=WorkbookFactory.create(fil);
		Sheet sh=book.getSheet(sheetname);
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(sh.getRow(num1).getCell(num2));
		return value;
	}
	
	

}
