package com.solvd.carina.demo.gui.mobilworld.android;

import com.solvd.carina.demo.gui.mobilworld.android.components.Menu;
import com.solvd.carina.demo.gui.mobilworld.common.MainPageBase;
import com.solvd.carina.demo.gui.mobilworld.desktop.AccountPage;
import com.solvd.carina.demo.gui.mobilworld.desktop.DevicesPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {
    @FindBy(xpath = "//div[@class='burger pull-left']")
    private Menu menu;

    public MainPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://mobilworld.by/");
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public DevicesPage openDevicePage() {
        return null;
    }

    @Override
    public AccountPage openAccountPage() {
        return null;
    }
}
