package com.basics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class Facebook {
	WebDriver driver;

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@Test
	public void getTitle() {
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}

	@Test
	public void getCurrentURL() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
	}
}