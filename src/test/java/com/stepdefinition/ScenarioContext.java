package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.pagemanager.PageObjectManager;

public class ScenarioContext {
	
	private PageObjectManager pageObjectManager;
	private WebDriver driver;
	private String url;
	private String userName;
	private String password;
	private String depositAccount;
	private String depositAmount;
	

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public void setPageObjectManager(PageObjectManager pageObjectManager) {
		this.pageObjectManager = pageObjectManager;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepositAccount() {
		return depositAccount;
	}

	public void setDepositAccount(String depositAccount) {
		this.depositAccount = depositAccount;
	}

	public String getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}
	
}
