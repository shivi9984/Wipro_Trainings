Feature: NopCommerce Website Testing
  As a customer
  I want to use nopCommerce website
  So that I can login, search products, add to cart, and checkout successfully

  Scenario: Complete shopping flow in nopCommerce
    Given I open the browser
    And I navigate to "https://demo.nopcommerce.com/"
    When I click on the login link
    And I enter valid username "shiva10@gmail.com" and password "IronMan"
    And I click on the login button
    Then I should see my account page

    When I navigate to "Electronics" category
    And I select "Cell phones" subcategory
    And I choose a product
    And I add the product to the shopping cart
    Then The product should be displayed in the shopping cart

    When I go to the shopping cart page
    And Click on Term Check Box
    And I click on checkout
    And I enter billing details
    And I select shipping method
    And I select payment method
    And I confirm the order
    Then I should see the order confirmation message
