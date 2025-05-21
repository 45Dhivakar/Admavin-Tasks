package Testing.To_DoAutomationTask2;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
