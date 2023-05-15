package com.solvd.pure.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private WebDriver driver;

    @FindBy(css = "a.dropdown-toggle[href='/catalog/'] > div")
    private WebElement devicesSection;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDevicesSectionPresent() {
        return isElementDisplayed(devicesSection);
    }

    public DevicesPage clickDevicesSection() {
        click(devicesSection);
        return new DevicesPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
