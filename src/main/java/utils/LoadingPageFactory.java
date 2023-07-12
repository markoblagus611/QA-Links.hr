package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Slf4j
public class LoadingPageFactory {

    public static <T> T get(Class<T> pageObjectClass) {
        WebDriver driver = WebDriverRunner.getWebDriver();

        String simpleName = pageObjectClass.getSimpleName();
        log.info("Initializing "+simpleName);
        Verify verify = pageObjectClass.getAnnotation(Verify.class);

        String expectedPageTitle;
        try {
            expectedPageTitle = verify.title();
        } catch (NullPointerException exception) {
            throw new NoSuchElementException(String.format("Please use @Verify annotation for %s page", simpleName));
        }

        if (!expectedPageTitle.equals(Verify.INVALID_TITLE)) {
            String actualPageTitle = driver.getTitle();
            Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title is not correct.");
        }

        String xpath = verify.xpath();
        if (!xpath.equals(Verify.INVALID_XPATH)) {
            if (driver.findElements(By.xpath(xpath)).isEmpty()) {
                throw new IllegalStateException(String.format("expected XPath %s", xpath));
            }
        }

        String css = verify.css();
        if(!css.equals(Verify.INVALID_CSS)) {
            if(driver.findElements(By.cssSelector(css)).isEmpty()) {
                throw new IllegalStateException(String.format("expected CSS %s", css));
            }
        }

        return Selenide.page(pageObjectClass);
    }
}