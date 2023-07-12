package pom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import utils.LoadingPageFactory;
import utils.Verify;

import java.time.Duration;

@Slf4j
@Verify
public class HomePage extends BasePage {

    public BasePage checkAndClosCookiesPopUp() {
        log.info("Checking if cookies pop up is visible");
        if(Selenide.$("#onetrust-banner-sdk [class=\"ot-sdk-row\"]").isDisplayed()) {
            log.info("Closing the cookies pop up");
            Selenide.$(".banner-actions-container #onetrust-accept-btn-handler")
                    .shouldBe(Condition.visible, Duration.ofSeconds(10))
                    .click();
            Selenide.$("#onetrust-banner-sdk [class=\"ot-sdk-row\"]").shouldBe(Condition.hidden, Duration.ofSeconds(10));
            return LoadingPageFactory.get(HomePage.class);
        }
        else return this;
    }
}