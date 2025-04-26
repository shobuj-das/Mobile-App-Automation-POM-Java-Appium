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
    public static AndroidDriver driver;
    @BeforeSuite
    public void startApp() throws MalformedURLException {
        File file = new File("src/test/resources");
        File apk = new File(file, "Android-MyDemoAppRN.1.3.0.build-244.apk");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("testemu");
        options.setUdid("emulator-5554");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setApp(apk.getAbsolutePath());
//        options.setAppPackage("com.androidsample.generalstore");
//        options.setAppActivity("com.androidsample.generalstore.SplashActivity");

        options.setAppPackage("com.saucelabs.mydemoapp.rn");
        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");

        URL remoteUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(remoteUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterSuite
    public void quitApp(){
//        if(driver != null){
//            driver.removeApp("com.androidsample.generalstore");
//        }
        driver.quit();
    }
}
