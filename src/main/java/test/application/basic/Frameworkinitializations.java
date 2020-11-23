package test.application.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Frameworkinitializations extends DriverContext {
	
public Frameworkinitializations() throws Exception {
		super();
		
	}

public Logger log = LogManager.getLogger(Frameworkinitializations.class);

	  
	
	protected  String UserName = prop.getProperty("Uname");
	protected  String pwd = prop.getProperty("pwd");
	protected  String search =prop.getProperty("search");
	protected  String pinCode = prop.getProperty("pincode");
	protected  String removeItem = prop.getProperty("removeItem");
	
	  @BeforeClass
	  public void browsersetUp() throws Exception 
	  {
	  
		  
		  log.info("driver invoked");
		  setBrowser(); 
	  }
	  
	  @AfterClass
	  public void tearDown() throws InterruptedException
	  {
		  quitBrowser(); 
		  log.info("browser closed");
	  }
	





	
}
