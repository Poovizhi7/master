package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LaunchPage {
	WebDriver driver;

	public LaunchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLstConfirmText() {
		return lstConfirmText;
	}
	
	
	@FindBy(linkText="Sign Up Here")
	private WebElement lstConfirmText;
	
	public void confirmLaunch() {
		Assert.assertTrue("Launch Page Assert",getLstConfirmText().getText().equalsIgnoreCase("Sign Up Here"));
		System.out.println("Launch page is verifed Successfully");
	}
}
