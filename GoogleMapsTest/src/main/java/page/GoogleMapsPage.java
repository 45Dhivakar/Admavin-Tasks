package page;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;



public class GoogleMapsPage{
	WebDriver driver;
	
	public GoogleMapsPage(WebDriver driver) {
		this.driver = driver;
	}
	public void open() {
		driver.get("https://www.google.com/maps");
	}
	
	public void searchLocation(String location) {
		WebElement searchBox = driver.findElement(By.id("searchboxinput"));
		searchBox.clear();
		searchBox.sendKeys("Bangalore");
		searchBox.sendKeys(Keys.ENTER);
	}
	public void clickZoomIn() {
		driver.findElement(By.cssSelector("#widget-zoom-in")).click();
	}
	public void clickZoomOut() {
		driver.findElement(By.cssSelector("#widget-zoom-out")).click();
	}
	public void clickDirections() {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement directionsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#QA0Szd > div > div > div.w6VYqd > div.bJzME.tTVLSc > div > div.e07Vkf.kA9KIf > div > div > div.m6QErb.Pf6ghf.XiKgde.ecceSd.tLjsW > div.etWJQ.jym1ob.peSXAf.kdfrQc.k17Vqe.NUqjXc > button")));
	    directionsBtn.click();
	}
	
	 public void enterRoute(String from, String to) throws InterruptedException {
	       // WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement startPoint = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//*[@id='sb_ifc50']/input")));
	        startPoint.sendKeys(from);
	        startPoint.sendKeys(Keys.ENTER);

	        Thread.sleep(3000); // Wait for destination input to be ready
	        WebElement endPoint = driver.findElement(By.xpath("//*[@id=\"sb_ifc50\"]/input"));
	        endPoint.sendKeys(to);
	        endPoint.sendKeys(Keys.ENTER);
	    }
//	  public void clickSomeElement() {
//	    	WebElement element = driver.findElement(By.className("d2cEI"));
//	    	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//	    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//	    	    wait.until(ExpectedConditions.elementToBeClickable(element));
//	    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//	    }
	    public String getDistance() {
	       
	        WebElement distanceText = driver.findElement(By.xpath("//*[@id=\"omnibox-directions\"]/div/div[2]/div/div/div/div[1]/button/div[1]/span[3]"));
	        WebElement distanceText1 = driver.findElement(By.cssSelector("#QA0Szd > div > div > div.w6VYqd > div:nth-child(2) > div > div.e07Vkf.kA9KIf > div > div > div.MlqQ3d.Hk4XGb > button"));
	        return distanceText.getText();
	    }
	    
	  
	    
	    
}