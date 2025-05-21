package util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {
    private WebDriver driver;

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotDir = "screenshots";
            // Ensure the directory exists
            try {
                Files.createDirectories(Paths.get(screenshotDir));
            } catch (IOException e) {
                System.out.println("Could not create screenshot directory: " + e.getMessage());
                return;
            }

            String screenshotPath = screenshotDir + File.separator + result.getName() + ".png";
            try {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destFile = new File(screenshotPath);
                Files.copy(srcFile.toPath(), destFile.toPath());
                System.out.println("Screenshot saved for: " + result.getName());
            } catch (Exception e) {
                System.out.println("Screenshot failed: " + e.getMessage());
            }
        }
    }
}