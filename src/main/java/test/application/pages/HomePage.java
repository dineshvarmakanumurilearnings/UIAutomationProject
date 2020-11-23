package test.application.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import test.application.basic.BasePage;
import test.application.basic.DriverContext;

public class HomePage extends BasePage{
	
	@FindBy(name="q")
	private WebElement searchBox;
	
	@FindBy(how=How.XPATH,using="//button[@type=\"submit\"]")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[.='Login']")
	private WebElement logInBtn;
	
	@FindBy(how = How.XPATH,using="//div[.='dinesh' and @class=\"_2aUbKa\"]")
	private WebElement myDetails;
	
	@FindBy(how = How.CSS,using="div._1XhL1B>ul>li")
	private List<WebElement> myDetailslist;
	
	@FindBy(css="div._3K4_9Q>a")
	private WebElement cartIcon;
	
	@FindBy(css="div._1jA3uo div._2aUbKa")
	private WebElement moreOptions;
	
	@FindBy(css="div._3pNZKl")
	private WebElement primaryHeader;
	
	@FindBy(css="div._3zdbog._3Ed3Ub")
	private WebElement secondaryHeader;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	private WebElement olayPwd;
	
	@FindBy(xpath="//input[@type=\"text\" and contains(@class,\"_\")]")
	private WebElement olayUname;
	
	@FindBy(xpath="//button[@type=\"submit\"]//span[.='Login']")
	private WebElement olayLogInBtn;
	
	@FindBy(xpath="//button[.='✕']")
	private WebElement olayCloseBtn;
	
	@FindBy(xpath="//span[.='Forgot?']")
	private WebElement olayForgetPwd;
	
	@FindBy(xpath="//button[.='Request OTP']")
	private WebElement olayReqstOTP;
	
	
	public BasePage itemSearch(String item)
	{
		olayCloseBtn.click();
		  searchBox.click();
		  searchBox.clear();
		searchBox.sendKeys(item);
		searchBtn.click();
		return getInstance(SearchResultPage.class);
		//return new SearchResultPage();
	}
	
	public BasePage goToCart() throws InterruptedException
	{
		Thread.sleep(3000);
		cartIcon.click();
		return getInstance(CartPage.class);
		//return new CartPage();
	}
	
	public BasePage logIn(String u_Name,String Pwd)
	{
		if(olayCloseBtn.isDisplayed())
		{
			olayCloseBtn.click();
		}
		logInBtn.click();
		olayUname.click();
		olayUname.clear();
		olayUname.sendKeys(u_Name);
		olayPwd.click();
		olayPwd.clear();
		olayPwd.sendKeys(Pwd);
		olayLogInBtn.click();
		
		//return getInstance(HomePage.class);
		return new HomePage();
	}
	public BasePage logOut() {
		if(isElementDisplayed(myDetails)) {
			Actions action = new Actions(driver);
			action.moveToElement(myDetails).perform();		
		}
		else {
			
		}
		
		for(WebElement row:myDetailslist) {
			if(row.getText().equalsIgnoreCase("Logout")) {
				row.click();
			}
		}
		
		return getInstance(HomePage.class);
		//return new HomePage();
	}
		


}
