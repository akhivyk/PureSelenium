package com.solvd.pure.selenium.pages;

import com.solvd.pure.selenium.pages.DevicesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(css = "a.dropdown-toggle[href='/catalog/'] > div")
    private WebElement devicesSection;

    public MainPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDevicesSectionPresent () {
        return devicesSection.isDisplayed();
    }

    public DevicesPage clickDevicesSection () {
        devicesSection.click();
        return new DevicesPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
