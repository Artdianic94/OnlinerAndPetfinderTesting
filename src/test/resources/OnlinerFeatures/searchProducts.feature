Feature: Search products

  @ui
  Scenario: Search for smartphone
    Given User enters "Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)" in the search field
    When Chooses the n-th product from the list
    Then Product page of "Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)" appear on the screen