package pom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import utils.LoadingPageFactory;
import utils.Verify;

import java.time.Duration;

@Verify
@Slf4j
public class SalesPage extends BasePage {

    public SalesPage clickToCheckBoxOnSalesPage(String productName, int checkBoxNumber) {
        Selenide.sleep(2000);
        log.info("Clicking '" + productName + "' checkbox");
        ElementsCollection checkBoxes = Selenide.$$(".filterItemUnselected");
        checkBoxes.get(checkBoxNumber).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return LoadingPageFactory.get(SalesPage.class);
    }

    public SalesPage clickToUncheckBoxOnSalesPage(String productName) {
        Selenide.sleep(2000);
        log.info("Unchecking '" + productName + "' checkbox");
        Selenide.$(By.className("filterItemSelected")).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return LoadingPageFactory.get(SalesPage.class);
    }

    public SalesPage checkIfOnlySelectedItemsAreDisplayed(String productName) {
        Selenide.sleep(2000);
        log.info("Checking if only '" + productName + "' items are displayed");
        ElementsCollection productTitles = Selenide.$$(".product-title");
        checkTitles(productTitles, productName);
        return this;
    }

    private void checkTitles(ElementsCollection productTitles, String itemName) {
        for(SelenideElement product : productTitles) {
            String actualTitle = product.getText().toLowerCase();
            log.info(product.getText().toLowerCase());
            assert actualTitle.contains(itemName);
        }
    }

    public SalesPage addSecondItemToCompareList(String productName) {
        log.info("Adding the second '" + productName + "' to compare list");
        ElementsCollection products = Selenide.$$(".compare-items .button-2");
        products.get(1).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public SalesPage checkIfNotificationBarIsVisibleWithMessage(String expectedText) {
        log.info("Checking if notification bar is visible");
        Selenide.$(By.id("bar-notification")).shouldBe(Condition.visible, Duration.ofSeconds(10));
        log.info("Checking if notification bar contains the right text");
        String actualText = Selenide.$(By.id("bar-notification")).getText();
        log.info("Expected text: " + expectedText);
        log.info("Actual text: " + actualText);
        assert actualText.contains(expectedText);
        log.info("Closing the notification bar");
        Selenide.$(".close").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        log.info("Checking if notification bar is closed");
        Selenide.$(By.id("bar-notification")).shouldBe(Condition.hidden, Duration.ofSeconds(10));
        return LoadingPageFactory.get(SalesPage.class);
    }
}