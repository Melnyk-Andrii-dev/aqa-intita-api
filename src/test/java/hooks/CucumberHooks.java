package hooks;

import cache.TestCache;
import cache.TestCacheKey;
import driver.DriverInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.ListOfAllCoursesPage;
import rest.util.Session;

@Getter
public class CucumberHooks {
    private WebDriver driver;
    private static final ListOfAllCoursesPage listOfAllCoursesPage = new ListOfAllCoursesPage();

    @Before("@ui")
    public void getDriver() {
        driver = new DriverInit().setDriver();
        BasePage.setDriverThreadLocal(driver);
    }

    @After(value = "@ui", order = 1)
    public void quitDriver() {
        if (driver != null)
            BasePage.getDriverThreadLocal().quit();
    }

    @Before("@session")
    public void getSessionTokens() {
        Session.saveSessionId();
        Session.saveXCsrfToken(TestCache.getStringFromCache(TestCacheKey.SESSION_ID));
    }
}
