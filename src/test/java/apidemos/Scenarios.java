package apidemos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Scenarios extends AppTest {

    @Test
    public void scenario1() throws InterruptedException {
        //Checks if the application is installed
        //Assertions.assertTrue(appiumDriver.isAppInstalled("com.hmh.api"),
        //        "App is not installed");

        //Checks if permissions are given by default
        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        apiDemos.arePermissionsGiven();

        //Checks if the opened app is the desired app
        //Assertions.assertTrue(appiumDriver.queryAppState("com.hmh.api.ApiDemos").equals("RUNNING"));

        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.ActionBarMenu);
        apiDemos.clickElementLocator(apiDemos.ActionBarTabsMenu);

        ActionBarTabs actionBarTabs = new ActionBarTabs(appiumDriver);
        actionBarTabs.disableToggleTabMode();
        int desiredTabCount = 3;
        actionBarTabs.addNewTabs(desiredTabCount);
        //Checks if desired number of tabs are added
        Thread.sleep(2000);
        Assertions.assertEquals(actionBarTabs.tabCount(), desiredTabCount,
                "Tab count is not " + desiredTabCount + "!");

        actionBarTabs.removeLastTab();
        //Checks if the last tab is deleted
        Assertions.assertTrue(actionBarTabs.isLastTabDeleted(desiredTabCount),
                "Last tab is not deleted!");

        actionBarTabs.removeAllTabs();
        //Checks if there is no active tab
        Assertions.assertEquals(actionBarTabs.tabCount(), 0,
                "There is an active tab or tabs!");
    }

    @Test
    public void scenario2() throws IOException, InterruptedException {
        //Clears cache without deleting the app
        Runtime.getRuntime().exec("adb shell pm clear com.hmh.api");

        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        Thread.sleep( 2000);
        apiDemos.clickElementLocator(apiDemos.openApp);
        Thread.sleep( 2000);
        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.ActivityMenu);
        apiDemos.clickElementLocator(apiDemos.CustomTitleMenu);

        //Checks the default textBox & navigationBar texts
        CustomTitle customTitle = new CustomTitle(appiumDriver);
        String leftText = "Left is best";
        String rightText = "Right is always right";
        Assertions.assertEquals(customTitle.getTextOfElement(customTitle.leftTextBox), leftText);
        Assertions.assertEquals(customTitle.getTextOfElement(customTitle.rightTextBox), rightText);
        Assertions.assertEquals(customTitle.getTextOfElement(customTitle.leftNavigationBar), leftText);
        Assertions.assertEquals(customTitle.getTextOfElement(customTitle.rightNavigationBar), rightText);

        //Checks if the changed texts are correct
        String newLeftText = "hello left";
        customTitle.clearText(customTitle.leftTextBox);
        customTitle.sendKeysTo(customTitle.leftTextBox, newLeftText);
        customTitle.clickElementLocator(customTitle.leftTextButton);
        Assertions.assertEquals(customTitle.getTextOfElement(customTitle.leftTextBox), newLeftText);
        Assertions.assertEquals(customTitle.getTextOfElement(customTitle.leftNavigationBar), newLeftText);

        String newRightText = "bye right";
        customTitle.clearText(customTitle.rightTextBox);
        customTitle.sendKeysTo(customTitle.rightTextBox, newRightText);
        customTitle.clickElementLocator(customTitle.rightTextButton);
        Assertions.assertEquals(customTitle.getTextOfElement(customTitle.rightTextBox), newRightText);
        Assertions.assertEquals(customTitle.getTextOfElement(customTitle.rightNavigationBar), newRightText);

    }

    @Test
    public void scenario3() throws IOException, InterruptedException {
        //Clears cache without deleting the app
        Runtime.getRuntime().exec("adb shell pm clear com.hmh.api");

        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        Thread.sleep( 2000);
        apiDemos.clickElementLocator(apiDemos.openApp);
        Thread.sleep( 2000);
        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.AlertDialogsMenu);
        apiDemos.clickElementLocator(apiDemos.ListDialog);

        ListDialog listDialog = new ListDialog(appiumDriver);
        Thread.sleep(2000);
        String alertMessage = listDialog.selectAnyElement();
        //Checks if the alert message is correct
        Assertions.assertEquals(listDialog.getTextOfElement(listDialog.AlertMessage), alertMessage, "" +
                "Alert message is incorrect!");

    }

    @Test
    public void scenario4() throws IOException, InterruptedException {
        //Clears cache without deleting the app
        Runtime.getRuntime().exec("adb shell pm clear com.hmh.api");

        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        Thread.sleep( 2000);
        apiDemos.clickElementLocator(apiDemos.openApp);
        Thread.sleep( 2000);
        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.FragmentMenu);
        apiDemos.clickElementLocator(apiDemos.ContextMenu);

        ContextMenu contextMenu = new ContextMenu(appiumDriver);
        contextMenu.longPress(contextMenu.LongPressMeButton);

        //Checks if the Menu A and Menu B are opened
        Assertions.assertEquals(contextMenu.getTextOfElement(contextMenu.MenuA), "Menu A");
        Assertions.assertEquals(contextMenu.getTextOfElement(contextMenu.MenuB), "Menu B");
    }

    @Test
    public void scenario5() throws IOException, InterruptedException {
        //Clears cache without deleting the app
        Runtime.getRuntime().exec("adb shell pm clear com.hmh.api");

        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        Thread.sleep( 2000);
        apiDemos.clickElementLocator(apiDemos.openApp);
        Thread.sleep( 2000);
        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.FragmentMenu);
        apiDemos.clickElementLocator(apiDemos.HideAndShowMenu);
    }

}
