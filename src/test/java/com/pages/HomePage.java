package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stepdefinition.CashDeposit;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(CashDeposit.driver, this);
	}

	public List<WebElement> getLstTransfer() {
		return lstTransfer;
	}

	public List<WebElement> getLstBetweenAccount() {
		return lstBetweenAccount;
	}

	public List<WebElement> getLstConfirmText() {
		return lstConfirmText;
	}

	@FindBy(linkText = "Transfer")
	private List<WebElement> lstTransfer;

	@FindBy(linkText = "Between Accounts")
	private List<WebElement> lstBetweenAccount;

	@FindBy(xpath = "//strong[@class='card-title text-white']")
	private List<WebElement> lstConfirmText;
}
