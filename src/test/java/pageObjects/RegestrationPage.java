package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegestrationPage extends BasePage {
	
	public RegestrationPage(WebDriver driver) {
		super(driver);


	}
	
@FindBy(xpath="//input[@id='gender-male']")
WebElement gender;

@FindBy(xpath="//input[@id='FirstName']")
WebElement InFirstname;

@FindBy(xpath="//input[@id='LastName']")
WebElement InLastname;

@FindBy(xpath="//input[@id='Email']")
WebElement Inemail;

@FindBy(xpath="//input[@id='Password']")
WebElement InPassword;

@FindBy(xpath="//input[@id='ConfirmPassword']")
WebElement InconfirmPassword;

@FindBy(xpath="//input[@id='register-button']")
WebElement Btregister;

public void setgender()
{
	gender.click();
}

public void setfirstname(String fname)
{
	InFirstname.sendKeys(fname);
}
public void setLastname(String lname)
{
	InLastname.sendKeys(lname);
}
public void setEmail(String email)
{
	Inemail.sendKeys(email);
}
public void setpassword(String pwd)
{
	InPassword.sendKeys(pwd);
}

public void setconfirmpwd(String pwd)
{
	InconfirmPassword.sendKeys(pwd);
}

public void clickRegister()
{
	Btregister.click();
}

}
