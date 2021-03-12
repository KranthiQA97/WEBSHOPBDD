package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kranthi
 * @comments Creating the Home Page Web Elements and Action Methods
 */
public class HomePage {
	
	WebDriver driver;
	
	/**
	 * @name HomePage
	 * @param driver
	 * @description initializing the HomePage Web Elements
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	###############  Home Page Web Elements starts here ###################
	
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	@CacheLookup WebElement loginLink;
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
	@CacheLookup WebElement welcomeText;
	
	@FindBy(css =  "#Email")
	@CacheLookup WebElement emailTextbox;
	
	@FindBy(css =  "#Password")
	@CacheLookup WebElement passwordTextbox;
	
	@FindBy(css =  "input[value='Log in']")
	@CacheLookup WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
	@CacheLookup WebElement accountID;
	
	
//	###############  Home Page Action Methods starts here ###################
	
	/**
	 * @name clickLoginLink
	 * @description By using this method we can click the Log in link in the home page
	 */
	public void clickLoginLink()
	{
		loginLink.click();
	}
	
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
	
	public String getAccountID()
	{
		return accountID.getText();
	}
	
	
	
	

}
