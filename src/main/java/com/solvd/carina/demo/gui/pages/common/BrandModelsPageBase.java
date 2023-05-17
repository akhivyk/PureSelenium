package com.solvd.carina.demo.gui.pages.common;

import com.solvd.carina.demo.gui.components.ModelItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class BrandModelsPageBase extends AbstractPage {

    public BrandModelsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ModelInfoPageBase selectModel(String modelName);

    public abstract List<ModelItem> getModels();

}
