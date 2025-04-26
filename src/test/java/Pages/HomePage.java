package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public By menuBar = By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView");
//    public By loginOption = By.xpath("//android.widget.TextView[@text=\"Log In\"]");
    public By loginOption = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");


}
