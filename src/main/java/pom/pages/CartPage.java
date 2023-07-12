package pom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import utils.Verify;

import java.time.Duration;

@Slf4j
@Verify
public class CartPage extends BasePage{

    public void submitOrder() {
        log.info("Clicking the button 'Dovrši' to submit the order");
        Selenide.$(".common-buttons #checkout ").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
}