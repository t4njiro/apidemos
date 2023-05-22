package apidemos;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ActionBarTabs extends ApiDemos {

    By TabModeText = By.xpath("//android.widget.TextView[contains(@text, 'App/Action Bar/Action Bar Tabs')]");
    By AddNewTabButton = By.id("com.hmh.api:id/btn_add_tab");
    By RemoveLastTabButton = By.id("com.hmh.api:id/btn_remove_tab");
    By ToggleTabModeButton = By.id("com.hmh.api:id/btn_toggle_tabs");
    By RemoveAllTabsButton = By.id("com.hmh.api:id/btn_remove_all_tabs");
    By ActionBarTabList = By.className("android.app.ActionBar$Tab");

    public ActionBarTabs(AndroidDriver appiumDriver) {
        super(appiumDriver);
    }

    public void disableToggleTabMode(){
        if(isDisplayed(TabModeText)){
            toggleTabMode();
        }
    }

    public void addNewTab(){
        clickElementLocator(AddNewTabButton);
    }

    public void addNewTabs(int n){
        for (int i = 0; i < n; i++) {
            addNewTab();
        }
    }

    public int tabCount(){
        return findElementLocatorList(ActionBarTabList).size();
    }

    public void removeLastTab(){
        clickElementLocator(RemoveLastTabButton);
    }

    public boolean isLastTabDeleted(int lastTab){
        By tab = By.xpath("//android.app.ActionBar.Tab[" + lastTab + "]");
        return !isDisplayed(tab);
    }

    public void toggleTabMode(){
        clickElementLocator(ToggleTabModeButton);
    }

    public void removeAllTabs(){
        clickElementLocator(RemoveAllTabsButton);
    }
}
