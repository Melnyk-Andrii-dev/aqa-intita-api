package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

@Getter
public class DriverInit {

    @Getter
    private WebDriver driver;

    public WebDriver setDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://qa.intita.com/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        return driver;

    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
