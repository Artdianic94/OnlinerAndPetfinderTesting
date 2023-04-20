Feature: Adding a product to the cart

  Background:
    When Page of product "Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)" is opened

  @ui
  Scenario Outline: Add the selected product to the cart
    Given User sees <productName> product name
    And  Description of this product
    When Chooses the first product with the min price
    And  Clicks 'Add to Cart' on product’s page
    Then A window with <message>,buttons <goToCartBtn> and <continueShopBtn> will appear on the screen
    And  A icon value of count shopping cart is change on <numberOnCart>
    Examples:
      | message                  | goToCartBtn       | continueShopBtn    | numberOnCart | productName                                                  |
      | Товар добавлен в корзину | Перейти в корзину | Продолжить покупки | 1            | "Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)" |

