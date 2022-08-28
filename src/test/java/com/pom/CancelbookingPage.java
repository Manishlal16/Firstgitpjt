package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelbookingPage extends BaseClass1 {
	public CancelbookingPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="ids[]")
	private WebElement clkradiobtn;
	
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement clkcancelbtn;
	
	@FindBy(id="search_result_error")
	private WebElement txtcancelled;

	public WebElement getClkradiobtn() {
		return clkradiobtn;
	}

	public WebElement getClkcancelbtn() {
		return clkcancelbtn;
	}
	
     
	public WebElement getTxtcancelled() {
		return txtcancelled;
	}

	public void CancelBooking() {
		
		elementClick(getClkradiobtn());
		elementClick(getClkcancelbtn());
		acceptAlert();
		
	}
}
