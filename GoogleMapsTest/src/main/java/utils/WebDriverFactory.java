package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory{
	public static WebDriver createDriver() {
		 System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse\\chrome-win64.exe");  
		return new ChromeDriver();
	}
}