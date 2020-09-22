package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver ldriver;

	public Loginpage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	WebElement txtusername;

	@FindBy(name = "password")
	WebElement txtpassword;

	@FindBy(name = "btnLogin")
	WebElement btnlogin;
	
	@FindBy(xpath= "//a[contains(text(),'Log out')]")
	WebElement logoutbutton;


	public void setusername(String uname) {
		txtusername.sendKeys(uname);
	}

	public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void clicksubmit() {
		btnlogin.click();
	}
	
	public void clicklogout()
	{
		logoutbutton.click();
	}
}
