package com.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebCommonSteps {
	
	WebDriver driver;
	PageObjectManager page_object_manager;
	String caseId;
	int rowNum;
	private ScenarioContext context;
	String Url;
	String userName;
	String userPassword;
	
	public WebCommonSteps(ScenarioContext context) {
		
		this.context = context;
		
	}
	
	
	@When("Launch the digital bank application url in browser")
	public void launch_the_digital_bank_application_in_browser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String url = context.getUrl(); 
		driver.get(url);
		driver.manage().window().maximize();
		page_object_manager = new PageObjectManager(driver);
		page_object_manager.getLaunch_page().confirmLaunch();

	}
	
	@When("User enters the username and password to log in to application")
	public void user_enters_the_and_to_log_in_to_application() {
		
		page_object_manager.getLogin_page().performLogin(context.getUserName(), context.getPassword());
		context.setPageObjectManager(page_object_manager);
	}
	
	@Then("User logs out of the application")
	public void user_logs_out_of_the_application() {
		page_object_manager.getLogout().performLogout();
		
	}



}
