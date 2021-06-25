package com.wired.get.utils;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GlobalVariables {
	public static String resultsFolder;
	public static String screenshotsFolder;
	public static StringBuilder resultString;
	public static String platform=System.getProperty("platform");
	public static String suiteName=System.getProperty("suiteName");
	public static String testName = null;
	public static WebDriver driver = null;
	public static ExtentHtmlReporter extentHtmlReporterAndroid;
	public static ExtentHtmlReporter extentHtmlReporterIOS;
	public static ExtentReports extentReportsAndroid;
	public static ExtentReports extentReportsIOS;
	public static ExtentTest extentTestAndroid;
	public static ExtentTest extentTestIOS;

}
