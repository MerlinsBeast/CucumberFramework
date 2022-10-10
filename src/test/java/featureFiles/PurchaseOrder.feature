Feature: purchase the order from Ecommerce website
  Background:
    Given I landed on the Ecommerce Page and logged in using username and password
  Scenario: Validating the purchase order fucntionality is working as expected
    When I add the prodcuts from the productList to Cart
    And Checkout productList and submit the order
    Then verify confirmation message is displayed in the Confirmation Page
#    Examples:
#    | username | password |
#    | yd276vijay@gmail.com | Merlins@01Sword |
