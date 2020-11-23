package test.application.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import test.application.basic.BasePage;

public class CartPage extends BasePage {
	@FindBy(xpath = "//span[.='Place Order']")
	private WebElement placeOrder;

	@FindBy(xpath = "//span[.='Price details']/..//div[.='Total Amount']/../span")
	private WebElement totalAmountInCart;

	@FindBy(css = "div._2twTWD>div:nth-child(3)>div>div")
	private WebElement totalText;

	@FindBy(css = "div._3ycxrs._2Rwa71>div>div a")
	private List<WebElement> itemsInCart;

	@FindBy(xpath = "//div[@class='gdUKd9' and .='Remove']")
	private List<WebElement> removeBtn;
	
	@FindBy(xpath = "//img[@title='Flipkart']")
	private WebElement flipkartIcon;

	
	@FindBy(css = "div._3ycxrs._2Rwa71>div:nth-child(2)>div>div:nth-child(1)")
	private List<WebElement> saveBtn;
	
	@FindBy(xpath="//button[@class=\"_2AkmmA _2Rr3iH\" and .='✕']")
	private WebElement closeOverlay;
	
	@FindBy(xpath="//div[.='Are you sure you want to remove this item?']")
	private WebElement removeOverlayMsg;
	
	@FindBy(xpath="//div[.='Cancel']")
	private WebElement removeCancel;
	
	@FindBy(xpath="//div[@class=\"row LFy2Lc\"]//div[.='Remove']")
	private WebElement removeConfirm;

	public BasePage placeOrder()
	{
		if (isElementDisplayed(totalText) && totalCartAmt == convertPrice(totalAmountInCart.getText()))
		{
		
			placeOrder.click();
		}
		else
		{
			System.out.println();
		}
		return getInstance(PaymentPage.class);
		// return new PaymentPage();
	}

	public void removeItem(String ritem) throws InterruptedException {
		int i=0;
		
		for(WebElement item:itemsInCart) {
			i=i+1;
			if(item.getText().contains(ritem)) {
				System.out.println(item.getText());
				String xpath = "(//div[@class='gdUKd9' and .='Remove'])["+i+"]";
				String css= "//div[@class='_1Ox9a7']/a[contains(text(),'"+ritem+"')]";
				System.out.println(css);
				WebElement itemremove = driver.findElement(By.xpath(css));
				System.out.println(itemremove.getText());
				int x = itemremove.getLocation().getX();
				int y = itemremove.getLocation().getY();
				
				  JavascriptExecutor js = (JavascriptExecutor) driver;
				  js.executeScript("window.scrollBy("+x+", "+y+")");
				 
				  Thread.sleep(3000);
				  driver.findElement(By.xpath(xpath)).click();
				 
				break;
			}
		}
		
		if(isElementDisplayed(removeOverlayMsg)&&isElementDisplayed(removeCancel)&&isElementDisplayed(removeConfirm))
		{
			removeConfirm.click();
		}else
		{
		
		}
	}
	public BasePage gotoHome() 
	{
		flipkartIcon.click();
		return getInstance(HomePage.class);
	}

}
