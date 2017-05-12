package com.testing.demositepageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		//this.driver = driver;
		HomePage.driver = driver;
		//PageFactory.initElements(driver, this);
	}

}
