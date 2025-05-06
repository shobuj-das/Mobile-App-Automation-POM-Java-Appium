package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductDetails extends BasePage {
    public By black = By.xpath("//android.view.ViewGroup[@content-desc=\"black circle\"]");
    public By blue = By.xpath("//android.view.ViewGroup[@content-desc=\"blue circle\"]");
    public By red = By.xpath("//android.view.ViewGroup[@content-desc=\"red circle\"]");
    public By gray = By.xpath("//android.view.ViewGroup[@content-desc=\"gray circle\"]");

    public By price = AppiumBy.accessibilityId("product price");
    public By counterPlus = AppiumBy.accessibilityId("counter plus button");
    public By counterMinus = AppiumBy.accessibilityId("counter minus button");
    public By counterAmount = AppiumBy.accessibilityId("counter amount");
    public By addToCartButton = AppiumBy.accessibilityId("Add To Cart button");
    public By cartBadge = By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.TextView");
    public By cartButton = AppiumBy.accessibilityId("cart badge");

}
