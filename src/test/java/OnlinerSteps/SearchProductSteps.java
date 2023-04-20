package OnlinerSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import OnlinerPages.HomePage;
import OnlinerPages.ProductPage;

public class SearchProductSteps {
    HomePage homePage;
    ProductPage productPage;

    public SearchProductSteps() {
        homePage = new HomePage();
        productPage = new ProductPage();
    }

    @Given("User enters {string} in the search field")
    public void enterDesiredProductInSearch(String desiredProduct) {
        homePage.openOnlinerWebsite();
        homePage.enterSearchingProduct(desiredProduct);
    }

    @When("Chooses the n-th product from the list")
    public void selectDesiredProductFromList() {
        homePage.clickOnDesiredProduct();
    }

    @Then("Product page of {string} appear on the screen")
    public void desiredProductOnScreen(String desiredProduct) {
        Assert.assertEquals(productPage.getProductNameOnPage(), desiredProduct, "The product found doesn't match the expected");
    }
}
