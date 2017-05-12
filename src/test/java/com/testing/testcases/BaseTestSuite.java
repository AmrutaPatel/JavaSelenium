package com.testing.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTestSuite {
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","src//test//resources//drivers//chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {
		driver.manage().deleteAllCookies();
		driver.navigate().to("http://jupiter.cloud.planittesting.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}