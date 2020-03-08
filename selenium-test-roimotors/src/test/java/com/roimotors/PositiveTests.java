package com.roimotors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {


	@Test
	public void websiteTest() {
		System.out.println("Starting websiteTest");


		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		// maximize browser window
		driver.manage().window().maximize();
		sleep(1000);

// Browse to the website
		String url = "https://www.roimotors.com/";
		driver.get(url);
		System.out.println("Page is opened");

		// not accepting cookies is causing errors, so we will do that
		WebElement cookieAcceptor = driver.findElement(By.xpath(
				"//button[@class='btn btn-primary consumer-privacy-banner-button flex-shrink-0 w-auto mt-3 mt-sm-0 ml-sm-3 mb-sm-3']"));
		cookieAcceptor.click();

// Search for a specific new vehicle (which has custom photos)
		WebElement searchIcon = driver.findElement(By
				.xpath("//button[@class='btn btn-link text-no-decoration']"));
		searchIcon.click();
		WebElement searchBar = driver.findElement(
				By.xpath("//input[@class='form-control site-text-search-input font-size-ios-zoom-override']"));
		searchBar.sendKeys("2020 Honda Accord");
		sleep(1000);
		searchBar.sendKeys(Keys.ENTER);
		System.out.println("Searched For 2020 Honda Accord");

// Open the Vehicle Details Page (VDP)
		WebElement firstSearchResult = driver.findElement(By.cssSelector(
				"#site-text-search1-app-root > div > div > div:nth-child(1) > div > nav > ul > li:nth-child(1) > a"));
		firstSearchResult.click();

		WebElement firstVehicleListing = driver.findElement(By.xpath(
				"//div[@id='inventory-results1-app-root']/div[@role='region']/ul/li[1]/div[1]/div[@class='vehicle-card-details-container']/h2/a[@href='/new/Honda/2020-Honda-Accord-burlington-a897bbe00a0a00f95adba92b2c306c38.htm']"));

		firstVehicleListing.click();

		String expectedUrl = "https://www.roimotors.com/new/Honda/2020-Honda-Accord-burlington-a897bbe00a0a00f95adba92b2c306c38.htm";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
		System.out.println("Opened VDP");

// Open up the photos slideshow
		WebElement slideShowLink = driver.findElement(By.cssSelector(
				"#media1-app-root > div > div.media-gallery-toolbar.border.m-4.absolute-bottom.absolute-left.d-print-none > div > div > div:nth-child(1) > a"));
		slideShowLink.click();
		System.out.println("Opened Slideshow");

// Scroll through a few photos
		WebElement rightArrow = driver.findElement(By.xpath(
				"//button[@class='btn-carousel p-0 mr-4 pswp__button pswp__button--arrow--right  visible btn']"));
		rightArrow.click();
		rightArrow.click();
		rightArrow.click();
		rightArrow.click();
		WebElement leftArrow = driver.findElement(By
				.xpath("//button[@class='btn-carousel p-0 ml-4 pswp__button pswp__button--arrow--left  visible btn']"));
		leftArrow.click();
		System.out.println("Clicked through slideshow");

// Close the photos slideshow
		WebElement slideshowEsc = driver
				.findElement(By.xpath("//button[@class='pswp__button pswp__button--close']"));
		slideshowEsc.click();
		System.out.println("Closed slideshow");

// Read the "Highlighted Features"
		// TODO: implement loop to remove duplicate code
		WebElement highlightedFeature0 = driver
				.findElement(By.cssSelector("div#hl-features1-app-root > ul > li:nth-of-type(1)"));
		WebElement highlightedFeature1 = driver
				.findElement(By.cssSelector("div#hl-features1-app-root > ul > li:nth-of-type(2)"));
		WebElement highlightedFeature2 = driver
				.findElement(By.cssSelector("div#hl-features1-app-root > ul > li:nth-of-type(3)"));
		WebElement highlightedFeature3 = driver
				.findElement(By.cssSelector("div#hl-features1-app-root > ul > li:nth-of-type(4)"));
		WebElement highlightedFeature4 = driver
				.findElement(By.cssSelector("div#hl-features1-app-root > ul > li:nth-of-type(5)"));
		WebElement highlightedFeature5 = driver
				.findElement(By.cssSelector("div#hl-features1-app-root > ul > li:nth-of-type(6)"));
		WebElement highlightedFeature6 = driver
				.findElement(By.cssSelector("div#hl-features1-app-root > ul > li:nth-of-type(7)"));
		WebElement highlightedFeature7 = driver
				.findElement(By.cssSelector("div#hl-features1-app-root > ul > li:nth-of-type(8)"));

		String expectedFeature0 = "Lane departure";
		String expectedFeature1 = "Speed limit sign recognition";
		String expectedFeature2 = "Distance pacing cruise control";
		String expectedFeature3 = "Automatic temperature control";
		String expectedFeature4 = "Wireless phone connectivity";
		String expectedFeature5 = "Exterior parking camera rear";
		String expectedFeature6 = "Front dual zone A/C";
		String expectedFeature7 = "Auto high-beam headlights";
		String actualFeature0 = highlightedFeature0.getText();
		String actualFeature1 = highlightedFeature1.getText();
		String actualFeature2 = highlightedFeature2.getText();
		String actualFeature3 = highlightedFeature3.getText();
		String actualFeature4 = highlightedFeature4.getText();
		String actualFeature5 = highlightedFeature5.getText();
		String actualFeature6 = highlightedFeature6.getText();
		String actualFeature7 = highlightedFeature7.getText();

		Assert.assertEquals(actualFeature0, expectedFeature0,
				"Actual feature does not contain expected feature.\nActual Feature: " + actualFeature0
						+ "\nExpected Feature: " + expectedFeature0);
		Assert.assertEquals(actualFeature1, expectedFeature1,
				"Actual feature does not contain expected feature.\nActual Feature: " + actualFeature1
						+ "\nExpected Feature: " + expectedFeature1);
		Assert.assertEquals(actualFeature2, expectedFeature2,
				"Actual feature does not contain expected feature.\nActual Feature: " + actualFeature2
						+ "\nExpected Feature: " + expectedFeature2);
		Assert.assertEquals(actualFeature3, expectedFeature3,
				"Actual feature does not contain expected feature.\nActual Feature: " + actualFeature3
						+ "\nExpected Feature: " + expectedFeature3);
		Assert.assertEquals(actualFeature4, expectedFeature4,
				"Actual feature does not contain expected feature.\nActual Feature: " + actualFeature4
						+ "\nExpected Feature: " + expectedFeature4);
		Assert.assertEquals(actualFeature5, expectedFeature5,
				"Actual feature does not contain expected feature.\nActual Feature: " + actualFeature5
						+ "\nExpected Feature: " + expectedFeature5);
		Assert.assertEquals(actualFeature6, expectedFeature6,
				"Actual feature does not contain expected feature.\nActual Feature: " + actualFeature6
						+ "\nExpected Feature: " + expectedFeature6);
		Assert.assertEquals(actualFeature7, expectedFeature7,
				"Actual feature does not contain expected feature.\nActual Feature: " + actualFeature7
						+ "\nExpected Feature: " + expectedFeature7);

		System.out.println("Actual features are as expected.");
// Check the Internet Price.
		// note - Internet Price is now Detailed Pricing.
		WebElement totalPriceValue = driver.findElement(
				By.xpath("//div[@id='detailed-pricing1-app-root']/div/dl[1]/dd[4]/span[@class='price-value']"));
		String actualTotalPriceValue = totalPriceValue.getText();
		String expectedTotalPriceValue = "$23,800";
		Assert.assertEquals(actualTotalPriceValue, expectedTotalPriceValue,
				"Actual Total Price Value is not as expected.");


		sleep(3000);
		// Close browser
		driver.quit();

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
