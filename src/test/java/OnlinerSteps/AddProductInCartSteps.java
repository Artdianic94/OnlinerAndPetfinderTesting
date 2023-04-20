package OnlinerSteps;

import OnlinerPages.HomePage;
import OnlinerPages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AddProductInCartSteps {
    HomePage homePage;
    ProductPage productPage;
    boolean isProductNameOnPage;
    boolean isProductDescriptionOnPage;
    String minPriceOfTheProduct;

    public AddProductInCartSteps() {
        homePage = new HomePage();
        productPage = new ProductPage();
    }

    @When("Page of product {string} is opened")
    public void pageOfProductIsOpened(String desiredProduct) {
        homePage.openOnlinerWebsite();
        homePage.enterSearchingProduct(desiredProduct);
        homePage.clickOnDesiredProduct();
    }

    @Given("User sees {string} product name")
    public boolean userSeesProductName(String productName) {
        return isProductNameOnPage = productPage.getProductNameOnPage().equals(productName);
    }

    @And("Description of this product")
    public boolean descriptionOfThisProduct() {
        return isProductDescriptionOnPage = productPage.getTitleWithDescriptionOfProduct().isEmpty();
    }

    @When("Chooses the first product with the min price")
    public void chooseProductWithMinPrice() {
        minPriceOfTheProduct = productPage.minPriceAsText;
    }

    @And("Clicks 'Add to Cart' on product’s page")
    public void clicksOnAddToCart() {
        productPage.chooseFirstProductWithMinPrice();
    }

    @Then("A window with {},buttons {} and {} will appear on the screen")
    public void windowWithParametersAppears(String message, String goToCartBtn, String continueShopBtn) {
        List<String> actualParametersOnWindow = new ArrayList<>();
        actualParametersOnWindow.add(productPage.getMessage());
        actualParametersOnWindow.add(productPage.getTextFromGoToCartBtn());
        actualParametersOnWindow.add(productPage.getTextFromContinueShopBtn());
        List<String> expectedParametersOnWindow = new ArrayList<>();
        expectedParametersOnWindow.add(message);
        expectedParametersOnWindow.add(goToCartBtn);
        expectedParametersOnWindow.add(continueShopBtn);
        Assert.assertEquals(actualParametersOnWindow, expectedParametersOnWindow, "There is no necessary text in the window");
    }

    @And("A icon value of count shopping cart is change on {}")
    public void numberOnShoppingCart(String numberOnCart) {
        Assert.assertEquals(productPage.getNumberOnCart(), numberOnCart, "Number on cart isn't 1");
    }
}
