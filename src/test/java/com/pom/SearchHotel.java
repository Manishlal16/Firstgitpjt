package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass1 {
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username_show")
	private WebElement txtname;
	
	@FindBy(id="location")
	private WebElement txtlocation;
	
	@FindBy(id="hotels")
	private WebElement txthotels;
	
	@FindBy(id="room_type")
	private WebElement txtroomtype;
	
	@FindBy(id="room_nos")
	private WebElement txtnoofrooms;
	
	//@FindBy(id="datepick_in")
	//private WebElement txtcheckindate;
	
	//@FindBy(id="datepick_out")
	//private WebElement txtcheckoutdate;
	
	@FindBy(id="adult_room")
	private WebElement txtadultroom;
	
	@FindBy(id="child_room")
	private WebElement txtchildroom;
	
	@FindBy(id="Submit")
	private WebElement btnsubmit;
	
	

	public WebElement getTxtname() {
		return txtname;
	}

	public WebElement getBtnsubmit() {
		return btnsubmit;
	}

	public WebElement getTxtlocation() {
		return txtlocation;
	}

	public WebElement getTxthotels() {
		return txthotels;
	}

	public WebElement getTxtroomtype() {
		return txtroomtype;
	}

	public WebElement getTxtnoofrooms() {
		return txtnoofrooms;
	}

	//public WebElement getTxtcheckindate() {
		//return txtcheckindate;
	//}

	//public WebElement getTxtcheckoutdate() {
	//	return txtcheckoutdate;
	//}

	public WebElement getTxtadultroom() {
		return txtadultroom;
	}

	public WebElement getTxtchildroom() {
		return txtchildroom;
	}

	public WebElement getTxtsubmit() {
		return btnsubmit;
	}
	
	public void searchoptions(String location,String hotels,String roomtype,String noofrooms,String adultroom, String childroom ) {
		
		optionSelectByText(getTxtlocation(),location);
		optionSelectByText(getTxthotels(),hotels);
		optionSelectByText(getTxtroomtype(),roomtype);
		optionSelectByText(getTxtnoofrooms(),noofrooms);
		//optionSelectByText(getTxtcheckindate(),checkindate);
		//optionSelectByText(getTxtcheckoutdate(),checkoutdate);
		optionSelectByText(getTxtadultroom(),adultroom);
		optionSelectByText(getTxtchildroom(),childroom);
		elementClick(getTxtsubmit());
	
		
	}
	}
