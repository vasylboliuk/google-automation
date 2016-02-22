package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleTranslatePage {

	protected WebDriver driver;
	//
	@FindBy(id = "source")
	private WebElement translateLeftField;
	//
	@FindBy(id = "result_box")
	private WebElement translateRightField;
	//
	@FindBy(id = "gt-tl-gms")
	private WebElement listBoxLanguages;
	//
	@FindBy(xpath = "//span[@id='result_box']/span")
	private WebElement translatedData;
	//
	@FindBy(id = "gt-submit")
	private WebElement translateButton;

	private String dataForTranslate;


	public GoogleTranslatePage(WebDriver driver) {
		this.driver = driver;
		//
		PageFactory.initElements(driver, this);
	}

	public String getDataForTranslation() {
		return dataForTranslate;
	}

	public String getTranslatedData() {
		return this.translatedData.getText();
	}

	private void clickLeftField() {
		this.translateLeftField.click();
	}

	private void setData(String text) {
		this.translateLeftField.sendKeys(text);
	}

	public void clickTranslateButton() {
		this.translateButton.click();
	}

	private void clicklistBoxLanguages() {
		this.listBoxLanguages.click();
	}

	private void selectLanguage() {
		driver.findElement(By.xpath("//div[@id='gt-tl-sugg']/div[2]")).click();

	}

	// Business Logic
	public void changLanguage() {
		clicklistBoxLanguages();
		selectLanguage();
	}

	public void setTranslateData(String dataForTranslate) throws Exception {
		this.dataForTranslate = dataForTranslate;
		clickLeftField();
		setData(getDataForTranslation());
	}

}
