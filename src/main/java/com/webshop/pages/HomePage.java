package com.webshop.pages;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kranthi
 * @description Contains the Home Page Web Elements and Action Methods
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
	@CacheLookup
	WebElement loginLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(.,'Books')]")
	WebElement booksLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(.,'Computers')]")
	@CacheLookup
	WebElement computersLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(.,'Electronics')]")
	@CacheLookup
	WebElement electronicsLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(.,'Apparel & Shoes')]")
	@CacheLookup
	WebElement apparelShoesLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(.,'Digital downloads')]")
	@CacheLookup
	WebElement digitalDownloadsLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(.,'Jewelry')]")
	@CacheLookup
	WebElement jewelryLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(.,'Gift Cards')]")
	@CacheLookup
	WebElement giftCardsLink;

	@FindBy(xpath = "//input[@value='Add to cart']")
	@CacheLookup
	List<WebElement> availableBooks;

	@FindBy(xpath = "//input[@value='Add to cart']/../../../..//div[@class='picture']")
	@CacheLookup
	List<WebElement> selectBook;

//	###############  Home Page Action Methods starts here ###################

	/**
	 * @name clickLoginLink
	 * @description By using this method we can click the Log in link in the home
	 *              page
	 */
	public void clickLoginLink() {
		loginLink.click();
	}

	/**
	 * 
	 */
	public void clickBooksLink() {
		booksLink.click();
	}

	/**
	 * 
	 */
	public void addFirstBook() {
		int lastBookIndex = availableBooks.size();

		for (int i = 0; i < lastBookIndex; i++) {

			if (!availableBooks.isEmpty() && i == 0) {
				availableBooks.get(i).click();
			}
		}
	}

	/**
	 * 
	 */
	public void selectFirstBook() {
		int lastBookIndex = selectBook.size();

		for (int i = 0; i < lastBookIndex; i++) {

			if (!selectBook.isEmpty() && i == 0) {
				selectBook.get(i).click();
			}
		}

	}

}
