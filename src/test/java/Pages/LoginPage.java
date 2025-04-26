package Pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    // valid username and password
    public final String validUsername = "bob@example.com";
    public final String validPassword = "10203040";

    // login locators
    public By usernameField = By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]");
    public By passwordFiled = By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]");
    public By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]");


}
