package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kranthi
 *
 */
public class BookDetailsPage {

	WebDriver driver;

	public BookDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	###############  Shopping Cart Page Web Elements starts here ###################

	@FindBy(xpath = "//div[@class='product-price']/span")
	@CacheLookup WebElement price;
	
	@FindBy(xpath = "//div[@class='add-to-cart-panel']/input[@class='qty-input']")
	@CacheLookup WebElement quantityTextbox;
	
	@FindBy(xpath = "//div[@class='add-to-cart-panel']/input[@value='Add to cart']")
	@CacheLookup WebElement addToCartButton;
	
	@FindBy(xpath = "//div[@id='bar-notification']/p")
	WebElement succMessage;
	

//	###############  Shopping Cart Page Action Methods starts here ###################

	/**
	 * @return
	 */
	public String getBookPrice() {
		return price.getText();
	}
	
	/**
	 * @return
	 */
	public WebElement enterQuantity()
	{
		quantityTextbox.clear();
		return quantityTextbox;
	}
	
	/**
	 * 
	 */
	public void clickAddToCartButton()
	{
		addToCartButton.click();
	}
	
	/**
	 * @return 
	 * 
	 */
	public String getProductAddSuccMsg()
	{
		System.out.println("======> Success Message: "+succMessage.getText());
		return succMessage.getText();
	}
	
	
}
