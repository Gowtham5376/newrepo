package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	static WebDriver driver;
	public static void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(url);
		driver.getCurrentUrl();
		driver.getTitle();
		driver.manage().window().maximize();
		}

	public static void sendkeys(WebElement element, String data) {
		element.sendKeys(data);
		
		}
	public static void sendkey(WebElement element, String data) {
		element.sendKeys(data);
	}
	public  static void click(WebElement element) {
		element.click();

	}
	public static String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}
	
	public static  String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public static void clear(WebElement element) {
		element.clear();
	}
	public static void selectByVisibleText(WebElement element,String data) {
		Select s= new Select(element);
		s.selectByVisibleText(data);
	}
	
	public static String excelRead(String path , String sheetname , int rownum , int cellnum) throws IOException {
		File f = new File(path);
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		
		if (cellType==1) {
			String data = cell.getStringCellValue();
			return data;
			
			
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/YYYY");
		    String data = d.format(dateCellValue);
		    return data;
		}
		
		else {
			double numericCellValue = cell.getNumericCellValue();
		    Long l = (long) numericCellValue;
		    String data = String.valueOf(l);
		    return data;
		 
		}
		
		
		
		
		
		
		
		
		
		

	}

	 public static void writeExcel(String path , String sheetname , int row , int cell , String data) throws IOException {
		 File f = new File (path);
		 Workbook w = new XSSFWorkbook();
		 Sheet createSheet = w.createSheet(sheetname);
		 Row createRow = createSheet.createRow(row);
		 Cell createCell = createRow.createCell(cell);
		 createCell.setCellValue(data);
		 FileOutputStream stream = new FileOutputStream(f);
		 w.write(stream);
		 
		
	}



	
}
