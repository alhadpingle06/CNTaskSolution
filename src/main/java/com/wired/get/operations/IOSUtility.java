/**
 * 
 */
package com.wired.get.operations;

import org.openqa.selenium.WebElement;
import com.wired.get.utils.GlobalVariables;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

/**
 * @author Alhad Pingle
 *
 */
public class IOSUtility {

	public static void tapElement(WebElement element) {
		// TODO Auto-generated method stub
		IOSTouchAction ta = new IOSTouchAction((IOSDriver<IOSElement>)GlobalVariables.driver);
		ta
		.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)))
		.perform();
	}

}
