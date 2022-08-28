package com.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aditinhotel {
	static WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
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
		driver.findElement(By.id("username")).sendKeys("Manish");
		driver.findElement(By.id("password")).sendKeys("manish@123");
		driver.findElement(By.id("login")).click();
	}
	@After
	public void aftermethod() {
		long timeMillis = System.currentTimeMillis();
		System.out.println(timeMillis);

	}
	@AfterClass
	public static void afterclass() {
		driver.quit();

	}
	
	
	
	
	
	
}
