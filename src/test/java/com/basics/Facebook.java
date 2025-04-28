package com.basics;

import java.time.Duration;

import org.openqa.selenium.By;
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

	@Test(priority = 1)
	public void getTitle() {
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}

	@Test(priority = 2)
	public void getCurrentURL() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
	}
	
	@Test(priority = 3)
	public void getText() {
		String actualText = driver.findElement(By.className("_8eso")).getText();
		Assert.assertEquals(actualText, "Facebook helps you connect and share with the people in your life.");
	}
}