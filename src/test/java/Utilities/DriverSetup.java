package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverSetup {
    private AndroidDriver driver;

    public void setupDriver() throws MalformedURLException {
        File file = new File("src/test/resources");
        File apk = new File(file, "Android-MyDemoAppRN.1.3.0.build-244.apk");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("testemu"); // change this to your device name
        options.setUdid("emulator-5554"); // change this to your device udid
        options.setPlatformName("android"); // change this to your device platform name
        options.setAutomationName("UiAutomator2"); //
        options.setApp(apk.getAbsolutePath());
        options.setAppPackage("com.saucelabs.mydemoapp.rn");
        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");

        URL remoteUrl = new URL("http://127.0.0.1:4723"); // change this to your appium server url
        driver = new AndroidDriver(remoteUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @BeforeSuite
    public void startApp() throws MalformedURLException {
        setupDriver();
    }

    public AndroidDriver getDriver(){
        return driver;
    }
    @AfterSuite
    public void quitApp(){
//        if(driver != null){
//            driver.removeApp("com.androidsample.generalstore");
//        }
        getDriver().quit();
    }
}
