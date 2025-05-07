package TestCases;

import Pages.BasePage;
import Pages.HomePage;
import Pages.ProductDetails;
import Utilities.DriverSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestProductPage extends DriverSetup {
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    ProductDetails productDetails = new ProductDetails();
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

    @Test(priority = 0 )
    public void addMultiColorProductToCart() throws InterruptedException {
        basePage.clickOnElement(homePage.productImage);
        basePage.hoverToPoint(328,1042,328,283);
        // select black color
        basePage.clickOnElement(productDetails.black);
        basePage.clickOnElement(productDetails.addToCartButton);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(productDetails.cartBadge, "1"));
//        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "1");
        softAssert.assertEquals(basePage.getElementText(productDetails.cartBadge), "1", "Cart badge does not match.");
        // select red color
        basePage.clickOnElement(productDetails.red);
        basePage.clickOnElement(productDetails.addToCartButton);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(productDetails.cartBadge, "2"));
//        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "2");
        softAssert.assertEquals(basePage.getElementText(productDetails.cartBadge), "2", "Cart badge does not match.");
        //select blue color
        basePage.clickOnElement(productDetails.blue);
        basePage.clickOnElement(productDetails.addToCartButton);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(productDetails.cartBadge, "3"));
//        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "3");
        softAssert.assertEquals(basePage.getElementText(productDetails.cartBadge), "3", "Cart badge does not match.");
        //select gray color
        basePage.clickOnElement(productDetails.gray);
        basePage.clickOnElement(productDetails.addToCartButton);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(productDetails.cartBadge, "4"));
//        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "4");
        softAssert.assertEquals(basePage.getElementText(productDetails.cartBadge), "4", "Cart badge does not match.");
        // select counter plus button
        basePage.clickOnElement(productDetails.counterPlus);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(productDetails.counterAmount, "2"));
//        Assert.assertEquals(basePage.getElementText(productDetails.counterAmount),"2");
        softAssert.assertEquals(basePage.getElementText(productDetails.counterAmount),"2", "Counter amount does not match.");
        basePage.clickOnElement(productDetails.addToCartButton);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(productDetails.cartBadge, "6"));
//        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "6");
        softAssert.assertEquals(basePage.getElementText(productDetails.cartBadge), "6", "Cart badge does not match.");
        // select counter minus button
        basePage.clickOnElement(productDetails.counterMinus);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(productDetails.counterAmount, "1"));
//        Assert.assertEquals(basePage.getElementText(productDetails.counterAmount),"1");
        softAssert.assertEquals(basePage.getElementText(productDetails.counterAmount),"1", "Counter amount does not match.");
        basePage.clickOnElement(productDetails.addToCartButton);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(productDetails.cartBadge, "7"));
//        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "7");
        softAssert.assertEquals(basePage.getElementText(productDetails.cartBadge), "7", "Cart badge does not match.");

        basePage.clickOnElement(productDetails.counterMinus);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(productDetails.counterAmount, "0"));
//        Assert.assertEquals(basePage.getElementText(productDetails.counterAmount),"0");
        softAssert.assertEquals(basePage.getElementText(productDetails.counterAmount),"0", "Counter amount does not match.");
        Assert.assertFalse(basePage.getEnabledStatus(productDetails.addToCartButton));

    }

    @Test(dependsOnMethods = {"addMultiColorProductToCart"}, priority = 1)
    public void addSecondProductToCart(){
        getDriver().navigate().back();
        WebElement product = basePage.getAllElements(homePage.productImage).get(1);
        product.click();
        basePage.hoverToPoint(328,1042,328,283);
        basePage.clickOnElement(productDetails.addToCartButton);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(productDetails.cartBadge, "8"));
//        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "8");
        softAssert.assertEquals(basePage.getElementText(productDetails.cartBadge), "8", "Cart badge does not match.");
    }
}
