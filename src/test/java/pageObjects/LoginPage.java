package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='Email']")
	WebElement txemail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txpwd;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement txlogin;
	
	public void setemail(String email)
	{
		txemail.sendKeys(email);
	}
	public void setpwd(String pwd)
	{
		txpwd.sendKeys(pwd);
	}
	public void clicklogin()
	{
		txlogin.click();
	}
}
