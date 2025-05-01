package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage {

    public By menuBar = By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView");
    public By loginOption = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");

    // -- product details
    public By productName = By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.TextView");

    // -- sort locators
    public By sortButton = AppiumBy.accessibilityId("sort button");
    public By sortByNameAscending = AppiumBy.accessibilityId("nameAsc");
    public By sortByNameDescending = AppiumBy.accessibilityId("nameDesc");
    public By sortByPriceAscending = AppiumBy.accessibilityId("priceAsc");
    public By sortByPriceDescending = AppiumBy.accessibilityId("priceDesc");

    // -- cart locators
    public By cartButton = AppiumBy.accessibilityId("cart badge");
    public By cartBadge = By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.TextView");

    public By linkedInButton = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView[3]");


    // -------------------------- Methods --------------------------------------

    public boolean isProductSortedInDescendingOrderByName(){

        List<String> productNames = new ArrayList<>();

        List<WebElement> names_1 = getAllElements(productName);
        for (WebElement name : names_1) {
            productNames.add(name.getDomAttribute("text"));
        }
        hoverToPoint(352, 1170, 352, 0);
        List<WebElement> names_2 = getAllElements(productName);

        for (WebElement name : names_2) {
            if (!productNames.contains(name.getDomAttribute("text"))) {
                productNames.add(name.getDomAttribute("text"));
            }
        }

        List<String> sortedNames = new ArrayList<>(productNames);
        sortedNames.sort(Collections.reverseOrder());
        return sortedNames.equals(productNames);
    }

    public boolean isProductSortedInAscendingOrderByName(){
        return !isProductSortedInDescendingOrderByName();
    }
}
