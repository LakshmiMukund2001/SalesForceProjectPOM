package com.test.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.pages.base.BasePage;

public class LoginPage extends BasePage{
	@FindBy(id="username") WebElement userNameElement;
	@FindBy(id="password") WebElement passwordElement;
	@FindBy(id="Login") WebElement loginButtonElement;
	@FindBy(id="error") WebElement errorElement;
	@FindBy(xpath="//input[@type=\'checkbox\'][@name=\'rememberUn\']")WebElement loginRemeberMeElement;
	@FindBy (id="forgot_password_link") WebElement forgotPasswordLinkElement;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String data) {
		//userNameElement.sendKeys(data);
		enterText(userNameElement, data, "Username textbox");
	}
	public void enterPassword(String data) {
		enterText(passwordElement, data, "password field");
	}
	
	public WebDriver clickLoginButton() {
		clickElement(loginButtonElement,"login button");
		return driver;
		
	}
	
	public String getTitleOfThePAge() {
		//waitUntilPageLoads();
		return getPageTitle();
	}
	public String getErrorMsg() {
		return getErrorMsg(errorElement);
	}
	public void checkReadMe() {
		radioButtonSelect(loginRemeberMeElement);
		
		
	}
	
	public String getAttribute( String attribute ) {
		return super.getAttribute(userNameElement, attribute);
	}
    public void clickPasswordForgotLink() {
    	forgotPasswordLinkElement.click();
    }
	
}