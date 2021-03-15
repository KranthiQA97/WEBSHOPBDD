package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author Kranthi
 * @description Contains the Welcome Page Web Elements and Action Methods
 */
public class WelcomePage {
	
	WebDriver driver;
	/**
	 * @constructor WelcomePage
	 * @param driver
	 */
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	###############  Welcome Page Web Elements starts here ###################
	
	@FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
	@CacheLookup WebElement accountID;
	
	@FindBy(xpath = "//li[@id='topcartlink']//span[contains(.,'Shopping cart')]")
	WebElement shoppingCartLink;
	
	@FindBy(xpath = "//div[@class='header-links']//a[@class='ico-logout']")
	WebElement logoutButton;
	
	
	
	
	
//	###############  Welcome Page Action Methods starts here ###################
	
	/**
	 * @return
	 */
	public String getAccountID()
	{
		return accountID.getText();
	}
	
	/**
	 * 
	 */
	public void clickShoppingCartLink()
	{
		shoppingCartLink.click();
	}
	
	public void clickLogoutButton()
	{
		logoutButton.click();
	}
}
