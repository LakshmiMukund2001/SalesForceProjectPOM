package com.test.pages.homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.pages.base.BasePage;


	public class HomePage extends BasePage {
		//@FindBy(xpath ="/html/body/div[2]/div[2]/h1") WebElement studentRegistration;
		
		public HomePage(WebDriver driver) {
			super(driver);
		}
		
		public String getPageTitle() {
			return super.getPageTitle();
		}
}