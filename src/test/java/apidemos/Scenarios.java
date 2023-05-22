package apidemos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Scenarios extends AppTest {

    @Test
    public void scenario1() throws InterruptedException {
        //Checks if the application is installed
        Assertions.assertTrue(appiumDriver.isAppInstalled(appPackage), "App is not installed");

        //Checks if permissions are given by default
        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        Assertions.assertTrue(apiDemos.arePermissionsGiven(), "Permissions are not given");

        //Checks if the opened app is the desired app
        Assertions.assertEquals(appActivity, appiumDriver.currentActivity(), "Desired app is not opened");

        apiDemos.clickElementLocator(apiDemos.AppMenu);
        apiDemos.clickElementLocator(apiDemos.ActionBarMenu);
        apiDemos.clickElementLocator(apiDemos.ActionBarTabsMenu);

        ActionBarTabs actionBarTabs = new ActionBarTabs(appiumDriver);
        actionBarTabs.disableToggleTabMode();
        int desiredTabCount = 3;
        actionBarTabs.addNewTabs(desiredTabCount);

        //Checks if desired number of tabs are added
        Thread.sleep(2000);
        Assertions.assertEquals(desiredTabCount, actionBarTabs.tabCount(), "Tab count is not " + desiredTabCount);

        actionBarTabs.removeLastTab();
        //Checks if the last tab is deleted
        Assertions.assertTrue(actionBarTabs.isLastTabDeleted(desiredTabCount), "Last tab is not deleted!");

        actionBarTabs.removeAllTabs();
        //Checks if there is no active tab
        Assertions.assertEquals(0, actionBarTabs.tabCount(), "There is an active tab or tabs!");
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
        Assertions.assertEquals(leftText, customTitle.getTextOfElement(customTitle.leftTextBox),
                "Default text in the left textBox is incorrect");
        Assertions.assertEquals(rightText, customTitle.getTextOfElement(customTitle.rightTextBox),
                "Default text in the right textBox is incorrect");
        Assertions.assertEquals(leftText, customTitle.getTextOfElement(customTitle.leftNavigationBar),
                "Default text in the left navigationBar is incorrect");
        Assertions.assertEquals(rightText, customTitle.getTextOfElement(customTitle.rightNavigationBar),
                "Default text in the right navigationBar is incorrect");

        //Checks if the changed texts are correct
        String newLeftText = "hello left";
        customTitle.clearText(customTitle.leftTextBox);
        customTitle.sendKeysTo(customTitle.leftTextBox, newLeftText);
        customTitle.clickElementLocator(customTitle.leftTextButton);
        Assertions.assertEquals(newLeftText, customTitle.getTextOfElement(customTitle.leftTextBox),
                "Updated text in the left textBox is incorrect");
        Assertions.assertEquals(newLeftText, customTitle.getTextOfElement(customTitle.leftNavigationBar),
                "Updated text in the left navigationBar is incorrect");

        String newRightText = "bye right";
        customTitle.clearText(customTitle.rightTextBox);
        customTitle.sendKeysTo(customTitle.rightTextBox, newRightText);
        customTitle.clickElementLocator(customTitle.rightTextButton);
        Assertions.assertEquals(newRightText, customTitle.getTextOfElement(customTitle.rightTextBox),
                "Updated text in the right textBox is incorrect");
        Assertions.assertEquals(newRightText, customTitle.getTextOfElement(customTitle.rightNavigationBar),
                "Updated text in the right navigationBar is incorrect");
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
        Assertions.assertTrue(contextMenu.isDisplayed(contextMenu.MenuA), "Menu A is not opened");
        Assertions.assertTrue(contextMenu.isDisplayed(contextMenu.MenuB), "Menu B is not opened");
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
        Assertions.assertTrue(hideAndShow.isDisplayed(hideAndShow.UpperButton), "Upper button is not displayed");
        Assertions.assertEquals("HIDE", hideAndShow.getTextOfElement(hideAndShow.UpperButton),
                "Upper button is not 'Hide' button");
        Assertions.assertTrue(hideAndShow.isDisplayed(hideAndShow.LowerButton), "Lower button is not displayed");
        Assertions.assertEquals("HIDE", hideAndShow.getTextOfElement(hideAndShow.LowerButton),
                "Lower button is not 'Hide' button");
        Assertions.assertTrue(hideAndShow.isDisplayed(hideAndShow.UpperTextBox), "Upper textBox is not displayed");
        Assertions.assertTrue(hideAndShow.isDisplayed(hideAndShow.LowerTextBox), "Lower textBox is not displayed");

        hideAndShow.clickElementLocator(hideAndShow.LowerButton);
        //Checks if the textBox is hidden
        Assertions.assertTrue(!hideAndShow.isDisplayed(hideAndShow.LowerTextBox), "Lower textBox is not hidden");
        //Checks if the Hide button is switched to Show
        Assertions.assertEquals("SHOW", hideAndShow.getTextOfElement(hideAndShow.LowerButton),
                "Lower button is not 'Show' button");

        hideAndShow.clickElementLocator(hideAndShow.LowerButton);
        Thread.sleep(2000);
        //Checks if the textBox is back
        Assertions.assertTrue(hideAndShow.isDisplayed(hideAndShow.LowerTextBox), "Lower textBox is not displayed");
        //Checks if the Show button is switched to Hide
        Assertions.assertEquals("HIDE", hideAndShow.getTextOfElement(hideAndShow.LowerButton),
                "Lower button is not 'Hide' button");
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
        Thread.sleep(2000);
        //Checks the notification
        Assertions.assertTrue(incomingMessage.isDisplayed(incomingMessage.NotificationApp),
                "Notification is not displayed");

        String msgTitle = incomingMessage.getTextOfElement(incomingMessage.NotificationTitle);
        String msgText = incomingMessage.getTextOfElement(incomingMessage.NotificationText);

        incomingMessage.clickElementLocator(incomingMessage.NotificationApp);
        //Checks that the notification detail is opened
        Assertions.assertTrue(incomingMessage.isDisplayed(incomingMessage.NotificationDetailText),
                "Notification detail is not opened");

        //Checks if detail page contains the message in the notification bar
        String notificationDetailMsg = incomingMessage.getTextOfElement(incomingMessage.NotificationDetailMsg);
        Assertions.assertTrue(notificationDetailMsg.contains(msgText),
                "Notification detail text does not contain text in the notification bar");
    }

    @Test
    public void scenario7() throws InterruptedException, IOException {
        //Delete the app and reinstall
        appiumDriver.removeApp(appPackage);
        Thread.sleep(2000);
        appiumDriver.installApp("C:\\API Demos.apk");
        Thread.sleep(2000);
        openApp();
        Thread.sleep(2000);

        ApiDemos apiDemos = new ApiDemos(appiumDriver);
        apiDemos.clickElementLocator(apiDemos.ViewsMenu);
        apiDemos.scrollUntilElementDisplayed(apiDemos.TabsMenu);
        apiDemos.clickElementLocator(apiDemos.TabsMenu);
        apiDemos.clickElementLocator(apiDemos.ScrollableMenu);

        ScrollableMenu scrollableMenu = new ScrollableMenu(appiumDriver);
        String desiredTab = "30";
        scrollableMenu.swipeUntilTab(desiredTab);
        scrollableMenu.clickElementLocator(scrollableMenu.getDesiredTab(desiredTab));
        Thread.sleep(2000);

        //Checks if the desired tab is selected
        Assertions.assertEquals("TAB " + desiredTab, scrollableMenu.getTextOfElement(scrollableMenu.SelectedTab),
                "Wrong tab is selected");

        //Checks that the opened page information belongs to the desired tab
        Assertions.assertTrue(scrollableMenu.getTextOfElement(scrollableMenu.TabContentText).contains("30"),
                "Page information does not belong to the desired tab");
    }

}
