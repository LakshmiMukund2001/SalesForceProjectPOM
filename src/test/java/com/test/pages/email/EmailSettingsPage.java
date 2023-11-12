package com.test.pages.email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.pages.base.BasePage;

public class EmailSettingsPage extends BasePage{

	public EmailSettingsPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='sender_name']") WebElement emailNameElement;
	@FindBy(xpath="//input[@id='sender_email']") WebElement emailElement;
	@FindBy(xpath="//input[@id='auto_bcc1']") WebElement radioAutomaticBCCElem;
	@FindBy(xpath="//input[@name='save']") WebElement saveElement;
	@FindBy(xpath="//div[@id='meSaveCompleteMessage']") WebElement saveCompleteMsgElem;
	public void enterEmailName(String fullname) {
		enterText(emailNameElement, fullname, "Email Name Element");
	}
	
	public void enterEmail(String emailAddr) {
		enterText(emailElement, emailAddr, "Email  Element");
	}
  public void clickAutoBCCEmail() {
	  radioAutomaticBCCElem.click();
  }
  public void saveButton() {
	  saveElement.click();
  }
  public String getMessage() {
	 return  getTextFromElement(saveCompleteMsgElem ,"save Complete Msg Elem" );
  }
}
