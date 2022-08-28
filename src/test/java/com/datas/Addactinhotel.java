package com.datas;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Addactinhotel extends BaseClass1{
	public static void main(String[] args) throws IOException {
		Addactinhotel addactinhotel = new Addactinhotel();
		addactinhotel.bookHotel();
		
	}

	public void bookHotel() throws IOException {
		launchChromeBrowser();
		launchurl("https://adactinhotelapp.com/");
		windowMaximize();
		ImplicityWait();
		WebElement txtuserName = elementByXpath("//input[@id='username']");
		String name = getdataFromExcel("hoteldetails", 1, 0);
		Sendkeys(txtuserName, name);
		
		WebElement txtpassword = elementById("password");
		String pass = getdataFromExcel("hoteldetails", 1, 1);
		Sendkeys(txtpassword, pass);
		
		WebElement btnlogin = elementById("login");
		elementClick(btnlogin);
		
		WebElement selectloc = elementById("location");
		optionSelectByValue(selectloc,"London");
		
		WebElement selecthotel = elementById("hotels");
		optionSelectByValue(selecthotel,"Hotel Sunshine");
		
		WebElement Roomtype = elementById("room_type");
		optionSelectByValue(Roomtype,"Standard");
		
		WebElement numofrooms = elementById("room_nos");
		optionSelectByValue(numofrooms,"2");
		
		WebElement Adultsper= elementById("adult_room");
		optionSelectByValue(Adultsper,"1");
		
		WebElement childperroom= elementById("child_room");
		optionSelectByValue(childperroom,"0");
		
		WebElement btnsearch = elementById("Submit");
		elementClick(btnsearch);
		
		WebElement radiobtn = elementById("radiobutton_0");
		elementClick(radiobtn);
		
		WebElement btncontinue = elementById("continue");
		elementClick(btncontinue);
		
		WebElement txtfirstname = elementById("first_name");
		String firname= getdataFromExcel("hoteldetails", 1, 2);
		Sendkeys(txtfirstname, firname);
		
		WebElement txtlastname = elementById("last_name");
		String lastname= getdataFromExcel("hoteldetails", 1, 3);
		Sendkeys(txtlastname, lastname);
		
		WebElement txtaddress = elementById("address");
		String address= getdataFromExcel("hoteldetails", 1, 4);
		Sendkeys(txtaddress, address);
		
		WebElement txtcreditno = elementById("cc_num");
		String cardno= getdataFromExcel("hoteldetails", 1, 5);
		Sendkeys(txtcreditno, cardno);
		
		WebElement txtcardtype = elementById("cc_type");
		String cardtype= getdataFromExcel("hoteldetails", 1, 6);
		Sendkeys(txtcardtype, cardtype);
		
		WebElement cardtype1= elementById("cc_type");
		optionSelectByValue(cardtype1,"VISA");
		
		WebElement selmonth= elementById("cc_exp_month");
		optionSelectByValue(selmonth,"8");
		
		WebElement selyr= elementById("cc_exp_year");
		optionSelectByValue(selyr,"2022");
		
		WebElement txtcvvno = elementById("cc_cvv");
		String cvvno= getdataFromExcel("hoteldetails", 1, 7);
		Sendkeys(txtcvvno, cvvno);
		
		WebElement booknow = elementById("book_now");
		elementClick(booknow);
		
		WebElement txtId = elementById("order_no");
		String attribute = elementGetData(txtId);
		writeData("hoteldetails",1,8,attribute);
	}

}
