package com.inetBankingV1.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.HomePage;
import com.inetBankingV1.pageObjects.LoginPage;
import com.inetBankingV1.pageObjects.NewCustomerPage;

public class TC_AddCustomerTest_003  extends BaseClass{
	
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp= new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		NewCustomerPage ncp= new NewCustomerPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(5000);
		
		hp.clickNewCustmer();
		
		ncp.setCustomerName("John Black");
		ncp.custGender();
		
		ncp.custAddress("600 Cedar Street");
		ncp.custDOB("10", "80", "17");
		ncp.custCity("Chicago");
		ncp.custPinCode(01234);
		ncp.custState("IL");
		ncp.custPhone("156265709");
		ncp.custEmailID(randomStr()+"@gmail.com");
		ncp.custPassword("password");
		ncp.clickSubmit();
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully");
		
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Add NewCustomer Test Passed");
		}
		else {
			Assert.assertTrue(false);
			CaptureScreenshot(driver, "AddNewCustomer");
			logger.warn("Test case Failed");
		}
		
	}
	
	

}
