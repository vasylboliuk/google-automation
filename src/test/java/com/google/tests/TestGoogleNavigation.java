package com.google.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.pages.GoogleResultsPage;
import com.google.pages.GoogleSearchPage;

public class TestGoogleNavigation extends TestSetup {
	final static Logger logger = LoggerFactory.getLogger(TestGoogleNavigation.class);

	/**
	 * <b>TC-01: Test navigation on google page.</b>
	 * 
	 * Scenario:
	 * <p>
	 * <ul>
	 * <li>1. Open Firefox browser
	 * <li>2. Open main Google search page
	 * <li>3. In search field type search data: "Apple"
	 * <li>4. Get number of results from first page
	 * <li>5. Navigate to second page -> get number of results from page
	 * <li>6. Navigate to tenth page -> get number of result from page
	 * <li>7. Verify number of results from second with tenth page
	 * <li>8. Verify number of results from first with tenth page
	 * <li>9. Verify number of results from first with second page
	 * </ul>
	 * <p>
	 * Expected Result: The same number of results are displayed as on the
	 * first, second and tenth page.
	 */
	@Test
	public void googleNavigationTest() {
		logger.info("Start: Test navigation on google page.");

		GoogleSearchPage search = new GoogleSearchPage(getDriver());
		GoogleResultsPage result = search.searchDataInGoogle("Apple");

		int countResultsPage1 = result.getNumberOfResults();
		logger.info("Count of result links in 1 page: " + String.valueOf(countResultsPage1));

		result = result.navigateToGoogleResultPage(2);
		int countResultsPage2 = result.getNumberOfResults();
		logger.info("Count of result links in 2 page: " + String.valueOf(countResultsPage2));

		result = result.navigateToGoogleResultPage(10);
		int countResultsPage10 = result.getNumberOfResults();
		logger.info("Count of result links in 10 page: " + String.valueOf(countResultsPage10));

		new SoftAssert().assertEquals(countResultsPage2, countResultsPage10,
				"Results from 2-page are not same from 10-page");

		new SoftAssert().assertEquals(countResultsPage1, countResultsPage10,
				"Results from 1-page are not same from 10-page");

		new SoftAssert().assertEquals(countResultsPage1, countResultsPage2,
				"Results from 1-page are not same from 2-page");

		logger.info("END: Test navigation on google page.");

	}

}
