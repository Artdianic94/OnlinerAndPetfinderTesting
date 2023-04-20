package OnlinerSteps;

import OnlinerPages.HomePage;
import OnlinerPages.ProductPage;
import OnlinerPages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DeleteProductInCartSteps {
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    public DeleteProductInCartSteps() {
        homePage = new HomePage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @When("The shopping cart page with {string} is opened")
    public void cartPageWithProductIsOpened(String addedProduct) {
        homePage.openOnlinerWebsite();
        homePage.enterSearchingProduct(addedProduct);
        homePage.clickOnDesiredProduct();
        productPage.chooseFirstProductWithMinPrice();
        shoppingCartPage.goInCart();
    }

    @Given("User hovers the cursor over the product and clicks on the delete icon")
    public void clicksOnDeleteIcon() {
        shoppingCartPage.cleanShoppingCartIfProductsExist();
    }

    @And("Closes the box with the product by clicking on close button")
    public void closesTheBoxWithTheProductByClickingOn() {
        shoppingCartPage.clickOnCloseBoxBtn();
    }

    @Then("Gets the {}")
    public void messageAboutEmptyCart(String message) {
        Assert.assertEquals(shoppingCartPage.getEmptyCartMessage(), message, "The cart isn't empty");
    }
}
