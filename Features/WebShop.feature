Feature: WebShop Demo Feature

@smoke
Scenario: Webshop end to end test
Given user should be navigate to the given url
Then click on the login button and validate the warning message
Then enter valid email and password and click on login button
And validate the user account id at the top right corner
