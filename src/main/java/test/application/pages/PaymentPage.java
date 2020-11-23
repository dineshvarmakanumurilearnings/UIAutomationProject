package test.application.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import test.application.basic.BasePage;

public class PaymentPage extends BasePage{
	
	List<String> list=Arrays.asList(paySegment);
	@FindBy(css="div._7XMNLT h3 span:nth-child(2)")
	private List<WebElement> payHeaders;
	
	@FindBy(css="button[type='submit']>span")
	private WebElement continueBtninLoginSection;
	
	@FindBy(css="div._2TeEBm>form>div>input")
	private WebElement mailIDinLoginSection;
	
	@FindBy(css="input[type='password']")
	private WebElement passwordinLoginSection;
	
	@FindBy(css="button[type='submit']")
	private WebElement loginBtn;
	
	@FindBy(css="div._7XMNLT>div>div>button")
	private WebElement changebtnonLoginSection;
	
	public void landOnpaymentPage() {
		if(getTitle().contains("Secure Payment")) {
			
		}
		else
		{
			
		}
	}
	public void login(String uName,String pwd) {
		if(isElementDisplayed(mailIDinLoginSection) && isElementDisplayed(continueBtninLoginSection)) {
			mailIDinLoginSection.sendKeys(uName);
			
			continueBtninLoginSection.click();
			
		}
		else {
			
		}
		if(isElementDisplayed(passwordinLoginSection)&& isElementDisplayed(loginBtn)) {
			
			passwordinLoginSection.sendKeys(pwd);
			
			loginBtn.click();
			
		}
		else {
			
		}
	}
	
	 
	  public boolean loginCollapse() {
		  if(isElementDisplayed(changebtnonLoginSection))
			  return true;
		  else
			  return false;
	  }
}
