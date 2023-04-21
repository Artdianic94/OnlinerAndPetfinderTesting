package hooks;

import OnlinerPages.ShoppingCartPage;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static staticData.WebUrls.ONLINER_URL;

public class OnlinerHooks {
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    WebDriver driver;

    @Before("@ui")
    public void setUpBrowser() {
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        Configuration.browserCapabilities = options;
        Configuration.baseUrl = ONLINER_URL;
        Configuration.timeout = 8000;
    }

    @After("@ui")
    public void quiteBrowser(Scenario scenario) {
        driver = getWebDriver();
        if (scenario.isFailed()) {
            Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        open(baseUrl);
        shoppingCartPage.goInCart();
        shoppingCartPage.cleanShoppingCartIfProductsExist();
        closeWebDriver();
    }
}
