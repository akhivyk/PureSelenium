package com.solvd.carina.demo.gui.mobilworld.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class IphonePageBase extends AbstractPage {

    public IphonePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<ExtendedWebElement> getModels();

    public abstract ExtendedWebElement findModel(String model);

    public abstract boolean isModelsPresent();

    public abstract SecondIphonePageBase openIphonePage(String model);
}
