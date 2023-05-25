package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.mobilworld.components.PopUpLoginWindow;
import com.solvd.carina.demo.gui.mobilworld.components.TopMenu;
import com.solvd.carina.demo.gui.mobilworld.desktop.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobilWorldWebTest extends AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        PopUpLoginWindow loginWindow = mainPage.openLoginWindow();
        Assert.assertTrue(loginWindow.isLoginInputPresent(), "Login input not found");
        Assert.assertTrue(loginWindow.isPasswordInputPresent(), "Password input not found");
        Assert.assertTrue(loginWindow.isLoginButtonPresent(), "Login button not found");

        loginWindow.inputLogin(R.TESTDATA.get("mw_username"));
        loginWindow.inputPassword(R.TESTDATA.get("mw_password"));

        mainPage = loginWindow.login();
        AccountPage accountPage = mainPage.openAccountPage();
        Assert.assertEquals(accountPage.getTitleText(), "Личный кабинет", "Login failed");
    }

    @Test
    public void addToCartIphone() {
        String model = "iPhone 14 Pro Max";
        String model2 = "iPhone 14 PRO Max 256 GB - Темно-фиолетовый";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        DevicesPage devicesPage = mainPage.openDevicesSection();
        Assert.assertTrue(devicesPage.isPageOpened(), "Devices section not opened");

        IphonePage iphonePage = devicesPage.openIphoneSection();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not found");

        SecondIphonePage secondIphonePage = iphonePage.clickModel(model);
        Assert.assertFalse(secondIphonePage.isIphoneModelsPresent(), "Models is not found");

        ItemPage itemPage = secondIphonePage.clickItem(model2);

        itemPage.clickAddToCartButton();
    }

    @Test
    public void testDeleteItemsFromCart() {
        String model = "iPhone 14 Pro Max";
        String model2 = "iPhone 14 PRO Max 256 GB - Темно-фиолетовый";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        DevicesPage devicesPage = mainPage.openDevicesSection();
        Assert.assertTrue(devicesPage.isPageOpened(), "Devices section not opened");

        IphonePage iphonePage = devicesPage.openIphoneSection();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not found");

        SecondIphonePage secondIphonePage = iphonePage.clickModel(model);
        Assert.assertFalse(secondIphonePage.isIphoneModelsPresent(), "Models is not found");

        ItemPage itemPage = secondIphonePage.clickItem(model2);

        itemPage.clickAddToCartButton();

        itemPage.clickRemoveAllItemsButton();
        Assert.assertFalse(itemPage.isRemoveItemsButtonPresent(), "Cart is not empty");
    }

    @Test
    public void testAllPagesAvailable() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();

        TopMenu topMenu = mainPage.getTopMenu();
        DevicesPage devicesPage = topMenu.openDevicesPage();
        Assert.assertTrue(devicesPage.isPageOpened(), "Devices section not opened");

        ServicePage servicePage = topMenu.openServicePage();
        Assert.assertTrue(servicePage.isPageOpened(), "Service section not opened");

        SalesPage salesPage = topMenu.openSalesPage();
        Assert.assertTrue(salesPage.isPageOpened(), "Sales section not opened");

        BlogPage blogPage = topMenu.openBlogPage();
        Assert.assertTrue(blogPage.isPageOpened(), "Blog section not opened");

        ContactsPage contactsPage = topMenu.openContactsPage();
        Assert.assertTrue(contactsPage.isPageOpened(), "Contacts section not opened");
    }

    @Test
    public void testProductInfo() {
        String model = "iPhone 14 Pro Max";
        String model2 = "iPhone 14 PRO Max 256 GB - Темно-фиолетовый";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        DevicesPage devicesPage = mainPage.openDevicesSection();
        Assert.assertTrue(devicesPage.isPageOpened(), "Devices section not opened");

        IphonePage iphonePage = devicesPage.openIphoneSection();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not found");

        SecondIphonePage secondIphonePage = iphonePage.clickModel(model);
        Assert.assertFalse(secondIphonePage.isIphoneModelsPresent(), "Models is not found");

        ItemPage itemPage = secondIphonePage.clickItem(model2);

        Assert.assertEquals(itemPage.getPrice(), "4 099", "Price incorrect");
        Assert.assertEquals(itemPage.getCurrency(), " руб.", "Currency incorrect");
    }

    @Test
    public void testSearchProducts() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page not opened");

        DevicesPage devicesPage = mainPage.openDevicesSection();
        Assert.assertTrue(devicesPage.isPageOpened(), "Iphone section not opened");

        IphonePage iphonePage = devicesPage.openIphoneSection();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not found");

        iphonePage.getModels().forEach(a -> LOGGER.info(a.getText()));
    }
}
