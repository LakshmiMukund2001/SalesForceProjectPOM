package com.test.script;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.page.upperMenu.UpperMenuPage;
import com.test.pages.login.LoginPage;
import com.test.pages.mySettings.MySettingsMenuPage;
import com.test.pages.email.EmailSettingsPage;
import com.test.page.profile.ProfilePage;
import com.test.utilities.BasicJavaUtils;
import com.test.utilities.PropertiesUtility;
import java.util.ArrayList;
import java.util.List;
public class SalesForceUserMenuScript  extends BaseTest{
	
	
	//Test TC 05 - Select User Menu from Dropdown
		@Test
		public void selectUserMenuDropDown(){
    	myLog.info("******Login to Sales Force App started***********");
		
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.valid.userid",p);
		String password=pro.getPropertyValue("login.valid.password",p);
		ArrayList<String> userNameMenuList = BasicJavaUtils.populateUserNameMenuArrayList();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		driver=loginPage.clickLoginButton();
		

		UpperMenuPage upperMenuPage=new UpperMenuPage(driver);	
		upperMenuPage.selectUserNameMenu();
		
		Assert.assertNotEquals(upperMenuPage.checkUsrMenuItems(userNameMenuList), false);
	}
		
		//Test TC 06 -Select "My Profile" option from user menu for <username> drop down
		@Test
		public void selectProfileTest() {
			
			myLog.info("******Login to Sales Force App started***********");
			
			PropertiesUtility pro=new PropertiesUtility();
			Properties p=pro.createPropertyObject();
			pro.loadFile("applicationDataProperties",p);
			String username=pro.getPropertyValue("login.valid.userid",p);
			String password=pro.getPropertyValue("login.valid.password",p);
			
			
			LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserName(username);
			loginPage.enterPassword(password);
			driver=loginPage.clickLoginButton();
			
			UpperMenuPage upperMenuPage=new UpperMenuPage(driver);	
			upperMenuPage.selectUserNameMenu();
			upperMenuPage.selectProfile();
			
			ProfilePage profilePage = new ProfilePage(driver);
			profilePage.clickEditProfile();
			profilePage.switchFrameByName("contactInfoContentId");
			profilePage.enterLastName("Mukes");
			profilePage.clickSaveAll();
			
		}
		//Test 07-Select "My settings" option from user menu for <username> drop down
		@Test
		public void selectMySettings() {
			PropertiesUtility pro=new PropertiesUtility();
			Properties p=pro.createPropertyObject();
			pro.loadFile("applicationDataProperties",p);
			String username=pro.getPropertyValue("login.valid.userid",p);
			String password=pro.getPropertyValue("login.valid.password",p);
			
			LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserName(username);
			loginPage.enterPassword(password);
			driver=loginPage.clickLoginButton();

			UpperMenuPage upperMenuPage=new UpperMenuPage(driver);	
			upperMenuPage.selectUserNameMenu();
			upperMenuPage.selectMySettings();
			
			MySettingsMenuPage settingsMenuPage=new MySettingsMenuPage(driver);	
			settingsMenuPage.selectPersonalInfo();
			settingsMenuPage.selectLoginHistory();
			settingsMenuPage.selectDownLoadLoginHistory();
			settingsMenuPage.selectDiplayLayout();
			settingsMenuPage.selectcustomTabs();
			settingsMenuPage.selectDropDownByCustomApp("Salesforce Chatter");
			settingsMenuPage.selectDropDownByAvailableTabs("Reports");
			settingsMenuPage.clickAddTabsButton();
			settingsMenuPage.saveButton(); //There is a flaw in the test case	
			settingsMenuPage.clickEmailMenu();
			settingsMenuPage.clickEmailSettings();
			
			EmailSettingsPage emailPage = new EmailSettingsPage(driver);
			emailPage.enterEmailName("Lakshmi Muke");
			emailPage.enterEmail("LakshmiH78@gmail.com");
			emailPage.clickAutoBCCEmail();
			emailPage.saveButton();
			Assert.assertNotEquals(emailPage.getMessage(),"[Your settings have been successfully saved.]");
					
		}
		
		//T08 - TestCase - Select "Developers Console" option from user menu for <username> drop down
		@Test
		public void selectDeveloperConsole() {
			PropertiesUtility pro=new PropertiesUtility();
			Properties p=pro.createPropertyObject();
			pro.loadFile("applicationDataProperties",p);
			String username=pro.getPropertyValue("login.valid.userid",p);
			String password=pro.getPropertyValue("login.valid.password",p);
			
			LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserName(username);
			loginPage.enterPassword(password);
			driver=loginPage.clickLoginButton();
			
			UpperMenuPage upperMenuPage=new UpperMenuPage(driver);	
			upperMenuPage.selectUserNameMenu();
			upperMenuPage.selectDeveloperConsole();
			upperMenuPage.getWindowHandler(2);
			//System.out.println("Windows Handler Title" + upperMenuPage.getPageTitle());
			Assert.assertNotEquals("[Developer Console]", upperMenuPage.getPageTitle());
			
			
		}
		//T09 - Select "Logout" option from user menu for <username> drop down
		@Test
		public void selectUserMenuLogout() {
			PropertiesUtility pro=new PropertiesUtility();
			Properties p=pro.createPropertyObject();
			pro.loadFile("applicationDataProperties",p);
			String username=pro.getPropertyValue("login.valid.userid",p);
			String password=pro.getPropertyValue("login.valid.password",p);
			
			LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserName(username);
			loginPage.enterPassword(password);
			driver=loginPage.clickLoginButton();
			
			UpperMenuPage upperMenuPage=new UpperMenuPage(driver);	
			upperMenuPage.selectUserNameMenu();
			upperMenuPage.selectLogout();
			upperMenuPage.getWindowHandler(1);
			System.out.println("Windows Handler Title" + upperMenuPage.getCurrentUrl().contains("logout"));
			upperMenuPage.getCurrentUrl().contains("logout");
			Assert.assertNotEquals("["+upperMenuPage.getCurrentUrl().contains("logout")+ "]", false);
				
		}
}
