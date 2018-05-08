package Support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverGenerator {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        return new FirefoxDriver();
    }
    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}