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

    // error messages
    public By usernameError = By.xpath("//android.view.ViewGroup[@content-desc='Username-error-message']/android.widget.TextView");
    public By passwordError = By.xpath("//android.view.ViewGroup[@content-desc='Password-error-message']/android.widget.TextView");
    public By loginError = By.xpath("//android.view.ViewGroup[@content-desc='generic-error-message']/android.widget.TextView");

    public By loginButtonLabel = By.xpath("(//android.widget.TextView[@text=\"Login\"])[2]");
// ----------------- Methods ---------------------------------
    public String getErrorMsg(String type){
        if(type.equals("username")){
            return getElementText(usernameError);
        }
        else if(type.equals("password")){
            return getElementText(passwordError);
        }
        else{
            return getElementText(loginError);
        }
    }
}
