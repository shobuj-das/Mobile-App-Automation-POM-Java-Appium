package Pages;

import Utilities.DriverSetup;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasePage extends DriverSetup {
    WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30));

    public WebElement getElement (By locator){
        return getDriver().findElement(locator);
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> getAllElements(By locator){
//        return wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) locator));
        return getDriver().findElements(locator);
    }
    public void writeOnElement(By locator, String text){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public void clickOnElement(By locator){
//        wait.until(ExpectedConditions.elementToBeClickable(locator));
        getElement(locator).click();
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public boolean getDisplayStatus(By locator){
        return getElement(locator).isDisplayed();
    }

    public boolean getEnabledStatus(By locator){
        return getElement(locator).isEnabled();
    }

    public boolean getSelectedStatus(By locator){
        return getElement(locator).isSelected();
    }

    public void hoverToPoint(int startX, int startY, int endX, int endY){

//        Dimension screenSize = driver.manage().window().getSize();
//        int screenWidth = screenSize.getWidth();
//        int screenHeight = screenSize.getHeight();
//
//        int bottomCenterX = screenWidth / 2;
//        int bottomCenterY = screenHeight / 2;
//        int topCenterX = screenWidth / 2;
//        int topCenterY = 0;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(Collections.singletonList(swipe));
    }

    public void refreshPage() {
        // Get the screen dimensions
        Dimension size = getDriver().manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();

        // Calculate swipe positions
        int startX = width / 2;
        int startY = (int) (height * 0.2);  // Start near the top of the screen
        int endY = (int) (height * 0.8);    // End near the bottom of the screen

        // Create pointer input for touch actions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Create the sequence of actions
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), startX, startY)); // This creates a pause
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(0));

        // Perform the actions
        getDriver().perform(Collections.singletonList(swipe));

        // Wait for refresh to complete (optional)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
