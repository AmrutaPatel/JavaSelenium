package com.testing.testcases;

import org.junit.Test;

import com.testing.demositepageobjects.CartPage;
import com.testing.demositepageobjects.HomePage;
import com.testing.demositepageobjects.ShopPage;

import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class CartPageTests extends BaseTestSuite {

	@Test
	public void testCartCount() {
		HomePage homePage = new HomePage(driver);
		CartPage cartPage = homePage.navigateCart();
		
		if(cartPage.getCartCount()==0){
			ShopPage shopPage =	homePage.navigateShop();
			shopPage.addProduct("Teddy Bear");
			if(cartPage.getCartCount()==1){
				cartPage= homePage.navigateCart();
				cartPage.clickEmptyCart(true);
				if(cartPage.getCartCount()==0){
					Assert.assertTrue("Cart count is added and removed as expected", true);
				}
				else{
					Assert.assertTrue("Cart count is not added and removed as expected", false);
				}
			}
		}
		else{
			Assert.assertTrue("Cart count is not 0 as expected", false);
		}
	}

}
