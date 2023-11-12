package com.test.page.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.pages.base.BasePage;

public class ProfilePage extends BasePage{

	public ProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//img[@title='Edit Profile']") WebElement editProfileElm;
	@FindBy(xpath="//a[normalize-space()='About']") WebElement aboutTabElem;
	@FindBy(xpath="//input[@id='lastName']") WebElement lastNameTxtElem;
	@FindBy(xpath="//input[@value='Save All']") WebElement saveAllButtonElem;
	public void clickEditProfile()	{
		editProfileElm.click();
	}
	public void clickAboutTab() {
		aboutTabElem.click();
	}
	public void enterLastName(String lastName) {
		enterText(lastNameTxtElem, lastName , "LastName Txt ELement");
	}
	public void clickSaveAll() {
		saveAllButtonElem.click();
	}
	

}
