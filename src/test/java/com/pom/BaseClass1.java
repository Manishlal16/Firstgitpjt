package com.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	
	public static WebDriver driver;
	//1.launch chrome browser
	public static void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	//2.navigate to webpage
	public static  void launchurl(String url) {
		driver.get(url);
	}
	//3.send data to textbox
	public void elementSendData(WebElement element,String data) {
			element.sendKeys(data);
	}
	//4.get currenturl
	public String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	//5.get webpage title
	public String webPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	//6.to close all tabs/quit browser
		public static void quitBrowser() {
			driver.quit();
		}
		//7.to find element by id
				public WebElement elementById(String idAttributeValue) {
					WebElement element = driver.findElement(By.id(idAttributeValue));
					return element;
				}
			//8.to find element by name
				public WebElement elementByName(String nameAtrributeValue) {
					WebElement element = driver.findElement(By.name(nameAtrributeValue));
					return element;
				}
			//9.to find element by classname
					public WebElement elementByClassName(String classNameAtrributeValue) {
						WebElement element = driver.findElement(By.name(classNameAtrributeValue));
						return element;
					}
			//10.to find element by name
					public WebElement elementByXpath(String xpath) {
						WebElement element = driver.findElement(By.xpath(xpath));
						return element;
					}
			//11.to get text from webpage
					public String elementText(WebElement element) {
						String text = element.getText();
						return text;	
					}
			//12.to click
					public void elementClick(WebElement element) {
						element.click();
					}
					//40.select from dropdown by text(selectByVisibleText)
					public void optionSelectByText(WebElement element,String text) {
						Select select =new Select(element);
						select.selectByVisibleText(text);
					}
			//13.select from dropdowndown by value
					public void optionSelectByValue(WebElement element,String value) {
						Select select=new Select(element);
						select.selectByValue(value);
					}
			//14.select from dropdown by index
					public void optionSelectByIndex(WebElement element,int index) {
						Select select =new Select(element);
						select.selectByIndex(index);
					}
					//15.to read data from excel
					public String getdataFromExcel(String sheetname,int rowIndex,int cellIndex) throws IOException{
						String res=null;
				File file=new File("C:\\Users\\user\\eclipse-workspace\\OMRDetails1\\libexcel\\pomexel.xlsx");
						FileInputStream inStream=new FileInputStream(file);
						Workbook workbook=new XSSFWorkbook(inStream);
						Sheet sheet=workbook.getSheet(sheetname);
							Row row = sheet.getRow(rowIndex);
								Cell cell = row.getCell(cellIndex);
								CellType type = cell.getCellType();
								switch(type)
								{case STRING:
									res= cell.getStringCellValue();
									break;
								case NUMERIC:
									if(DateUtil.isCellDateFormatted(cell))
									{
										Date dateCellValue = cell.getDateCellValue();
										SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyy");
										res = dateformat.format(dateCellValue);	
									}
									else
									{
										double d = cell.getNumericCellValue();
										BigDecimal num=BigDecimal.valueOf(d);
										res = num.toString();	
									}
									break;
									default:
										break;
								}
								return res;
								}
					//16.to update existing data in Excel
					public void upadateData(String sheetname,int rowIndex,int cellIndex,String oldData,String newData) throws IOException {
						File file=new File("C:\\Users\\user\\eclipse-workspace\\OMRDetails1\\libexcel\\pomexel.xlsx");
						Workbook workbook=new XSSFWorkbook();
						Sheet sheet = workbook.createSheet(sheetname);
						Row row = sheet.createRow(rowIndex);
						Cell cell = row.createCell(cellIndex);
						String stringCellValue = cell.getStringCellValue();
						if(stringCellValue.equals(oldData)) {
							cell.setCellValue(newData);
						}
						FileOutputStream out=new FileOutputStream(file);
						workbook.write(out);
					}
						//17.to clear data
						public void clearData(WebElement element) {
							element.clear();
						}
						//18.Window maximize
						public static void windowMaximize() {
					    	   driver.manage().window().maximize();
					       }
						//19.SendKeys
						public void Sendkeys(WebElement element,String text) {
					    	   element.sendKeys(text);
						}
						//20.Implicity Wait
						public static void ImplicityWait() {
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						}
						//21.to close current window
						public void closeCurrentWindow() {
							driver.close();
						}
						//22.Get attribute
						public String getAttribute(WebElement element) {
							String attribute = element.getAttribute("value");
							return attribute;
						
						}
						//23.to write data in empty cell in Excel
						public void writeData(String sheetname,int rowIndex,int cellIndex,String data) throws IOException {
							File file=new File("C:\\Users\\user\\eclipse-workspace\\OMRDetails1\\libexcel\\pomexel.xlsx");
							FileInputStream inStream=new FileInputStream(file);
							Workbook workbook=new XSSFWorkbook(inStream);
							Sheet sheet=workbook.getSheet(sheetname);
								Row row = sheet.getRow(rowIndex);
								Cell cell = row.createCell(cellIndex);
								cell.setCellValue(data);
								FileOutputStream out=new FileOutputStream(file);
								workbook.write(out);}
						//24.to accept alert
						public void acceptAlert() {
							Alert alert = driver.switchTo().alert();
							alert.accept();
						}
				//25.to cancel alert
						public void cancelAlert() {
							Alert alert = driver.switchTo().alert();
							alert.dismiss();
						}
				//26.to senddata to alert and click ok
						public void sendDataToAlert(String data) {
							Alert alert = driver.switchTo().alert();
							alert.sendKeys(data);
							alert.accept();
						}
						
						
					}
