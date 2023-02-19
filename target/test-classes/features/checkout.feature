@checkout
Feature: Checkout
 @checkout-success
  Scenario: Checkout - Successfully Checkout Pillow
    Given user navigates to "midtrans"
    And user click "BUY NOW" button
    When user click on checkout button
    And user choose "Credit/debit card" as a payment method
    When user input credit card number "4811111111111114", expiry date "0225" and cvv number "123"
    And user verify pay now button is appeared
    And user click on "Pay now" button
    When user input password "112233" for payment
    Then user click on OK button