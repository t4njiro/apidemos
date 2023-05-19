package apidemos;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ActionBarTabs extends ApiDemos {

    By TabTextView = By.className("android.widget.TextView");
    By AddNewTabButton = By.id("com.hmh.api:id/btn_add_tab");
    By RemoveLastTabButton = By.id("com.hmh.api:id/btn_remove_tab");
    By ToggleTabModeButton = By.id("com.hmh.api:id/btn_toggle_tabs");
    By RemoveAllTabsButton = By.id("com.hmh.api:id/btn_remove_all_tabs");
    By ActionBarTabList = By.className("android.app.ActionBar$Tab");

    public ActionBarTabs(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void disableToggleTabMode(){
        if(findElementLocator(TabTextView).isDisplayed()){
            toggleTabMode();
        }
        else
            return;
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
        By tab = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]" +
                "/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.app.ActionBar.Tab["
                +lastTab+"]/android.widget.TextView");
        try{
            return !findElementLocator(tab).isDisplayed();
        }
        catch (NoSuchElementException e){
            return true;
        }
    }

    public void toggleTabMode(){
        clickElementLocator(ToggleTabModeButton);
    }

    public void removeAllTabs(){
        clickElementLocator(RemoveAllTabsButton);
    }
}
