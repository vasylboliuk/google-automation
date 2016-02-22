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

	@Test(groups = { "group-one" })
	public void googleTranslateTest() throws Exception {
		logger.info("Start: Test google translate.");

		GoogleSearchPage search = new GoogleSearchPage(getDriver());
		GoogleResultsPage result = search.searchDataInGoogle("translate google com");

		result.navigateToGoogleTranslate();
		GoogleTranslatePage translate = new GoogleTranslatePage(getDriver());
		translate.setTranslateData("Apple");
		// Verification: The same text is displayed
		Assert.assertEquals(translate.getDataForTranslation(), translate.getTranslatedData(),
				"Translation data are not same");

		translate.changLanguage();
		// Verification: Translated text was changed
		Assert.assertNotEquals(translate.getDataForTranslation(), translate.getTranslatedData(),
				"Translation data are same");

		logger.info("END: Test google translate.");
	}

}
