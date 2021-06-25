package com.wired.get.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverInitializer{

	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static AndroidDriver<AndroidElement> androidDiver;
	public static IOSDriver<IOSElement> iOSDriver;

	/**
	 * Description : This function would set the capabilities for Android
	 * @return
	 */
	public static AndroidDriver<AndroidElement> getAndroidDriver() 
	{

		File source = new File("src/test/resources");
		File app = new File(source, "Apps/Get WIRED_v1.3.2_apkpure.com.apk");
		File chromeDrivers = new File(source, "BrowserDrivers/Chrome/");
		File chromeMapping = new File(source, "BrowserMapping/Chrome/map.json");

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability("chromedriverExecutableDir", chromeDrivers.getAbsolutePath());
		capabilities.setCapability("chromedriverChromeMappingFile", chromeMapping.getAbsolutePath());
//		capabilities.setCapability("enableWebviewDetailsCollection", true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

		try {
			URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
			androidDiver = new AndroidDriver<AndroidElement>(serverUrl, capabilities);
			androidDiver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return androidDiver;
	}

	/**
	 * Description : This function would set the capabilities for iOS
	 * @return
	 */
	public static IOSDriver<IOSElement> getiOSDriver() 
	{
		capabilities.setCapability("platformName", "");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability("deviceName", "");
		capabilities.setCapability("udid","");
		capabilities.setCapability("AutomationName","");
		capabilities.setCapability("xcodeOrgId","");
		capabilities.setCapability("xcodeSigningId","");
		capabilities.setCapability("bundleId", "");
		try {
			URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
			iOSDriver = new IOSDriver<IOSElement>(serverUrl, capabilities);
			iOSDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return iOSDriver;
	}
}

