package pages;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class RegistrationMessagePopup extends BasePage {

    public RegistrationMessagePopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "l-popup__message-content")
    private WebElement message;

    @FindBy(xpath = "//div[@class='l-popup__message-close at-message-close js-close-popup']")
    private WebElement closeMessage;


    public void validateRegistrationMessage() {
        String expectedMessage = "Dziękujemy, zostałeś automatycznie zalogowany na swoje konto.";
        String actualMessage = message.getText();

        log.info("Oczekiwana wiadomość: {}", expectedMessage);
        log.info("Rzeczywista wiadomość: {}", actualMessage);

        Assert.assertEquals("Treść wiadomości nie jest zgodna z oczekiwaną.", expectedMessage, actualMessage);
    }

    public void closeRegistrationMessage() {
        closeMessage.click();
    }
}
