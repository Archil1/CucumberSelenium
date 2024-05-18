package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;

	// As a generic we are passing WebDriver
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * this method is used to initialize the ThreadLocal driver on the basis of
	 * given browser 
	 * @param browser
	 * @return this will return the driver
	 */
	public WebDriver init_driver(String browser) {
		// TheadLocal set() will set a browser for the current thread's copy
		System.out.println("browser value is " + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() {

		/*
		 * tlDriver.get() will return the value in the current thread's copy which in
		 * this case is the driver we are initializing And we are also creating
		 * getDriver() method to fetch the driver
		 */
		return tlDriver.get();
	}
}
