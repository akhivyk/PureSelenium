package com.solvd.pure.selenium;

import com.solvd.pure.selenium.pages.DevicesPage;
import com.solvd.pure.selenium.pages.IphonePage;
import com.solvd.pure.selenium.pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class PureSeleniumWebTest {
    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger();

    @BeforeClass
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "/Users/akhivyk/Documents/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testSearchProducts () {
        MainPage mainPage = new MainPage(driver);
        driver.get("https://mobilworld.by/");

        Assert.assertTrue(mainPage.isDevicesSectionPresent(), "Devices section is not present");

        DevicesPage devicesPage = mainPage.clickDevicesSection();
        Assert.assertTrue(devicesPage.iphoneSectionPresent(), "Iphone section is not found");

        IphonePage iphonePage = devicesPage.clickIphonePage();
        Assert.assertFalse(iphonePage.getModels().isEmpty(), "Models is not present");

        iphonePage.getModels().forEach(a -> LOGGER.info(a.getText()));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
