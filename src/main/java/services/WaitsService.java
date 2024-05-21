package services;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsService {

    private WebDriver driver;
    private WebDriverWait wait;
    private Duration timeout;

    public WaitsService(WebDriver driver) {
        this.driver = driver;
        this.timeout = Duration.ofSeconds(ReadProperties.getTimeout());
        this.wait = new WebDriverWait(driver, this.timeout);
    }
}
