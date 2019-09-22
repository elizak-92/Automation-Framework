Feature: User creates an account

  Scenario: Order T-Shirt (and Verify in Order History)
    Given user opens the automationpractice website
    When selects t-shirts category from the navigation menu
    And user selects a "Faded Short Sleeve T-shirts" and adds it to the cart
    Then the following confirmation message is displayed:
    """
    Product successfully added to your shopping cart
    """

    When user clicks the Proceed to checkout button
    And user clicks the Proceed to checkout button on the Summary page
    Then the Authentication page is displayed

    When user inserts "elizak@test.co.uk" and "Password123" and clicks the Sign in button
    And user clicks the Proceed to checkout button on the Addresses page
    And user selects the terms of service checkbox
    And user clicks Pay by bank wire button
    And user clicks the I Confirm My Order button
    And user opens my Account Page
    And user clicks the Order History and Details button
    Then a new order is displayed for today's date, with a total price of "$18.51", using a payment method "Bank wire" with a status of "On backorder"
    And user logs out

  Scenario: Update Personal Information (First Name) in My Account
    When user opens the automationpractice website and clicks the Sign in button
    Then the Authentication page is displayed
    When user inserts "elizak@test.co.uk" and "Password123" and clicks the Sign in button
    And user clicks the My Personal Information button
    And user updates the First Name field to "Anna" and clicks Save
    And user logs out
