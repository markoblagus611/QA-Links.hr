package pom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import pom.pages.smallHouseholdAppliances.KitchenAccessories;
import pom.pages.smallHouseholdAppliances.SmallHouseholdAppliancesPage;
import pom.pages.tvAudioVideo.GPSNavigationPage;
import pom.pages.tvAudioVideo.TvOrAudioVideoPage;
import utils.LoadingPageFactory;
import utils.Verify;

import java.time.Duration;

@Slf4j
@Verify
public class BasePage {

    public HomePage validateHomePageLoadingCompleted(long loadingSeconds) {
        log.info("Validating home page loading completed");
        Selenide.$(By.id("header-white")).shouldBe(Condition.visible, Duration.ofSeconds(loadingSeconds));
        return LoadingPageFactory.get(HomePage.class);
    }

    public BasePage openSmallHouseholdAppliancesPage() {
        log.info("Opening small household appliances page");
        Selenide.$("[class=\"category category-04 \"]").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public BasePage openTvOrAudioVideoPage() {
        log.info("Opening Tv/audio video page");
        Selenide.$("[class=\"category category-02 \"] .content .title").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public BasePage openCartPage() {
        log.info("Opening cart page");
        Selenide.$(".header-links #topcartlink").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public BasePage openSalesPage() {
        log.info("Opening Sales page");
        Selenide.$("#headerMenuParent .mega-menu-responsive-root-hide .akcije").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public BasePage openComparePage() {
        log.info("Opening compare page");
        Selenide.$(".compare .icon").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    // SMALL HOUSEHOLD APPLIANCES PAGE

    public SmallHouseholdAppliancesPage validateSmallHouseholdAppliancesPageLoadingCompleted(long loadingSeconds) {
        log.info("Validating small household appliances page loading");
        SelenideElement pageTitle = Selenide.$("[class=\"page-title title-container\"]").shouldBe(Condition.visible, Duration.ofSeconds(loadingSeconds));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "MALI KUĆANSKI APARATI";
        log.info("expected page title: MALI KUĆANSKI APARATI");
        log.info("actual page title: " + actualPageTitle);
        assert actualPageTitle.contains(expectedPageTitle);
        return LoadingPageFactory.get(SmallHouseholdAppliancesPage.class);
    }

    public KitchenAccessories validateKitchenAccessoriesPageLoadingCompleted(long loadingSeconds) {
        log.info("Validating kitchen accessories page loading completed");
        SelenideElement pageTitle = Selenide.$(".page-title").shouldBe(Condition.visible, Duration.ofSeconds(loadingSeconds));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "KUHINJSKI DODACI";
        log.info("expected page title: KUHINJSKI DODACI");
        log.info("actual page title: " + actualPageTitle);
        assert actualPageTitle.contains(expectedPageTitle);
        return LoadingPageFactory.get(KitchenAccessories.class);
    }

    // TV/AUDIO VIDEO PAGE

    public TvOrAudioVideoPage validateTvOrAudioVideoPageLoadingCompleted(long loadingSeconds) {
        log.info("Validating tv/audio video page loading completed");
        SelenideElement pageTitle = Selenide.$(".page-title").shouldBe(Condition.visible, Duration.ofSeconds(loadingSeconds));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "TV / AUDIO VIDEO";
        log.info("expected page title: TV / AUDIO VIDEO");
        log.info("actual page title: " + actualPageTitle);
        assert actualPageTitle.contains(expectedPageTitle);
        return LoadingPageFactory.get(TvOrAudioVideoPage.class);
    }

    public GPSNavigationPage validateGPSNavigationPageLoadingCompleted(long loadingSeconds) {
        log.info("Validating gps navigation page loading completed");
        SelenideElement pageTitle = Selenide.$(".page-title").shouldBe(Condition.visible, Duration.ofSeconds(loadingSeconds));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "GPS NAVIGACIJA";
        log.info("expected page title: GPS NAVIGACIJA");
        log.info("actual page title: " + actualPageTitle);
        assert actualPageTitle.contains(expectedPageTitle);
        return LoadingPageFactory.get(GPSNavigationPage.class);
    }

    // CART PAGE

    public CartPage validateCartPageLoadingCompleted(long loadingSeconds) {
        log.info("Validating cart page loading completed");
        SelenideElement pageTitle = Selenide.$("[class=\"page shopping-cart-page\"] .page-title").shouldBe(Condition.visible, Duration.ofSeconds(loadingSeconds));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "Košarica";
        log.info("expected page title: Košarica");
        log.info("actual page title: " + actualPageTitle);
        assert actualPageTitle.contains(expectedPageTitle);
        return LoadingPageFactory.get(CartPage.class);
    }

    // SALES PAGE

    public SalesPage validateSalesPageLoadingCompleted(long loadingSeconds) {
        log.info("Validating sales page loading completed");
        SelenideElement pageTitle = Selenide.$(".page-title").shouldBe(Condition.visible, Duration.ofSeconds(loadingSeconds));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "Akcije - INFORMATIKA";
        log.info("expected page title: Akcije - INFORMATIKA");
        log.info("actual page title: " + actualPageTitle);
        assert actualPageTitle.contains(expectedPageTitle);
        return LoadingPageFactory.get(SalesPage.class);
    }

    // COMPARE PAGE

    public ComparePage validateComparePageLoadingCompleted(long loadingSeconds) {
        log.info("Validating compare page loading completed");
        SelenideElement pageTitle = Selenide.$(".page-title").shouldBe(Condition.visible, Duration.ofSeconds(loadingSeconds));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "Usporedi proizvode";
        log.info("expected page title: Usporedi proizvode");
        log.info("actual page title: " + actualPageTitle);
        assert actualPageTitle.contains(expectedPageTitle);
        return LoadingPageFactory.get(ComparePage.class);
    }
}