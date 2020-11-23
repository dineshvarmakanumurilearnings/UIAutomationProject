package test.application.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverContext extends Base {
	
	public DriverContext() throws Exception {
		prop = new Properties();
		fis = new FileInputStream("E:\\Pratcise\\application\\config\\config.properties");
		prop.load(fis);
	}
	private DesiredCapabilities capabilites = new DesiredCapabilities();
	public void setBrowser() throws Exception {
		
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		int waitTime = Integer.parseInt(prop.getProperty("waitTime"));
		int pageloadTime = Integer.parseInt(prop.getProperty("pageloadTime"));

		switch (browser) {
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// threaddriver.set(driver);

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;
		case "IE":
			capabilites.setCapability("ignoreProtectedModeSettings", true);
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

			break;
		}

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(pageloadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

	}

	public void quitBrowser() {
		driver.quit();
	}

}
