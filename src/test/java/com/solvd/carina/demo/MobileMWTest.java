package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.mobilworld.android.*;
import com.solvd.carina.demo.gui.mobilworld.android.components.Menu;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MobileMWTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isLoginInputPresent(), "Login input not found");
        softAssert.assertTrue(loginPage.isPasswordInputPresent(), "Password input not found");
        softAssert.assertAll();

        loginPage.inputLogin(R.TESTDATA.get("mw_username"));
        loginPage.inputPassword(R.TESTDATA.get("mw_password"));

        loginPage = loginPage.login();
        Assert.assertEquals(loginPage.getPageTitle(), "Личный кабинет", "login failed");
    }

    @Test
    public void testAddToCartIphone() {
        String model = "iPhone 14 Pro Max";
        String model2 = "iPhone 14 PRO Max 256 GB - Темно-фиолетовый";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();

        Menu menu = mainPage.getMenu();
        menu.openMenu();

        menu.clickDevicesPage();
        DevicesPage devicesPage = menu.openDevicesPage();

        IphonePage iphonePage = devicesPage.openIphoneSection();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not present");

        SecondIphonePage secondIphonePage = iphonePage.openIphonePage(model);
        Assert.assertFalse(secondIphonePage.isIphoneModelsPresent(), "Models is not present");

        ItemPage itemPage = secondIphonePage.openItemPage(model2);
        itemPage.addToCartButton();
    }

    @Test
    public void testDeleteItemsFromCart() {
        String model = "iPhone 14 Pro Max";
        String model2 = "iPhone 14 PRO Max 256 GB - Темно-фиолетовый";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();

        Menu menu = mainPage.getMenu();
        menu.openMenu();

        menu.clickDevicesPage();
        DevicesPage devicesPage = menu.openDevicesPage();

        IphonePage iphonePage = devicesPage.openIphoneSection();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not present");

        SecondIphonePage secondIphonePage = iphonePage.openIphonePage(model);
        Assert.assertFalse(secondIphonePage.isIphoneModelsPresent(), "Models is not present");

        ItemPage itemPage = secondIphonePage.openItemPage(model2);
        itemPage.addToCartButton();

        itemPage.clickRemoveAllItemsButton();
        Assert.assertFalse(itemPage.isRemoveItemsButtonPresent(), "Cart is not empty");
    }

    @Test
    public void testAllPagesAvailable() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();

        String devicesPageUrl = "https://mobilworld.by/catalog/";
        String servicePageUrl = "https://mobilworld.by/services/";
        String salesPageUrl = "https://mobilworld.by/sale/";
        String blogPageUrl = "https://mobilworld.by/blog/";
        String contactsPageUrl = "https://mobilworld.by/contacts/";

        Menu menu = mainPage.getMenu();
        menu.openMenu();

        DevicesPage devicesPage = menu.openDevicesPage();
        Assert.assertEquals(getDriver().getCurrentUrl(), devicesPageUrl, "Device page not opened");

        menu.openMenu();
        ServicesPage servicesPage = menu.openServicesPage();
        Assert.assertEquals(getDriver().getCurrentUrl(), servicePageUrl, "Service page not opened");

        menu.openMenu();
        SalesPage salesPage = menu.openSalesPage();
        Assert.assertEquals(getDriver().getCurrentUrl(), salesPageUrl, "Sales page not opened");

        menu.openMenu();
        BlogPage blogPage = menu.openBlogPage();
        Assert.assertEquals(getDriver().getCurrentUrl(), blogPageUrl, "Blog page not opened");

        menu.openMenu();
        ContactsPage contactsPage = menu.openContactsPage();
        Assert.assertEquals(getDriver().getCurrentUrl(), contactsPageUrl, "Contacts page not opened");
    }

    @Test
    public void testProductInfo() {
        String model = "iPhone 14 Pro Max";
        String model2 = "iPhone 14 PRO Max 256 GB - Темно-фиолетовый";

        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();

        Menu menu = mainPage.getMenu();
        menu.openMenu();

        menu.clickDevicesPage();
        DevicesPage devicesPage = menu.openDevicesPage();

        IphonePage iphonePage = devicesPage.openIphoneSection();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not present");

        SecondIphonePage secondIphonePage = iphonePage.openIphonePage(model);
        Assert.assertFalse(secondIphonePage.isIphoneModelsPresent(), "Models is not present");

        ItemPage itemPage = secondIphonePage.openItemPage(model2);

        Assert.assertEquals(itemPage.getPrice(), "4 099", "Price incorrect");
        Assert.assertEquals(itemPage.getCurrency(), " руб.", "Currency incorrect");
    }

    @Test
    public void testSearchProducts() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();

        Menu menu = mainPage.getMenu();
        menu.openMenu();

        menu.clickDevicesPage();
        DevicesPage devicesPage = menu.openDevicesPage();

        IphonePage iphonePage = devicesPage.openIphoneSection();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not present");

        iphonePage.getModels().forEach(a -> LOGGER.info(a.getText()));
    }
}
