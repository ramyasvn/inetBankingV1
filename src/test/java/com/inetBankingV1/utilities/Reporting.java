package com.inetBankingV1.utilities;

//This is listener class using which reports are generated

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void OnStart(ITestContext testcontext) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+ timestamp + ".html";
		htmlreporter= new ExtentHtmlReporter(System.getProperty("user-dir")+"/test-output/"+repName);
		htmlreporter.loadXMLConfig(System.getProperty("user-dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "ramya");
		
		htmlreporter.config().setDocumentTitle("InetBanking Test Report");
		htmlreporter.config().setReportName("Functional Test Report");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.DARK);
	}
	
	public void OnTestSuccess(TestResult tr) {
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void OnTestFailure(TestResult tr) {
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotpath=System.getProperty("user-dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(screenshotpath);
		
		if(f.exists()) {
			try {
				logger.fail("Screenshot is Below"+logger.addScreenCaptureFromPath(screenshotpath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
    public void OnTestSkip(TestResult tr) {
    	
    	logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
		
	}
    
    public void OnFinish(ITestContext testcontext) {
    	extent.flush();
    }
    
    

}
