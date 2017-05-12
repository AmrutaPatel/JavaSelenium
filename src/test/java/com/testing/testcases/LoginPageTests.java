package com.testing.testcases;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import junit.framework.Assert;
import com.testing.demositepageobjects.HomePage;
import com.testing.demositepageobjects.LoginPage;

@SuppressWarnings("deprecation")
public class LoginPageTests extends BaseTestSuite {

	@Test
	public void testInvalidLogin() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.navigateLogin();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		loginPage.Login("XXX", "XXX",true);
		Assert.assertEquals("Invalid login message is displayed.", "Your login details are incorrect", loginPage.getErrorMessage());
	}

	@Test
	public void testValidLogin(){
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.navigateLogin();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		loginPage.Login("user1", "letmein",true);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertEquals("Successful login message is displayed.", "Welcome to Jupiter Toys, a magical world for good girls and boys.", loginPage.getWelcomeMessage());
	}
}
