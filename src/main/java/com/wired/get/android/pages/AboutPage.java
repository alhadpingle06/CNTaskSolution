/**
 * 
 */
package com.wired.get.android.pages;

import org.openqa.selenium.support.PageFactory;

import com.wired.get.utils.GlobalVariables;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Alhad Pingle
 *
 */
public class AboutPage {	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
	public AndroidElement privacyPolicyTab;

	/**
	 * Description : class constructor
	 */

	public AboutPage() {
		PageFactory.initElements(new AppiumFieldDecorator(GlobalVariables.driver), this);			
		
	}

}
