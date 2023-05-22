package apidemos;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu extends ApiDemos{

    By LongPressMeButton = By.id("com.hmh.api:id/long_press");
    By MenuA = By.xpath("//android.widget.RelativeLayout/android.widget.TextView[contains(@text, 'Menu A')]");
    By MenuB = By.xpath("//android.widget.RelativeLayout/android.widget.TextView[contains(@text, 'Menu B')]");

    public ContextMenu(AndroidDriver appiumDriver) {
        super(appiumDriver);
    }

    public void longPress(By elementLocator) {
        WebElement el = findElementLocator(elementLocator);
        Actions actions = new Actions(appiumDriver);
        actions.clickAndHold(el);
        actions.perform();
    }
}
