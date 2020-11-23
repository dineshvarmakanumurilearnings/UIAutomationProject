package test.application.pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



import test.application.basic.BasePage;
import test.application.basic.DriverContext;


public class ProductPage extends BasePage{
	
	@FindBy(xpath="//label[.='Compare']")
	private WebElement comparecbox;
	
	@FindBy(css="ul.row>li:nth-child(1) button")
	private WebElement addToCart;
	
	@FindBy(css="ul.row>li:nth-child(2) button span")
	private WebElement buyNow;
	
	@FindBy(id="pincodeInputId")
	private WebElement pinCode;
	
	//@FindBy(xpath="//div[@class=\"_2IqPSX _3y2HTb\"]//span[.='Check']")
	@FindBy(css="span._2aK_gu")
	private WebElement pinCheck;
	
	@FindBy(css="div[class*='_2IqPSX '] span")
	private WebElement pinChange;
	
	@FindBy(xpath="(//div[@class=\"_29Zp1s\"])[1]")
	private WebElement zipStatus;
	
	@FindBy(css="div._29OxBi ._1vC4OE._3qQ9m1")
	private WebElement productPrice;
	
	public void landOnProductPage() {
		if(currentProducttitle.contains(getTitle())) {
			Assert.assertTrue(true, "landed on same product page");
		}
		else
		{
			Assert.assertFalse(false, "not landed on same product page");
		}
	}
	public String checkPin(String zip) throws InterruptedException
	{
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,300)");
		pinCode.click();
		pinCode.clear();
		pinCode.sendKeys(zip);
		pinCheck.click();
		return zipStatus.getText();
	}
   
	public BasePage addToCart() throws InterruptedException
	{
		Thread.sleep(2000);
		totalCartAmt=totalCartAmt+convertPrice(productPrice.getText());
		if(isElementDisplayed(addToCart)&& addToCart.isEnabled())
		{	
			addToCart.click();
				
		}
		else { 
			driver.close();
			}
		
		return getInstance(CartPage.class);
		//return new CartPage();
	}
	
	public  BasePage Purchase()
	{
		buyNow.click();
		return getInstance(PaymentPage.class);
		//return new PaymentPage();
	}
	
	

}
