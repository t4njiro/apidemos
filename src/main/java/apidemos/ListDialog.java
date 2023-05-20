package apidemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ListDialog extends ApiDemos {

    By SelectedElement;
    By AlertMessage = By.id("android:id/message");

    public ListDialog(AndroidDriver appiumDriver) {
        super(appiumDriver);
    }

    public String selectAnyElement() {
        String listElementsXpath = "//android.widget.ListView/android.widget.TextView";
        List<WebElement> list = findElementLocatorList(By.xpath(listElementsXpath));

        Random random = new Random();
        int randomElement = random.nextInt(list.size());
        int idx = randomElement + 1;
        this.SelectedElement = By.xpath(listElementsXpath + '[' + idx + ']');

        String msg = "You selected: " + randomElement + " , " + getTextOfElement(SelectedElement);
        findElementLocator(SelectedElement).click();
        return msg;
    }
}
