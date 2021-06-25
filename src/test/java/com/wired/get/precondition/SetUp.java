/**
 * 
 */
package com.wired.get.precondition;

import java.lang.reflect.Method;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.wired.get.android.pages.AboutPage;
import com.wired.get.android.pages.HomePage;
import com.wired.get.android.pages.SettingsPage;
import com.wired.get.utils.DriverInitializer;
import com.wired.get.utils.GlobalVariables;

/**
 * @author Alhad Pingle
 *
 */
public class SetUp {

	public HomePage homePage = null;
	public SettingsPage settingsPage = null;
	public AboutPage aboutPage = null;

	

	@BeforeMethod
	public void caseSetUp(Method method) throws InterruptedException {

		GlobalVariables.testName = method.getName();
		if(GlobalVariables.platform.equalsIgnoreCase("Android"))
		{
			GlobalVariables.driver = DriverInitializer.getAndroidDriver();
			homePage = new HomePage();
			settingsPage = new SettingsPage();
			aboutPage = new AboutPage();
		}
		else
		{
			GlobalVariables.driver = DriverInitializer.getiOSDriver();
		}
	}

	@AfterMethod
	public void afterMethod() {
		//		Cleaning up the previous test case results
		if (GlobalVariables.resultString.length() > 1) {
			GlobalVariables.resultString.delete(0, GlobalVariables.resultString.length());
		}
		GlobalVariables.driver.quit();
	}



}
