package pom.pages.tvAudioVideo;

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
public class GPSNavigationPage extends BasePage {

    public GPSNavigationPage pickRoadNavigationCategory() {
        log.info("Picking the road navigation category");
        Selenide.$(".listbox .cat-020901").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return LoadingPageFactory.get(GPSNavigationPage.class);
    }

    public GPSNavigationPage sortRoadGPSNavigationsFromHigherToLowerPrice() {
        log.info("Opening sorting drop down menu button");
        Selenide.$(".product-sorting #sortOptionsDropDown0").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        log.info("Picking the 'Price: Higher to lower' option");
        Selenide.$(".sublevel [data-dropdownoptionvalue=\"11\"]").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return LoadingPageFactory.get(GPSNavigationPage.class);
    }

    public GPSNavigationPage addTheMostExpensiveItemToTheCart() {
        log.info("Adding the most expensive road gps navigation the the cart");
        ElementsCollection navigations = Selenide.$$("[class=\"button-2 product-box-add-to-cart-button\"]");
        navigations.get(0).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public GPSNavigationPage checkIfNotificationBarIsVisibleAndContainsRightMessage(String expectedMessage) {
        log.info("Checking if notification bar is visible");
        Selenide.$(By.id("bar-notification")).shouldBe(Condition.visible, Duration.ofSeconds(10));
        log.info("Checking if notification bar contains the right message");
        String actualMessage = Selenide.$("#bar-notification .content").getText();
        assert actualMessage.contains(expectedMessage);
        log.info("Closing the notification bar");
        Selenide.$("#bar-notification .close").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        log.info("Validating notification bar is closed");
        Selenide.$(By.id("bar-notification")).shouldBe(Condition.hidden, Duration.ofSeconds(10));
        return LoadingPageFactory.get(GPSNavigationPage.class);
    }

    public GPSNavigationPage checkQuantityInCart() {
        Selenide.sleep(2000);
        log.info("Checking if the quantity in cart is 1");
        String cartQuantity = Selenide.$(".articleNum .cart-qty").shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
        assert cartQuantity.equals("1");
        return this;
    }
}