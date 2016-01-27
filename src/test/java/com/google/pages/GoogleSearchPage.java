package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.pages.GoogleResultsPage;

public class GoogleSearchPage {
	
	protected WebDriver driver;
	//
	@FindBy(name="q")
	private WebElement googleSearchField;
	//
	@FindBy(name ="btnG")
	private WebElement googleSearchButton;
	
	
	//GoogleSearchPage page constructor
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		//
		PageFactory.initElements(driver, this);
	}
		
	
	//Click on Google Search field
	private void clickSearchField() {
		this.googleSearchField.click();
	}
	//Clear data
	private void clearSearchField() {
		this.googleSearchField.clear();;
	}
	
	//Type searching text
	private void setSearchingText(String text) {
		this.googleSearchField.sendKeys(text);
	}
	
	//Click Submit button
	private void clickSearchButton() {
		this.googleSearchButton.click();
	}
	
	//Business Logic
	private void setSearchData(String searchData) throws Exception {
		clickSearchField();
		clearSearchField();
		setSearchingText(searchData);
		clickSearchButton();
	}
	
	public GoogleResultsPage searchDataInGoogle(String searchData) throws Exception {
		setSearchData(searchData);
		return new GoogleResultsPage(driver);
	}
	
}
