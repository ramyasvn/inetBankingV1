package com.inetBankingV1.testCases;




import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	
	public String baseUrl= readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
				
	    logger= Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
			}
		else if(br.equals("MSEdge")) {
			System.setProperty("webdriver.microsoftedge.driver", readconfig.getMSEdgePath());
			driver=new InternetExplorerDriver();
			}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void CaptureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		File target=new File(System.getProperty("user-dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot is taken");
	}
	
	public String randomStr() {
		
		String generatedStr=RandomStringUtils.randomAlphabetic(8);
		return generatedStr;
		
	}
	
	public String randomNumber() {
		
		String generatedNo=RandomStringUtils.randomNumeric(4);
		return generatedNo;
		
	}

}
