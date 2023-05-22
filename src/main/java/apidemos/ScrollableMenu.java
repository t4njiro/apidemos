package apidemos;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ScrollableMenu extends ApiDemos{

    By SelectedTab = By.xpath("//android.widget.TextView[contains(@selected, 'true')]");
    By TabContentText = By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'android:id/tabcontent')]" +
            "/android.widget.TextView");

    public ScrollableMenu(AndroidDriver appiumDriver) {
        super(appiumDriver);
    }

    public By getDesiredTab(String desiredTab){
        return By.xpath("//*[contains(@text, '"+ "TAB " + desiredTab + "')]");
    }

    public void swipeUntilTab(String tab){
        appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"" + "Tab " + tab + "\"))"));
    }
}
