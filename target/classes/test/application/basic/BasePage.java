package test.application.basic;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.application.pages.ProductPage;

public class BasePage extends Base {
	
	public static String currentProducttitle =null;
	public static int totalCartAmt=0;
	public String paySegment[] = {"Login or Signup","Delivery Address","Order Summary"};
	
	public <T extends BasePage> T As(Class<T> page)
	{
		return (T)this;
	}
	 public int convertPrice(String price) {
		  price=price.replaceAll("₹", "");
		  price=price.replaceAll(",", "");
		  int price1 = Integer.parseInt(price);
		  return price1;
		}
	public String switchWindow()
	{
		String reqID = null;
		String pwID = driver.getWindowHandle();
		Set<String> wID = driver.getWindowHandles();
		for(String id:wID) {
			if(id!=pwID)
				reqID= id;	
		}
		return reqID;
	}
	
	public String getTitle() {
		return(driver.getTitle());
	}
	
	public boolean isElementDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}
	
	public String getScreenShot(String testcasename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destpath=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		File dest = new File(destpath);
		FileUtils.copyFile(src, dest);
		 return destpath;
	}
	
}
