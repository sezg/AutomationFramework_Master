package com.envision.automation.tests;

import com.envision.automation.framework.core.BaseTest;
import com.envision.automation.framework.utils.DataGenerator;
import com.envision.automation.pages.HomePage;
import com.envision.automation.pages.LandingPage;
import com.envision.automation.pages.LoginPage;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseTest {

    @Test
    public void validateSuccessfulLoginToApplication() throws IOException, InterruptedException {
        JSONObject loginData = jsonUtils.getJsonObject(jsonUtils.mainJsonObj, "loginData");
        String userName = jsonUtils.getJsonObjectValue(loginData, "username");
        String passWord = jsonUtils.getJsonObjectValue(loginData, "password");
        String loginName = jsonUtils.getJsonObjectValue(loginData, "loginName");


        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage
                .launchAutomationPracticeApplication()
                .clickOnSignIn();

        HomePage homePage = loginPage
                .enterUsername(userName)
                .enterPassword(passWord)
                .clickOnSignIn();

        homePage
                .checkIfSignOutDisplayed()
                .checkIfUsernameLoggedInIsValid(loginName);
    }

    @Test
    public void validateSuccessfulLoginUsingRandomData() throws IOException, InterruptedException {

        System.out.println(DataGenerator.getUsername()
                +"/ "+DataGenerator.getPassword()
                +"/ "+DataGenerator.getLoginName());

        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage
                .launchAutomationPracticeApplication()
                .clickOnSignIn();

        HomePage homePage = loginPage
                .enterUsername(DataGenerator.getUsername())
                .enterPassword(DataGenerator.getPassword())
                .clickOnSignIn();

        homePage
                .checkIfSignOutDisplayed()
                .checkIfUsernameLoggedInIsValid(DataGenerator.getLoginName());
    }
}
