package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="By.xpath(\"//a[normalize-space()='Register']\")")
	WebElement lnkregestration;
	
	@FindBy(xpath="By.xpath(\"//a[normalize-space()='Log in']\")")
	WebElement lnklogin;
	
	public void clickRegister()
	{
		lnkregestration.click();
	}
	public void clicklogin()
	{
		lnklogin.click();
	}
	
}
