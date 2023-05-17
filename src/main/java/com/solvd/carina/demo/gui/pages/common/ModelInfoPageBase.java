package com.solvd.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ModelInfoPageBase extends AbstractPage {

    public ModelInfoPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readDisplay();

    public abstract String readCamera();

    public abstract String readRam();

    public abstract String readBattery();

}
