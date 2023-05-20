package apidemos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Scenarios extends AppTest {

    @Test
    public void scenario1() throws InterruptedException {
        //Checks if the application is installed
        Assertions.assertTrue(appiumDriver.isAppInstalled("com.hmh.api"),
                "App is not installed");

        //Checks if permissions are given by default
        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        apiDemos.arePermissionsGiven();

        //Checks if the opened app is the desired app
        Assertions.assertEquals(".ApiDemos", appiumDriver.currentActivity());

        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.ActionBarMenu);
        apiDemos.clickElementLocator(apiDemos.ActionBarTabsMenu);

        ActionBarTabs actionBarTabs = new ActionBarTabs(appiumDriver);
        actionBarTabs.disableToggleTabMode();
        int desiredTabCount = 3;
        actionBarTabs.addNewTabs(desiredTabCount);
        //Checks if desired number of tabs are added
        Thread.sleep(2000);
        Assertions.assertEquals(desiredTabCount, actionBarTabs.tabCount(),
                "Tab count is not " + desiredTabCount + "!");

        actionBarTabs.removeLastTab();
        //Checks if the last tab is deleted
        Assertions.assertTrue(actionBarTabs.isLastTabDeleted(desiredTabCount),
                "Last tab is not deleted!");

        actionBarTabs.removeAllTabs();
        //Checks if there is no active tab
        Assertions.assertEquals(0, actionBarTabs.tabCount(),
                "There is an active tab or tabs!");
    }

    @Test
    public void scenario2() throws IOException, InterruptedException {
        //Clears cache without deleting the app
        clearCacheWithoutDeleting();

        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.ActivityMenu);
        apiDemos.clickElementLocator(apiDemos.CustomTitleMenu);

        //Checks the default textBox & navigationBar texts
        CustomTitle customTitle = new CustomTitle(appiumDriver);
        String leftText = "Left is best";
        String rightText = "Right is always right";
        Assertions.assertEquals(leftText, customTitle.getTextOfElement(customTitle.leftTextBox));
        Assertions.assertEquals(rightText, customTitle.getTextOfElement(customTitle.rightTextBox));
        Assertions.assertEquals(leftText, customTitle.getTextOfElement(customTitle.leftNavigationBar));
        Assertions.assertEquals(rightText, customTitle.getTextOfElement(customTitle.rightNavigationBar));

        //Checks if the changed texts are correct
        String newLeftText = "hello left";
        customTitle.clearText(customTitle.leftTextBox);
        customTitle.sendKeysTo(customTitle.leftTextBox, newLeftText);
        customTitle.clickElementLocator(customTitle.leftTextButton);
        Assertions.assertEquals(newLeftText, customTitle.getTextOfElement(customTitle.leftTextBox));
        Assertions.assertEquals(newLeftText, customTitle.getTextOfElement(customTitle.leftNavigationBar));

        String newRightText = "bye right";
        customTitle.clearText(customTitle.rightTextBox);
        customTitle.sendKeysTo(customTitle.rightTextBox, newRightText);
        customTitle.clickElementLocator(customTitle.rightTextButton);
        Assertions.assertEquals(newRightText, customTitle.getTextOfElement(customTitle.rightTextBox));
        Assertions.assertEquals(newRightText, customTitle.getTextOfElement(customTitle.rightNavigationBar));
    }

    @Test
    public void scenario3() throws IOException, InterruptedException {
        //Without clearing cache and deleting the app
        restartApp();

        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.AlertDialogsMenu);
        apiDemos.clickElementLocator(apiDemos.ListDialog);

        ListDialog listDialog = new ListDialog(appiumDriver);
        Thread.sleep(2000);
        String alertMessage = listDialog.selectAnyElement();
        //Checks if the alert message is correct
        Assertions.assertEquals(alertMessage, listDialog.getTextOfElement(listDialog.AlertMessage), "" +
                "Alert message is incorrect!");

    }

    @Test
    public void scenario4() throws IOException, InterruptedException {
        //Without clearing cache and deleting the app
        restartApp();

        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.FragmentMenu);
        apiDemos.clickElementLocator(apiDemos.ContextMenu);

        ContextMenu contextMenu = new ContextMenu(appiumDriver);
        contextMenu.longPress(contextMenu.LongPressMeButton);

        //Checks if the Menu A and Menu B are opened
        Assertions.assertEquals("Menu A", contextMenu.getTextOfElement(contextMenu.MenuA));
        Assertions.assertEquals("Menu B", contextMenu.getTextOfElement(contextMenu.MenuB));
    }

    @Test
    public void scenario5() throws IOException, InterruptedException {
        //Without clearing cache and deleting the app
        restartApp();

        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.FragmentMenu);
        apiDemos.clickElementLocator(apiDemos.HideAndShowMenu);

        //Checks if there are two Hide buttons & text boxes
        HideAndShow hideAndShow = new HideAndShow(appiumDriver);
        Assertions.assertTrue(hideAndShow.isDisplayed(hideAndShow.UpperButton));
        Assertions.assertEquals("HIDE", hideAndShow.getTextOfElement(hideAndShow.UpperButton));
        Assertions.assertTrue(hideAndShow.isDisplayed(hideAndShow.LowerButton));
        Assertions.assertEquals("HIDE", hideAndShow.getTextOfElement(hideAndShow.LowerButton));
        Assertions.assertTrue(hideAndShow.isDisplayed(hideAndShow.UpperTextBox));
        Assertions.assertTrue(hideAndShow.isDisplayed(hideAndShow.LowerTextBox));

        hideAndShow.clickElementLocator(hideAndShow.LowerButton);
        //Checks if the textBox is hidden
        Assertions.assertTrue(!hideAndShow.isDisplayed(hideAndShow.LowerTextBox));
        //Checks if the Hide button is switched to Show
        Assertions.assertEquals("SHOW", hideAndShow.getTextOfElement(hideAndShow.LowerButton));

        hideAndShow.clickElementLocator(hideAndShow.LowerButton);
        Thread.sleep(2000);
        //Checks if the textBox is back
        Assertions.assertTrue(hideAndShow.isDisplayed(hideAndShow.LowerTextBox));
        //Checks if the Show button is switched to Hide
        Assertions.assertEquals("HIDE", hideAndShow.getTextOfElement(hideAndShow.LowerButton));
    }

    @Test
    public void scenario6() throws IOException, InterruptedException {
        //Without clearing cache and deleting the app
        restartApp();

        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.NotificationMenu);
        apiDemos.clickElementLocator(apiDemos.IncomingMessageMenu);

        IncomingMessage incomingMessage = new IncomingMessage(appiumDriver);
        incomingMessage.clickElementLocator(incomingMessage.ShowNotificationButton);
        incomingMessage.appiumDriver.openNotifications();
        //Checks the notification
        Assertions.assertEquals("API Demos", incomingMessage.getTextOfElement(incomingMessage.FirstNotificationSenderApp));
        Assertions.assertEquals("Joe", incomingMessage.getTextOfElement(incomingMessage.FistNotificationSender));
        Assertions.assertEquals("kthx. meet u for dinner. cul8r", incomingMessage.
                getTextOfElement(incomingMessage.FirstNotificationText));
        incomingMessage.clickElementLocator(incomingMessage.FirstNotificationText);
    }

}
