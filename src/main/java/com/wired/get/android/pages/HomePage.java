/**
 * 
 */
package com.wired.get.android.pages;

import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.wired.get.utils.GlobalVariables;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Alhad Pingle
 *
 */
public class HomePage {


	@AndroidFindBy(xpath = "//android.widget.ImageView")
	public AndroidElement wiredLogo;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
	public AndroidElement settingsMenu;


	/**
	 * Description : class constructor

	 */
	public HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(GlobalVariables.driver), this);			
		//		this.extentTestAndroid = extentTestAndroid;
	}

}
