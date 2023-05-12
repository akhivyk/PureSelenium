package com.solvd.pure.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevicesPage {
    private WebDriver driver;
    @FindBy(css = "a.icons_fa.parent[href='/catalog/iphone/'] > span.name")
    private WebElement iphoneSection;

    public DevicesPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean iphoneSectionPresent () {
        return iphoneSection.isDisplayed();
    }

    public IphonePage clickIphonePage () {
        iphoneSection.click();
        return new IphonePage(driver);
    }
}
