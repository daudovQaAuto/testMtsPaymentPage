package tests.base;

import commonAndConstant.CommonActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.topUpAnyPhoneNumber.MobilePhoneTopUpPage;
import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static commonAndConstant.Config.*;

//* To launch test concurrently
/*@Execution(ExecutionMode.CONCURRENT)*/
@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MobilePhoneTopUpPage mobilePhoneTopUpPage = new MobilePhoneTopUpPage(driver);
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);


    static {
        LOGGER.info("START TIME: " + LocalTime.now());
        LOGGER.info("Start clear reports dir: build/reports ...");

        /** Clear previous allure reports (очистка от предыдущих результатов запусков тестов)*/
        File allureResults = new File("allure-results");
        if (allureResults.isDirectory()){
            for (File item : Objects.requireNonNull(allureResults.listFiles()))
                item.delete();
        }
        if(CLEAR_REPORTS_DIRECTORY){
            File allureScreenshots = new File("build/reports/tests");
            for (File item : Objects.requireNonNull(allureScreenshots.listFiles()))
                item.delete();
        }
    }
        /** Clearing cookies before each iteration with browser */
    @AfterEach
    void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            jse.executeScript("window.sessionStorage.clear()");
        }
    }

        /** To hold browser open. It can be changed in configuration */
    @AfterAll
    public void tearDown() {
        /*if (!HOLD_BROWSER_OPEN) {
            driver.close();
        }*/
        driver.close();
    }
}
