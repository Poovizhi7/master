package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stepdefinition.CashDeposit;

public class FundTransferPage {
	
	public FundTransferPage() {
		PageFactory.initElements(CashDeposit.driver, this);
	}

	public List<WebElement> getLstSender() {
		return lstSender;
	}

	public List<WebElement> getLstReceiver() {
		return lstReceiver;
	}

	public List<WebElement> getLstAmount() {
		return lstAmount;
	}

	public List<WebElement> getLstSubmitButton() {
		return lstSubmitButton;
	}

	@FindBy(id="fromAccount")
	private List<WebElement> lstSender;
	
	@FindBy(id="toAccount")
	private List<WebElement> lstReceiver;
	
	@FindBy(id="amount")
	private List<WebElement> lstAmount;
	
	@FindBy(xpath ="//button[@type='submit']")
	private List<WebElement> lstSubmitButton;
}
