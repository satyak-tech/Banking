package com.banking.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageobjects.Loginpage;
import com.banking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends Baseclass {
    
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws Exception
	{
		Loginpage lp=new Loginpage(driver);
		lp.setusername(user);
		lp.setpassword(pwd);
		lp.clicksubmit();
		
	Thread.sleep(3000);
		
		if(isAlertPresent1()==true)
		{
			driver.switchTo().alert().accept();  //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent1()
	{
		try
		{
			driver.switchTo().alert();
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/banking/testdata/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]= new String[rownum][colcount];
		
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<colcount;j++) 
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
