package com.google.tests;




import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.google.pages.GoogleResultsPage;
import com.google.pages.GoogleSearchPage;

public class TestGoogleNavigation extends TestSetup {
		
	@Test
	public void googleNavigationTest() throws Exception{
		System.out.println("Test navigation.");
				
		GoogleSearchPage search = new GoogleSearchPage(getDriver());
		search.searchDataInGoogle("Apple");
		
		GoogleResultsPage result = new GoogleResultsPage(getDriver());
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
