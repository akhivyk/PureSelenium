package com.solvd.carina.demo.gui.mobilworld.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SwitchTabs extends AbstractPage {

    @FindBy(id = "com.android.chrome:id/tab_switcher_button")
    private ExtendedWebElement tabsBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='New tab']")
    private ExtendedWebElement newTabBtn;

    public SwitchTabs(WebDriver driver) {
        super(driver);
    }

    public void clickTabsBtn() {
        tabsBtn.click();
    }

    public ChromeMainPage clickNewTabBtn() {
        newTabBtn.click();
        return new ChromeMainPage(driver);
    }
}
