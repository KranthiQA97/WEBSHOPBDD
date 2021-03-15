Feature: WebShop Demo Feature

@smoke
Scenario: Webshop end to end test
Given user should be navigate to the given url
Then click on the login button and validate the warning message
Then enter valid email and password and click on login button
And validate the user account id at the top right corner
Then click on the Books link and add the book to the cart
And now clear the cart
Then click on the Books category and select a book from the list
And get the price details and enter the quantity that is more than one
Then click on add to cart button
Then validate the product added success message
Then click on shopping cart link at the top and validate sub total price
Then click on Check out
Then click on address drop down and select a new billing address
Then Click on Continue button
Then click on address drop down and select a new shipping address
Then click on Continue button and select shipping method
Then click on payment method and click on continue button
And validate the payment method message and click on the continue button 
Then click on the continue button and validate the order processed success message
And click on continue button and click on logout button
  