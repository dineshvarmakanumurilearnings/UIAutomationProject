package test.application.testPages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.application.basic.Base;
import test.application.basic.BasePage;
import test.application.basic.DriverContext;
import test.application.basic.Frameworkinitializations;
import test.application.pages.CartPage;
import test.application.pages.HomePage;
import test.application.pages.PaymentPage;
import test.application.pages.ProductPage;
import test.application.pages.SearchResultPage;

public class EtoETest extends Frameworkinitializations{
	
public EtoETest() throws Exception {
		super();
		
	}
public Logger log = LogManager.getLogger(EtoETest.class);
	
	@Test(priority=0)
	public void logIn() 
	{
		currentPage = getInstance(HomePage.class);
		String title = currentPage.As(HomePage.class).getTitle();
		if (title.contains("Online Shopping Site for Mobiles, Electronics, Furniture,")) {
			Assert.assertTrue(true, "tile matched");
			log.info("title Matched");
		} else {
			Assert.assertFalse(false, "tile not matched");
			log.error("title not  Matched");
		}
		log.info("Home page Launched");
		
		
	}
	
	@Test(priority=1)
	public void searchItem() 
	{
		currentPage=currentPage.As(HomePage.class).itemSearch(search);
		log.info("searched for samsung TV");
		
	}
	
	@Test(priority=2)
	public void sortItem() throws InterruptedException {
		
		SearchResultPage srp = currentPage.As(SearchResultPage.class);
		log.info("landed on search result page");
		srp.highToLowPrice();
		log.info("sorted from high to low pricing");
		Thread.sleep(2000);
		currentPage = srp.selectFirstResult();
		log.info("clicked on 1 st highrst result");
	}
	
	@Test(priority=3)
	public void pinCheckAndBuy() throws InterruptedException {
		
		  ProductPage pp =  currentPage.As(ProductPage.class); 
		  pp.landOnProductPage();
		  log.info("landed on product page");
		  String msg = pp.checkPin(pinCode);
		  log.info(msg);
		  currentPage = pp.addToCart();
		  log.info("clicked addtocart button on product page");
          Thread.sleep(3000);	  
	}
	
	  @Test(priority=4)
	  public void placeOrder() {
		  currentPage=currentPage.As(CartPage.class).placeOrder();
		  log.info("clicked on Place Order");
	  }
	  @Test(priority=5)
	  public void MakePayment() {
		  PaymentPage pPage=currentPage.As(PaymentPage.class);
		 pPage.landOnpaymentPage();
		 log.info("landed on secure payment page");
		 pPage.login(prop.getProperty("Uname"),prop.getProperty("pwd"));
		 log.info("user logged in successfully on payment page");
		
		 pPage.loginCollapse();
	  }
	 
	

}
