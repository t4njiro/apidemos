package apidemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.input.model.TouchPoint;

public class ContextMenu extends ApiDemos{

    By LongPressMeButton = By.id("com.hmh.api:id/long_press");
    By MenuA = By.xpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]");
    By MenuB = By.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]");

    public ContextMenu(AndroidDriver appiumDriver) {
        super(appiumDriver);
    }

    public void longPress(By elementLocator) throws InterruptedException {
        WebElement el = findElementLocator(elementLocator);
        AndroidTouchAction touchAction = new AndroidTouchAction((PerformsTouchActions) appiumDriver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(el))).perform();
    }
}
