package test.application.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.application.basic.Base;
import test.application.basic.BasePage;
import test.application.basic.DriverContext;

public class SearchResultPage extends BasePage{
	
	@FindBy(css="div._1YuAuf")
	private WebElement sortSection;
	
	@FindBy(css="a[href*='viewcart'] span")
	private WebElement cartIcon;
	
	@FindBy(css="div._1YuAuf ._1MCcAi.D_NGuZ  ._1qKb_B>select")
	private WebElement minPrice;
	
	@FindBy(css="div._1YuAuf ._1MCcAi.D_NGuZ  ._1YoBfV>select")
	private WebElement maxPrice;
	
	//@FindBy(css="div._3O0U0u>div>div>a:nth-child(2)")
	@FindBy(css="div._3O0U0u ._3wU53n")
	private List<WebElement> srchResults;
	
	@FindBy(css="._3ywJNQ div")
	private List<WebElement> sortByHeader;
	
	
	public void highToLowPrice()
	{
		for(WebElement high:sortByHeader) {
			if(high.getText().equalsIgnoreCase("Price -- High to Low"))
				high.click();
		}
	}
	
	public BasePage selectFirstResult()
	{
		for(WebElement result:srchResults)
		{
			currentProducttitle=result.getText();
			result.click();
			break;
		}
		getTitle();
        String id=switchWindow();
		driver.switchTo().window(id);
		getTitle();
		return getInstance(ProductPage.class);
		//return new ProductPage();
	}
	
	public BasePage clickonCart() {
		cartIcon.click();
		return getInstance(CartPage.class);
		//return new CartPage();
	}
	
}
