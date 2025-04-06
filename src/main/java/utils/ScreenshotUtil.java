package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private static final String SCREENSHOT_DIR = "screenshots";

    public static String takeScreenshot(String testName) {
        try {
            File screenshotDir = new File(SCREENSHOT_DIR);
            if (!screenshotDir.exists()) {
                boolean created = screenshotDir.mkdirs();
                if (!created) {
                    System.err.println("Failed to create folder for screenshots " + screenshotDir.getAbsolutePath());
                    return null;
                }
            }

            File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String path = SCREENSHOT_DIR + "/" + testName + "_" + timestamp + ".png";
            File dest = new File(path);
            FileUtils.copyFile(src, dest);

            return dest.getAbsolutePath();
        } catch (IOException | WebDriverException e) {
            e.printStackTrace();
            return null;
        }
    }
}