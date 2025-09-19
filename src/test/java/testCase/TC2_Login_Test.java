package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testCases.BaseClass;


public class TC2_Login_Test extends BaseClass {

    @Test(groups="sanity")
    public void verify_InvalidLogin() {
        logger.info("**** Starting TC2_Login_Test (Invalid Login) ****");

        try {
            // Create Login Page Object
            LoginPage lp = new LoginPage(driver);

            // Enter invalid email
            lp.setemail("invalid@yourstore.com");
            logger.info("Entered Invalid Email");

            // Enter invalid password
            lp.setpwd("wrongpassword");
            logger.info("Entered Invalid Password");

            // Click login button
            lp.clicklogin();
            logger.info("Clicked Login");

            // Validation - Example: Check if error message is displayed
            String exp_msg = "Login was unsuccessful.";
            String pageSource = driver.getPageSource();

            if (pageSource.contains(exp_msg)) {
                logger.info("Invalid Login Test Passed");
                Assert.assertTrue(true);
            } else {
                logger.error("Invalid Login Test Failed");
                Assert.fail("Expected error message not found.");
            }

        } catch (Exception e) {
            logger.error("Exception in TC2_Login_Test: " + e.getMessage());
            Assert.fail("Test Failed due to Exception: " + e.getMessage());
        }

        logger.info("**** Finished TC2_Login_Test ****");
    }
}
