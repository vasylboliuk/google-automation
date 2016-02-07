package com.google.tests;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.pages.GoogleResultsPage;
import com.google.pages.GoogleSearchPage;
import com.google.pages.GoogleTranslatePage;


public class TestGoogleTranslate extends TestSetup {
	final static Logger logger = LoggerFactory.getLogger(TestGoogleTranslate.class);	
		
	@Test(groups = {"group-one"})
	public void googleTranslateTest() throws Exception{
		logger.info("Test google translate.");
		
		GoogleSearchPage search = new GoogleSearchPage(getDriver());
		search.searchDataInGoogle("translate google com");
		
		GoogleResultsPage result = new GoogleResultsPage(getDriver());
		result.navigateToGoogleTranslate();
		
		GoogleTranslatePage translate = new GoogleTranslatePage(getDriver());
		translate.setTranslateData("Apple");
		//Verification: The same text is displayed
		Assert.assertTrue(translate.getDataForTranslation().equals(translate.getTranslatedData()));
		//
		translate.changLanguage();
		//Verification: Translated text was changed
		Assert.assertTrue(!(translate.getDataForTranslation().equals(translate.getTranslatedData())));
		
		logger.info("END: Test google translate.");
	}
	
		
		
}
