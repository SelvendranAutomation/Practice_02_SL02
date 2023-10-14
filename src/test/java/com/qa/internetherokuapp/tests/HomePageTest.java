package com.qa.internetherokuapp.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.internetherokuapp.pages.HomePage;
import com.qa.internetherokuapp.pages.TestBase;



public class HomePageTest {
	
	public WebDriver driver;
	public TestBase testBase;
	public Properties prop;
	public HomePage homePage;


	
	@BeforeTest
	public void setUp(){
		testBase = new TestBase();	
		prop = testBase.initProperty();
		driver = testBase.init(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		homePage =  new HomePage(driver);
		
	}
	


	
	@Test(priority = 0)
	public void verifyJSAlert(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+ title);
		Assert.assertEquals(title, "The Internet");
				
		homePage.clickForJSAlertButton();	
		String textJSAlert =homePage.handleJSAlertAccept();
		System.out.println("Home page JSAlert text is: "+ textJSAlert);
		String resultText =homePage.getResultText();
		System.out.println("Home page ResultText is: "+ resultText);
		
		Assert.assertEquals(textJSAlert, "I am a JS Alert");
		Assert.assertEquals(resultText, "You successfully clicked an alert");


	}

	@Test(priority = 1)
	public void verifyJSConfirm(){

				
		homePage.clickForJSConfirmButton();	
		String textJSAlert =homePage.handleJSAlertAccept();
		System.out.println("Home page Confirm text is: "+ textJSAlert);
		String resultText =homePage.getResultText();
		System.out.println("Home page ResultText is: "+ resultText);
		
		Assert.assertEquals(textJSAlert, "I am a JS Confirm");
		Assert.assertEquals(resultText, "You clicked: Ok");

		homePage.clickForJSConfirmButton();	
		String textJSAlertDismiss =homePage.handleJSAlertDismiss();
		System.out.println("Home page Confirm text is: "+ textJSAlertDismiss);
		String resultTextDismiss =homePage.getResultText();
		System.out.println("Home page ResultText is: "+ resultTextDismiss);
		
		Assert.assertEquals(textJSAlertDismiss, "I am a JS Confirm");
		Assert.assertEquals(resultTextDismiss, "You clicked: Cancel");

	}
	
	@Test(priority = 2)
	public void verifyJSPrompt(){
		String promptInputTest = "Prompt Input Test";
				
		homePage.clickForJSPromptButton();	
		String textJSAlert[] =homePage.handleJSPromptTypeAccept(promptInputTest);
		System.out.println("Home page Prompt text is: "+ textJSAlert[0]+ textJSAlert[1]);
		String resultText =homePage.getResultText();
		System.out.println("Home page ResultText is: "+ resultText);
		
		Assert.assertEquals(textJSAlert[0], promptInputTest);
		Assert.assertEquals(textJSAlert[1], "I am a JS prompt");
		Assert.assertEquals(resultText, "You entered: "+promptInputTest);

		homePage.clickForJSPromptButton();	
		String textJSAlertDismiss[] =homePage.handleJSPromptTypeDismiss(promptInputTest);
		System.out.println("Home page Prompt text is: "+ textJSAlertDismiss[0]+textJSAlertDismiss[1]);
		String resultTextDismiss =homePage.getResultText();
		System.out.println("Home page ResultText is: "+ resultTextDismiss);
		
		Assert.assertEquals(textJSAlertDismiss[0], promptInputTest);
		Assert.assertEquals(textJSAlertDismiss[1], "I am a JS prompt");
		Assert.assertEquals(resultTextDismiss, "You entered: null");
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
