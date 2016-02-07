package com.google.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.commons.TestProperties;

public abstract class TestSetup {
	
private WebDriver driver;
	
	@BeforeClass
	public void oneTimeSetUp() {
		//System.setProperty("webdriver.firefox.bin", "c:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestProperties.getWaiterTimeout(), TimeUnit.SECONDS);
	}

	@AfterClass
	public void oneTimeTearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void setUp() {
		driver.get(TestProperties.getGooglePageUrl());
	}

	@AfterMethod
	public void tearDown() {
		driver.get(TestProperties.getGooglePageUrl()); //After method navigate to Google home page
	}
	
	public WebDriver getDriver(){
		return this.driver;
	}
	

}
