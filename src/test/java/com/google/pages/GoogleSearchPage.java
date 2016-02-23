package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

	protected WebDriver driver;

	@FindBy(name = "q")
	private WebElement googleSearchField;

	@FindBy(name = "btnG")
	private WebElement googleSearchButton;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		//
		PageFactory.initElements(driver, this);
	}

	private void clickSearchField() {
		this.googleSearchField.click();
	}

	private void clearSearchField() {
		this.googleSearchField.clear();
		;
	}

	private void setSearchingText(String text) {
		this.googleSearchField.sendKeys(text);
	}

	private void clickSearchButton() {
		this.googleSearchButton.click();
	}

	private void setSearchData(String searchData) {
		clickSearchField();
		clearSearchField();
		setSearchingText(searchData);
		clickSearchButton();
	}

	/**
	 * Set search data to Google search field and click on search button.
	 * 
	 * @return result page after searching.
	 */
	public GoogleResultsPage searchDataInGoogle(String searchData) {
		setSearchData(searchData);
		return new GoogleResultsPage(driver);
	}

}
