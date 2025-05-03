package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HomePage extends BasePage {

    public By menuBar = By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView");
    public By loginOption = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");

    // -- product details
    public By productImage = By.xpath("//android.view.ViewGroup[@content-desc='store item']/android.view.ViewGroup/android.widget.ImageView");

//    public By productName = By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.TextView");
    public By productName = By.xpath("//android.widget.TextView[@content-desc='store item text']");
    public By productPrice = By.xpath("//android.widget.TextView[@content-desc='store item price']");

    public By reviewStar = By.xpath("//android.view.ViewGroup[starts-with(@content-desc, 'review')]");
    public By closeModalButton = AppiumBy.accessibilityId("Close Modal button");
    public By reviewWelcomeMgs = By.xpath("//android.widget.TextView[@text='Thank you for submitting your review!']");
    public final String welcomeMgs = "Thank you for submitting your review!";
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

    public List<String> getProductNameList(){

        refreshPage();
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
        return productNames;
    }

    public boolean isProductSortedInAscendingOrderByName(){
        List<String> productNames = getProductNameList();
        System.out.println("Ascending name: " + productNames.size());
        for (int i = 0; i < productNames.size() - 1; i++) {
            if (productNames.get(i).compareToIgnoreCase(productNames.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isProductSortedInDescendingOrderByName(){
        List<String> productNames = getProductNameList();
        System.out.println("Descending name: " + productNames.size());
        for (int i = 0; i < productNames.size() - 1; i++) {
            if (productNames.get(i).compareToIgnoreCase(productNames.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public List<Float> getPriceList(){
        List<Float> prices = new ArrayList<>();
        refreshPage();
        List<WebElement> prices_1 = getAllElements(productPrice);
        for(WebElement price : prices_1){
            float value = Float.parseFloat(price.getText().replace("$",""));;
            prices.add(value);
        }

        hoverToPoint(352, 1170, 352, 0);
        List<WebElement> prices_2 = getAllElements(productPrice);

        for(WebElement price : prices_2){
            float value = Float.parseFloat(price.getText().replace("$",""));
            if(!prices.contains(value)){
                prices.add(value);
            }
        }
        return prices;
    }

    public boolean isProductSortedInAscendingOrderByPrice(){
        List<Float> prices = getPriceList();
        System.out.println("Ascending price: " + prices.size());
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isProductSortedInDescendingOrderByPrice(){
        List<Float> prices = getPriceList();
        System.out.println("Descendin price: " + prices.size());
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
