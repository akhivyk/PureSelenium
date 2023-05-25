package com.solvd.carina.demo.gui.mobilworld.desktop;

import com.solvd.carina.demo.gui.mobilworld.components.TopMenu;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SalesPage extends AbstractPage {
    @FindBy(className = "header-wrapper topmenu-LIGHT")
    private TopMenu topMenu;

    public SalesPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://mobilworld.by/sale/");
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
