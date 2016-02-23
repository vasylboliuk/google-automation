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

	/**
	 * <b>TC-02: Test Google translate.</b>
	 * 
	 * Scenario:
	 * <ul>
	 * <li>1. Open Firefox browser
	 * <li>2. Open main Google search page
	 * <li>3. In search field type search data: "translate google com"
	 * <li>4. Open first link (Google translate page)
	 * <li>5. In left panel type data for translation "Apple"
	 * <li>6. Verify that in right panel translated data are same.
	 * <li>7. Get inactive languages from top right panel, click on any.
	 * </ul>
	 * <p>
	 * Expected Result: Translated text was changed(doesn't equal to the text
	 * before).
	 */
	@Test(groups = { "group-one" })
	public void googleTranslateTest() {
		logger.info("Start: Test google translate.");

		GoogleSearchPage search = new GoogleSearchPage(getDriver());
		GoogleResultsPage result = search.searchDataInGoogle("translate google com");

		result.navigateToGoogleTranslate();
		GoogleTranslatePage translate = new GoogleTranslatePage(getDriver());
		translate.setTranslateData("Apple");
		Assert.assertEquals(translate.getDataForTranslation(), translate.getTranslatedData(),
				"Translation data are not same");

		translate.changLanguage();
		Assert.assertNotEquals(translate.getDataForTranslation(), translate.getTranslatedData(),
				"Translation data are same");

		logger.info("END: Test google translate.");
	}

}
