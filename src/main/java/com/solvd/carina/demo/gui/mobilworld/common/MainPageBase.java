package com.solvd.carina.demo.gui.mobilworld.common;

import com.solvd.carina.demo.gui.mobilworld.android.components.Menu;
import com.solvd.carina.demo.gui.mobilworld.common.components.MenuBase;
import com.solvd.carina.demo.gui.mobilworld.desktop.AccountPage;
import com.solvd.carina.demo.gui.mobilworld.desktop.DevicesPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainPageBase<T extends Menu> extends AbstractPage {

    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract DevicesPage openDevicePage();

    public abstract AccountPage openAccountPage();

    public abstract MenuBase getMenu();
}
