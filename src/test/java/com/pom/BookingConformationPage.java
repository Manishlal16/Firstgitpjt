package com.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConformationPage extends BaseClass1{
	 public BookingConformationPage() {
		PageFactory.initElements(driver, this);
	}
	 
	 @FindBy(xpath="//td[text()='Booking Confirmation ']")
	 private WebElement txtconform;
	 
	 @FindBy(id="order_no")
	private WebElement copyorderno;
	 
	@FindBy(id="my_itinerary")
	private WebElement clkbookeditinerary;
	
	
	
	public WebElement getTxtconform() {
		return txtconform;
	}
	public WebElement getCopyorderno() {
		return copyorderno;
	}
	public WebElement getClkbookeditinerary() {
		return clkbookeditinerary;
	}

	public String BookingConfirmation() throws IOException {
		
		String attribute = getAttribute(getCopyorderno());
		writeData("Adactin", 1, 18,attribute);
		
		elementClick(getClkbookeditinerary());
		return attribute;

	}

	
	
	
	

}
