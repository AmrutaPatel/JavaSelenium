package com.testing.testcases;

import org.junit.Test;
import com.testing.demositepageobjects.HomePage;
import com.testing.demositepageobjects.ShopPage;


public class ShopPageTests extends BaseTestSuite {

	@SuppressWarnings("deprecation")
	@Test
	public void testProductAndPrice() {
		HomePage homePage = new HomePage(driver);
		ShopPage shopPage = homePage.navigateShop();
		junit.framework.Assert.assertTrue(shopPage.findProductVerifyPrice("Smiley Bear", "$14.99"));
	}
	
	@Test
	public void testAddProduct() {
		HomePage homePage = new HomePage(driver);
		ShopPage shopPage = homePage.navigateShop();
		String price = shopPage.addProduct("Funny Cow");
		System.out.println("Price " + price);
	}

}
