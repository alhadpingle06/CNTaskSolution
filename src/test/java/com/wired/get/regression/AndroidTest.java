/**
 * 
 */
package com.wired.get.regression;


import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wired.get.operations.AndroidUtility;
import com.wired.get.precondition.SetUp;
import com.wired.get.utils.GlobalVariables;
import com.wired.get.utils.Reporting;
import com.wired.get.utils.TestVerifications;
import com.wired.get.utils.Utils;

import io.appium.java_client.android.AndroidDriver;



/**
 * @author Alhad Pingle
 *
 */
public class AndroidTest extends SetUp{

@Test(testName = "AQA TC001 - Notification Pass Test", enabled = false)
public void notificationPassTest() {
	// TODO Auto-generated method stub
//	For test results reporting
	Reporter.log("Test Case Name - AQA TC001 - Notification Pass Test");
	GlobalVariables.extentTestAndroid = GlobalVariables.extentReportsAndroid.createTest("AQA TC001 - Notification Pass Test"); 
	
	String scriptVerificationID, scripVerificationName;
	
	boolean a = false;
	boolean b = false;
	boolean c = false;
	boolean d = false;
	boolean e = false;
	
	try {
		//	verify that the application is launched
		a = TestVerifications.verifyIsElementDisplayed(homePage.wiredLogo, "verify that the application is launched", "NPT001");
		
//	Go to settings
		AndroidUtility.tapElement(homePage.settingsMenu);
		
		Utils.staticWait(2000);
		
//	verify that Notifications switch is on
		b = TestVerifications.verifyDesiredWebElementAttribute(settingsPage.notificationSwitch, "NPT002", "verify that Notifications switch is on", "text", "ON");
		
//	verify notifications message
		c = TestVerifications.verifyElementTextOnPage("NPT003", "verify notifications message", settingsPage.notificationMessage, "You will receive alerts from WIRED");
		
//	Switch the notifications switch off
		AndroidUtility.tapElement(settingsPage.notificationSwitch);
		
		Utils.staticWait(3000);
		
//	Verify that notification switch is off
		d = TestVerifications.verifyDesiredWebElementAttribute(settingsPage.notificationSwitch, "NPT004", "verify that Notifications switch is off", "text", "OFF");

//	verify notification message
		e = TestVerifications.verifyElementTextOnPage("NPT005", "verify notifications message", settingsPage.notificationMessage, "You will not receive alerts from Wired.");
		
//	switch notification on
		AndroidUtility.tapElement(settingsPage.notificationSwitch);
		
		if (a && b && c && d && e) {

			Assert.assertTrue(true);
			
		} else {

			Assert.fail((GlobalVariables.resultString).toString());
			
		}
	} catch (Exception ex) {

		scriptVerificationID = GlobalVariables.testName;
		scripVerificationName = GlobalVariables.testName;

		String expectedResult = "No undesirable excepion should be thrown during script execution";
		String actualResult = ex.getMessage();

		Reporting.reportScriptFailure(scriptVerificationID, scripVerificationName, expectedResult, actualResult);
		Assert.fail((GlobalVariables.resultString).toString());
		
	}

}

@Test(testName = "AQA TC002 - Notification Fail Test", enabled = false)
public void notificationFailTest() {
	// TODO Auto-generated method stub
	
//	For test results reporting
	Reporter.log("Test Case Name - AQA TC002 - Notification Fail Test");
	GlobalVariables.extentTestAndroid = GlobalVariables.extentReportsAndroid.createTest("AQA TC002 - Notification Fail Test"); 
	
	String scriptVerificationID, scripVerificationName;
	
	boolean a = false;
	boolean b = false;
	boolean c = false;
	boolean d = false;
	boolean e = false;
	
	try {
		//	verify that the application is launched
		a = TestVerifications.verifyIsElementDisplayed(homePage.wiredLogo, "verify that the application is launched", "NFT001");
		
//	Go to settings
		AndroidUtility.tapElement(homePage.settingsMenu);
		
		Utils.staticWait(2000);
		
//	verify that Notifications switch is on
		b = TestVerifications.verifyDesiredWebElementAttribute(settingsPage.notificationSwitch, "NT002", "verify that Notifications switch is on", "text", "ON");
		
//	verify notifications message
		c = TestVerifications.verifyElementTextOnPage("NFT003", "verify notifications message", settingsPage.notificationMessage, "You will receive alerts from WIRED");
		
//	Switch the notifications switch off
		AndroidUtility.tapElement(settingsPage.notificationSwitch);
		
		Utils.staticWait(3000);
		
//	Verify that notification switch is off
		d = TestVerifications.verifyDesiredWebElementAttribute(settingsPage.notificationSwitch, "NFT004", "verify that Notifications switch is off", "text", "OFF");

//	verify notification message
		e = TestVerifications.verifyElementTextOnPage("NFT005", "verify notifications message", settingsPage.notificationMessage, "TestFail - You will not receive alerts from Wired.");
		
//	switch notification on
		AndroidUtility.tapElement(settingsPage.notificationSwitch);
		
		if (a && b && c && d && e) {
			Assert.assertTrue(true);
			
		} else {

			Assert.fail((GlobalVariables.resultString).toString());
			
		}
	} catch (Exception ex) {

		scriptVerificationID = GlobalVariables.testName;
		scripVerificationName = GlobalVariables.testName;

		String expectedResult = "No undesirable excepion should be thrown during script execution";
		String actualResult = ex.getMessage();

		Reporting.reportScriptFailure(scriptVerificationID, scripVerificationName, expectedResult, actualResult);
		Assert.fail((GlobalVariables.resultString).toString());
		
	}

}

@Test(testName = "AQA TC003 - Privacy Policy Test", enabled = false)
public void privacyPolicyTest() {
	// TODO Auto-generated method stub
	
//	For test results reporting
	Reporter.log("Test Case Name - AQA TC003 - Privacy Policy Test");
	GlobalVariables.extentTestAndroid = GlobalVariables.extentReportsAndroid.createTest("AQA TC003 - Privacy Policy Test"); 
	
	String scriptVerificationID, scripVerificationName;
	
	boolean a = false;
	boolean b = false;
	boolean c = false;
	boolean d = false;
	boolean e = false;
	
	try {
		//	verify that the application is launched
		a = TestVerifications.verifyIsElementDisplayed(homePage.wiredLogo, "verify that the application is launched", "PPT001");
		
//	Go to settings
		AndroidUtility.tapElement(homePage.settingsMenu);
		
		Utils.staticWait(2000);
		
//	verify that About tab is displayed
		b = TestVerifications.verifyIsElementDisplayed(settingsPage.aboutTab, "verify that About tab is displayed", "PPT002");
		
//		Go to About tab
		AndroidUtility.tapElement(settingsPage.aboutTab);
		
//		verify that Privacy Policy tab is displayed
		c = TestVerifications.verifyIsElementDisplayed(aboutPage.privacyPolicyTab, "verify that Privacy Policy tab is displayed", "PPT003");
		
//		Go to privacy policy tab
		AndroidUtility.tapElement(aboutPage.privacyPolicyTab);
		
		Utils.staticWait(20000);
		
//		Switch context
		String appContext = AndroidUtility.switchToWebContext();
		
//		Verify browser title
		d = TestVerifications.verifyBrowserPageTitle("PPT004", "Verify browser title", "Condé Nast - Privacy Policy");
		
//		Press android back button
		AndroidUtility.back();
		
//		Switch context
		AndroidUtility.switchToContext(appContext);

		//		verify that Privacy Policy tab is displayed
		e = TestVerifications.verifyIsElementDisplayed(aboutPage.privacyPolicyTab, "verify that Privacy Policy tab is displayed", "PPT005");
		
		if (a && b && c && d && e) {
			Assert.assertTrue(true);
			
		} else {

			Assert.fail((GlobalVariables.resultString).toString());
			
		}
	} catch (Exception ex) {

		scriptVerificationID = GlobalVariables.testName;
		scripVerificationName = GlobalVariables.testName;

		String expectedResult = "No undesirable excepion should be thrown during script execution";
		String actualResult = ex.getMessage();

		Reporting.reportScriptFailure(scriptVerificationID, scripVerificationName, expectedResult, actualResult);
		Assert.fail((GlobalVariables.resultString).toString());
		
	}

}


}
