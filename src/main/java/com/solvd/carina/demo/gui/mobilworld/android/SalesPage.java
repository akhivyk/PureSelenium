package com.solvd.carina.demo.gui.mobilworld.android;

import com.solvd.carina.demo.gui.mobilworld.common.SalesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SalesPageBase.class)
public class SalesPage extends SalesPageBase {
    public SalesPage(WebDriver driver) {
        super(driver);
    }
}
