package apidemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CustomTitle extends ApiDemos {

    By leftTextBox = By.id("com.hmh.api:id/left_text_edit");
    By rightTextBox = By.id("com.hmh.api:id/right_text_edit");
    By leftNavigationBar = By.id("com.hmh.api:id/left_text");
    By rightNavigationBar = By.id("com.hmh.api:id/right_text");
    By leftTextButton = By.id("com.hmh.api:id/left_text_button");
    By rightTextButton = By.id("com.hmh.api:id/right_text_button");

    public CustomTitle(AndroidDriver appiumDriver) {
        super(appiumDriver);
    }

}
