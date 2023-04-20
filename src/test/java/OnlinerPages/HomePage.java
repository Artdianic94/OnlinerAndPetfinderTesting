package OnlinerPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private static final By SEARCH_INPUT = By.xpath("//input[@class='fast-search__input']");
    private static final By SEARCH_FRAME = By.xpath("//iframe[@class='modal-iframe']");
    private static final By SEARCHING_RESULT = By.xpath("//div[@class='result__wrapper']");

    public void openOnlinerWebsite() {
        open(baseUrl);
    }

    public void enterSearchingProduct(String desiredProduct) {
        $(SEARCH_INPUT).shouldBe(Condition.visible).sendKeys(desiredProduct);
    }

    public void clickOnDesiredProduct() {
        switchTo().frame($(SEARCH_FRAME));
        $(SEARCHING_RESULT).click();
    }
}
