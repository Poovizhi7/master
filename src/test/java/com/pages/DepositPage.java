package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class DepositPage {

	WebDriver driver;

	public DepositPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[4]/a")
	private WebElement transfersPage;

	@FindBy(linkText = "Deposit")
	private WebElement depositPage;

	@FindBy(id = "id")
	private WebElement depositAccount;

	@FindBy(id = "amount")
	private WebElement depositAmount;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='right-panel']/div[2]/div/div/div/div/div/strong")
	private WebElement assertDepositPage;

	@FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[1]/td[5]")
	private WebElement finalBalance;

	public WebElement getFinalBalance() {
		return finalBalance;
	}

	public WebElement getTransfersPage() {
		return transfersPage;
	}

	public WebElement getDepositPage() {
		return depositPage;
	}

	public WebElement getDepositAccount() {
		return depositAccount;
	}

	public WebElement getDepositAmount() {
		return depositAmount;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getAssertDepositPage() {
		return assertDepositPage;
	}

	public void gotoDepositPage() {
		getTransfersPage().click();
		getDepositPage().click();
		Assert.assertTrue("Deposit Page Assertion", getAssertDepositPage().getText().equals("Deposit into Account"));
		System.out.println("Deposit Page is verified successfully");
	}


	public void performDeposit(String accountForDeposit, String depositAmount) {
		Select account = new Select(getDepositAccount());
		account.selectByValue(accountForDeposit);
		getDepositAmount().sendKeys(depositAmount);
		getSubmitButton().click();
	}
	
	public String getBalancePostDeposit() {
		String fBalance = getFinalBalance().getText();
		return fBalance;
	}
	public void verifyDeposit(String depositAmount, String iBalance,String finalBalance) {
		String substr1 = iBalance.substring(1, 6);
		double beforeamt = Double.parseDouble(substr1);
		System.out.println("balance before deposit : " + beforeamt);
		double depositamt = Double.parseDouble(depositAmount);
		String substr2 = finalBalance.substring(1, 6);
		double finalamt = Double.parseDouble(substr2);
		System.out.println("balance after deposit : " + finalamt);
		Assert.assertEquals("Deposit Transfer success Assertion", (beforeamt + depositamt), finalamt, 0.0);
		System.out.println("Deposit is successful");
	}
}
