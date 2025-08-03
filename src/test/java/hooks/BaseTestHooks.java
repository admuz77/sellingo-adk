package hooks;

import drivers.DriversManager;
import org.junit.After;
import org.junit.Before;

public abstract class BaseTestHooks {
    protected DriversManager driversManager;

    @Before
    public void openApplication() {
        driversManager = new DriversManager();
        driversManager.setUpChromeDriver();
        driversManager.openBrowser("https://demo.sellingo.pl/rejestracja");
    }

    @After
    public void tearDown() {
        driversManager.tearDownBrowser();
    }
}