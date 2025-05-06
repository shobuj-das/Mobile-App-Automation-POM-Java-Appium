package TestCases;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DataSet;
import Utilities.DriverSetup;
import org.testng.Assert;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginPage extends DriverSetup {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeClass
    public void navigateToLoginPage() {
        basePage.clickOnElement(homePage.menuBar);
        basePage.clickOnElement(homePage.loginOption);
    }

    @Test(priority = 1)
    public void loginWithValidCredentials() throws InterruptedException {
//        basePage.clickOnElement(homePage.menuBar);
//        basePage.clickOnElement(homePage.loginOption);
        basePage.writeOnElement(loginPage.usernameField, loginPage.validUsername);
        basePage.writeOnElement(loginPage.passwordFiled, loginPage.validPassword);
        basePage.clickOnElement(loginPage.loginButton);
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = DataSet.class , priority = 0)
    public void loginWithInvalidCredentials(String username, String password, String errorMgs, String type) throws InterruptedException {
//        basePage.clickOnElement(homePage.menuBar);
//        basePage.clickOnElement(homePage.loginOption);
        basePage.writeOnElement(loginPage.usernameField, username);
        basePage.writeOnElement(loginPage.passwordFiled, password);
        basePage.clickOnElement(loginPage.loginButton);
//
        String actualErrorMsg = loginPage.getErrorMsg(type);
        Assert.assertEquals(actualErrorMsg, errorMgs);
    }
    
    @Test
    public void loginButtonPropertyCheck() throws IOException {
//        basePage.clickOnElement(homePage.menuBar);
//        basePage.clickOnElement(homePage.loginOption);
        // Check button size
        int buttonWidth = loginPage.getElement(loginPage.loginButton).getSize().getWidth();
        int buttonHeight = loginPage.getElement(loginPage.loginButton).getSize().getHeight();
        Assert.assertTrue(buttonWidth > 0 && buttonHeight > 0);
        System.out.printf("Button size: %d x %d", buttonWidth, buttonHeight);
        // Check button label
        String buttonText = loginPage.getElement(loginPage.loginButtonLabel).getText();
        Assert.assertEquals(buttonText, "Login");

        // Check if button is enabled and clickable
        boolean isEnabled = loginPage.getElement(loginPage.loginButton).isEnabled();
        boolean isDisplayed = loginPage.getElement(loginPage.loginButton).isDisplayed();
        Assert.assertTrue(isEnabled && isDisplayed);
    }

}