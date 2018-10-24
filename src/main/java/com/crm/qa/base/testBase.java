package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;
import com.crm.qa.util.testUtil;

public class testBase {

	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Properties prop;

	public testBase() throws IOException {

		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\nairs\\eclipse-workspace\\POMTestNG\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);

	}

	public void initialize() throws IOException {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C://Users//nairs//chromedriver_win32//chromedriver.exe");

			driver = new ChromeDriver();

			// WebEventListener
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();

			e_driver.register(eventListener);
			driver=e_driver;

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(testUtil.pageLoadTimeOut, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(testUtil.implicitelyWait, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));

		}
	}

}
