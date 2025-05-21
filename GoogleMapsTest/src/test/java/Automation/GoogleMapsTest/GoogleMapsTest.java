package Automation.GoogleMapsTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import base.BaseTest;
import page.GoogleMapsPage;



public class GoogleMapsTest extends BaseTest {
	
	

    @Test
    public void testGoogleMapsFeatures() throws InterruptedException {
        GoogleMapsPage maps = new GoogleMapsPage(driver);

        maps.open();
        Thread.sleep(5000); // wait for full load

        maps.clickZoomIn();
        maps.clickZoomOut();

        maps.searchLocation("Bangalore, Karnataka");
        Thread.sleep(5000);

        maps.clickDirections();
        maps.enterRoute("HRBR Layout", "Karnataka");
        Thread.sleep(5000);

        String distance = maps.getDistance();
        System.out.println("Distance between Louvre and Eiffel Tower: " + distance);
        
    }
}