Feature: The added product exist in the cart

  Background:
    When The box with "Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)" product with text Товар добавлен в корзину is opened
    And One product added in the cart

  @ui
  Scenario Outline: Added product is displayed in the cart
    Given User clicks on cart button
    Then Sees that the page shopping Cart is opened
    And The <addedProduct> displays on the page
    Examples:
      | addedProduct                                               |
      | Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный) |