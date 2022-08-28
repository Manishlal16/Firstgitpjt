package com.pom;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Junit extends BaseClass1 {
	@BeforeClass
	public static void beforeclass() {
		
		WebDriver driver;
		launchChromeBrowser();
		launchurl("https://adactinhotelapp.com/");
		windowMaximize();
	}
	
	@AfterClass
	public static void afterclass() {
		//quitBrowser();
		}
	@Test
	public void BookHotel() throws IOException {
		ImplicityWait();
		
		
		
		Loginpage1 loginpage = new Loginpage1();
		loginpage.login(getdataFromExcel("Adactin", 1, 0),getdataFromExcel("Adactin", 1, 1));
		
		SearchHotel searchhotel = new SearchHotel();
		WebElement txtwlcmmsg = searchhotel.getTxtname();
		String attribute = getAttribute(txtwlcmmsg);
		Assert.assertEquals("verify after login welcome msg is present","Hello Manishlal!",attribute);
		searchhotel.searchoptions(getdataFromExcel("Adactin", 1, 2),getdataFromExcel("Adactin", 1, 3),getdataFromExcel("Adactin", 1, 4),
				getdataFromExcel("Adactin", 1, 5),getdataFromExcel("Adactin", 1, 8),
			    getdataFromExcel("Adactin", 1, 9));
		
		SelectHotel selecthotel = new SelectHotel();
		WebElement txtselect = selecthotel.getTxtselect();
		String elementText = elementText(txtselect);
		Assert.assertEquals("verify after search hotel", "Select Hotel",elementText);
		selecthotel.hotelselect();
		
		BookAHotelPage1 bookahotel = new BookAHotelPage1();
		WebElement txtbook= bookahotel.getTxtbookhotel();
		String element2text = elementText(txtbook);
		Assert.assertEquals("verify after Book a hotel", "Book A Hotel",element2text);
	
		
		bookahotel.BookAhotel(getdataFromExcel("Adactin", 1, 10),getdataFromExcel("Adactin", 1, 11),getdataFromExcel("Adactin", 1, 12)
				,getdataFromExcel("Adactin", 1, 13),getdataFromExcel("Adactin", 1, 14),getdataFromExcel("Adactin", 1, 15),getdataFromExcel("Adactin", 1, 16),getdataFromExcel("Adactin", 1, 17));
		
		
		BookingConformationPage bookingconfirmation = new BookingConformationPage();
		WebElement txtconform= bookingconfirmation.getTxtconform();
		String element3text = elementText(txtconform);
		Assert.assertEquals("verify after Book a conorm", "Booking Confirmation",element3text);
		bookingconfirmation.BookingConfirmation();
		
		
		BookedItineraryPage bookeditinery = new BookedItineraryPage();
		bookeditinery.BookedItinerary(getdataFromExcel("Adactin", 1, 18));
		
		CancelbookingPage cancelthepage = new CancelbookingPage();
		cancelthepage.CancelBooking();
		WebElement txtcanc= cancelthepage.getTxtcancelled();
		String element4text = elementText(txtcanc);
		Assert.assertEquals("verify after cancelled", "The booking has been cancelled.",element4text);
		
		
		
		
		
		
		
		
		}
	}
