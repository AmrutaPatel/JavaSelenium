package com.testing.demositepageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		//this.driver = driver; //gives warning: The static field BasePage.driver should be accessed in a static way 
		CartPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Empty Cart")
	WebElement btnEmptyCart;
	
	@FindBy(linkText ="Yes")
	WebElement btnEmptyCartYes;
	
	@FindBy(className = "btn.btn-cancel.btn-danger")
	WebElement btnEmptyCartNo;
	
	public void clickEmptyCart(boolean emptyCart){
		String switchToMainWindow = driver.getWindowHandle();
		btnEmptyCart.click();
		String switchToPopUpWindow = driver.getWindowHandle();
		driver.switchTo().window(switchToPopUpWindow);
		if(emptyCart){
			btnEmptyCartYes.click();
		}
		else{
			btnEmptyCartNo.click();
		}
		
		driver.switchTo().window(switchToMainWindow);
	}
	
	
	
}