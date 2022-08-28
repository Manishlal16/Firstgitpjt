package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage1 extends BaseClass1 {
	public Loginpage1() {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="username")
	private WebElement txtuserName;
	
	@FindBy(id="password")
	private WebElement txtpassword;
	
	@FindBy(id="login")
	private WebElement btnlogin;

	public WebElement getTxtuserName() {
		return txtuserName;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}
	
	public void login(String userName,String Password) {
		elementSendData(getTxtuserName(),userName);
		elementSendData(getTxtpassword(),Password);
		elementClick(getBtnlogin());
		 }

}
