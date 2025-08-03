package drivers;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Getter
@Slf4j
public class DriversManager {
    private WebDriver driver;

    public void setUpChromeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openBrowser(String url) {
        log.info("Otwieranie się przeglądarki na stronie: {}", url);
        driver.get(url);
    }

    public void tearDownBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}