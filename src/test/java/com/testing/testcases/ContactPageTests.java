package com.testing.testcases;

import org.junit.Test;

import com.testing.demositepageobjects.ContactPage;
import com.testing.demositepageobjects.HomePage;

import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class ContactPageTests extends BaseTestSuite {

	@Test
	public void testMandatoryFieldErrorMessages() {
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.navigateContact();
		contactPage.clickSubmit();
		
		Assert.assertEquals("Error message is displayed for Forename field", "Forename is required", contactPage.getFirstNameError());
		Assert.assertEquals("Error message is displayed for Email field", "Email is required", contactPage.getEmailError());
		Assert.assertEquals("Error message is displayed for Message field", "Message is required", contactPage.getMessageError());
		
		contactPage.setFirstName("Testing");
		contactPage.setEmail("test@testing.com.au");
		contactPage.setMessage("Welcome to testing!");
		
		Assert.assertEquals("Error message is not displayed for Forename field", "", contactPage.getFirstNameError());
		Assert.assertEquals("Error message is not displayed for Email field", "", contactPage.getEmailError());
		Assert.assertEquals("Error message is not displayed for Message field", "", contactPage.getMessageError());
	}
	
	
	@Test
	public void testInvalidFieldErrorMessages() {
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.navigateContact();
		
		contactPage.setTelephone("asd3$@#$");
		contactPage.setEmail("test@");
				
		Assert.assertEquals("Inavlid Telephone number message is displayed", "Please enter a valid telephone number", contactPage.getTelephoneError());
		Assert.assertEquals("Inavlid Email message is displayed", "Please enter a valid email", contactPage.getEmailError());
	}
	
	@Test
	public void testContactIsSubmittedSuccessfully() {
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.navigateContact();
		contactPage.setFirstName("Dan");
		contactPage.setEmail("dan@jupiter.com");
		contactPage.setMessage("Welcome to web automation!");
		contactPage.clickSubmit();
		Assert.assertEquals("Successful submission message is displayed", "Thanks Dan, we appreciate your feedback.", contactPage.getSuccessMessage());
	}
}

