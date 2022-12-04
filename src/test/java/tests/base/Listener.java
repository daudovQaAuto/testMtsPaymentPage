package tests.base;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/** Tracking the progress of the test and implementing a screenshot when bug is detected */
public class Listener implements TestWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
    @Override
    public void testFailed(ExtensionContext context, Throwable cause){
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss" + " " + "dd_MMMM_yy");
        LOGGER.info("Test {} - FAILED!", context.getTestMethod().get().getName());
        String screenshotName = context.getTestMethod().get().getName() + " " + format.format(dateNow) + ".png";
        LOGGER.info("Trying to trace screenShot...");
        TakesScreenshot ts = (TakesScreenshot) ((BaseTest) context.getRequiredTestInstance()).driver;

        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("build/reports/tests/" + screenshotName ));
        } catch (IOException e) {
            LOGGER.info("Exception on saving screenshot!");
            throw new RuntimeException(e);
        }
        attachScreenshotToAllure(ts);
    }
        /** to attach screenshots to allure report*/
        @Attachment
        public byte[] attachScreenshotToAllure (TakesScreenshot takescreenshot){
        return takescreenshot.getScreenshotAs(OutputType.BYTES);
    }
}
