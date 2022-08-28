package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedItineraryPage extends BaseClass1{
	public BookedItineraryPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_id_text")
	private WebElement txtorderid;
	
	@FindBy(id="search_hotel_id")
	private WebElement btnclk;

	public WebElement getTxtorderid() {
		return txtorderid;
	}

	public WebElement getBtnclk() {
		return btnclk;
	}
	
	public void BookedItinerary(String orderid) {
		elementSendData(getTxtorderid(),orderid);
		elementClick(getBtnclk());
		

	}
	
	

}
