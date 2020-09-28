package com.pages;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLstTextUserName() {
		return lstTextUserName;
	}

	public WebElement getLstTextPassword() {
		return lstTextPassword;
	}

	public WebElement getLstLoginButton() {
		return lstLoginButton;
	}

	public WebElement getLstWelcomeText() {
		return lstWelcomeText;
	}

	@FindBy(id = "username")
	private  WebElement lstTextUserName;
	
	@FindBy(id = "password")
	private  WebElement lstTextPassword;
	
	@FindBy(id = "submit")
	private  WebElement lstLoginButton;

	
	@FindBy(xpath = "//h4[@class='mb-3']")
	private WebElement lstWelcomeText;
	
	public void performLogin(String userName, String password) {
		
		getLstTextUserName().sendKeys(userName);
		getLstTextPassword().sendKeys(password);
		getLstLoginButton().click();
		Assert.assertTrue("Login Page Assertion",getLstWelcomeText().getText().equals("Account Balance Summary"));
		System.out.println("Login page is verified Successfully");
	}
	
}


