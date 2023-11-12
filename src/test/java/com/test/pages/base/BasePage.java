package com.test.pages.base;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.utilities.ExtentReportsUtility;
import com.test.utilities.Log4JUtility;

public class BasePage {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected Log4JUtility logObject=Log4JUtility.getInstance();
	protected static Logger myLog;
	protected ExtentReportsUtility report=ExtentReportsUtility.getInstance();
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		BasePage.myLog.info("page title is returned");
		System.out.println("The page title is " + driver.getTitle());
		return driver.getTitle();
	}
   public boolean emptyTextBox(WebElement elem , String objectName) {
	   waitForVisibility(elem,10,objectName);
	   if(elem.getAttribute("value").isEmpty()) {
		   System.out.println("TextBox Empty");
		   return true;
	   }
	   System.out.println("TextBox  not Empty");
	   return false;
   }
	public void refreshPage() {
		driver.navigate().refresh();
		myLog.info("page is refreshed");

	}
	public String getCurrentWindowsHandler() {
		return driver.getWindowHandle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public void getwindowsHandler(int winIndex) {
		String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        System.out.println("HInside windowsHandler" ); 
        // Here we will check if child window has other child windows and will fetch the heading of the child window
        int winCount = 0;
        while (iterator.hasNext()) {
             String ChildWindow = iterator.next();
                //if (winName.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                //WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " );
                if(winCount == winIndex) {winCount++; break;}
            }
        //return driver.getWindowHandle();
	}
	
    public void clickActionPerform(WebElement elem , String objectName) {
    	waitForVisibility(elem,20,objectName);
    	Actions actions = new Actions(driver);
		actions.moveToElement(elem).click();		
		actions.build().perform();
		//waitForVisibility(elem,20,objectName);
    }
    
    public void selectDropDownByText(WebElement drpDown, String str) {
    	Select drpDownElement = new Select(drpDown);
    	drpDownElement.selectByVisibleText(str);
    }
    
    public void switchFrameByName(String frameName) {
    	driver.switchTo().frame(frameName);
    }
    
	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		//BasePage.this.info("extracted the text from" + objectName);
		return data;
	}
	
	public String getAttribute(WebElement elem , String attribute) {
		return elem.getAttribute(attribute);
	}
    public String getErrorMsg(WebElement elem) {
    	return elem.getText();
    }
	
	public static void waitForVisibility(WebElement ele,int time,int pollingtime,String objectName) {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(time))
		.pollingEvery(Duration.ofSeconds(pollingtime))
		.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.visibilityOf(ele));
		System.out.println(objectName+" is waited for visibility using fluent wait");
	}
	
	public static void waitForVisibility(WebElement ele,int time,String objectNam) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
    public void radioButtonSelect(WebElement radioElem) {
    	boolean isSelected = radioElem.isSelected();
		
    
    	if(isSelected == false) {
    		radioElem.click();
    	}
    }
    
    public void radioButtonUnSelect(WebElement radioElem) {
    	boolean isSelected = radioElem.isSelected();
		
    	
    	if(isSelected == true) {
    		radioElem.click();
    	}
    }
	public void enterText(WebElement ele, String data, String objectName) {
		waitForVisibility(ele,20,objectName);
		//TODO:  Change this to work with wait
		
		if (ele.isDisplayed()) {
			clearElement(ele, objectName);
			ele.sendKeys(data);
			System.out.println("Pass:"+objectName+" is entered to the username filed");
		} else {
			System.out.println(objectName + " element is not displayed");
		}
	}

	public void clearElement(WebElement ele, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			System.out.println(ObjectName + " is cleared");
		} else {
			System.out.println(ObjectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			System.out.println(objectName + "button is clicked");
			
		} else {
			System.out.println("button element is not enabled");
			
		}
	}

}