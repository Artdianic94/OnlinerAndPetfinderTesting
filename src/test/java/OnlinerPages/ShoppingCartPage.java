package OnlinerPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ShoppingCartPage {
    private static final By CART_BTN = By.xpath("//a[@title='Корзина']");
    private static final By DELETE_PRODUCT = By.xpath("//div[@class='cart-form__offers-part cart-form__offers-part_remove']");
    private static final By CART_TITLE = By.xpath("//div[@class='cart-form__title cart-form__title_big-alter cart-form__title_condensed-additional']");
    private static final By ADDED_PRODUCT_TITLE = By.xpath("//div[@class='cart-form__offers']//a[@href and contains(@class, 'cart-form__link')]");
    private static final By CLOSE_BOX_WITH_PRODUCT = By.xpath("//a[contains(.,'Закрыть')]");
    private static final By EMPTY_CART_MESSAGE = By.xpath("//div[@class='cart-message__title cart-message__title_big']");

    public void goInCart() {
        refresh();
        $(CART_BTN).click();
    }

    public String getCartTitle() {
        return $(CART_TITLE).getText();
    }

    public String getAddedProductTitle() {
        return $(ADDED_PRODUCT_TITLE).getText();
    }

    public void cleanShoppingCartIfProductsExist() {
        Actions actions = new Actions(getWebDriver());
        if ($(DELETE_PRODUCT).is(Condition.exist)) {
            for (int i = 0; i < $$(DELETE_PRODUCT).size(); i++) {
                actions.moveToElement($(DELETE_PRODUCT)).perform();
                $$(DELETE_PRODUCT).get(i).click();
            }
        }
    }

    public void clickOnCloseBoxBtn() {
        $(CLOSE_BOX_WITH_PRODUCT).should(Condition.visible).click();
    }

    public String getEmptyCartMessage() {
        return $(EMPTY_CART_MESSAGE).getText();
    }
}
