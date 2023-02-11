@urStore
Feature: yourStore login screen Functionality

  @Login
  Scenario: Login page validation - Resister/New Customer

    Given User open browser
    And Navigate to yourStore application
    When user click My Account button
    And User click on login button
    Then Login screen open with NewCustomer and Returning Customer tab
    Then user Continue with NewCustomer option
    Then user set login details and check privacy policy & click continue
    Then User see Your Account Has Been Created! message
    Then Close browser

  @AddItem
  Scenario: Adding item to cart

    Given User open browser
    And Navigate to yourStore application
    When user click My Account button
    And User click on login button
    And Login screen opens and user login with resistered credential
    Then User redirected back to home screen
    And User opens Desktop section and add one item to cart
    Then User verifies item present in the cart
    Then User remove item if not available

    Scenario: Product payment and Checkout

      Given User open browser



