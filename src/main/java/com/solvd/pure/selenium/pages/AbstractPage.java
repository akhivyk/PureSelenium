package com.solvd.pure.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;


public abstract class AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger();

    private WebDriver driver;

    private String absolutePageUrl;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        try {
            LOGGER.info("Clicking element: {}", element);
            WebDriverWait wait = new WebDriverWait(driver, 10); // Установите подходящее значение таймаута
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", element);
            LOGGER.info("Element clicked successfully");
        } catch (Exception e) {
            LOGGER.error("Failed to click element: {}", element, e);
            // Дополнительные действия при возникновении ошибки, например, скриншот страницы, остановка теста и т. д.
        }
    }

    protected void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            LOGGER.info("Waiting for element to be displayed: {}", element);
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(element));
            LOGGER.info("Element is displayed: {}", element);
            return true;
        } catch (TimeoutException e) {
            LOGGER.error("Element is not displayed within the specified timeout: {}", element);
            return false;
        } catch (NoSuchElementException e) {
            LOGGER.error("Element is not displayed: {}", element);
            return false;
        }
    }

    protected void setInputField(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
