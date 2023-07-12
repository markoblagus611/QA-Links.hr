package pom.pages.smallHouseholdAppliances;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import pom.pages.BasePage;
import utils.LoadingPageFactory;
import utils.Verify;

import java.time.Duration;

@Slf4j
@Verify
public class SmallHouseholdAppliancesPage extends BasePage {
    public KitchenAccessories pickKitchenAccessoriesCategory() {
        log.info("Picking 'Kitchen accessories category'");
        Selenide.$(".listbox .cat-0402").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return LoadingPageFactory.get(KitchenAccessories.class);
    }
}