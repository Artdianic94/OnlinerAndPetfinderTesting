package hooks;

import OnlinerPages.ShoppingCartPage;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static staticData.WebUrls.ONLINER_URL;

public class OnlinerHooks {
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Before("@ui")
    public void setUpBrowser() {
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        Configuration.browserCapabilities = options;
        Configuration.baseUrl = ONLINER_URL;
    }

    @After("@ui")
    public void quiteBrowser() {
        open(baseUrl);
        shoppingCartPage.goInCart();
        shoppingCartPage.cleanShoppingCartIfProductsExist();
        closeWebDriver();
    }
}
