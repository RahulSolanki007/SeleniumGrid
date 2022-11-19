package com.mytest;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
    WebDriver driver;
	
    @Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browserName) {
		
		System.out.println("browser name is : " + browserName);
		
       MutableCapabilities sauceOption = new MutableCapabilities();
       sauceOption.setCapability("username", "oauth-solanki.rahul680-ae1fb");
       sauceOption.setCapability("accessKey", "381f86ed-c852-4f1b-818a-6ed6115056a5");
       
       DesiredCapabilities cap = new DesiredCapabilities();
       cap.setCapability("sauce:options", sauceOption);
       cap.setCapability("browserVersion", "latest");
       cap.setCapability("platformName", "windows 10");
       
       if(browserName.equals("chrome")) {
    	   WebDriverManager.chromedriver().setup();
    	   cap.setCapability("browserName", "chrome");
       }
       else if(browserName.equals("firefox")) {
    	   WebDriverManager.firefoxdriver().setup();
    	   cap.setCapability("browserName", "firefox");
       }
       //https://oauth-solanki.rahul680-ae1fb:381f86ed-c852-4f1b-818a-6ed6115056a5@ondemand.eu-central-1.saucelabs.com:443/wd/hub
       try {
		driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
	} catch (MalformedURLException e) {
		
		e.printStackTrace();
	}   
       
	
	}
	
	@AfterMethod(alwaysRun = true) 	
	public void tearDown() {
		driver.quit();
	}
	

}
