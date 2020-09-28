package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pagemanager.PageObjectManager;
import com.utitlity.ExcelUtil;

import io.cucumber.java.en.And;

import io.cucumber.java.en.When;


public class SavingAccountCreation {
	
	public static WebDriver driver;
	PageObjectManager page_object_manager;
	String iBalance ;
	String fBalance ;
	String Url;
	String userName;
	String userPassword;
	String userAccountName;
	String userDepositAmount;
	
	private ScenarioContext context;

	public SavingAccountCreation(ScenarioContext context) {
		this.context = context;
	}

	
	@When("User gets {string} to perform savings account opening")
	public void user_gets_to_perform_savings_account_opening(String testCaseId) throws Exception {
		
		System.out.println("****Executing savings account Scenario****");
		Url = ExcelUtil.getMapData().get(testCaseId).get("url");
		userName = ExcelUtil.getMapData().get(testCaseId).get("UserName");
		userPassword = ExcelUtil.getMapData().get(testCaseId).get("Password");
		userAccountName = ExcelUtil.getMapData().get(testCaseId).get("AccountName");
		userDepositAmount = ExcelUtil.getMapData().get(testCaseId).get("DepositAmount");
		context.setUserName(userName);
		context.setPassword(userPassword);
		context.setUrl(Url);
		context.setDepositAccount(userAccountName);
		context.setDepositAmount(userDepositAmount);
	}
	
	@And("User initiate the saving bank account opening")
	public void user_initiate_the_saving_bank_account_opening() {
		try {
			context.getPageObjectManager().getSavings_page().getSavingsMenu().click();
			context.getPageObjectManager().getSavings_page().getNewSavings().click();
			 Assert.assertTrue("Savings Account creation Page",
					 context.getPageObjectManager().getSavings_page()
			 .getNewSavingsHeading().getText().equals("New Savings Account"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User inputs the AccountName, DepositAmount to complete the savings account opening")
	public void user_inputs_the_AccountName_DepositAmount_to_complete_the_savings_account_opening() {

		try {

			context.getPageObjectManager().getSavings_page().getAccountType().click();
			context.getPageObjectManager().getSavings_page().getAccountOwnership().click();
			context.getPageObjectManager().getSavings_page().getAccountName().sendKeys(userAccountName);
			context.getPageObjectManager().getSavings_page().getOpenBal().sendKeys(userDepositAmount);
			context.getPageObjectManager().getSavings_page().getSavingSubmit().click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User can able to view the newly created account with AccountName successfully")
	public void user_can_able_to_view_the_newly_created_account_with_AccountName_successfully() {
		try {
			context.getPageObjectManager().getSavings_page().getSavingsMenu().click();
			context.getPageObjectManager().getSavings_page().getViewSavingAcc().click();
			List<WebElement> aclist = context.getPageObjectManager().getSavings_page().getAccountList();
			String accountname = null;
			for (int i = 0; i < aclist.size(); i++) {
				accountname = aclist.get(i).getText();
				if (accountname.contains(userAccountName)) {
					System.out.println(accountname);
					Assert.assertTrue(accountname, accountname.contains(userAccountName));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
