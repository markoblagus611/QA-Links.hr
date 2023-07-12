package pom.pages.smallHouseholdAppliances;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import pom.pages.BasePage;
import utils.LoadingPageFactory;
import utils.Verify;

import java.time.Duration;

@Slf4j
@Verify
public class KitchenAccessories extends BasePage {

    public KitchenAccessories sortFromLowerToHigherPrice() {
        log.info("Clicking the drop down menu button for sorting");
        ElementsCollection sortingButton = Selenide.$$(By.id("sortOptionsDropDown0"));
        sortingButton.get(0).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        log.info("Clicking the option 'Price: lower to higher'");
        Selenide.$("[data-dropdownoptionvalue=\"10\"]").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return LoadingPageFactory.get(KitchenAccessories.class);
    }

    public void pickANumberOfItemsShownOnPage() {
        log.info("Clicking the drop down menu button for the number of items shown on the page");
        Selenide.$(".product-page-size #productsPageSizeDropDown0").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        log.info("Choosing to show 12 items instead of 24");
        Selenide.$(".sublevel [data-dropdownoptionvalue=\"12\"]").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        checkIfNumberOfItemsIsCorrect();
    }

    public KitchenAccessories checkIfItemsAreSortedProperly() {
        Selenide.sleep(2000);
        ElementsCollection prices = Selenide.$$("[class=\"divTableCell priceDivTable price\"]");
        log.info("Comparing all prices on the first page");
        comparePricesLowerToHigher(prices);
        return this;
    }

    private void comparePricesLowerToHigher(ElementsCollection prices) {
        for (int i = 0; i < prices.size() - 1; i++) {
            String currentPriceText = prices.get(i).getText();
            String nextPriceText = prices.get(i + 1).getText();
            double currentPriceDouble;
            double nextPriceDouble;

            if (currentPriceText.length() == 5) {
                currentPriceDouble = Double.parseDouble(currentPriceText.charAt(0) + "." + currentPriceText.substring(1, 3));
                if (nextPriceText.length() > 5) continue;
                nextPriceDouble = Double.parseDouble(nextPriceText.charAt(0) + "." + nextPriceText.substring(1, 3));
            } else {
                currentPriceDouble = Double.parseDouble(currentPriceText.substring(0, 2) + "." + currentPriceText.substring(2, 4));
                if (nextPriceText.length() > 6) continue;
                nextPriceDouble = Double.parseDouble(nextPriceText.substring(0,2) + "." + nextPriceText.substring(2, 4));
            }
            assert currentPriceDouble <= nextPriceDouble;
        }
    }

    private void checkIfNumberOfItemsIsCorrect() {
        log.info("Checking if the number of items on the page is equal to 12");
        Selenide.sleep(2000);
        ElementsCollection items = Selenide.$$(".item-box .product-item");
        assert items.size() == 12;
    }
}