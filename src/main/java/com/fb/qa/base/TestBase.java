package com.fb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fb.qa.util.Testutil;

public class TestBase {

	// initialize Webdriver
	public static WebDriver driver;
	public static Properties prop;
	
	
	// create constructor 
	
	public TestBase() {
		
		// read your properties from config.properties file
					try {
						prop = new Properties();
						FileInputStream ip = new FileInputStream("C:\\Users\\hv_19\\eclipse-workspace\\"
								+ "fbtest\\src\\main\\java\\com\\fb\\qa\\config\\config.properties");
						prop.load(ip);
						} 
					catch (FileNotFoundException e) 
					{
						e.printStackTrace();
					}
					catch (IOException e) 
					{
						e.printStackTrace();
					}

				}
	// create method to initialize browser and variables
	
	public static void initialization(){
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\hv_19\\Downloads\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else 	if (browsername.equals("ff")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\hv_19\\Downloads\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
						
		}
		
	
		// configure the window
		
		driver.manage().window().minimize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		// get the url from config.properties
		
		driver.get(prop.getProperty("url"));
		
}
	
}
