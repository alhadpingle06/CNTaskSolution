/**
 * 
 */
package com.wired.get.utils;

import org.testng.Reporter;

import com.aventstack.extentreports.Status;

/**
 * @author Alhad Pingle
 * This class handles the test case result reportings
 *
 */
public class Reporting {

	static Utils objUtils = new Utils();
	static public String strScreenShot;

	public static void verifyTestResult(boolean blnVar, String testVerificationName, String verificationID,
			String actionFailureMessage, String expectedResult) {
		// TODO Auto-generated method stub

		if (blnVar) {
			Reporter.log("Test Verification: " + testVerificationName + " is PASS\n");
			GlobalVariables.extentTestAndroid.log(Status.PASS, testVerificationName);
		}

		else {

			Reporter.log("Test Verification: " + testVerificationName + " is FAIL\n");
			GlobalVariables.extentTestAndroid.log(Status.FAIL, testVerificationName);

			strScreenShot = objUtils.getScreenShot(verificationID);

			String msg =  Reporting.errorMessageCreater(testVerificationName, actionFailureMessage, expectedResult);

			GlobalVariables.resultString.append(msg+" ;\n:screenshot: " + strScreenShot + "\n");

		}

	}

	private static String errorMessageCreater(String testVerificationName, String actionFailureMessage,
			String expectedResult) {
		// TODO Auto-generated method stub
		return "\n :Test Verification Name: " + testVerificationName +
				" ;\n :FAIL: " + actionFailureMessage + 
				" ;\n :expected: "+ expectedResult;
	}

	public static void reportScriptFailure(String scriptVerificationID, String scripVerificationName, String expectedResult, String actualResult) {
		// TODO Auto-generated method stub

		String actionFailureMessage = "Script failure";

		Reporter.log("Script Verification: " + scripVerificationName + " is FAIL\n");
		GlobalVariables.extentTestAndroid.log(Status.FAIL, scripVerificationName);

		strScreenShot = objUtils.getScreenShot(scriptVerificationID);

		String msg =  Reporting.errorMessageCreater(scripVerificationName, actionFailureMessage, expectedResult, actualResult);

		GlobalVariables.resultString.append(msg+" ;\n:screenshot: " + strScreenShot + "\n");

	}

	private static String errorMessageCreater(String testVerificationName, String actionFailureMessage,
			String expectedResult, String actualResult) {
		// TODO Auto-generated method stub
		return "\n :Test Verification Name: " + testVerificationName +
				" ;\n :FAIL: " + actionFailureMessage + 
				" ;\n :expected: "+ expectedResult + 
				" ;\n : actual: " + actualResult;
	}




}
