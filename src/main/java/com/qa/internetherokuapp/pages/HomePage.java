package com.qa.internetherokuapp.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends TestBase{
	
	private ElementUtil elementUtil;
	
	private By clickForJSAlertButton_xpath = By.xpath( "//button[text()='Click for JS Alert']");
	private By clickForJSConfirmButton_xpath = By.xpath( "//button[text()='Click for JS Confirm']");
	private By clickForJSPromptButton_xpath = By.xpath( "//button[text()='Click for JS Prompt']");
	private By resultText_id = By.id( "result");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public void clickForJSAlertButton(){
		
		elementUtil.waitForElementPresent(clickForJSAlertButton_xpath, 30);
		driver.findElement(clickForJSAlertButton_xpath).click();
	}

	public void clickForJSConfirmButton(){
		
		elementUtil.waitForElementPresent(clickForJSConfirmButton_xpath, 30);
		driver.findElement(clickForJSConfirmButton_xpath).click();
	}

	public void clickForJSPromptButton(){
		
		elementUtil.waitForElementPresent(clickForJSPromptButton_xpath, 30);
		driver.findElement(clickForJSPromptButton_xpath).click();
	}
	public String handleJSAlertAccept(){
		String alertText = "";
		Alert alert = elementUtil.waitForAlertPresent(60);
		alertText = alert.getText();
		alert.accept();
		return alertText;

	}
	public String handleJSAlertDismiss(){
		String alertText = "";
		Alert alert = elementUtil.waitForAlertPresent(60);
		alertText = alert.getText();
		alert.dismiss();
		return alertText;

	}
	
	public String[] handleJSPromptTypeAccept(String inputText){
		String alertText = "";
		Alert alert = elementUtil.waitForAlertPresent(60);
		alert.sendKeys(inputText);
		alertText = alert.getText();
		alert.accept();
		return new String[] {inputText, alertText};

	}
	
	public String[] handleJSPromptTypeDismiss(String inputText){
		String alertText = "";
		Alert alert = elementUtil.waitForAlertPresent(60);
		alert.sendKeys(inputText);
		alertText = alert.getText();
		alert.dismiss();
		return new String[] {inputText, alertText};

	}
	
	public String getResultText() {
		elementUtil.getScreenshot();		
		return driver.findElement(resultText_id).getText();
	}

	
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
}
