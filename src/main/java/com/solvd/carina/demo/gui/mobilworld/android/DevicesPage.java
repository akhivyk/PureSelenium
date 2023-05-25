package com.solvd.carina.demo.gui.mobilworld.android;

import com.solvd.carina.demo.gui.mobilworld.common.DevicesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DevicesPageBase.class)
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
