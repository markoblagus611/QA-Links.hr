package pom.pages.tvAudioVideo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import pom.pages.BasePage;
import utils.LoadingPageFactory;
import utils.Verify;

import java.time.Duration;

@Slf4j
@Verify
public class TvOrAudioVideoPage extends BasePage {

    public GPSNavigationPage pickGPSNavigationCategory() {
        log.info("Picking 'GPS navigation' category");
        Selenide.$(".listbox .cat-0209").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return LoadingPageFactory.get(GPSNavigationPage.class);
    }
}