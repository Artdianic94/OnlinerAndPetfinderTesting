package OnlinerSteps;

import OnlinerPages.HomePage;
import OnlinerPages.ProductPage;
import OnlinerPages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddedProductInCartSteps {
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    public AddedProductInCartSteps() {
        homePage = new HomePage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @When("The box with {string} product with text Товар добавлен в корзину is opened")
    public void openBoxWithAddedProduct(String addedProduct) {
        homePage.openOnlinerWebsite();
        homePage.enterSearchingProduct(addedProduct);
        homePage.clickOnDesiredProduct();
        productPage.chooseFirstProductWithMinPrice();
    }

    @And("One product added in the cart")
    public void oneProductAddedInTheCart() {
        Assert.assertEquals(productPage.getNumberOnCart(), "1", "The cart doesn't contain 1 product");
    }

    @Given("User clicks on cart button")
    public void userClicksOnCartButton() {
        shoppingCartPage.goInCart();
    }

    @Then("Sees that the page shopping Cart is opened")
    public void seesThatThePageShoppingCartIsOpened() {
        Assert.assertEquals(shoppingCartPage.getCartTitle(), "Корзина", "It's not the cart page");
    }

    @And("The {} displays on the page")
    public void addedProductDisplaysOnThePage(String addedProduct) {
        Assert.assertEquals(shoppingCartPage.getAddedProductTitle(), addedProduct, "The added product isn't in the shopping cart");
    }
}
