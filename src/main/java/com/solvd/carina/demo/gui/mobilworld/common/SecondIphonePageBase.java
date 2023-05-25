package com.solvd.carina.demo.gui.mobilworld.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SecondIphonePageBase extends AbstractPage {

    public SecondIphonePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isIphoneModelsPresent();

    public abstract ExtendedWebElement findModel(String model);
}
