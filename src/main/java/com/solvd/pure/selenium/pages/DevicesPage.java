package com.solvd.pure.selenium.pages;

import com.solvd.pure.selenium.components.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevicesPage extends AbstractPage {
    private WebDriver driver;
    @FindBy(css = "a.icons_fa.parent[href='/catalog/iphone/'] > span.name")
    private WebElement iphoneSection;

    @FindBy(xpath = "//div[@class='header-wrapper topmenu-LIGHT']")
    private TopMenu topMenu;

    public DevicesPage(WebDriver driver) {
        topMenu = new TopMenu(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean iphoneSectionPresent() {
        return isElementDisplayed(iphoneSection);
    }

    public IphonePage clickIphonePage() {
        click(iphoneSection);
        return new IphonePage(driver);
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
