package pom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import utils.Verify;

import java.time.Duration;

@Verify
@Slf4j
public class ComparePage extends BasePage{

    public void checkNumberOfProductsAndDeleteAll() {
        log.info("Checking if there are 2 products to compare");
        String numOfCompareProducts = Selenide.$(By.className("compare-products-count")).shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
        assert numOfCompareProducts.equals("2");
        log.info("Deleting all products from compare page");
        Selenide.$(By.className("clear-list")).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        log.info("Checking if the right text is visible");
        String actualText = Selenide.$(By.className("no-data")).shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
        String expectedText = "Nemate artikala";
        log.info("Expected text: " + expectedText);
        log.info("Actual text: " + actualText);
        assert actualText.contains(expectedText);
    }
}