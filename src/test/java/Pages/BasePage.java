package Pages;

import Utilities.DriverSetup;
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
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

    public WebElement getElement (By locator){
        return driver.findElement(locator);
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> getAllElements(By locator){
//        return wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) locator));
        return driver.findElements(locator);
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
        driver.perform(Collections.singletonList(swipe));
    }
}
