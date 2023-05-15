package com.solvd.pure.selenium;

import com.solvd.pure.selenium.pages.DevicesPage;
import com.solvd.pure.selenium.pages.IphonePage;
import com.solvd.pure.selenium.pages.MainPage;
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

        Assert.assertTrue(mainPage.isDevicesSectionPresent(), "Devices section is not present");

        DevicesPage devicesPage = mainPage.clickDevicesSection();
        Assert.assertTrue(devicesPage.iphoneSectionPresent(), "Iphone section is not found");

        IphonePage iphonePage = devicesPage.clickIphonePage();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not present");

        iphonePage.getModels().forEach(a -> LOGGER.info(a.getText()));
    }

    @Test(threadPoolSize = 2)
    public void testPage () {
        driver.get("https://mobilworld.by/");
        LOGGER.info(driver.getTitle());
    }
}
