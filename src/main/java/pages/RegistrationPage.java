package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitManager;

@Slf4j
public class RegistrationPage extends BasePage {

    private WaitManager waitManager;

    @FindBy(xpath = "//header[@data-catalog ='masterpage']")
    private WebElement header;

    @FindBy(xpath = "(//input[@placeholder='E-mail'])[1]")
    private WebElement emailInput;

    @FindBy(xpath = "(//input[@placeholder='Hasło'])[1]")
    private WebElement passwordInput;

    @FindBy(xpath = "(//input[@placeholder='Powtórz hasło'])[1]")
    private WebElement repeatPasswordInput;

    @FindBy(xpath = "(//div[@class='c-checkbox-field__checkmark'])[1]")
    private WebElement statuteCheckbox;

    @FindBy(xpath = "//button[contains(.,'Zarejestruj się') and not(ancestor::aside)]")
    private WebElement submitRegistrationButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.waitManager = new WaitManager(driver);
    }

    public boolean isPageLoaded() {
        try {
            if (waitManager.waitForElementToBeVisible(header).isDisplayed()) {
                log.info("Strona rejestracji została załadowana.");
                return true;
            }
        } catch (NoSuchElementException e) {
            log.warn("Strona rejestracji się nie załadowała: nagłówek nie jest dostępny.");
        } catch (Exception e) {
            log.error("Błąd podczas sprawdzania nagłówka: {}", e.getMessage());
        }
        return false;
    }

    public void fillEmail(String email) {
        waitManager.waitForElementToBeVisible(emailInput).sendKeys(email);
        log.info("Uzupełnienie e-maila: {}", email);
    }

    public void fillPassword(String password) {
        waitManager.waitForElementToBeVisible(passwordInput).sendKeys(password);
        log.info("Uzupełnienie hasła.");
    }

    public void repeatPassword(String password) {
        waitManager.waitForElementToBeVisible(repeatPasswordInput).sendKeys(password);
        log.info("Powtórzenie hasła.");
    }

    public void confirmStatute() {
        waitManager.waitForElementToBeClickable(statuteCheckbox).click();
        log.info("Zaznaczenie checkboxa potwierdzającego zapoznanie się z regulaminem");
    }

    public void submitRegistration() {
        waitManager.waitForElementToBeClickable(submitRegistrationButton).click();
        log.info("Kliknięcie przycisku rejestracji");
    }
}