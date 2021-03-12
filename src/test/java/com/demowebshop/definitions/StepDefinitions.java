package com.demowebshop.definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.webshop.drivermanager.BaseClass;
import com.webshop.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepDefinitions extends BaseClass {
	public static WebDriver driver;
	public static HomePage hp;

	@Given("user should be navigate to the given url")
	public void user_should_be_navigate_to_the_given_url() {
		driver = initializeDriver();
		hp = new HomePage(driver);
	}

	@Then("click on the login button and validate the warning message")
	public void click_on_the_login_button_and_validate_the_warning_message() {
		hp.clickLoginLink();
		String welcomeText = hp.getWelcomeText();
		Assert.assertEquals(prop.getProperty("warningtext"), welcomeText);
	}
	
	@Then("enter valid email and password and click on login button")
	public void enter_valid_email_and_password_and_click_on_login_button() {
		hp.enterEmail().sendKeys(prop.getProperty("username"));
		hp.enterPassword().sendKeys(prop.getProperty("password"));
		hp.clickLoginButton();
	}
	
	@Then("validate the user account id at the top right corner")
	public void validate_the_user_account_id_at_the_top_right_corner() {
		String accountID = hp.getAccountID();
		Assert.assertEquals(prop.getProperty("username"), accountID);
	}
	
	
	
	
	
	
}
