package scenarios;

import hooks.BaseTestHooks;
import com.github.javafaker.Faker;
import models.RegistrationDataModel;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.MyAccountSubMenu;
import pages.RegistrationMessagePopup;
import pages.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTestHooks {

    private RegistrationPage registrationPage;
    private RegistrationMessagePopup registrationMessagePopup;
    private MainPage mainPage;
    private MyAccountSubMenu myAccountSubMenu;
    private Faker faker;
    private RegistrationDataModel registrationDataModel;

    @Before
    public void setUp() {
        registrationPage = new RegistrationPage(driversManager.getDriver());
        registrationMessagePopup = new RegistrationMessagePopup(driversManager.getDriver());
        mainPage = new MainPage(driversManager.getDriver());
        myAccountSubMenu = new MyAccountSubMenu(driversManager.getDriver());
        faker = new Faker();
        registrationDataModel = new RegistrationDataModel();
    }

    @Test
    public void registrationTest() {
        String uniqueEmail = faker.internet().emailAddress();
        String uniquePassword = faker.internet().password();

        checkPageVisibility();
        newUserRegistration(uniqueEmail, uniquePassword);
        messageValidation();
        logOutUser();
    }

    private void checkPageVisibility() {
        assertTrue("Nagłówek powinien być widoczny", registrationPage.isPageLoaded());
    }

    private void newUserRegistration(String uniqueEmail, String uniquePassword) {
        fillRegistrationForm(uniqueEmail, uniquePassword);

        registrationPage.confirmStatute();
        registrationPage.submitRegistration();
    }

    private void fillRegistrationForm(String uniqueEmail, String uniquePassword) {
        registrationPage.fillEmail(uniqueEmail);
        registrationDataModel.setEmail(uniqueEmail);

        registrationPage.fillPassword(uniquePassword);
        registrationDataModel.setPassword(uniquePassword);

        registrationPage.repeatPassword(uniquePassword);
    }

    private void messageValidation() {
        registrationMessagePopup.validateRegistrationMessage();
        registrationMessagePopup.closeRegistrationMessage();
    }

    private void logOutUser() {
        mainPage.clickAccount();
        myAccountSubMenu.logOutUser();
    }
}