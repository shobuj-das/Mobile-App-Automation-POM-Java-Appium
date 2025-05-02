package TestCases;

import Pages.BasePage;
import Pages.HomePage;
import Utilities.DriverSetup;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomePage_tc extends DriverSetup {
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();

    @Test
    public void homePageTest() throws InterruptedException {
        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByNameAscending);
        Thread.sleep(2000);

        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByNameDescending);
        Thread.sleep(2000);

    }

    @Test(testName = "sort by Name - descending")
    public void checkSortByNameDescending() {
        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByNameDescending);

        Assert.assertTrue(homePage.isProductSortedInDescendingOrderByName());
    }

    @Test(testName = "sort by Name - ascending")
    public void checkSortByNameAscending() {
        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByNameAscending);

        Assert.assertTrue(homePage.isProductSortedInAscendingOrderByName());
    }

    @Test ( testName = "sort by Price - ascending")
    public void checkSortByPriceAscending() {
        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByPriceAscending);
        Assert.assertTrue(homePage.isProductSortedInAscendingOrderByPrice());
    }

    @Test ( testName = "sort by Price - descending")
    public void checkSortByPriceDescending() {
        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByPriceDescending);
        Assert.assertTrue(homePage.isProductSortedInDescendingOrderByPrice());
    }
}
