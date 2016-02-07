package com.google.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.pages.GoogleResultsPage;
import com.google.pages.GoogleSearchPage;
import com.google.commons.TestProperties;

public class TestGoogleNavigation {
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
	
	@Test
	public void googleNavigationTest() throws Exception{
		System.out.println("Test navigation.");
				
		GoogleSearchPage search = new GoogleSearchPage(driver);
		search.searchDataInGoogle("Apple");
		
		GoogleResultsPage result = new GoogleResultsPage(driver);
		int countResultsPage1 = result.getNumberOfResults();
		System.out.println(countResultsPage1);
			
		result = result.navigateToGoogleResultPage(2);
		int countResultsPage2 = result.getNumberOfResults();
		System.out.println(countResultsPage2);
		
		result = result.navigateToGoogleResultPage(10);
		int countResultsPage10 = result.getNumberOfResults();
		System.out.println(countResultsPage10);
		
		//Verification: Results of Page 2 and 10
		new SoftAssert().assertTrue(countResultsPage2==countResultsPage10);
		
		//Verification: Results of Page 1 and 10
		new SoftAssert().assertTrue(countResultsPage1==countResultsPage10);
		
		//Verification: Results of Page 1 and 2
		new SoftAssert().assertTrue(countResultsPage1==countResultsPage2);
	}
	
}
