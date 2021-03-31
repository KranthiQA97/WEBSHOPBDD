package com.demowebshop.definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.webshop.drivermanager.BaseClass;
import com.webshop.pages.BookDetailsPage;
import com.webshop.pages.HomePage;
import com.webshop.pages.LoginPage;
import com.webshop.pages.ShoppingCartPage;
import com.webshop.pages.WelcomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions extends BaseClass {
	public static WebDriver driver;
	public static HomePage hp;
	public static LoginPage lp;
	public static WelcomePage wp;
	public static ShoppingCartPage scp;
	public static BookDetailsPage bdp;

	@Given("user should be navigate to the given url")
	public void user_should_be_navigate_to_the_given_url() {
		driver = initializeDriver();
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		wp = new WelcomePage(driver);
		scp = new ShoppingCartPage(driver);
		bdp = new BookDetailsPage(driver);
	}

	@Then("click on the login button and validate the warning message")
	public void click_on_the_login_button_and_validate_the_warning_message() {
		hp.clickLoginLink();
		String welcomeText = lp.getWelcomeText();
		Assert.assertEquals(prop.getProperty("warningtext"), welcomeText);
	}

	@Then("enter valid email and password and click on login button")
	public void enter_valid_email_and_password_and_click_on_login_button() {
		lp.enterEmail().sendKeys(prop.getProperty("username"));
		lp.enterPassword().sendKeys(prop.getProperty("password"));
		lp.clickLoginButton();
	}

	@Then("validate the user account id at the top right corner")
	public void validate_the_user_account_id_at_the_top_right_corner() {
		String accountID = wp.getAccountID();
		Assert.assertEquals(prop.getProperty("username"), accountID);
	}

	@Then("click on the Books link and add the book to the cart")
	public void click_on_the_books_link_and_add_the_book_to_the_cart() {
		hp.clickBooksLink();
		hp.addFirstBook();
		wp.clickShoppingCartLink();
	}

	@Then("now clear the cart")
	public void now_clear_the_cart() {
		scp.checkAllRemoveCheckBoxes();
		scp.clickUpdateCartButton();
	}

	@Then("click on the Books category and select a book from the list")
	public void click_on_the_books_category_and_select_a_book_from_the_list() {
		hp.clickBooksLink();
		hp.selectFirstBook();
	}

	@Then("get the price details and enter the quantity that is more than one")
	public void get_the_price_details_and_enter_the_quantity_that_is_more_than_one() {
		String bookPrice = bdp.getBookPrice();
		System.out.println("Book Price : "+bookPrice);
		bdp.enterQuantity().sendKeys(prop.getProperty("quantity"));
	}
	
	@Then("click on add to cart button")
	public void click_on_add_to_cart_button() {
		bdp.clickAddToCartButton();
	}
	
	@Then("validate the product added success message")
	public void validate_the_product_added_success_message() {
		String succMsg = bdp.getProductAddSuccMsg();
		Assert.assertEquals(prop.getProperty("succmsg"), succMsg);
	}
	
	@Then("click on shopping cart link at the top and validate sub total price")
	public void click_on_shopping_cart_link_at_the_top_and_validate_sub_total_price() {
	    wp.clickShoppingCartLink();
	    String subTotal = scp.getSubtotal();
	    Assert.assertEquals(prop.getProperty("subtotal"), subTotal);
	}
	
	@Then("click on Check out")
	public void click_on_check_out() {
		scp.clickTermsCheckBox();
		scp.clickCheckOutButton();
	    
	}
	@Then("click on address drop down and select a new billing address")
	public void click_on_address_drop_down_and_select_a_new_billing_address() {
	    scp.selectNewBillingAddress();
	}
	@Then("Click on Continue button")
	public void click_on_continue_button() {
	    scp.clickBillingContinueButton();
	}
	@Then("click on address drop down and select a new shipping address")
	public void click_on_address_drop_down_and_select_a_new_shipping_address() {
//	    scp.selectNewShippingAddress();
		scp.clickShippingContinueButton();
	}
	@Then("click on Continue button and select shipping method")
	public void click_on_continue_button_and_select_shipping_method() {
	    scp.clickNextDayAirRadioButton();
	    scp.clickShippingMethodContinueButton();
	}
	@Then("click on payment method and click on continue button")
	public void click_on_payment_method_and_click_on_continue_button() {
	    scp.clickCODButton();
	    scp.clickPayMetodContinueButton();
	}
	@Then("validate the payment method message and click on the continue button")
	public void validate_the_payment_method_message_and_click_on_the_continue_button() {
	    String payInfoMsg = scp.getPaymentInfoText();
	    Assert.assertEquals(prop.getProperty("paymentinfo"),payInfoMsg);
	}
	@Then("click on the continue button and validate the order processed success message")
	public void click_on_the_continue_button_and_validate_the_order_processed_success_message() {
	    scp.clickPayInfoContinueButton();
	}
	@Then("click on continue button and click on logout button")
	public void click_on_continue_button_and_click_on_logout_button() {
	    scp.clickConfirmOrderConfirmButton();
	    String orderSuccMsg = scp.getOrderConfirmSuccessMsg();
	    Assert.assertEquals(prop.getProperty("orderprocessedtext"),orderSuccMsg);
	}



}
