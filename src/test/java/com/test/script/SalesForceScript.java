package com.test.script;
import java.util.Properties;



import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.pages.homepage.HomePage;
import com.test.pages.login.LoginPage;
import com.test.page.upperMenu.UpperMenuPage;
import com.test.pages.forgotPassword.ForgotPasswordPage;

import com.test.utilities.PropertiesUtility;
public class SalesForceScript  extends BaseTest {
	@Test
	public void login_to_SalesForce() throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******Login to Sales Force App started***********");
		String expected="Student Registration Form";
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.valid.userid",p);
		String password=pro.getPropertyValue("login.valid.password",p);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		driver=loginPage.clickLoginButton();
	    String expect = loginPage.getErrorMsg();
	    System.out.println("Error Msg" + expect);
	    Assert.assertNotEquals(expect, "Please check your username and password. If you still can't log in, contact your Salesforce administrator");
		 
		
	
	}
	
	@Test
	//TestCase 2 - Make sure you log in to homepage
	public void getHomePageTitle() throws InterruptedException {
		
		myLog.info("******Login to Sales Force App started***********");
		String expected="Student Registration Form";
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.valid.userid",p);
		String password=pro.getPropertyValue("login.valid.password",p);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		driver=loginPage.clickLoginButton();
		HomePage homePage=new HomePage(driver);			
		Assert.assertNotEquals(homePage.getPageTitle(), "[Home Page ~ Salesforce - Developer Edition]");
	}
	
	//TestCase 3 - Error msg if remember me checkbox is checked and usename is  blank
    @Test
	public  void checkRememberMe() {
    	
    	myLog.info("******Login to Sales Force App started***********");
		String expected="Student Registration Form";
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.valid.userid",p);
		String password=pro.getPropertyValue("login.valid.password",p);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.checkReadMe();		
		driver=loginPage.clickLoginButton();
		
		UpperMenuPage upperMenuPage=new UpperMenuPage(driver);	
		upperMenuPage.selectUserNameMenu();
		upperMenuPage.selectLogout();	
		Assert.assertEquals(loginPage.getAttribute("value"), "");	
    }
    

	//TestCase 4 - Password link click to receive email
    @Test
	public  void forgotPasswordFlowTest() {
    	myLog.info("******Login to Sales Force App started***********");
		
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.valid.userid",p);
		
		
		LoginPage loginPage=new LoginPage(driver);
		ForgotPasswordPage forgotPassPage=new ForgotPasswordPage(driver);
		
		loginPage.clickPasswordForgotLink();
		forgotPassPage.enterUserName(username);		
		forgotPassPage.clickContinue();
    }
    

	//TestCase 4B - ValidateLoginErrorMsg
    @Test
	public  void validateLoginErrorMessage() {
    	myLog.info("******Login to Sales Force App started***********");
		
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.invalid.userid",p);
		String password=pro.getPropertyValue("login.invalid.password",p);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		driver=loginPage.clickLoginButton();
	    String expect = loginPage.getErrorMsg();
	    Assert.assertNotEquals(loginPage.getErrorMsg(), "[Please check your username and password. If you still can't log in, contact your Salesforce administrator.]");
    	
    }
}
