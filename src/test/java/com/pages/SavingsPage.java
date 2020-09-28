package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavingsPage {
	
WebDriver driver;
	
	public SavingsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSavingsMenu() {
		return savingsMenu;
	}

	public WebElement getSavingsPage() {
		return savingsPage;
	}

	public WebElement getFirstBalance() {
		return firstBalance;
	}

	public List<WebElement> getAccountList() {
		return accountList;
	}

	public WebElement getNewSavings() {
		return newSavings;
	}

	public WebElement getNewSavingsHeading() {
		return newSavingsHeading;
	}

	public WebElement getAccountType() {
		return accountType;
	}

	public WebElement getAccountOwnership() {
		return accountOwnership;
	}

	public WebElement getAccountName() {
		return accountName;
	}

	public WebElement getOpenBal() {
		return openBal;
	}

	public WebElement getSavingSubmit() {
		return savingSubmit;
	}

	public WebElement getViewSavingAcc() {
		return viewSavingAcc;
	}



	@FindBy(id = "savings-menu")
	private WebElement savingsMenu;
	
	@FindBy(linkText = "View Savings")
	private WebElement savingsPage;
	
	@FindBy(xpath = "//*[@id='transactionTable']/tbody/tr[1]/td[5]")
	private WebElement firstBalance;
	
	@FindBy(xpath = "(//div[@class='card-body'][1])")
	private List<WebElement> accountList;
	
	@FindBy(id="new-savings-menu-option")
	private WebElement newSavings;
	
	@FindBy(xpath="//strong[text()='New Savings Account']")
	private WebElement newSavingsHeading;
	
	@FindBy(xpath = "//input[@type='radio']/preceding::label[@for='Savings']")
	private  WebElement accountType;
	
	@FindBy(xpath = "//input[@type='radio']/preceding::label[@for='Individual']")
	private  WebElement accountOwnership;
	
	@FindBy(id = "name")
	private  WebElement accountName;
	
	@FindBy(id = "openingBalance")
	private  WebElement openBal;
	
	@FindBy(id = "newSavingsSubmit")
	private  WebElement savingSubmit;
	
	@FindBy(xpath = "//a[contains(text(),'View Savings')]")
	private  WebElement viewSavingAcc;
	
	
	
}