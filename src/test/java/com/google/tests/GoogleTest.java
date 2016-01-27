package com.google.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.commons.Properties;
import com.google.pages.GoogleResultsPage;
import com.google.pages.GoogleSearchPage;
import com.google.pages.GoogleTranslatePage;

public class GoogleTest {
	private WebDriver driver;
	
	@BeforeClass(groups = {"group-one"})
	public void oneTimeSetUp() {
		System.setProperty("webdriver.firefox.bin", Properties.PATH_TO_FIREFOX_34);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Properties.WAITERS_TIMEOUT, TimeUnit.SECONDS);
	}

	@AfterClass(groups = {"group-one"})
	public void oneTimeTearDown() {
		driver.quit();
	}

	@BeforeMethod(groups = {"group-one"})
	public void setUp() {
		driver.get(Properties.ENG_GOOGLE_PAGE_URL);
	}

	@AfterMethod(groups = {"group-one"})
	public void tearDown() {
		driver.get(Properties.ENG_GOOGLE_PAGE_URL); //After method navigate to Google home page
	}
	
	@Test(groups = {"group-one"})
	public void googleTranslateTest() throws Exception{
		System.out.println("Test google translate.");
		
		GoogleSearchPage search = new GoogleSearchPage(driver);
		search.searchDataInGoogle("translate google com");
		
		GoogleResultsPage result = new GoogleResultsPage(driver);
		result.navigateToGoogleTranslate();
		
		GoogleTranslatePage translate = new GoogleTranslatePage(driver);
		translate.setTranslateData("Apple");
		//Verification: The same text is displayed
		Assert.assertTrue(translate.getDataForTranslation().equals(translate.getTranslatedData()));
		//
		translate.changLanguage();
		//Verification: Translated text was changed
		Assert.assertTrue(!(translate.getDataForTranslation().equals(translate.getTranslatedData())));
	}
	
		
		
}
