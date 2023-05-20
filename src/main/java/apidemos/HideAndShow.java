package apidemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HideAndShow extends ApiDemos{

    By UpperButton = By.id("com.hmh.api:id/frag1hide");
    By LowerButton = By.id("com.hmh.api:id/frag2hide");
    By UpperTextBox = By.id("com.hmh.api:id/fragment1");
    By LowerTextBox = By.id("com.hmh.api:id/fragment2");

    public HideAndShow(AndroidDriver appiumDriver) {
        super(appiumDriver);
    }
}
