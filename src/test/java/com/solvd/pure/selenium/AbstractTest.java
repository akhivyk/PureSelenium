package com.solvd.pure.selenium;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger();
    protected ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws MalformedURLException {
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } else {
            throw new IllegalArgumentException("Invalid browser parameter");
        }

        driverThreadLocal.set(driver);
    }

    @AfterClass
    public void tearDown() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenshotIfFailed(driverThreadLocal.get(), testResult.getMethod().getMethodName());
        }
    }

    private void takeScreenshotIfFailed(WebDriver driver, String methodName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "screenshots/" + methodName + "_" + generateTimestamp() + ".png";

        try {
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            LOGGER.info("Screenshot captured: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateTimestamp() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
