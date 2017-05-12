package com.testing.demositepageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
		ShopPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[contains(@id,'product-')]/div")
	List<WebElement> products;

	public boolean findProductVerifyPrice(String productName, String productPrice){
		for(WebElement e: products){
			if(e.findElement(By.className("product-title")).getText().equals(productName)){
				if (productPrice.equals(e.findElement(By.className("product-price")).getText()))
				{
					return true;
				}
			}
		}
		return false;
	}

	public String addProduct(String productName){
		for(WebElement e: products){
			if(e.findElement(By.className("product-title")).getText().equals(productName)){
				e.findElement(By.linkText("Buy")).click();
				return  e.findElement(By.className("product-price")).getText();
			}
		}
		return "";
	}
}