package apidemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class IncomingMessage extends ApiDemos{

    By ShowNotificationButton = By.id("com.hmh.api:id/notify");
    By NotificationApp = By.xpath("//*[contains(@resource-id, 'android:id/app_name_text')][contains(@text, 'API Demos')]");
    By NotificationTitle = By.xpath("(//*[contains(@resource-id, 'android:id/title')])[1]");
    By NotificationText = By.xpath("(//*[contains(@resource-id, 'android:id/text')])[1]");
    By NotificationDetailText = By.xpath("//*[contains(@text, 'Did you notice that the status bar icon disappeared?')]");
    By NotificationDetailMsg = By.xpath("//android.widget.ImageView/../android.widget.TextView");

    public IncomingMessage(AndroidDriver appiumDriver) {
        super(appiumDriver);
    }
}
