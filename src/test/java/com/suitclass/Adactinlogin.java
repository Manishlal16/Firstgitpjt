package com.suitclass;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adactinlogin {
	static WebDriver driver;
	@BeforeClass
	public static void beforeclass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
        driver.manage().window().maximize();
	}
	@Before
	public void beforemethod() {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);

	}
	@Test
	public void login() {
		WebElement txtusername = driver.findElement(By.id("username"));
		txtusername.sendKeys("Greens8767");
		String name = txtusername.getAttribute("value");
		Assert.assertEquals("Verify the username", "Greens8767", name);
		
		WebElement txtpassword = driver.findElement(By.id("password"));		
		txtpassword.sendKeys("QN8V3A");
		String password = txtpassword.getAttribute("value");
		Assert.assertEquals("Verify the password ", "QN8V3A", password);
		
		WebElement btnlogin = driver.findElement(By.id("login"));
		btnlogin.click();
		//String login = btnlogin.getAttribute("value");
		//Assert.assertTrue("verify the login",login);
		}

}
