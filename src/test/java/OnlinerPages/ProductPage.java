package OnlinerPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProductPage {
    private static final By PRODUCT_TITLE = By.tagName("h1");
    private static final By LIST_OF_PRICES = By.xpath("//div[@class='product-aside__offers-flex']//span");
    private static final By PRODUCT_DESCRIPTION = By.xpath("//div[@class='offers-description__specs']//p");
    private static final By MESSAGE_ABOUT_ADD = By.xpath("//div[@class='product-recommended__divider']/preceding-sibling::div[@class='product-recommended__subheader']");
    private static final By GO_TO_CART_BTN = By.xpath("//div[@class='product-recommended__control product-recommended__control_checkout']//a[@href]");
    private static final By CONTINUE_SHOP_BTN = By.xpath("//div[@class='product-recommended__control product-recommended__control_checkout']//preceding-sibling::a");
    private static final By NUMBER_ON_CART = By.xpath("//div[@class='auth-bar__counter']");
    private static final String ADD_TO_CART_BTN = "//div[contains(@class,'product-aside__offers-item ') and contains(., '%s')]//a[contains(., 'В корзину')]";
    public String minPriceAsText;

    public String getProductNameOnPage() {
        return $(PRODUCT_TITLE).shouldBe(Condition.visible).getText();
    }

    public String getTitleWithDescriptionOfProduct() {
        return $(PRODUCT_DESCRIPTION).getText();
    }

    private WebElement getProductWebElementWithMinPrice() {
        ElementsCollection productPrices = $$(LIST_OF_PRICES);
        WebElement priceToClick = productPrices.get(0);
        double minPrice = Double.MAX_VALUE;
        for (int i = 0; i < productPrices.size(); i++) {
            String priceText = productPrices.get(i).getText();
            double priceDouble = Double.parseDouble(priceText.replace(",", "."));
            if (priceDouble < minPrice) {
                minPrice = priceDouble;
                priceToClick = productPrices.get(i);
                minPriceAsText = priceText;
            }
        }
        return priceToClick;
    }

    public void chooseFirstProductWithMinPrice() {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(getProductWebElementWithMinPrice()).perform();
        $(By.xpath(String.format(ADD_TO_CART_BTN, minPriceAsText))).shouldBe(Condition.visible).click();
    }

    public String getMessage() {
        return $(MESSAGE_ABOUT_ADD).getText();
    }

    public String getTextFromGoToCartBtn() {
        return $(GO_TO_CART_BTN).getText();
    }

    public String getTextFromContinueShopBtn() {
        return $(CONTINUE_SHOP_BTN).getText();
    }

    public String getNumberOnCart() {
        refresh();
        return $(NUMBER_ON_CART).getText();
    }
}
