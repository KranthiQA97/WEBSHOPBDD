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
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement billingAddressCountry;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	WebElement addressLine1;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement zipCode;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement phoneNumber;
	
	@FindBy(xpath = "//select[@id='shipping-address-select']")
	WebElement shippingAddress;
	
	@FindBy(xpath = "//div[@id='billing-buttons-container']//input")
	WebElement billingContinueButton;
	
	@FindBy(xpath = "//div[@id='shipping-buttons-container']//input")
	WebElement shippingAddressContinueButton;
	
	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']//input")
	WebElement shippingMethodContinueButton;
	
	@FindBy(xpath = "//div[@id='payment-method-buttons-container']//input")
	WebElement payMetodContinueButton;
	
	@FindBy(xpath = "//div[@id='payment-info-buttons-container']//input")
	WebElement payInfoContinueButton;
	
	@FindBy(xpath = "//input[@id='shippingoption_1']")
	WebElement nextDayAirRadioButton;
	
	@FindBy(xpath = "//label[contains(.,'COD')]/../input[@name='paymentmethod']")
	WebElement codRadioButton;
	
	@FindBy(xpath = "//h2[contains(text(),'Payment information')]/../..//td/p")
	WebElement paymentInfoMsg;
	
	@FindBy(xpath = "//div[@id='confirm-order-buttons-container']//input")
	WebElement orderConfirmButton;
	
	@FindBy(xpath="//div[@class='section order-completed']//strong")
	WebElement orderConfirmSuccessMsg;
	
	
	
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
		Select address = new Select(billingAddressCountry);
		address.selectByIndex(0);
//		city.sendKeys("Toronto");
//		addressLine1.sendKeys("957 Eglinton Avenue");
//		zipCode.sendKeys("M4P 1A6");
//		phoneNumber.sendKeys("111111111");
		
	}
	
	/**
	 * 
	 */
	public void selectNewShippingAddress()
	{
		Select address = new Select(shippingAddress);
		address.selectByValue("1896248");
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
		shippingAddressContinueButton.click();
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

	public void clickPayInfoContinueButton() {
		payInfoContinueButton.click();
	}

	public void clickConfirmOrderConfirmButton() {
		orderConfirmButton.click();
	}
	
	public String getOrderConfirmSuccessMsg()
	{
		return orderConfirmSuccessMsg.getText();
	}
	
	

}
