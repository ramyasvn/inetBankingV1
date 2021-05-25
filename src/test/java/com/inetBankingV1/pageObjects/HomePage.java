package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver rdriver) {
		
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(linkText="Log out")
	@CacheLookup
	WebElement lnklogout;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkNewCustomer;
	
	public void clickLogout() {
		lnklogout.click();
	}
	
	public void clickNewCustmer() {
		lnkNewCustomer.click();
	}

}
