package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAHotelPage1 extends BaseClass1{
	
	public BookAHotelPage1() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtbookhotel;
	
	@FindBy(id="first_name")
	private WebElement txtfirstname;
	
	@FindBy(id="last_name")
	private WebElement txtlastname;
	
	@FindBy(id="address")
	private WebElement txtaddress;
	
	@FindBy(id="cc_num")
	private WebElement txtccno;
	
	@FindBy(id="cc_type")
	private WebElement txtcctype;
	
	@FindBy(id="cc_exp_month")
	private WebElement clkexpmonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement clkexpyr;
	
	@FindBy(id="cc_cvv")
	private WebElement txtcvvno;
	
	@FindBy(id="book_now")
	private WebElement btnbooknow;
	
	
	
	public WebElement getTxtbookhotel() {
		return txtbookhotel;
	}

	public WebElement getTxtfirstname() {
		return txtfirstname;
	}

	public WebElement getTxtlastname() {
		return txtlastname;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getTxtccno() {
		return txtccno;
	}

	public WebElement getTxtcctype() {
		return txtcctype;
	}

	public WebElement getClkexpmonth() {
		return clkexpmonth;
	}

	public WebElement getClkexpyr() {
		return clkexpyr;
	}

	public WebElement getTxtcvvno() {
		return txtcvvno;
	}

	public WebElement getBtnbooknow() {
		return btnbooknow;
	}

	public void BookAhotel(String firstname,String lastname,String address,String ccno,String cctype,
		String month, String yr ,String cvvno) {
		
		elementSendData(getTxtfirstname(),firstname);
		elementSendData(getTxtlastname(),lastname);
		elementSendData(getTxtaddress(),address);
		elementSendData(getTxtccno(),ccno);
		elementSendData(getTxtcctype(),cctype);
		elementSendData(getClkexpmonth(),month);
		elementSendData(getClkexpyr(),yr);
		elementSendData(getTxtcvvno(),cvvno);
		elementClick(getBtnbooknow());
		}

}
