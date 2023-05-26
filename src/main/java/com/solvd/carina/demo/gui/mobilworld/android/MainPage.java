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

    private static final String THIS_METHOD_IS_DEFINED_ONLY_IN_DESKTOP = "This method is not yet implemented for Android";

    public MainPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://mobilworld.by/");
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public DevicesPage openDevicePage() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_DEFINED_ONLY_IN_DESKTOP);
    }

    @Override
    public AccountPage openAccountPage() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_DEFINED_ONLY_IN_DESKTOP);
    }
}
