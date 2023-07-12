package utils;

import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import pom.pages.HomePage;

@Slf4j
public class BaseTest {

    public HomePage openHomePage() {
        String url = "https://www.links.hr/hr/";
        log.info("Navigating to " + url);
        Selenide.open(url);
        return LoadingPageFactory.get(HomePage.class);
    }
}