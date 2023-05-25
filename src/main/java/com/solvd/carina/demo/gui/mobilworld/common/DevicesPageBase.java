package com.solvd.carina.demo.gui.mobilworld.common;

import com.solvd.carina.demo.gui.mobilworld.android.IphonePage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DevicesPageBase extends AbstractPage {

    public DevicesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract IphonePage openIphoneSection();
}
