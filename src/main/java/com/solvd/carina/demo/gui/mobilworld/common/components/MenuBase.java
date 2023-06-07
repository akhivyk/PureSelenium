package com.solvd.carina.demo.gui.mobilworld.common.components;

import com.solvd.carina.demo.gui.mobilworld.common.*;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class MenuBase extends AbstractUIObject {

    public MenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void openMenu();

    public abstract void clickDevicesPage();

    public abstract DevicesPageBase openDevicesPage();

    public abstract ServicesPageBase openServicesPage();

    public abstract SalesPageBase openSalesPage();

    public abstract BlogPageBase openBlogPage();

    public abstract ContactsPageBase openContactsPage();

    public abstract LoginPageBase openLoginPage();
}
