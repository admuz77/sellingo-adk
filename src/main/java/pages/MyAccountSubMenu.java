package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class MyAccountSubMenu extends BasePage {
    public MyAccountSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(.,'Wyloguj się')]")
    private WebElement logOutButton;

    public void logOutUser() {
        logOutButton.click();
        log.info("Wylogowanie się z konta użytkownika");
    }

}
