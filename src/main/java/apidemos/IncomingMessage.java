package apidemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class IncomingMessage extends ApiDemos{

    By ShowNotificationButton = By.id("com.hmh.api:id/notify");
    By FirstNotificationSenderApp = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget" +
            ".FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]" +
            "/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView");
    By FistNotificationSender = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android." +
            "widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    By FirstNotificationText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android." +
            "widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView");

    public IncomingMessage(AndroidDriver appiumDriver) {
        super(appiumDriver);
    }

    public void getNotificationText(){

    }
}
