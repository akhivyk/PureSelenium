package com.solvd.carina.demo.gui.mobilworld.android;

import com.solvd.carina.demo.gui.mobilworld.common.ServicesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ServicesPageBase.class)
public class ServicesPage extends ServicesPageBase {

    public ServicesPage(WebDriver driver) {
        super(driver);
    }
}
