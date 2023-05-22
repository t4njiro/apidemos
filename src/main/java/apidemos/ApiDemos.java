package apidemos;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class ApiDemos
{
    public AndroidDriver appiumDriver;

    By AppMenu = By.xpath("//android.widget.TextView[contains(@text, 'App')]");
    By ActionBarMenu = By.xpath("//android.widget.TextView[contains(@text, 'Action Bar')]");
    By ActionBarTabsMenu = By.xpath("//android.widget.TextView[contains(@text, 'Action Bar Tabs')]");
    By ActivityMenu = By.xpath("//android.widget.TextView[contains(@text, 'Activity')]");
    By CustomTitleMenu = By.xpath("//android.widget.TextView[contains(@text, 'Custom Title')]");
    By AlertDialogsMenu = By.xpath("//android.widget.TextView[contains(@text, 'Alert Dialogs')]");
    By ListDialog = By.id("com.hmh.api:id/select_button");
    By FragmentMenu = By.xpath("//android.widget.TextView[contains(@text, 'Fragment')]");
    By ContextMenu = By.xpath("//android.widget.TextView[contains(@text, 'Context Menu')]");
    By HideAndShowMenu = By.xpath("//android.widget.TextView[contains(@text, 'Hide and Show')]");
    By NotificationMenu = By.xpath("//android.widget.TextView[contains(@text, 'Notification')]");
    By IncomingMessageMenu = By.xpath("//android.widget.TextView[contains(@text, 'IncomingMessage')]");
    By ViewsMenu = By.xpath("//android.widget.TextView[contains(@text, 'Views')]");
    By TabsMenu = By.xpath("//android.widget.TextView[contains(@text, 'Tabs')]");
    By ScrollableMenu = By.xpath("//android.widget.TextView[contains(@text, 'Scrollable')]");

    public ApiDemos(AndroidDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public boolean arePermissionsGiven(){
        if (appiumDriver.getCapabilities().getCapability(
                AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS).toString().equals("true")){
            return true;
        }
        return false;
    }

    public WebElement findElementLocator(By elementLocator){
        return appiumDriver.findElement(elementLocator);
    }

    public List<WebElement> findElementLocatorList(By elementLocator){
        return appiumDriver.findElements(elementLocator);
    }

    public void clickElementLocator(By elementLocator){
        findElementLocator(elementLocator).click();
    }

    public String getTextOfElement(By elementLocator){
        return findElementLocator(elementLocator).getText();
    }

    public void clearText(By elementLocator){
        findElementLocator(elementLocator).clear();
    }

    public void sendKeysTo(By elementLocator, String key){
        findElementLocator(elementLocator).sendKeys(key);
    }

    public boolean isDisplayed(By elementLocator){
        try {
            WebElement element = findElementLocator(elementLocator);
            return element.isDisplayed();
        }
        catch (NoSuchElementException noSuchElementException){
            return false;
        }
        catch (StaleElementReferenceException staleElementReferenceException){
            return false;
        }
    }

    public void scrollUntilElementDisplayed(By elementLocator){
        TouchAction action = new TouchAction(appiumDriver);
        Dimension size = appiumDriver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX=width/2;
        int startYCoordinate= (int)(height*.7);
        int endYCoordinate= (int)(height*.2);
        while(!isDisplayed(elementLocator)){
            action.press(PointOption.point(middleOfX, startYCoordinate))
                    .waitAction(waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
        }
    }

}
