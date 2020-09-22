package com.banking.testcases;

import org.testng.annotations.Test;

import com.banking.pageobjects.Loginpage;

public class Tc_Logintest_001 extends Baseclass {

	@Test
	public void logintest() {

		
		Loginpage lp = new Loginpage(driver);
		lp.setusername(username);

		lp.setpassword(password);

		lp.clicksubmit();

	}
}
