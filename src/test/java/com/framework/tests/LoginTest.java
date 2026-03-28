package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test(description = "Verify successful login with valid credentials")
    public void testSuccessfulLogin() {
        logger.info("Starting Successful Login Test");
        LoginPage loginPage = new LoginPage(getDriver());
        
        loginPage.login("Admin", "admin123");
        logger.info("Login performed");
        
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard should be displayed after login");
        logger.info("Login verified successfully");
    }
}
