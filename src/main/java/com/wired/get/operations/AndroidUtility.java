/**
 * 
 */
package com.wired.get.operations;

import java.util.Set;

import org.openqa.selenium.WebElement;
import com.wired.get.utils.GlobalVariables;
import com.wired.get.utils.Utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

/**
 * @author Alhad Pingle
 *
 */
public class AndroidUtility {

	public static void tapElement(WebElement element) {
		// TODO Auto-generated method stub
		TouchAction ta = new TouchAction((AndroidDriver<AndroidElement>)GlobalVariables.driver);
		ta
		.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)))
		.perform();

	}

	public static void switchToContext(String context) {
		// TODO Auto-generated method stub
		
		((AndroidDriver<AndroidElement>)GlobalVariables.driver).context(context);
				
	}

	public static String switchToWebContext() {
		// TODO Auto-generated method stub
		
		String currentContext = ((AndroidDriver<AndroidElement>)GlobalVariables.driver).getContext();
		
		Set<String> context = ((AndroidDriver<AndroidElement>)GlobalVariables.driver).getContextHandles();
		
		for (String con : context) {
			if (con.equals(currentContext)) {
				continue;
			} else {
				switchToContext(con);
				break;
			}
		}
		
		return currentContext;
	}

	public static void back() {
		// TODO Auto-generated method stub
		((AndroidDriver<AndroidElement>)GlobalVariables.driver).pressKey(new KeyEvent(AndroidKey.BACK));
		Utils.staticWait(2000);
		
	}

}
