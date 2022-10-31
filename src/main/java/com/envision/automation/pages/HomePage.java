package com.envision.automation.pages;

import com.envision.automation.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage checkIfSignOutDisplayed() throws IOException {
        boolean status = isDisplayed("HomePage.lnkSignedOut");
        Assert.assertTrue(status, "Element Sign Out not displayed");
        return this;
    }

    public String getUsernameLoggedIn() throws IOException {
        String name = getWebElementText("HomePage.lnkUserLoggedIn");
        return name;
    }

    public HomePage checkIfUsernameLoggedInIsValid(String userLoggedIn) throws IOException {
        Assert.assertEquals(userLoggedIn, getUsernameLoggedIn());
        return this;
    }
}
