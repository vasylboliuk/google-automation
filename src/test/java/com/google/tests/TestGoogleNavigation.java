package com.google.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.pages.GoogleResultsPage;
import com.google.pages.GoogleSearchPage;

public class TestGoogleNavigation extends TestSetup {
	final static Logger logger = LoggerFactory.getLogger(TestGoogleNavigation.class);

	@Test
	public void googleNavigationTest() throws Exception {
		logger.info("Start: Test navigation on google page.");

		GoogleSearchPage search = new GoogleSearchPage(getDriver());
		search.searchDataInGoogle("Apple");

		GoogleResultsPage result = new GoogleResultsPage(getDriver());
		int countResultsPage1 = result.getNumberOfResults();
		logger.info("Count of result links in 1 page" + String.valueOf(countResultsPage1));

		result = result.navigateToGoogleResultPage(2);
		int countResultsPage2 = result.getNumberOfResults();
		logger.info("Count of result links in 2 page:" + String.valueOf(countResultsPage2));

		result = result.navigateToGoogleResultPage(10);
		int countResultsPage10 = result.getNumberOfResults();
		logger.info("Count of result links in 10 page:" + String.valueOf(countResultsPage10));

		// Verification: Results of Page 2 and 10
		new SoftAssert().assertTrue(countResultsPage2 == countResultsPage10);

		// Verification: Results of Page 1 and 10
		new SoftAssert().assertTrue(countResultsPage1 == countResultsPage10);

		// Verification: Results of Page 1 and 2
		new SoftAssert().assertTrue(countResultsPage1 == countResultsPage2);

		logger.info("END: Test navigation on google page.");

	}

}
