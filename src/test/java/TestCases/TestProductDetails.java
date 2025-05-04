package TestCases;

import Pages.BasePage;
import Pages.HomePage;
import Pages.ProductDetails;
import Utilities.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductDetails extends DriverSetup {
    BasePage basePage = new BasePage();
    ProductDetails productDetails = new ProductDetails();
    HomePage homePage = new HomePage();

    @Test
    public void testProductDetails(){
        basePage.clickOnElement(homePage.productImage);
        basePage.hoverToPoint(346,997,346,373);
        basePage.clickOnElement(productDetails.addToCartButton);
        Assert.assertEquals(basePage.getElementText(productDetails.cartBadge), "1");
        basePage.hoverToPoint(346,373,346,997);
    }

    @Test
    public void getActivity() throws InterruptedException {
        basePage.clickOnElement(homePage.productImage);
        String activityName = driver.currentActivity();
        System.out.println( "Current activity: " + activityName);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
    }
}
