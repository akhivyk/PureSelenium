package com.solvd.carina.demo.gui.pages.common;

import com.solvd.carina.demo.gui.components.compare.ModelSpecs;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CompareModelsPageBase extends AbstractPage {

    public CompareModelsPageBase(WebDriver driver) {
        super(driver);
        this.setPageURL("/compare.php3");
    }

    public abstract List<ModelSpecs> compareModels(String... models);

}
