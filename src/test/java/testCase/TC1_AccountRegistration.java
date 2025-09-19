package testCase;



import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegestrationPage;

public class TC1_AccountRegistration extends BaseClass{
	
	
	@Test(groups="Regression")
	void login() throws InterruptedException
	{
		logger.info("***Starting Accountregistariont*****");
		
		HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
	    hp.clickRegister();
	    Thread.sleep(5000);
		
		RegestrationPage regpage= new RegestrationPage(driver);
		
		regpage.setgender();
		regpage.setfirstname("John");
		regpage.setLastname("Tester");
		regpage.setEmail("KumarTester143@gmail.com");
		regpage.setpassword("Tester123");
		regpage.setconfirmpwd("Tester123");
		regpage.clickRegister();
		
		
		
	}


}
