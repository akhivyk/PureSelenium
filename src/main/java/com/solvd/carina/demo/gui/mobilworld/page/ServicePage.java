package com.solvd.carina.demo.gui.mobilworld.page;

import com.solvd.carina.demo.gui.mobilworld.components.TopMenu;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ServicePage extends AbstractPage {
    @FindBy(className = "header-wrapper topmenu-LIGHT")
    private TopMenu topMenu;

    public ServicePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://mobilworld.by/services/");
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
