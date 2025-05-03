package TestCases;

import Pages.BasePage;
import Pages.HomePage;
import Utilities.DriverSetup;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Test_HomePage extends DriverSetup {
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();

    @Test(testName = "sort by Name - descending", priority = 0)
    public void checkSortByNameDescending() {
        basePage.refreshPage();
        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByNameDescending);
        Assert.assertTrue(homePage.isProductSortedInDescendingOrderByName());
    }

    @Test(testName = "sort by Name - ascending", priority = 1)
    public void checkSortByNameAscending() {
        basePage.refreshPage();
        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByNameAscending);
        Assert.assertTrue(homePage.isProductSortedInAscendingOrderByName());
    }

    @Test ( testName = "sort by Price - ascending", priority = 2)
    public void checkSortByPriceAscending() {
        basePage.refreshPage();
        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByPriceAscending);
        Assert.assertTrue(homePage.isProductSortedInAscendingOrderByPrice());
    }

    @Test ( testName = "sort by Price - descending", priority = 3)
    public void checkSortByPriceDescending() {
        basePage.refreshPage();
        basePage.clickOnElement(homePage.sortButton);
        basePage.clickOnElement(homePage.sortByPriceDescending);
        Assert.assertTrue(homePage.isProductSortedInDescendingOrderByPrice());
    }

    @Test(testName = "checking product review star", priority = 4, enabled = false)
    public void checkProductReviewStar() {
        List<WebElement> reviewStars = homePage.getAllElements(homePage.reviewStar);

        for (int i = 0; i < reviewStars.size(); i++) {
            try {
                // Relocate the element to avoid stale element issues
                WebElement star = homePage.getAllElements(homePage.reviewStar).get(i);

                // Click the review star
                star.click();

                // Verify modal is displayed and enabled
                Assert.assertTrue(basePage.getDisplayStatus(homePage.closeModalButton), "Close modal button should be displayed.");
                Assert.assertTrue(basePage.getEnabledStatus(homePage.closeModalButton), "Close modal button should be enabled.");

                // Verify the welcome message
                Assert.assertEquals(basePage.getElementText(homePage.reviewWelcomeMgs), homePage.welcomeMgs, "Welcome message does not match.");

                // Close the modal
                basePage.clickOnElement(homePage.closeModalButton);
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element encountered for star at index " + i);
                // Optionally, you can retry or log the failure
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }


    @Test(enabled = false, testName = "testing")
    public void testing(){
        checkSortByNameAscending();
        basePage.refreshPage();
        checkSortByNameDescending();
    }
}
