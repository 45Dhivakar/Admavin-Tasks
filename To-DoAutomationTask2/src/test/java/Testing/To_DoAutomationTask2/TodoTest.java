package Testing.To_DoAutomationTask2;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.qameta.allure.Step;
import util.ScreenshotUtil;

public class TodoTest {
    WebDriver driver;
    TodoPage todo;
    ExtentReports extent;
    ExtentTest test;
   // ScreenshotUtil screenshotUtil;
    

    @BeforeClass
    public void setup() {
        // If not using WebDriverManager, make sure chromedriver is in your PATH
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/dist/#");
        driver.manage().window().maximize();
        todo = new TodoPage(driver);
        
        extent = ExtentReport.getInstance();
    }

    @Test(priority = 1)
    public void addTasks() {
        todo.addTask("Task 1 Buy Milk");
        todo.addTask("Task 2 Buy NewsPapers");
        todo.addTask("Task 3 Buy Some Vegitables");
        Assert.assertEquals(todo.getTasks().size(), 3);
        test.pass("Task Add Sucessfully!");
    }

    @Test(priority = 2)
    public void completeSecondTask() {
        todo.completeTask(1);
        Assert.assertTrue(todo.isTaskCompleted(1), "Second task should be marked as completed.");
        test.pass("SecondTask Completed Sucessfully!");
    }

    @Test(priority = 3)
    public void deleteFirstTask() {
        todo.deleteTask(0);
        Assert.assertEquals(todo.getTasks().size(), 2);
        test.pass("Third Task Compleated!");
    }
    @Test
    public void myTest() {
        test = extent.createTest("My Test");
        test.info("Step 1: Say Hi! To Friend's");
        // ...test logic
        test.pass("Test passed!");
    }
    @Test
    public void failExample() {
        test.info("This test will fail for demo");
        Assert.assertTrue(false, "Failing this on purpose");
        test.fail("This step fails and will show as red in the report");
    }

    
//    @AfterMethod
//    public void takeScreenshotOnSuccess(ITestResult result) {
//        if (result.getStatus() == ITestResult.SUCCESS) {
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            File dest = new File("screenshots" + File.separator + result.getName() + "_success.png");
//            dest.getParentFile().mkdirs(); 
//            try {
//                Files.copy(screenshot.toPath(), dest.toPath());
//                System.out.println("Screenshot saved for success: " + dest.getAbsolutePath());
//            } catch (IOException e) {
//                System.out.println("Failed to save screenshot: " + e.getMessage());
//            }
//        }
//    }
    @AfterClass
    public void teardown() {
        if (driver != null) driver.quit();
        extent.flush(); 
    }
}