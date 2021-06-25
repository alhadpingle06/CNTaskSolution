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
public class SettingsPage {

	@AndroidFindBy(xpath = "//android.widget.Switch")
	public AndroidElement notificationSwitch;

	@AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
	public AndroidElement notificationMessage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='']")
	public AndroidElement cancelButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
	public AndroidElement aboutTab;

	/**
	 * Description : class constructor
	 */

	public SettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(GlobalVariables.driver), this);			
		
	}

}
