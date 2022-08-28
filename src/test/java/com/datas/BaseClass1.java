package com.datas;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass1 {

	WebDriver driver;
	//1.launch chrome browser
	public void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	//2.navigate to webpage
	public void launchurl(String url) {
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
	//5.get webpagetitle
	public String webPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	//6.to close current window
	public void closeCurrentWindow() {
		driver.close();
	}
	//7.to close all tabs/quit browser
	public void quitBrowser() {
		driver.quit();
	}
	//8.to find element by id
		public WebElement elementById(String idAttributeValue) {
			WebElement element = driver.findElement(By.id(idAttributeValue));
			return element;
		}
	//9.to find element by name
		public WebElement elementByName(String nameAtrributeValue) {
			WebElement element = driver.findElement(By.name(nameAtrributeValue));
			return element;
		}
	//10.to find element by classname
			public WebElement elementByClassName(String classNameAtrributeValue) {
				WebElement element = driver.findElement(By.name(classNameAtrributeValue));
				return element;
			}
	//11.to find element by name
			public WebElement elementByXpath(String xpath) {
				WebElement element = driver.findElement(By.xpath(xpath));
				return element;
			}
	//12.to get text from webpage
			public String elementText(WebElement element) {
				String text = element.getText();
				return text;	
			}
	//13.to click
			public void elementClick(WebElement element) {
				element.click();
			}
	//14.to send data by JS(value)
			public void elementSendDataJs(String data,WebElement element) {
				JavascriptExecutor executor=(JavascriptExecutor) driver;
				executor.executeScript("arguments[0].setAttribute('value','"+data+"')",element);
			}
	//15.to send data by JS(other than value)
			public void elementSendDataJs(String attributename,String data,WebElement element) {
				JavascriptExecutor executor=(JavascriptExecutor) driver;
				executor.executeScript("arguments[0].setAttribute('"+attributename+"','"+data+"')",element);
			}
	//16.to send data by JS
			public void elementclickJs(WebElement element) {
				JavascriptExecutor executor=(JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click()",element);
			}
	//17.to get inserted data by JS
			public Object elementGetDataJs(WebElement element) {
				JavascriptExecutor executor=(JavascriptExecutor) driver;
				Object attributeValue = executor.executeScript("arguments[0].getAttribute('value')",element);
				return attributeValue;
			}
	//18.to get inserted data(value)
			public String elementGetData(WebElement element) {
				String attributeValue = element.getAttribute("value");
				return attributeValue;
			}
	//19.to get inserted data(other than value)
			public String elementGetData(WebElement element,String attritubeName) {
				String attributeValue = element.getAttribute(attritubeName);
				return attributeValue;
			}
	//20.move to element
			
			public void moveToElement(WebElement element) {
				Actions actions=new Actions(driver);
				
				actions.moveToElement(element).perform();	
			}
	//21.drag and drop
			public void dragAndDrop(WebElement source,WebElement destination) {
				Actions actions=new Actions(driver);
				actions.dragAndDrop(source, destination).perform();
			}
	//22.contextclick
			public void contextClickAction(WebElement element) {
				Actions actions=new Actions(driver);
				actions.contextClick(element).perform();
			}	
	//23.to eneter data in caps
			public void sendDataInCaps(WebElement element,String data) {
				Actions actions=new Actions(driver);
				actions.keyDown(Keys.SHIFT).sendKeys(element, data).keyUp(Keys.SHIFT).perform();				
			}
	//24.double click
			public void elementDoubleClick(WebElement element) {
				Actions actions=new Actions(driver);
				actions.doubleClick(element);
			}
	//25.to accept alert
			public void acceptAlert() {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
	//26.to cancel alert
			public void cancelAlert() {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
			}
	//27.to senddata to alert and click ok
			public void sendDataToAlert(String data) {
				Alert alert = driver.switchTo().alert();
				alert.sendKeys(data);
				alert.accept();
			}
	//28.element scrolldown by JS
			public void elementScrollDownJs(WebElement element) {
				JavascriptExecutor executor=(JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(true)",element);
			}
	//29.element scrollUp by JS
			public void elementScrollUpJs(WebElement element) {
				JavascriptExecutor executor=(JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(false)",element);
			}
	//30.take screenshot
			public void screenshot(File destination) throws IOException {
				TakesScreenshot screenshot=(TakesScreenshot) driver;
				File source = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, destination);
			}
	//31.take elementscreenshot
			public void screenshot(WebElement element,File destination) throws IOException {
				File source = element.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, destination);
				
			}
	//32.to navigate to webpage
			public void navigateToWebPageBynavigate(String url) throws MalformedURLException {
				URL weburl=new URL(url);
				driver.navigate().to(weburl);	
			}
	//33.navigate to backward
			public void backward() {
				driver.navigate().back();
			}
	//34.navigate to forward
			public void forward() {
				driver.navigate().forward();
			}
	//35.switch to frame by id
			public void frameId(String frameid)
			{
				driver.switchTo().frame(frameid);
			}
	//36.switch to frame by name
			public void frameName(String frameName) {
				driver.switchTo().frame(frameName);
			}
	//37.switch to frame by index
			public void frameIndex(int index) {
				driver.switchTo().frame(index);
			}
	//38. switch to outside of frame
			public void frameOutside() {
				driver.switchTo().defaultContent();
			}
	//39.switch to parent frame
			public void parentFrame() {
				driver.switchTo().parentFrame();
			}
	//40.select from dropdown by text(selectByVisibleText)
			public void optionSelectByText(WebElement element,String text) {
				Select select =new Select(element);
				select.selectByVisibleText(text);
			}
	//41.select from dropdowndown by value
			public void optionSelectByValue(WebElement element,String value) {
				Select select=new Select(element);
				select.selectByValue(value);
			}
	//42.select from dropdown by index
			public void optionSelectByIndex(WebElement element,int index) {
				Select select =new Select(element);
				select.selectByIndex(index);
			}
	//43.get all options from dropdown
			public List<WebElement> allOptionINDropDown(WebElement element){
				Select select=new Select(element);
				List<WebElement> options = select.getOptions();
				return options;
			}
	//44.to get all selected option
			public List<WebElement> allSelectedOption(WebElement element){
				Select select=new Select(element);
				List<WebElement> selectedOption=select.getAllSelectedOptions();
				return selectedOption;
			}
	//45.Dropdown is multiple
			public boolean dropDownIsMultiple(WebElement element) {
				Select select=new Select(element);
				boolean isMultiple = select.isMultiple();	
				return isMultiple;
			}
	//46.deselect by index in dropdown
			public void deSelectdropAndDownByIndex(WebElement element,int index) {
				Select select=new Select(element);
				select.deselectByIndex(index);
			}
	//47.deselect by value in dropdown
			public void deSelectdropAndDownByValue(WebElement element,String value) {
				Select select=new Select(element);
				select.deselectByValue(value);
			}
	//48.deselect by text in dropdown
			public void deSelectdropAndDownByText(WebElement element,String text) {
				Select select=new Select(element);
				select.deselectByVisibleText(text);
			}
	//49.deselect alloption
			public void deSelectAllOption(WebElement element) {
				Select select=new Select(element);
				select.deselectAll();
			}
	//50.switch to child window
			public void switchToChildWindow() {
				String prtwin = driver.getWindowHandle();
				Set<String> allwin = driver.getWindowHandles();
				for(String win:allwin) {
				if(!(win.equals(prtwin))) {
					driver.switchTo().window(win);
				}}}
	//51.implicit wait
			public void implicitWait(int seconds) {
				driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
			}
	//52.to read data from excel
			public String getdataFromExcel(String sheetname,int rowIndex,int cellIndex) throws IOException{
				String res=null;
		File file=new File("C:\\Users\\user\\eclipse-workspace\\OMRDetails1\\libexcel\\hotel.xlsx");
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
								SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyy");
								String date = dateformat.format(dateCellValue);	
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
						return res;}
			//53.to update existing data in Excel
			public void upadateData(String sheetname,int rowIndex,int cellIndex,String oldData,String newData) throws IOException {
				File file=new File("D:\\deva pro and details\\devait\\practice\\MavenProject\\Excel file\\testdata.xlsx");
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
		//54.to write data in empty cell in Excel
			public void writeData(String sheetname,int rowIndex,int cellIndex,String data) throws IOException {
				File file=new File("C:\\Users\\user\\eclipse-workspace\\OMRDetails1\\libexcel\\hotel.xlsx");
				FileInputStream inStream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(inStream);
				Sheet sheet=workbook.getSheet(sheetname);
					Row row = sheet.getRow(rowIndex);
					Cell cell = row.createCell(cellIndex);
					cell.setCellValue(data);
					FileOutputStream out=new FileOutputStream(file);
					workbook.write(out);}
		//55.to findelements for webtable
			public List<WebElement> findAllElementsByTag(String tagName){
				List<WebElement> elements = driver.findElements(By.tagName(tagName));
				return elements;
			}
		//56.find element by tagname
			public WebElement elementByTag(String tagName) {
				WebElement element = driver.findElement(By.tagName(tagName));
				return element;
			}
		//57.to press downkey
			public void pressDownKey() throws AWTException {
				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);		
			}
		//58.to press enterkey
			public void pressEnterKey() throws AWTException{
				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);	
			}
		//59.to create workbook
			public void createWorkbook(File file,String sheetname) throws IOException {
				Workbook workbook=new XSSFWorkbook();
				workbook.createSheet(sheetname);
				FileOutputStream out=new FileOutputStream(file);
				workbook.write(out);
			}
		//60.to get all table data
			public List<WebElement> tableDataFromWebtable(String rowTagName,String tableDataTagName){
				List<WebElement> rowElements = driver.findElements(By.tagName(rowTagName));
				List<WebElement> tableData = null;
				for(int i=0;i<rowElements.size();i++) {
					WebElement column= rowElements.get(i);
					tableData = column.findElements(By.tagName(tableDataTagName));	
				}
				return tableData;
			}
		//61.to clear data
			public void clearData(WebElement element) {
				element.clear();
			}
			//62.Window maximize
			public void windowMaximize() {
		    	   driver.manage().window().maximize();
		       }
			//63.SendKeys
			public void Sendkeys(WebElement element,String text) {
		    	   element.sendKeys(text);
			}
			//64.Implicity Wait
			public void ImplicityWait() {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}
			
			}
				
			
			
			
			
			
			
			
			
			
			
			
			
			
