package com.orangehrmlive.testsuite;


import com.orangehrmlive.pages.LoginPage;
import com.orangehrmlive.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getAfterLoginText(), "Dashboard", "Text not found");
    }

    @Test(groups = {"smoke", "regression"})
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        loginPage.clickOnForgotPasswordLink();
        Assert.assertEquals(loginPage.getResetText(), "Reset Password", "Text not found");
    }
}
