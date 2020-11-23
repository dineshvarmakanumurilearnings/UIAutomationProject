package test.application.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public  class Base {

	public static BasePage currentPage;
	public static WebDriver driver = null;
	public Properties prop = null;
	public FileInputStream fis = null;
	
	public <T extends BasePage> T getInstance(Class<T> page)
	{
		Object obj = PageFactory.initElements(driver,page);
		return page.cast(obj);	
	}
	
	

}
