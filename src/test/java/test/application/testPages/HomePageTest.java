package test.application.testPages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import test.application.basic.Frameworkinitializations;
import test.application.pages.CartPage;
import test.application.pages.HomePage;

public class HomePageTest extends Frameworkinitializations {
	public HomePageTest() throws Exception {
		super();
		
	}

	public Logger log = LogManager.getLogger(HomePageTest.class);
	
	@Test(priority=6)
	public void loginTest() {
		currentPage = getInstance(HomePage.class);
		currentPage.As(HomePage.class).logIn(UserName, pwd);
		log.info("logged in ");
	}

	

	@Test(priority=8)
	public void VerifyTitle() {
		String title = currentPage.As(HomePage.class).getTitle();
		if (title.contains("Online Shopping Site for Mobiles, Electronics, Furniture,")) {
			Assert.assertTrue(true, "tile matched");
			log.info("title Matched");
		} else {
			Assert.assertFalse(false, "tile not matched");
			log.error("title not  Matched");
		}
	}
	@Test(priority=9)
	public void gotoCartPage() throws InterruptedException {
		currentPage =currentPage.As(HomePage.class).goToCart();
		log.info("Clicked on cart icon on home page");
	}
	@Test(priority=10)
	public void removeCartItem() throws InterruptedException {
		CartPage cartPage =currentPage.As(CartPage.class);
		log.info("landed on cart page");
		cartPage.removeItem(removeItem);
		log.info("removed item from cart");
		currentPage=cartPage.gotoHome();
		log.info("navigating to home page");
	}
	
	@Test(priority=11)
	public void LogOut() {
		log.info("landed on home page");
		currentPage=currentPage.As(HomePage.class).logOut();
		log.info("logged out successfully");
	}
}
