package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
    private static final String LOADING_INDICATOR = "//i[contains(@class, 'fa-gear')]";
    @Getter
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static WebDriver getDriverThreadLocal() {
        return DRIVER_THREAD_LOCAL.get();
    }

    public static void setDriverThreadLocal(WebDriver webDriver) {
        DRIVER_THREAD_LOCAL.set(webDriver);
    }

    public void waitForLoading() {
        new WebDriverWait(getDriverThreadLocal(), 30).until(ExpectedConditions.invisibilityOf(findElementByXPath(LOADING_INDICATOR)));
    }

    public WebElement waitForVisibilityOfElement(String locator) {
        return new WebDriverWait(getDriverThreadLocal(), 30).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public List<WebElement> waitForVisibilityOfAllElementsCustomized(String xpath) {
        return new WebDriverWait(getDriverThreadLocal(), 5)
                .until(ExpectedConditions.refreshed
                        (ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))));
    }

    public WebElement waitForClickabilityOfElement(String locator) {
        return new WebDriverWait(getDriverThreadLocal(), 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }



    public WebElement findElementByXPath(String xpath) {
        return waitForVisibilityOfElement(xpath);
    }

    public List<WebElement> findAllElementsByXPath(String xpath) {
        return getDriverThreadLocal().findElements(By.xpath(xpath));
    }
    public WebElement findClickabilityElementByXPath(String xpath){
        return waitForClickabilityOfElement(xpath);
    }

    public List<WebElement> findAllElementsByXPathCustomized(String xpath) {
        return waitForVisibilityOfAllElementsCustomized(xpath);
    }

    public void implicitlyWait(int seconds) {
        getDriverThreadLocal().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void waitForVisibilityOfAllElements(int seconds) {
        try {
            new WebDriverWait(getDriverThreadLocal(), seconds).until(ExpectedConditions.visibilityOfAllElements());
        } catch (Exception ignored) {
        }
    }

    public Boolean isElementPresent(String xpath) {
        return !findAllElementsByXPath(xpath).isEmpty();
    }

    public void reloadPage() {
        getDriverThreadLocal().navigate().refresh();
    }

    public boolean isIframeDisplayed(By by) {
       return !getDriverThreadLocal().findElements(by).isEmpty();
    }
}
