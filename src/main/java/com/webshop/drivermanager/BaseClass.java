package com.webshop.drivermanager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Created by Kranthi on 12/Mar/2021.
 */
public class BaseClass {

	private final String filePath = ".\\src\\test\\resources\\Configurations\\config.properties";
	FileReader fileReader;
	BufferedReader buffReader;
	public static Properties prop;
	public static WebDriver driver = null;

	/**
	 * @name: BaseClass
	 * @comments: Constructor to initialize and load the property file
	 */
	public BaseClass() {
		try {
			fileReader = new FileReader(filePath);
			buffReader = new BufferedReader(fileReader);
			prop = new Properties();
			try {
				prop.load(buffReader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				buffReader.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @return 
	 * @name: initializeDriver
	 * @comments: Initializing the driver and its properties from the properties file
	 */
	public static WebDriver initializeDriver() {
		String browser = prop.getProperty("browser");
		if (browser != null && browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			
//			ChromeOptions options = new ChromeOptions();
//			options.setHeadless(true);
			
			driver = new ChromeDriver();
		}
		else if(browser != null && browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	
	
	
	
	

}
