package TestCases;

import Pages.BasePage;
import Pages.HomePage;
import Pages.ProductDetails;
import Utilities.DriverSetup;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductPage extends DriverSetup {
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    ProductDetails productDetails = new ProductDetails();

    @Test(priority = 0 )
    public void addMultiColorProductToCart() throws InterruptedException {
        basePage.clickOnElement(homePage.productImage);
        basePage.hoverToPoint(328,1042,328,283);
        // select black color
        basePage.clickOnElement(productDetails.black);
        basePage.clickOnElement(productDetails.addToCartButton);
        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "1");
        // select red color
        basePage.clickOnElement(productDetails.red);
        basePage.clickOnElement(productDetails.addToCartButton);
        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "2");
        //select blue color
        basePage.clickOnElement(productDetails.blue);
        basePage.clickOnElement(productDetails.addToCartButton);
        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "3");
        //select gray color
        basePage.clickOnElement(productDetails.gray);
        basePage.clickOnElement(productDetails.addToCartButton);
        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "4");
        // select counter plus button
        basePage.clickOnElement(productDetails.counterPlus);
        Assert.assertEquals(basePage.getElementText(productDetails.counterAmount),"2");
        basePage.clickOnElement(productDetails.addToCartButton);
        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "6");
        // select counter minus button
        basePage.clickOnElement(productDetails.counterMinus);
        Assert.assertEquals(basePage.getElementText(productDetails.counterAmount),"1");
        basePage.clickOnElement(productDetails.addToCartButton);
        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "7");

        basePage.clickOnElement(productDetails.counterMinus);
        Assert.assertEquals(basePage.getElementText(productDetails.counterAmount),"0");
        Assert.assertFalse(basePage.getEnabledStatus(productDetails.addToCartButton));

    }

    @Test(dependsOnMethods = {"addMultiColorProductToCart"}, priority = 1)
    public void addSecondProductToCart(){
        driver.navigate().back();
        WebElement product = basePage.getAllElements(homePage.productImage).get(1);
        product.click();
        basePage.hoverToPoint(328,1042,328,283);
        basePage.clickOnElement(productDetails.addToCartButton);
        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "8");
    }
}
