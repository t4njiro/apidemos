package apidemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppTest
{
    public static AndroidDriver appiumDriver;
    public static String appPackage = "com.hmh.api";
    public static String appActivity = ".ApiDemos";

    @BeforeAll
    static void beforeTest() {
        try{
            System.out.println("Starting tests on Android...");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 27");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appPackage + appActivity);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AndroidDriver(url, desiredCapabilities);
        }
        catch (MalformedURLException mx){
            System.out.println("Malformed URL Exception");
        }
    }

    @AfterAll
    static void tearDown(){
        if(appiumDriver != null)
            appiumDriver.quit();
    }

    public void openApp() throws IOException {
        Runtime.getRuntime().exec("adb shell am start -n " + appPackage + "/" + appPackage + appActivity);
    }

    public void clearCacheWithoutDeleting() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("adb shell pm clear " + appPackage);
        Thread.sleep(5000);
        openApp();
        Thread.sleep(5000);
    }
    public void restartApp() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("adb shell am force-stop " + appPackage);
        Thread.sleep(2000);
        openApp();
        Thread.sleep(2000);
    }

}
