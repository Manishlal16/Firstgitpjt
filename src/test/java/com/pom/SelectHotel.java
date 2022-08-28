package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClass1 {
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement txtselect;
	
	@FindBy(id="radiobutton_0")
	private WebElement clkradiobtn;
	
	@FindBy(id="continue")
	private WebElement clkcontinue;
	
	

	public WebElement getTxtselect() {
		return txtselect;
	}

	public WebElement getClkradiobtn() {
		return clkradiobtn;
	}

	public WebElement getClkcontinue() {
		return clkcontinue;
	}
	
	public void hotelselect() {
		elementClick(getClkradiobtn());
		elementClick(getClkcontinue());
		
		
	}

}
