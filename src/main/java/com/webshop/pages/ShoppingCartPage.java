package com.webshop.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {
	
	WebDriver driver;
	
	/**
	 * @param driver
	 */
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	###############  Shopping Cart Page Web Elements starts here ###################
	
	@FindBy(xpath = "//input[@type='checkbox' and @name='removefromcart']")
	@CacheLookup List<WebElement> removeCheckBoxes;
	
	@FindBy(xpath = "//span[text()='Price:']//following-sibling::span")
	@CacheLookup List<WebElement> addedbooksPrice;
	
	@FindBy(xpath = "//span[contains(text(),'Sub-Total:')]/../following-sibling::td//span[@class='product-price']")
	WebElement subtotal;
	
	@FindBy(css = "input[name='updatecart']")
	@CacheLookup WebElement updateCartButton;
	
	@FindBy(css = "button#checkout")
	@CacheLookup WebElement checkoutButton;
	
	@FindBy(css = "input[name='termsofservice']")
	WebElement termsCheckBox;
	
	@FindBy(css = "select#billing-address-select")
	WebElement billingAddress;
	
	@FindBy(xpath = "//select[@id='shipping-address-select']")
	WebElement shippingAddress;
	
	@FindBy(xpath = "//div[@id='billing-buttons-container']//input[@title='Continue']")
	WebElement billingContinueButton;
	
	@FindBy(xpath = "//*[@id='shipping-buttons-container']/input")
	WebElement shippingContinueButton;
	
	@FindBy(xpath = "//*[@id='shipping-method-buttons-container']/input")
	WebElement shippingMethodContinueButton;
	
	@FindBy(xpath = "//*[@id='payment-method-buttons-container']/input")
	WebElement payMetodContinueButton;
	
	@FindBy(xpath = "//*[@id='payment-info-buttons-container']/input")
	WebElement payInfoContinueButton;
	
	@FindBy(xpath = "//input[@id='shippingoption_1']")
	WebElement nextDayAirRadioButton;
	
	@FindBy(xpath = "//label[contains(.,'COD')]/../input[@name='paymentmethod']")
	WebElement codRadioButton;
	
	@FindBy(xpath = "//h2[contains(text(),'Payment information')]/../..//td/p")
	WebElement paymentInfoMsg;
	
	@FindBy(xpath = "//*[@id='confirm-order-buttons-container']/input")
	WebElement orderConfirmButton;
	
	
	
//	###############  Shopping Cart Page Action Methods starts here ###################
	
	/**
	 * 
	 */
	public void checkAllRemoveCheckBoxes()
	{
		for (WebElement webElement : removeCheckBoxes) {
			webElement.click();
		}
	}
	
	/**
	 * 
	 */
	public void clickUpdateCartButton()
	{
		updateCartButton.click();
	}
	
	/**
	 * @return
	 */
	public String getFirstBookPrice()
	{
		int totalAddedBooks = addedbooksPrice.size();
		String priceOfBook = null;
		for (int i = 0; i < totalAddedBooks; i++) {
			if(!addedbooksPrice.isEmpty() && i==0)
			{
				priceOfBook = addedbooksPrice.get(i).getText();
			}
		}
		return priceOfBook;
	}
	
	/**
	 * @return
	 */
	public String getSubtotal()
	{
		return subtotal.getText();
	}
	
	/**
	 * 
	 */
	public void clickCheckOutButton()
	{
		checkoutButton.click();
	}
	
	/**
	 * 
	 */
	public void clickTermsCheckBox()
	{
		termsCheckBox.click();
	}
	
	/**
	 * 
	 */
	public void selectNewBillingAddress()
	{
		Select address = new Select(billingAddress);
		address.selectByIndex(2);
	}
	
	/**
	 * 
	 */
	public void selectNewShippingAddress()
	{
		Select address = new Select(shippingAddress);
		address.selectByIndex(2);
	}
	
	/**
	 * 
	 */
	public void clickBillingContinueButton()
	{
		billingContinueButton.click();
	}
	
	/**
	 * 
	 */
	public void clickShippingContinueButton()
	{
		shippingContinueButton.click();
	}
	
	/**
	 * 
	 */
	public void clickShippingMethodContinueButton()
	{
		shippingMethodContinueButton.click();
	}
	
	/**
	 * 
	 */
	public void clickPayMetodContinueButton()
	{
		payMetodContinueButton.click();
	}
	
	/**
	 * 
	 */
	public void clickNextDayAirRadioButton()
	{
		nextDayAirRadioButton.click();
	}
	
	/**
	 * 
	 */
	public void clickCODButton()
	{
		codRadioButton.click();
	}
	
	/**
	 * @return
	 */
	public String getPaymentInfoText()
	{
		return paymentInfoMsg.getText();
	}
	
	

}
