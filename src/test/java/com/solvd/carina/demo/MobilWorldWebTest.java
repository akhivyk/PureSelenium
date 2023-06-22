package com.solvd.carina.demo;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.proxy.CaptureType;
import com.browserup.harreader.model.Har;
import com.browserup.harreader.model.HarEntry;
import com.browserup.harreader.model.HarRequest;
import com.browserup.harreader.model.HarResponse;
import com.solvd.carina.demo.gui.mobilworld.components.PopUpLoginWindow;
import com.solvd.carina.demo.gui.mobilworld.components.TopMenu;
import com.solvd.carina.demo.gui.mobilworld.desktop.*;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.proxy.ProxyPool;
import com.zebrunner.carina.proxy.browserup.CarinaBrowserUpProxy;
import com.zebrunner.carina.utils.R;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class MobilWorldWebTest extends AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @TestRailCaseId("C3559")
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
    @TestRailCaseId("C3560")
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
    @TestRailCaseId("C3561")
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
    @TestRailCaseId("C3562")
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
    @TestRailCaseId("C3563")
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

    @Test(testName = "MobilWorld - testOpenWebSiteWithCookie")
    public void testOpenWebSiteWithCookie() {
        String cookieName = "session-username";
        String cookieValue = "standard_user";
        WebDriver driver = getDriver();
        driver.get("https://www.saucedemo.com/");

        Cookie cookie = new Cookie(cookieName, cookieValue);
        driver.manage().addCookie(cookie);
        driver.get("https://www.saucedemo.com/inventory.html");

        Set<Cookie> cookies = driver.manage().getCookies();
        boolean cookieFound = false;
        for (Cookie cookie1 : cookies) {
            if (cookie1.getName().equals(cookieName) && cookie1.getValue().equals(cookieValue)) {
                cookieFound = true;
                break;
            }
        }
        Assert.assertTrue(cookieFound, "Cookie " + cookieName + " with value " + cookieValue + " not found");
    }


    @Test
    public void testValidateFoundCallUsingProxy() {
        R.CONFIG.put("browserup_proxy", "true", true);
        R.CONFIG.put("proxy_type", "DYNAMIC", true);
        R.CONFIG.put("proxy_port", "0", true);

        getDriver();

        BrowserUpProxy browserUpProxy = ProxyPool.getOriginal(CarinaBrowserUpProxy.class)
                .orElseThrow()
                .getProxy();
        browserUpProxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        browserUpProxy.newHar();

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");

        getDriver().get("https://www.solvd.com/");

        BrowserUpProxy proxy = ProxyPool.getOriginal(CarinaBrowserUpProxy.class)
                .orElseThrow()
                .getProxy();

        Har har = proxy.getHar();
        List<HarEntry> entries = har.getLog().getEntries();

        boolean isEventSent = false;

        for (HarEntry entry : entries) {
            HarRequest request = entry.getRequest();
            if (request.getUrl().contains("https://rest.happierleads.com")) {
                isEventSent = true;

                HarResponse response = entry.getResponse();
                String responseBody = response.getContent().getText();

                Assert.assertTrue(responseBody.contains("data"));
                break;
            }
        }

        Assert.assertTrue(isEventSent);
    }
}
