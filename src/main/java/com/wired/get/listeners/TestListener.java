package com.wired.get.listeners;

import java.io.File;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.wired.get.utils.GlobalVariables;
import com.wired.get.utils.Utils;


/**
 * @author Alhad.Pingle
 * This class governs the actions to be performed on start and at finish of the test execution 
 *
 */
public class TestListener implements ITestListener, ISuiteListener {

	Utils oUtils = new Utils(); 

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		GlobalVariables.extentReportsAndroid.flush();

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

		GlobalVariables.suiteName = System.getProperty("suiteName");

		//Create results folders
		GlobalVariables.resultsFolder = oUtils.getResultFolder();

		String screenshotFolderName = GlobalVariables.resultsFolder+"\\screenshots\\";
		new File(screenshotFolderName).mkdir();
		GlobalVariables.screenshotsFolder = screenshotFolderName;

		GlobalVariables.resultString = new StringBuilder("");
		
		
		File file = new File(".//Reports//");
		if(!file.exists())
		{
			file.mkdirs();
		}

		if(GlobalVariables.platform.equalsIgnoreCase("Android"))
		{
			GlobalVariables.extentHtmlReporterAndroid = new ExtentHtmlReporter(".//Reports//Reports_Android.html");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GlobalVariables.extentReportsAndroid = new ExtentReports();	
			
			GlobalVariables.extentReportsAndroid.attachReporter(GlobalVariables.extentHtmlReporterAndroid);
			GlobalVariables.extentHtmlReporterAndroid.config().setDocumentTitle("WIRED automation test");
			GlobalVariables.extentHtmlReporterAndroid.config().setReportName("WIRED Android Report");
			GlobalVariables.extentHtmlReporterAndroid.config().setTestViewChartLocation(ChartLocation.TOP);
			GlobalVariables.extentHtmlReporterAndroid.config().setTheme(Theme.STANDARD);
		}
		else
		{
			GlobalVariables.extentHtmlReporterIOS = new ExtentHtmlReporter(".//Reports//Reports_iOS.html");
			GlobalVariables.extentReportsIOS = new ExtentReports();		
			GlobalVariables.extentReportsIOS.attachReporter(GlobalVariables.extentHtmlReporterIOS);
			GlobalVariables.extentHtmlReporterIOS.config().setDocumentTitle("WIRED automation test");
			GlobalVariables.extentHtmlReporterIOS.config().setReportName("WIRED iOS Report");
			GlobalVariables.extentHtmlReporterIOS.config().setTestViewChartLocation(ChartLocation.TOP);
			GlobalVariables.extentHtmlReporterIOS.config().setTheme(Theme.STANDARD);
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub


	}

}
