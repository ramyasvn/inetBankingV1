package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	
	WebDriver driver;
	
	public NewCustomerPage(WebDriver ldriver) {
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	WebElement radiobtnGender;
	
	@FindBy(how=How.NAME, using="dob")
	@CacheLookup
	WebElement txtDOB;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPinCode;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtPhone;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement txtEmailID;
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how=How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void setCustomerName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender() {
		radiobtnGender.click();
	}
	
	public void custDOB(String mm, String yy, String dd) {
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
	}
	
	public void custAddress(String addr) {
		txtAddress.sendKeys(addr);
	}
	
	public void custCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void custState(String cstate) {
		txtCity.sendKeys(cstate);
	}
	
	public void custPinCode(int pin) {
		txtPinCode.sendKeys(String.valueOf(pin));
	}
	
	public void custPhone(String phoneno) {
		txtPhone.sendKeys(phoneno);
	}
	
	
	public void custEmailID(String email) {
		txtEmailID.sendKeys(email);
	}
	
	public void custPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnSubmit.click();;
	}
	
	
	
}
