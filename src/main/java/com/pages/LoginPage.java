package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	// 1. by locators private in nature
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInBtn = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?111");

	// 2. Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// 3. page actions :features (behavior) of the page the form of methods
	// assertions should not be in these class
	// assertions should be in step definitions or test class
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExists() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signInBtn).click();
	}

	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with "+un+"and password "+pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		/*
		 * if a page method is redirecting to an another page it's responsibility 
		 * is to return the object of that new page
		 */
		return new AccountsPage(driver);
	}
}
