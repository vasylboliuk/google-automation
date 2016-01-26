package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultsPage {
	protected WebDriver driver;
	
	
	
	public GoogleResultsPage(WebDriver driver) {
		this.driver = driver;
		//
		PageFactory.initElements(driver, this);
	}
	
	//Click on result link in page
	public void clickOnResultLinkInPage(){
		driver.findElement(By.xpath("//div[@class='g'][1]//ancestor::h3//a")).click();
	}
	
	public GoogleTranslatePage navigateToGoogleTranslate() throws Exception {
		clickOnResultLinkInPage();
		return new GoogleTranslatePage(driver);
	}
	
}
