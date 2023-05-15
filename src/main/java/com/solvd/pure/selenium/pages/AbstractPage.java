package com.solvd.pure.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;


public abstract class AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger();

    protected void click(WebElement element) {
        LOGGER.info("Clicking element: {}", element);
        element.click();
    }

    protected void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            LOGGER.info("Element is displayed: {}", element);
            return true;
        } catch (NoSuchElementException e) {
            LOGGER.error("Element is not displayed: {}", element);
            return false;
        }
    }
}
