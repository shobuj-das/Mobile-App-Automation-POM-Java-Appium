package TestCases;

import Pages.BasePage;
import Pages.HomePage;
import Utilities.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        basePage.clickOnElement(homePage.sortByPriceAscending);
        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByNameAscending);

        Assert.assertFalse(homePage.isProductSortedInAscendingOrderByName());
    }
}
