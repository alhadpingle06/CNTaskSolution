/**
 * 
 */
package com.wired.get.utils;
import org.openqa.selenium.WebElement;

/**
 * @author Alhad Pingle
 * This class contains all the test verifications - Soft assertions
 *
 */
public class TestVerifications {

	public static boolean verifyIsElementDisplayed(WebElement inputMenu, String testVerificationName, String verificationID) {
		// TODO Auto-generated method stub

		String elementDisplayFailureMessage = "Element not displayed";

		boolean blnVar = inputMenu.isDisplayed();
		Reporting.verifyTestResult(blnVar, testVerificationName, verificationID, elementDisplayFailureMessage, "Desired Element should be displayed");
		if (blnVar) {
			return true;
		}else {
			return false;
		}
	}


	public static boolean verifyElementTextOnPage(String verificationID, String testVerificationName, WebElement element,
			String expectedText) {
		// TODO Auto-generated method stub
		String expectedTextFailureMessage = "Desired Element Text Not Displayed";

		boolean blnVar = element.getText().equals(expectedText);

		Reporting.verifyTestResult(blnVar, testVerificationName, verificationID, expectedTextFailureMessage, expectedText);

		if (blnVar) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean verifyDesiredWebElementAttribute(WebElement element, String verificationID, String testVerificationName, String attribute,String value) {
		// TODO Auto-generated method stub
		String expectedAttributePresenceFailureMessage = "Element attribute does not display desired value";

		boolean blnVar = element.getAttribute(attribute).contains(value);

		Reporting.verifyTestResult(blnVar, testVerificationName, verificationID, expectedAttributePresenceFailureMessage,  "Element attribute does display desired value");

		if (blnVar) {
			return true;
		}

		else {
			return false;
		}

	}
	
	public static boolean verifyBrowserPageTitle(String verificationID, String testVerificationName, String expectedBrowserTitle) {
		// TODO Auto-generated method stub
		String pageNavFailureMessage = "Page Navigation Failed";
		System.out.println(GlobalVariables.driver.getTitle());
		boolean blnVar = GlobalVariables.driver.getTitle().contains(expectedBrowserTitle);

		Reporting.verifyTestResult(blnVar, testVerificationName, verificationID, pageNavFailureMessage, expectedBrowserTitle);

		if (blnVar) {
			return true;
		}

		else {
			return false;

		}
	}

}
