package Pages;

import Utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage extends DriverSetup {
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

    public WebElement getElement (By locator){
        return driver.findElement(locator);
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> getAllElements(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) locator));
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
}
