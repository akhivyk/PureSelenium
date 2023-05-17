package com.solvd.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AllBrandsPageBase extends AbstractPage {

    public AllBrandsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract BrandModelsPageBase selectBrand(String brandName);

}
