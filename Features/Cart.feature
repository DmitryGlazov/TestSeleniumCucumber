Feature: Cart functionality of Application
  Verify if user is able to use cart functionality

  Scenario: User should be able to remove item from cart

    Given Open product page

    When Choose color

    When Choose size

    When Click add to cart button

    When Remove item from cart

    Then See empty cart message

  Scenario: User should be able to increase item quantity in cart

    Given Open product page

    When Choose color

    When Choose size

    When Click add to cart button

    When Increase item quantity

    Then See increased price