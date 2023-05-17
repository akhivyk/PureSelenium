package com.solvd.carina.demo.gui.mobilworld.page;

import com.solvd.carina.demo.gui.mobilworld.components.TopMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DevicesPage extends AbstractPage {
    @FindBy(css = "a.icons_fa.parent[href='/catalog/iphone/'] > span.name")
    private ExtendedWebElement iphoneSection;

    @FindBy(xpath = "//a[contains(@href, '/catalog/iphone/iphone_14_pro_max/')]")
    private ExtendedWebElement secondIphonePage;

    @FindBy(className = "header-wrapper topmenu-LIGHT")
    private TopMenu topMenu;

    public DevicesPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://mobilworld.by/catalog/");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(iphoneSection);
    }

    public IphonePage openIphoneSection() {
        iphoneSection.click();
        return new IphonePage(driver);
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
