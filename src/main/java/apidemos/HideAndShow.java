package apidemos;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HideAndShow extends ApiDemos{

    By UpperHideButton = By.id("com.hmh.api:id/frag1hide");
    By LowerHideButton = By.id("com.hmh.api:id/frag2hide");
    By UpperTextBox = By.id("com.hmh.api:id/fragment1");
    By LowerTextBox = By.id("com.hmh.api:id/fragment2");

    public HideAndShow(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
}
