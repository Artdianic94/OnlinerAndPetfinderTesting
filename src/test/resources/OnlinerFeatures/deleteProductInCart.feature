Feature: Removing a product from the cart

  Background:
    Given The shopping cart page with "Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)" is opened

  @ui
  Scenario Outline: Added product was deleted in the cart
    Given User hovers the cursor over the product and clicks on the delete icon
    And Closes the box with the product by clicking on close button
    Then Gets the <message>
    Examples:
      | message            |
      | Ваша корзина пуста |