package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kranthi
 * @description Contains the Login Page Web Elements and Action Methods
 */
public class LoginPage {
	
	WebDriver driver;
	/**
	 * @constructor WelcomePage
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	###############  Login Page Web Elements starts here ###################
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
	@CacheLookup WebElement welcomeText;
	
	@FindBy(css =  "#Email")
	@CacheLookup WebElement emailTextbox;
	
	@FindBy(css =  "#Password")
	@CacheLookup WebElement passwordTextbox;
	
	@FindBy(css =  "input[value='Log in']")
	@CacheLookup WebElement loginButton;
	
	
//	###############  Login Page Action Methods starts here ###################
	
	/**
	 * @name getWelcomeText
	 * @return Welcome Warning error message
	 * @description
	 */
	public String getWelcomeText()
	{
		return welcomeText.getText();
	}
	
	/**
	 * @return
	 */
	public WebElement enterEmail()
	{
		return emailTextbox;
	}
	
	/**
	 * @return
	 */
	public WebElement enterPassword()
	{
		return passwordTextbox;
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}

}
