package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "header-account")
    private WebElement accountButton;

    public void clickAccount() {
        accountButton.click();
        log.info("Kliknięcie w Konto na pasku górnego menu");
    }
}
