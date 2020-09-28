package com.stepdefinition;
import com.utitlity.ExcelUtil;


import org.openqa.selenium.WebDriver;
import com.pagemanager.PageObjectManager;
import io.cucumber.java.en.*;


public class CashDeposit {

	public static WebDriver driver;
	PageObjectManager page_object_manager;
	String iBalance ;
	String fBalance ;
	String Url;
	String userName;
	String userPassword;
	String userDepositAccount;
	String userDepositAmount;
	
	private ScenarioContext context;

	public CashDeposit(ScenarioContext context) {
		this.context = context;
	}
	
	@Given("User gets {string} to perform  deposit into account")
	public void user_gets_to_perform_deposit_into_account(String testCaseId) throws Exception {
		
		System.out.println("****Executing Cash Deposit Scenario****");
		Url = ExcelUtil.getMapData().get(testCaseId).get("url");
		userName = ExcelUtil.getMapData().get(testCaseId).get("UserName");
		userPassword = ExcelUtil.getMapData().get(testCaseId).get("Password");
		userDepositAccount = ExcelUtil.getMapData().get(testCaseId).get("AccountForDeposit");
		userDepositAmount = ExcelUtil.getMapData().get(testCaseId).get("DepositAmount");
		context.setUserName(userName);
		context.setPassword(userPassword);
		context.setUrl(Url);
		context.setDepositAccount(userDepositAccount);
		context.setDepositAmount(userDepositAmount);
	}

	@When("User gets the inital balance from Savings page")
	public void user_gets_the_inital_balance_from_Savings_page() {
//		iBalance = context.getPageObjectManager().getSavings_page().getAccountBalance();
	}

	@When("User initiates the deposit into account")
	public void user_initiates_the_deposit_into_account() {
		context.getPageObjectManager().getDeposit_page().gotoDepositPage();
	}

	@When("User inputs the accountForDeposit and depositAmount to complete the deposit")
	public void user_inputs_the_data_to_complete_the_deposit() {
		context.getPageObjectManager().getDeposit_page().performDeposit(userDepositAccount, userDepositAmount);
		fBalance = context.getPageObjectManager().getDeposit_page().getBalancePostDeposit();
		context.getPageObjectManager().getDeposit_page().verifyDeposit(userDepositAmount, iBalance, fBalance);
	}

}
