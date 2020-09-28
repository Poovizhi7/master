package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stepdefinition.CashDeposit;

public class TransactionPage {

	public TransactionPage() {
		PageFactory.initElements(CashDeposit.driver, this);
	}
	public List<WebElement> getTextHeading() {
		return textHeading;
	}

	public List<WebElement> getTextRow() {
		return textRow;
	}



	@FindBy(tagName = "th")
	private List<WebElement> textHeading;
	
	@FindBy(tagName = "tr")
	private List<WebElement> textRow;
	

	
}
