package com.test.pages.mySettings;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.pages.base.BasePage;

public class MySettingsMenuPage extends BasePage{
	public MySettingsMenuPage(WebDriver driver) {
		super(driver);
	}
	//Personal Menu
	@FindBy(xpath="//span[text()='Personal']") WebElement personalElement;
	@FindBy(xpath="//a//span[text()='Login History']") WebElement lHistoryElement;
	@FindBy(xpath="//a[contains(text(),'Download')]") WebElement downLoadElement;
	@FindBy(xpath="//table[@class='detailList']//tr[2]//td//select") WebElement CutomAppElements;
	
	//Display & Layout Menu
	@FindBy(xpath="//span[text()='Display & Layout']") WebElement dispLayoutElement;
	@FindBy(xpath="//span[@id = 'CustomizeTabs_font']") WebElement custTabsElement;
	@FindBy(xpath="//table[@class='layout'] //td[@class='selectCell']//select[1]")WebElement availabeTabsElement;
	@FindBy(xpath ="//a[@id='duel_select_0_right']") WebElement addButtonElement;
	@FindBy(xpath="//input[@name='save']") WebElement saveButtonElement;
	
	
	//Email Menu Item
	@FindBy(xpath="//span[text()='Email']") WebElement emailElement;
	@FindBy(xpath="//a[@id = 'EmailSettings_font']") WebElement emailSettingsElement;
	
	
	public void selectPersonalInfo() {
		clickActionPerform(personalElement , "Personal Info Element");
	}
	public void selectLoginHistory() {
		clickActionPerform(lHistoryElement , "Login History Element");
	}
	public void selectDownLoadLoginHistory() {
		clickActionPerform(downLoadElement , "Download Login History Element");
	}
	public void selectDropDownByCustomApp(String customAppChoice) {
		selectDropDownByText(CutomAppElements,customAppChoice);
	}
	public void selectDropDownByAvailableTabs(String availableTabsChoice) {
		selectDropDownByText(availabeTabsElement,availableTabsChoice);
	}
	public void clickAddTabsButton() {
		addButtonElement.click();
	}
	
	
	
	// Display & Layout
	public void selectDiplayLayout() {
		clickActionPerform(dispLayoutElement , "Diplay and Layout Element");
	}
	public void selectcustomTabs() {
		clickActionPerform(custTabsElement , "Customs Tab Element");
	}
	public void saveButton() {
		saveButtonElement.click();
	}
	
	//Email
	public void clickEmailMenu() {
		emailElement.click();
	}
	public void clickEmailSettings() {
		emailSettingsElement.click();
	}
}
