package com.reuseable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected static WebDriver driver;
	static public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	static public void url(String url) {
		driver.get(url);
	}
	public WebElement findElementId(String id) {
		return driver.findElement(By.id(id));
	}
	public void sendKeys(WebElement element, String keys) {
		element.sendKeys(keys);
	}
	public void createSheet(int i, int j) throws IOException {
		File file = new File("C:\\Users\\Rudra\\eclipse-workspace\\Adactin\\excel\\data.xlsx");
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet();
		Row row = sheet.createRow(i);
		Cell cell = row.createCell(j);
		FileOutputStream fileoutputstream = new FileOutputStream(file);
		workBook.write(fileoutputstream);
	}
	public String getData(int sheetNo, int rowNo, int cellNo) throws IOException {
		File file = new File("C:\\Users\\Rudra\\eclipse-workspace\\Adactin\\excel\\data.xlsx");
		FileInputStream fileStream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fileStream);
		Sheet sheet = book.getSheetAt(sheetNo);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String value = cell.getStringCellValue().toString();
		return value;
	}
	public void writeData(int s, int r, int c, String value) throws IOException {
		File file = new File("C:\\Users\\Rudra\\eclipse-workspace\\Adactin\\excel\\data.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workBook = new XSSFWorkbook(stream);
		Sheet sheet = workBook.getSheetAt(s); 
		Row row = sheet.createRow(r);
		Cell createCell = row.createCell(c);
		createCell.setCellValue(value);
		FileOutputStream fileoutputstream = new FileOutputStream(file);
		workBook.write(fileoutputstream);
	}
	public void dropDownSelect(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void click(WebElement element) {
		element.click();
	}
	public void clear(WebElement element) {
		element.clear();
	}
	public String getValue(WebElement element) {
		return element.getAttribute("value");
	}
	public void takeScreenShot(WebElement element) throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)element);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\Rudra\\eclipse-workspace\\Adactin\\screenShot\\shot.png");
		FileUtils.copyFile(SrcFile, DestFile);
	}
	@SuppressWarnings("deprecation")
	public void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	public static void windowClose() {
		driver.quit();
	}
}
