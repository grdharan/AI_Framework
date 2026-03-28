package com.framework.pages;

import com.framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private WaitUtils waitUtils;

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void login(String username, String password) {
        waitUtils.waitForElementVisible(usernameField).sendKeys(username);
        waitUtils.waitForElementVisible(passwordField).sendKeys(password);
        waitUtils.waitForElementClickable(loginButton).click();
    }

    public boolean isDashboardDisplayed() {
        return waitUtils.waitForElementVisible(dashboardHeader).isDisplayed();
    }
}
