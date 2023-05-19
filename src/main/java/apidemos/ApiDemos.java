package apidemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApiDemos
{
    public AppiumDriver appiumDriver;

    By AppMenu = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]" +
            "/android.widget.ListView/android.widget.TextView[3]");
    By ActionBarMenu = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
            "FrameLayout[2]/android.widget.ListView/android.widget.TextView[1]");
    By ActionBarTabsMenu = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
            "FrameLayout[2]/android.widget.ListView/android.widget.TextView[2]");
    By ActivityMenu = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
            "FrameLayout[2]/android.widget.ListView/android.widget.TextView[2]");
    By CustomTitleMenu = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
            "FrameLayout[2]/android.widget.ListView/android.widget.TextView[3]");
    By openApp = By.xpath("(//android.widget.TextView[@content-desc=\"API Demos\"])[1]");
    By AlertDialogsMenu = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
            "FrameLayout[2]/android.widget.ListView/android.widget.TextView[4]");
    By ListDialog = By.id("com.hmh.api:id/select_button");
    By FragmentMenu = By.xpath("//android.widget.ListView/android.widget.TextView[6]");
    By ContextMenu = By.xpath("//android.widget.ListView/android.widget.TextView[3]");
    By HideAndShowMenu = By.xpath("//android.widget.ListView/android.widget.TextView[7]");

    public ApiDemos(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void arePermissionsGiven(){
        Assertions.assertTrue(appiumDriver.getCapabilities().getCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS).toString().equals("true"),
                "Permissions are not given by default");
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

}
