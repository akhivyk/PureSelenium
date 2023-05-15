package com.solvd.pure.selenium;

import com.solvd.pure.selenium.items.PopUpCartWindow;
import com.solvd.pure.selenium.items.PopUpLoginWindow;
import com.solvd.pure.selenium.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PureSeleniumWebTest extends AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test(threadPoolSize = 2)
    public void testSearchProducts() {
        MainPage mainPage = new MainPage(driver);
        driver.get("https://mobilworld.by/");

        Assert.assertTrue(mainPage.isDevicesSectionPresent(), "Devices section is not found");

        DevicesPage devicesPage = mainPage.clickDevicesSection();
        Assert.assertTrue(devicesPage.iphoneSectionPresent(), "Iphone section is not found");

        IphonePage iphonePage = devicesPage.clickIphonePage();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not found");

        iphonePage.getModels().forEach(a -> LOGGER.info(a.getText()));
    }

    @Test(threadPoolSize = 2)
    public void testLogin () {
        String login = "Artsiom";
        String password = "test1234";

        MainPage mainPage = new MainPage(driver);
        driver.get("https://mobilworld.by/");

        Assert.assertEquals(mainPage.getLoginButtonText(), "Войти", "Login button not found");

        PopUpLoginWindow popUpLoginWindow = mainPage.openLoginWindow();
        Assert.assertTrue(popUpLoginWindow.isLoginInputPresent(), "Login input not found");
        Assert.assertTrue(popUpLoginWindow.isPasswordInputPresent(), "Password input not found");
        Assert.assertTrue(popUpLoginWindow.isLoginButtonPresent(), "Login button not found");

        popUpLoginWindow.inputLogin(login);
        popUpLoginWindow.inputPassword(password);

        mainPage = popUpLoginWindow.login();
        AccountPage accountPage = mainPage.openAccountPage();
        Assert.assertEquals(accountPage.getTitleText(), "Личный кабинет", "Login failed");
    }

    @Test
    public void testAddToCartIphone () {
        String model = "iPhone 14 Pro Max";
        String model2 = "iPhone 14 PRO Max 256 GB - Темно-фиолетовый";

        MainPage mainPage = new MainPage(driver);
        driver.get("https://mobilworld.by/");

        Assert.assertTrue(mainPage.isDevicesSectionPresent(), "Devices section is not found");

        DevicesPage devicesPage = mainPage.clickDevicesSection();
        Assert.assertTrue(devicesPage.iphoneSectionPresent(), "Iphone section is not found");

        IphonePage iphonePage = devicesPage.clickIphonePage();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not found");

        SecondIphonePage secondIphonePage = iphonePage.clickModel(model);
        Assert.assertFalse(secondIphonePage.isIphoneModelsPresent(), "Models is not found");

        ItemPage itemPage = secondIphonePage.clickItem(model2);

        itemPage.clickAddToCartButton();

        Assert.assertTrue(itemPage.isAddedToCart(), "Add to cart failed");
    }

    @Test
    public void testDeleteItemsFromCart () {
        String model = "iPhone 14 Pro Max";
        String model2 = "iPhone 14 PRO Max 256 GB - Темно-фиолетовый";

        MainPage mainPage = new MainPage(driver);
        driver.get("https://mobilworld.by/");

        Assert.assertTrue(mainPage.isDevicesSectionPresent(), "Devices section is not found");

        DevicesPage devicesPage = mainPage.clickDevicesSection();
        Assert.assertTrue(devicesPage.iphoneSectionPresent(), "Iphone section is not found");

        IphonePage iphonePage = devicesPage.clickIphonePage();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not found");

        SecondIphonePage secondIphonePage = iphonePage.clickModel(model);
        Assert.assertFalse(secondIphonePage.isIphoneModelsPresent(), "Models is not found");

        ItemPage itemPage = secondIphonePage.clickItem(model2);

        itemPage.clickAddToCartButton();

        Assert.assertTrue(itemPage.isAddedToCart(), "Add to cart failed");

        PopUpCartWindow popUpCartWindow = itemPage.clickCartButton();

        popUpCartWindow.removeAllItemsFromCart();
        Assert.assertEquals(popUpCartWindow.getTitleText(), "Ваша корзина пуста", "Cart items are not removed");
    }

    @Test
    public void testAllPagesAvailable() {
        MainPage mainPage = new MainPage(driver);
        driver.get("https://mobilworld.by/");

        String devicesPageUrl = "https://mobilworld.by/catalog/";
        String servicePageUrl = "https://mobilworld.by/services/";
        String salesPageUrl = "https://mobilworld.by/sale/";
        String blogPageUrl = "https://mobilworld.by/blog/";
        String contactsPageUrl = "https://mobilworld.by/contacts/";

        DevicesPage devicesPage = mainPage.getTopMenu().openDevicesPage();
        Assert.assertEquals(driver.getCurrentUrl(), devicesPageUrl, "Devices section not opened");

        ServicePage servicePage = devicesPage.getTopMenu().openServicePage();
        Assert.assertEquals(driver.getCurrentUrl(), servicePageUrl, "Service section not opened");

        SalesPage salesPage = servicePage.getTopMenu().openSalesPage();
        Assert.assertEquals(driver.getCurrentUrl(), salesPageUrl, "Sales section not opened");

        BlogPage blogPage = salesPage.getTopMenu().openBlogPage();
        Assert.assertEquals(driver.getCurrentUrl(), blogPageUrl, "Blog section not opened");

        ContactsPage contactsPage = blogPage.getTopMenu().openContactsPage();
        Assert.assertEquals(driver.getCurrentUrl(), contactsPageUrl, "Contacts section not opened");
    }

    @Test
    public void testProductInfo() {
        String model = "iPhone 14 Pro Max";
        String model2 = "iPhone 14 PRO Max 256 GB - Темно-фиолетовый";

        MainPage mainPage = new MainPage(driver);
        driver.get("https://mobilworld.by/");

        Assert.assertTrue(mainPage.isDevicesSectionPresent(), "Devices section is not found");

        DevicesPage devicesPage = mainPage.clickDevicesSection();
        Assert.assertTrue(devicesPage.iphoneSectionPresent(), "Iphone section is not found");

        IphonePage iphonePage = devicesPage.clickIphonePage();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not found");

        SecondIphonePage secondIphonePage = iphonePage.clickModel(model);
        Assert.assertFalse(secondIphonePage.isIphoneModelsPresent(), "Models is not found");

        ItemPage itemPage = secondIphonePage.clickItem(model2);

        Assert.assertEquals(itemPage.getPrice(), "4 099", "Price incorrect");
        Assert.assertEquals(itemPage.getCurrency(), " руб.", "Currency incorrect");
    }
}
