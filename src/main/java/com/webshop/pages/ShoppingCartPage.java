package com.webshop.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void clickCheckOutButton()
	{
		checkoutButton.click();
	}
	

}
