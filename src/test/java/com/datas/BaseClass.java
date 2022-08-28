package com.datas;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
       WebDriver driver;
       public void getDriver() {
    	   WebDriverManager.chromedriver().setup();
    	   driver = new ChromeDriver();
       }
       public void enterurl(String url) {
    	   driver.get(url);
       }
       public void windowMaximize() {
    	   driver.manage().window().maximize();
       }
       public String LaunchUrl(String url) {
    	   driver.navigate().to(url);
		return url;
       }
       public void closetheCurentBrowser() {
    	   driver.quit();
       }
       public void closeAllBrowser() {
    	   driver.close();
       }
       public void MoveBackword() {
    	   driver.navigate().back();
       }
       public void MoveForward() {
    	   driver.navigate().forward();
       }
       public void pageRefresh() {
    	   driver.navigate().refresh();
       }
       
       public void elementSendkeys(WebElement element,String data) {
    	   element.sendKeys(data);
       }
       public void elementSendkeysJs(WebElement element,String data) {
    	   JavascriptExecutor executor = (JavascriptExecutor)driver;
    	   executor.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
       }
       public String getApplicationTitle() {
    	   String title = driver.getTitle();
		return title;
       }
       public WebElement elementFindById(String attributevalue) {
    	   WebElement element = driver.findElement(By.id(attributevalue));
		return element;
       }
       public WebElement elementFindByName(String attributevalue) {
    	   WebElement element = driver.findElement(By.name(attributevalue));
		return element;
    	}
       public WebElement elementFindByClassName(String attributevalue) {
    	   WebElement element = driver.findElement(By.className(attributevalue));
		return element;
    	}
       public WebElement elementFindByXpath(String Xpath) {
    	   WebElement element = driver.findElement(By.xpath(Xpath));
		return element;
    	}
       public void elementClick(WebElement element) {
    	   element.click();
       }
       public String elementAttributeValue(WebElement element) {
    	   String attribute = element.getAttribute("value");
		return attribute;
       }
       public String elementAttributeValue(WebElement element,String AttributeName) {
    	   String attribute = element.getAttribute(AttributeName);
		return attribute;
    	}
       public void SelectOptionByText(WebElement element,String text) {
    	   Select select = new Select(element);
    	   select.selectByVisibleText(text);
       }
       public void SelectOptionByAttribute(WebElement element,int index) {
    	   Select select = new Select(element);
    	   select.selectByIndex(index);
       }
       public void MouseoverAction(WebElement element) {
    	   Actions actions = new Actions(driver);
    	   actions.moveToElement(element).perform();
       }
       public void ConTextClick(WebElement element) {
    	   Actions actions = new Actions(driver);
    	   actions.contextClick(element).perform();
       }
       public void DragandDrop(WebElement element1,WebElement element2) {
    	   Actions actions = new Actions(driver);
    	   actions.dragAndDrop(element1,element2).perform();
    	   }
       public void DoubleClick(WebElement element) {
    	   Actions actions = new Actions(driver);
    	   actions.doubleClick(element).perform();
    	   }
       public void Accept() {
    	   Alert alert = driver.switchTo().alert();
    	   alert.accept();
       }
       public void TakeScreenshot() {
    	   TakesScreenshot ts = (TakesScreenshot)driver;
    	   File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
       }
       public void GetAlloptions(WebElement element) {
    	   Select select = new Select(element);
    	   List<WebElement> options = select.getOptions();
       }
       public void Getcount(WebElement element) {
    	   Select select = new Select(element);
    	   List<WebElement> options = select.getOptions();
    	   options.size();
       }
       public void FirstselectedOption(WebElement element) {
    	   Select select = new Select(element);
    	   WebElement firstSelectedOption = select.getFirstSelectedOption();
    	   String attribute = firstSelectedOption.getAttribute("value");
       }
       public void GetAllSelectedOptions(WebElement element) {
    	   Select select = new Select(element);
    	   List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
       }
       public void DeselectedByValue(WebElement element) {
    	   Select select = new Select(element);
    	   select.deselectByValue("value");
       }
       public void DeselectedByVisibleText(WebElement element,String text) {
    	   Select select = new Select(element);
    	   select.deselectByVisibleText(text);
       }
       public void DeselectedByIndex(WebElement element,int index) {
    	   Select select = new Select(element);
    	   select.deselectByIndex(index);
       }
       public void IsMultiple(WebElement element) {
    	   Select select = new Select(element);
    	   select.isMultiple();
       }
       public void GetWindowHandle() {
    	   String windowHandle = driver.getWindowHandle();
       }
       public void GetAllWindows() {
    	   Set<String> allwindows = driver.getWindowHandles();
       }
       public void FindTableRow(WebElement element,String tr ) {
    	   WebElement findElement = driver.findElement(By.tagName("tr"));
    	   
       }
       public void Sendkeys(WebElement element,String text) {
    	   element.sendKeys(text);
       }
       
    
       
       
       
       
        
       
       
       
}
