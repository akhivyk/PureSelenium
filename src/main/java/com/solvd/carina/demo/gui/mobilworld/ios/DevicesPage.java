package com.solvd.carina.demo.gui.mobilworld.ios;

import com.solvd.carina.demo.gui.mobilworld.android.IphonePage;
import com.solvd.carina.demo.gui.mobilworld.common.DevicesPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DevicesPage extends DevicesPageBase {

    @FindBy(xpath = "//a[@href='/catalog/iphone/']")
    private ExtendedWebElement iphoneSection;

    public DevicesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IphonePage openIphoneSection() {
        iphoneSection.clickByJs();
        return new IphonePage(driver);
    }
}
