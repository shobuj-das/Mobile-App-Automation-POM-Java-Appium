package TestCases;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DataSet;
import Utilities.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage_tc extends DriverSetup {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        basePage.clickOnElement(homePage.menuBar);
        basePage.clickOnElement(homePage.loginOption);
        basePage.writeOnElement(loginPage.usernameField, loginPage.validUsername);
        basePage.writeOnElement(loginPage.passwordFiled, loginPage.validPassword);
        basePage.clickOnElement(loginPage.loginButton);

        Thread.sleep(3000);
    }
    @Test(dataProvider = "invalidLoginData", dataProviderClass = DataSet.class)
    public void loginWithInvalidCredentials(String username, String password, String errorMgs) throws InterruptedException {
        basePage.clickOnElement(homePage.menuBar);
        basePage.clickOnElement(homePage.loginOption);
        basePage.writeOnElement(loginPage.usernameField, username);
        basePage.writeOnElement(loginPage.passwordFiled, password);
        basePage.clickOnElement(loginPage.loginButton);
        Assert.assertEquals(basePage.getElementText(loginPage.));
    }
}
