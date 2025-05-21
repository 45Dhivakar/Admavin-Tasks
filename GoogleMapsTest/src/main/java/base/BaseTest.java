package base;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.capstoneproject.utils.ExtentManager;

import io.qameta.allure.Step;
import utils.WebDriverFactory;

public class BaseTest{
	     protected WebDriver driver;
	     

	    @BeforeClass
	    public void setup() {
	    	
	       // System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver-v0.34.0-win64.exe");
	  
	        System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse\\chrome-win64.exe");
	   
	    	
	        driver = new ChromeDriver();
	       //driver = new FirefoxDriver();
	        
	        driver.manage().window().maximize();
	        
	       
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	      
	    }
	}

